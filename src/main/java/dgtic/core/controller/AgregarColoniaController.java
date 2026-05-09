package dgtic.core.controller;

import dgtic.core.model.dto.*;
import dgtic.core.model.dto.auto.LogoDTO;
import dgtic.core.model.dto.colonia.CodigoPostalDTO;
import dgtic.core.model.dto.colonia.ColoniaDTO;
import dgtic.core.model.dto.colonia.EstadoDTO;
import dgtic.core.model.dto.colonia.MunicipioDTO;
import dgtic.core.model.entity.direccion.CodigoPostal;
import dgtic.core.model.entity.direccion.Colonia;
import dgtic.core.model.entity.direccion.Estado;
import dgtic.core.model.entity.direccion.Municipio;
import dgtic.core.service.Vehiculo.Logo.LogoService;
import dgtic.core.service.codigopostal.CodigoService;
import dgtic.core.service.colonia.ColoniaService;
import dgtic.core.service.estado.EstadoService;
import dgtic.core.service.municipio.MunicipioService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Controller
public class AgregarColoniaController {

    @Autowired
    EstadoService estadoService;
    @Autowired
    MunicipioService municipioService;
    @Autowired
    ColoniaService coloniaService;
    @Autowired
    CodigoService codigoService;



    @RequestMapping(value = "Alta", method = RequestMethod.GET)
    public String nosotros(Model model) {
        model.addAttribute("formulario3");
        return "colonia/alta";
    }

    @GetMapping("lista")
    public String listarColonias(Model model){
        List<Colonia> colonias=coloniaService.obtenerTodas();

        List<Formulario3DTO> lista=colonias.stream().map(
                c ->{
                 Formulario3DTO dto = new Formulario3DTO();
                 dto.setCp(c.getCodigoPostal().getCodigo());
                 dto.setColonia(c.getNombre());
                 dto.setMunicipio(c.getMunicipio().getNombre());
                 dto.setEstado(c.getMunicipio().getEstado().getNombre());
                 return dto;
                }).collect(Collectors.toList());
        model.addAttribute("colonias",colonias);

        return  "colonia/lista";
    }

    
    @PreAuthorize("hasRole('Asesor')")
    @GetMapping("Agregar")
    public String mostrarFormulario(Model model){
        model.addAttribute("formulario3", new Formulario3DTO());
        model.addAttribute("estados", estadoService.findAll());
        model.addAttribute("codigos", codigoService.findAll());
        return "colonia/alta";
    }


    @PostMapping("/alta")
    public String alta(@Valid @ModelAttribute("formulario3") Formulario3DTO formulario3DTO, BindingResult binding, Model model){
        model.addAttribute("estados", estadoService.findAll());
        List<Colonia> colonias = new ArrayList<>();
        List<Municipio> municipios = new ArrayList<>();
        model.addAttribute("codigos", codigoService.findAll());
        System.out.println(formulario3DTO.getCp());
        System.out.println(formulario3DTO.getEstado());
        CodigoPostal codigo = codigoService.crearOObtener(formulario3DTO.getCp());
        colonias = codigo.getColonias();
        model.addAttribute("colonias", colonias);
        Estado estado = estadoService.crearUObtener(formulario3DTO.getEstado());
        municipios=estado.getMunicios();
        model.addAttribute("municipios", municipios);
        Municipio muni = Municipio.builder()
                .nombre(formulario3DTO.getMunicipio())
                .estado(estado)
                .build();
        Municipio municipio = municipioService.crearUObtener(muni);
        Colonia col = Colonia.builder()
                .nombre(formulario3DTO.getColonia())
                .codigoPostal(codigo)
                .municipio(municipio)
                .build();
       coloniaService.crearUObtener(col);
        if (binding.hasErrors()) {
            return "colonia/alta";
        }
        return "colonia/alta";
    }

    @GetMapping("/colonia/lista2")
    public String listarColonias2(Model model) {
        model.addAttribute("colonias", coloniaService.obtenerTodas());
        return "colonia/lista2";
    }

    @GetMapping("/colonia/eliminar/{id}")
    @Transactional
    public String eliminarColonia(@PathVariable Long id) {
        coloniaService.deleteById(id);
        return "redirect:/colonia/lista2";
    }

@GetMapping("/editarColonia/{id}")
    public String editarColonia(@PathVariable Long id, Model model){
        ColoniaDTO colonia = coloniaService.findById(id);
        model.addAttribute("colonia", colonia);
        model.addAttribute("estados", estadoService.findAll());
        model.addAttribute("municipios", municipioService.findAll());

        return "colonia/editar";
}


@PostMapping("/actualizarColonia")
@Transactional
    public String actualizarColonia(@ModelAttribute("colonia") Colonia colonia){
        coloniaService.actualizar(colonia);
        return "redirect:/colonias";
}











}
