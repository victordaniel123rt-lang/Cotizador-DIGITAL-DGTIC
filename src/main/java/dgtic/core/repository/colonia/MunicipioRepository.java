package dgtic.core.repository.colonia;

import dgtic.core.model.dto.colonia.MunicipioDTO;
import dgtic.core.model.entity.direccion.Municipio;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface MunicipioRepository extends JpaRepository<Municipio, Long>{

    @Query("SELECT new dgtic.core.model.dto.colonia.MunicipioDTO(m.municipio_id, m.nombre) " +
            "FROM Municipio m " +
            "WHERE m.nombre = :nombre AND m.estado.nombre = :estado")
    Optional<MunicipioDTO> findByNombreAndEstadoNombre(@Param("nombre") String nombre, @Param("estado") String estado);

    Optional<Municipio> findByNombre(String nombre);



}
