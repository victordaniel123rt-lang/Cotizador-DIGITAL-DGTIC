package dgtic.core.controller;

import com.openhtmltopdf.pdfboxout.PdfRendererBuilder;
import dgtic.core.exception.NotDataFoundException;
import dgtic.core.model.dto.ClienteDTO;
import dgtic.core.model.dto.Cotizacion.CotizacionFinalDTO;
import dgtic.core.model.dto.CotizacionDTO;
import dgtic.core.model.entity.Cotizacion.Coberturas;
import dgtic.core.model.entity.Cotizacion.CotizacionFinal;
import dgtic.core.model.entity.auto.Marca;
import dgtic.core.model.entity.direccion.CodigoPostal;
import dgtic.core.model.entity.direccion.Colonia;
import dgtic.core.repository.auto.MarcaRepository;
import dgtic.core.repository.cotizacion.CoberturasRepository;
import dgtic.core.repository.cotizacion.CotizacionFinalRepository;
import dgtic.core.service.Cliente.ClienteService;
import dgtic.core.service.Vehiculo.Auto.AutoServiceImpl;
import dgtic.core.service.Vehiculo.Año.AñoService;
import dgtic.core.service.Vehiculo.Marca.MarcaService;
import dgtic.core.service.Vehiculo.Modelo.ModeloService;
import dgtic.core.service.Vehiculo.Version.VersionService;
import dgtic.core.service.codigopostal.CodigoService;
import dgtic.core.service.colonia.ColoniaServiceImpl;
import dgtic.core.service.cotizacion.CobeturaService;
import dgtic.core.service.cotizacion.CotizacionFinalService;
import dgtic.core.service.cotizacion.PDFService;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@Slf4j
@SessionAttributes({"direccion", "auto","form", "genera"})
@AllArgsConstructor
public class CotizarController {
    VersionService versionService;
    ModeloService modeloService;
    MarcaService marcaService;
    MarcaRepository marcaRepository;
    CoberturasRepository coberturasRepository;
    CotizacionFinalService cotizacionFinalService;
    CobeturaService coberturaService;
    PDFService pdfService;
    CotizacionFinalRepository cotizacionFinalRepository;
    @Autowired
    private TemplateEngine templateEngine;
    @Autowired
    ColoniaServiceImpl coloniaService;
    @Autowired
    CodigoService codigoService;
    @Autowired
    AutoServiceImpl autoService;
    @Autowired
    AñoService añoService;
    @Autowired
    ClienteService clienteService;

    @GetMapping("Inicio3")
    public String Inicio(Model model){
        model.addAttribute("start");
        return "index";
    }


    @GetMapping("Legalizado")
    public String Legalizado(Model model){
        model.addAttribute("legalizado");
        return "cotizar/legalizado";
    }
    @GetMapping("moto")
    public String Moto(Model model){
        model.addAttribute("moto");
        return "cotizar/moto";
    }



    @RequestMapping(value = "cotizar2", method = RequestMethod.GET)
    public String principal(Model model){
    model.addAttribute("costos");
    return "cotizar/cotizar";
}



@GetMapping("cotizar")
    public String cotizar(Model model){
    model.addAttribute("form", new CotizacionDTO());
    model.addAttribute("genera", new CotizacionFinalDTO());
    model.addAttribute("coberturas", coberturasRepository.findAll());
    return "cotizar/cotizar";
}


    @PostMapping("/cotizar")
    public String cotizar(HttpSession session, @ModelAttribute("form") CotizacionDTO form, @ModelAttribute("genera") CotizacionFinalDTO cotizacion, @RequestParam(value = "accion", required = false) String accion, Model model) {
        model.addAttribute("anios", añoService.findAll());
        List<Colonia> colonias = new ArrayList<>();

        if (form.getCodigopostal() != null) {
            try {
                CodigoPostal cp = codigoService.buscarPorCodigo(form.getCodigopostal());

                if (cp != null) {
                    colonias = cp.getColonias();

                    if (!colonias.isEmpty()) {
                        Colonia col = colonias.get(0);
                        form.setMunicipio(col.getMunicipio().getNombre());
                        form.setEstado(col.getMunicipio().getEstado().getNombre());
                    }
                }

            } catch (NotDataFoundException e) {
                model.addAttribute("error", "El código postal no existe");
            }
        }

        model.addAttribute("colonias", colonias);

        if (form.getAnio() != null) {
            model.addAttribute("marcas", autoService.obtenerMarcas(form.getAnio()));
        } else {
            model.addAttribute("marcas", new ArrayList<>());
        }
        if(form.getMarca()!=null){
            Marca marca = marcaRepository.findById(form.getMarca()).orElse(null);
            if(marca!=null && marca.getLogo()!=null){
                model.addAttribute("logoMarca", marca.getLogo().getUrlogo());
            }

        }
        if (form.getMarca() != null) {
            model.addAttribute("modelos",
                    autoService.obtenerModelosPorAnioAndMarca(form.getAnio(), form.getMarca()));
        } else {
            model.addAttribute("modelos", new ArrayList<>());
        }

        if (form.getModelo() != null) {
            model.addAttribute("versiones",
                    autoService.obtenerVersionesPorAnioAndModelo(form.getAnio(), form.getModelo()));
        } else {
            model.addAttribute("versiones", new ArrayList<>());
        }
        ClienteDTO cliente = new ClienteDTO();
        cliente.setNombre(form.getNombre());
        cliente.setSegundonombre(form.getSegundonombre());
        cliente.setApellidoPaterno(form.getApellidoPaterno());
        cliente.setApellidoMaterno(form.getApellidoMaterno());
        cliente.setFechaNacimiento(form.getFechaNacimiento());
        cliente.setCorreo(form.getCorreo());
        cliente.setNumero(form.getNumero());
        cliente.setGenero(form.getGenero());
        session.setAttribute("form", form);
        System.out.println("Guardado en sesión: " + form.getCorreo());
        if(cliente.getNombre() !=null && !cliente.getNombre().isEmpty()){
            clienteService.guardar(cliente);
        }
        if("cotizar".equals(accion)){
            Map<String, Map<String, BigDecimal>> diferimientos = cotizacionFinalService.diferimiento(cotizacion);
            double precio = 5500;
            String año=String.valueOf(añoService.findById(form.getAnio()));
            String nombreMarca= String.valueOf(marcaService.findById(form.getMarca()));
            String nombreModelo=String.valueOf(modeloService.findById(form.getModelo()));
            String nombreVersion = String.valueOf(versionService.findById(form.getVersion()));
            model.addAttribute("form", form);
            model.addAttribute("precio", precio);
            model.addAttribute("anio", año);
            model.addAttribute("marcaNombre", nombreMarca);
            model.addAttribute("nombreModelo", nombreModelo);
            model.addAttribute("nombreVersion", nombreVersion);
            model.addAttribute("coberturas", coberturasRepository.findAll());
            model.addAttribute("costos", diferimientos);
            model.addAttribute("correo", form.getCorreo());
            var anioObj = añoService.findById(form.getAnio());
            var modeloObj = modeloService.findById(form.getModelo());
            var vrsObj = versionService.findById(form.getVersion());

            if (cotizacion.getCobertura() != null) {

                var resultado = cotizacionFinalService.obtenerCotizacionPorCobertura(cotizacion.getCobertura());
                var cobObj = coberturaService.findById(cotizacion.getCobertura());
                model.addAttribute("genera", resultado);
                model.addAttribute("costo", resultado.getCosto());
                model.addAttribute("coberturaNombre", cobObj.getNombre());
                session.setAttribute("coberturaNombre", cobObj.getNombre());

                session.setAttribute("genera", cotizacion);
                session.setAttribute("anio", anioObj.getAnio());
                session.setAttribute("marcaNombre", nombreMarca);
                session.setAttribute("nombreModelo", modeloObj.getModelo());
                session.setAttribute("nombreVersion", vrsObj.getVersion() );
                model.addAttribute("costos", diferimientos);
                session.setAttribute("costos", diferimientos);
                session.setAttribute("coberturaPdf", cobObj.getNombre());
            }
            return "cotizar/resultado";
        }

        return "cotizar/cotizar";
    }




//    @GetMapping("/pdf")
//    public void generarPdf(HttpSession session, HttpServletResponse response, Model model) throws Exception {
//
//        CotizacionDTO cotizacionDTO = (CotizacionDTO) session.getAttribute("form");
//        CotizacionFinalDTO cotizacionFinalDTO = (CotizacionFinalDTO) session.getAttribute("genera");
//        Map<String, Map<String, BigDecimal>> diferimientos = (Map<String, Map<String, BigDecimal>>) session.getAttribute("costos");
//        Context context = new Context();
//        context.setVariable("form", cotizacionDTO);
//        context.setVariable("genera", cotizacionFinalDTO);
//        context.setVariable("anio", session.getAttribute("anio"));
//        context.setVariable("marcaNombre", session.getAttribute("marcaNombre"));
//        context.setVariable("nombreModelo", session.getAttribute("nombreModelo"));
//        context.setVariable("nombreVersion", session.getAttribute("nombreVersion"));
//        context.setVariable("coberturaPdf", session.getAttribute("coberturaPdf"));
//        context.setVariable("costos", diferimientos);
//        context.setVariable("coberturaNombre", session.getAttribute("coberturaNombre"));
//
//
//
//        String html = templateEngine.process("cotizar/cotizacion", context);
//
//        response.setContentType("application/pdf");
//        response.setHeader("Content-Disposition", "attachment; filename=cotizacion.pdf");
//        String path = new ClassPathResource("static/img/logoDGTIC.png").getFile().getAbsolutePath();
//        model.addAttribute("logoPath", "file:/" + path);
//
//
//        PdfRendererBuilder builder = new PdfRendererBuilder();
//        builder.withHtmlContent(html, null);
//        builder.toStream(response.getOutputStream());
//        builder.run();
//    }





@GetMapping("/pdf")
    public void generarPdf(HttpSession session, HttpServletResponse response) throws Exception{
        byte[] pdf = pdfService.generarPDF((CotizacionDTO) session.getAttribute("form"),
                (CotizacionFinalDTO) session.getAttribute("genera"),
                (Map<String, Map<String, BigDecimal>>) session.getAttribute("costos"),
                Map.of("anio", session.getAttribute("anio"), "marcaNombre", session.getAttribute("marcaNombre"),
                        "nombreModelo", session.getAttribute("nombreModelo"),"nombreVersion", session.getAttribute("nombreVersion"),
                        "coberturaPdf", session.getAttribute("coberturaPdf"),"coberturaNombre", session.getAttribute("coberturaNombre")
                        )
                );

        response.setContentType("aplication/pdf");
        response.setHeader("Content-Disposition","attachment; filename=cotizacion.pdf");
        response.getOutputStream().write(pdf);

}




@PostMapping("enviar-pdf")
    public String enviarPdf(HttpSession session, RedirectAttributes  response) throws Exception{
    System.out.println("ENTRO AL POST");
    CotizacionDTO cotizacionDTO = (CotizacionDTO) session.getAttribute("form");
    System.out.println("Recuperado: " + cotizacionDTO.getCorreo());

    byte[] pdf = pdfService.generarPDF((CotizacionDTO) session.getAttribute("form"),
            (CotizacionFinalDTO) session.getAttribute("genera"),
            (Map<String, Map<String, BigDecimal>>) session.getAttribute("costos"),
            Map.of("anio", session.getAttribute("anio"), "marcaNombre", session.getAttribute("marcaNombre"),
                    "nombreModelo", session.getAttribute("nombreModelo"),"nombreVersion", session.getAttribute("nombreVersion"),
                    "coberturaPdf", session.getAttribute("coberturaPdf"),"coberturaNombre", session.getAttribute("coberturaNombre")
            )
    );


    pdfService.enviarPdf(cotizacionDTO.getCorreo(), pdf);

    response.addFlashAttribute("mensaje", "Correo enviado correctamente");
    return "redirect:/cotizar";

}
















}
