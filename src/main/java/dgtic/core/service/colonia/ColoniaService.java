package dgtic.core.service.colonia;

import dgtic.core.model.dto.colonia.ColoniaDTO;
import dgtic.core.model.entity.direccion.Colonia;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface ColoniaService {
    List<ColoniaDTO> findAll();
    List<Colonia> obtenerTodas();
    ColoniaDTO findById(Long id);
    ColoniaDTO save(ColoniaDTO coloniaDTO);
    void deleteById(Long id);
    Colonia crearUObtener(Colonia colonia);

    @Transactional
    void actualizar(Colonia colonia);
    List<ColoniaDTO> findColoniaByCP(String codigo);

}
