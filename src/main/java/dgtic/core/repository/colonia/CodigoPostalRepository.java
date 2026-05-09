package dgtic.core.repository.colonia;

import dgtic.core.model.dto.colonia.CodigoPostalDTO;
import dgtic.core.model.entity.direccion.CodigoPostal;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;
@Repository
public interface CodigoPostalRepository extends JpaRepository<CodigoPostal, Long> {
//    @Query("SELECT new dgtic.core.model.dto.colonia.CodigoPostalDTO(c.id_cp, c.codigo) FROM CodigoPostal c WHERE c.codigo = :codigo")
//    CodigoPostalDTO findByCodigoDos(@Param("codigo") String codigo);

    Optional<CodigoPostal> findByCodigo(String codigo);

}
