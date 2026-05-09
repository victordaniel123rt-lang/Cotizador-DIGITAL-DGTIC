package dgtic.core.repository.colonia;

import dgtic.core.model.dto.colonia.EstadoDTO;
import dgtic.core.model.entity.direccion.Estado;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface EstadoRepository extends JpaRepository<Estado, Long> {
//    @Query("SELECT new dgtic.core.model.dto.colonia.EstadoDTO(e.estado_id, e.nombre) FROM Estado e WHERE e.nombre = :nombre")
//    Optional<EstadoDTO> findByNombre(@Param("nombre") String nombre);

    Optional<Estado> findByNombre(String nombre);
}
