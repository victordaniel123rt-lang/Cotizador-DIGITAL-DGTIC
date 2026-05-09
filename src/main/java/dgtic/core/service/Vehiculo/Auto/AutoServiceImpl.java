package dgtic.core.service.Vehiculo.Auto;

import dgtic.core.model.entity.auto.Marca;
import dgtic.core.model.entity.auto.Modelo;
import dgtic.core.model.entity.auto.Version;
import dgtic.core.repository.auto.AutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AutoServiceImpl implements AutoService{
    @Autowired
    AutoRepository autoRepository;

    public List<Marca> obtenerMarcas(Long anio){
        return autoRepository.obtenerMarcasAndImagenesPorAnio(anio);
    }

    public List<Modelo> obtenerModelosPorAnioAndMarca(Long anio, Long marca){
        return autoRepository.obtenerModelosPorAnioYMarca(anio,marca);
    }

    public List<Version> obtenerVersionesPorAnioAndModelo(Long anio, Long modelo){
        return autoRepository.obtenerVersionesPorAñoYModelo(anio,modelo);
    }


//    @Override
//    public String obtenerMarcaById(long id) {
//        return autoRepository.obtenerMarcaById(id);
//    }

    @Override
    public String obtenerNombreModelo(Long id) {
        return "";
    }

    @Override
    public String obtenerNombreVersion(Long id) {
        return "";
    }
}
