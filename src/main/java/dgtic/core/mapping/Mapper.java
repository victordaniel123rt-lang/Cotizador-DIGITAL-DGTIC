package dgtic.core.mapping;

import dgtic.core.model.dto.*;
import dgtic.core.model.dto.Cotizacion.CoberturasDTO;
import dgtic.core.model.dto.Cotizacion.CotizacionFinalDTO;
import dgtic.core.model.dto.auto.*;
import dgtic.core.model.dto.colonia.CodigoPostalDTO;
import dgtic.core.model.dto.colonia.ColoniaDTO;
import dgtic.core.model.dto.colonia.EstadoDTO;
import dgtic.core.model.dto.colonia.MunicipioDTO;
import dgtic.core.model.entity.*;
import dgtic.core.model.entity.Cotizacion.Coberturas;
import dgtic.core.model.entity.Cotizacion.CotizacionFinal;
import dgtic.core.model.entity.auto.*;
import dgtic.core.model.entity.direccion.CodigoPostal;
import dgtic.core.model.entity.direccion.Colonia;
import dgtic.core.model.entity.direccion.Estado;
import dgtic.core.model.entity.direccion.Municipio;

public class Mapper {


    public static Logo toLogo(LogoDTO logoDTO){
        if(logoDTO == null){
            return null;
        }
        return Logo.builder()
                .idLogo(logoDTO.getLogoid())
                .urlogo(logoDTO.getUrlogo())
                .build();
    }

    public static LogoDTO toLogoDTO(Logo logo){
        if(logo==null){
            return null;
        }
        LogoDTO logoDTO = LogoDTO.builder()
                .logoid(logo.getIdLogo())
                .urlogo(logo.getUrlogo())
                .marca(logo.getMarca().getId_marca())
                .build();
        return logoDTO;
    }



    public static AñoDTO toAñoDTO(Año año){
        if(año == null){
            return  null;
        }
        AñoDTO añoDTO = AñoDTO.builder()
                .anio_id(año.getId_anio())
                .anio(año.getAnio())
                .build();
        return añoDTO;
    }


    public static VersionDTO toVersionDTO(Version version){
        if(version==null){
            return null;
        }
        VersionDTO versionDTO = VersionDTO.builder()
                .idVersion(version.getId_version())
                .version(version.getVersion())
                .modelo(version.getModelo().getId_modelo())
                .build();

        return versionDTO;
    }



    public static ModeloDTO toModeloDTO(Modelo modelo){
        if(modelo == null){
            return null;
        }
        ModeloDTO modeloDTO = ModeloDTO.builder()
                .idModelo(modelo.getId_modelo())
                .modelo(modelo.getModelo())
                .marca(modelo.getMarca().getId_marca())
                .build();
        return modeloDTO;
    }




    public static MarcaDTO toMarcaDTO(Marca marca){
        if(marca == null){
            return null;
        }
        MarcaDTO marcaDTO = MarcaDTO.builder()
                .idMarca(marca.getId_marca())
                .marca(marca.getMarca())
                .build();
        return marcaDTO;
    }


    public static Marca toMarca(MarcaDTO marcaDTO){
        if(marcaDTO==null){
            return  null;
        }
        return Marca.builder()
                .id_marca(marcaDTO.getIdMarca())
                .marca(marcaDTO.getMarca())
                .build();

    }




    public static ClienteDTO toClienteDTO(Cliente cliente){
        if (cliente == null){
            return null;
        }
        return ClienteDTO.builder()
                .nombre(cliente.getNombre())
                .segundonombre(cliente.getSegundoNombre())
                .apellidoPaterno(cliente.getApellido_paterno())
                .apellidoMaterno(cliente.getApellido_materno())
                .fechaNacimiento(cliente.getFnac())
                .genero(cliente.getGenero())
                .correo(cliente.getCorreo())
                .numero(cliente.getNumero())
                .build();
    }

    public static Cliente toCliente(ClienteDTO clienteDTO){
        if(clienteDTO == null){
            return null;
        }
        return Cliente.builder()
                .id(clienteDTO.getIdCliente())
                .nombre(clienteDTO.getNombre())
                .segundoNombre(clienteDTO.getSegundonombre())
                .apellido_paterno(clienteDTO.getApellidoPaterno())
                .apellido_materno(clienteDTO.getApellidoMaterno())
                .fnac(clienteDTO.getFechaNacimiento())
                .numero(clienteDTO.getNumero())
                .genero(clienteDTO.getGenero())
                .correo(clienteDTO.getCorreo())
                .build();
    }


    public static ColoniaDTO toColoniaDTO(Colonia colonia) {
        if (colonia == null) {
            return null;
        }
        return ColoniaDTO.builder()
                .colonia_id(colonia.getId_colonia())
                .nombre(colonia.getNombre())
                .build();

    }

    public static Estado toEstado(EstadoDTO estadoDTO) {
        if (estadoDTO == null) {
            return null;
        }
        return Estado.builder()
                .estado_id(estadoDTO.getId_estado())
                .nombre(estadoDTO.getNombre())
                .build();
    }

    public static EstadoDTO toEstadoDTO(Estado estado) {
        if (estado == null) {
            return null;
        }
        return EstadoDTO.builder()
                .id_estado(estado.getEstado_id())
                .nombre(estado.getNombre())
                .build();
    }


    public static Municipio toMunicipio(MunicipioDTO municipioDTO) {
        if (municipioDTO == null) {
            return null;
        }
        return Municipio.builder()
                .municipio_id(municipioDTO.getId_municipio())
                .nombre(municipioDTO.getNombre())
                .build();
    }
    public static MunicipioDTO tomunicipioDTO(Municipio municipio){
        if(municipio==null){
            return null;
        }
        return MunicipioDTO.builder()
                .id_municipio(municipio.getMunicipio_id())
                .nombre(municipio.getNombre())
                .build();
    }

    public static CodigoPostalDTO toCodigoDTO(CodigoPostal codigoPostal){
        if(codigoPostal==null){
            return null;
        }
        return CodigoPostalDTO.builder()
                .cp_id(codigoPostal.getId_cp())
                .nombre(codigoPostal.getCodigo())
                .build();
    }

    public static CodigoPostal toCodigo(CodigoPostalDTO codigoPostalDTO){
        if(codigoPostalDTO==null){
            return null;
        }
        return CodigoPostal.builder()
                .id_cp(codigoPostalDTO.getCp_id())
                .codigo(codigoPostalDTO.getNombre())
                .build();
    }


    public static CoberturasDTO toCoberturasDTO(Coberturas coberturas){
        if(coberturas==null){
            return null;
        }
        return  CoberturasDTO.builder()
                .id(coberturas.getId())
                .nombre(coberturas.getNombre())
                .build();
    }


    public static CotizacionFinalDTO toCotizacionFinalDTO(CotizacionFinal cotizacionFinal){
        if(cotizacionFinal==null){
            return null;
        }
        return CotizacionFinalDTO.builder()
                .id(cotizacionFinal.getId())
                .costo(cotizacionFinal.getCosto())
                .build();
    }

    public CotizacionFinalDTO toDTO(CotizacionFinal entity) {
        CotizacionFinalDTO dto = new CotizacionFinalDTO();
        dto.setCosto(entity.getCosto());
        dto.setCobertura(entity.getCobertura().getId());
        return dto;
    }




}
