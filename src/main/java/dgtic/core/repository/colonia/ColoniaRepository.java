package dgtic.core.repository.colonia;

import dgtic.core.model.dto.colonia.ColoniaDTO;
import dgtic.core.model.entity.direccion.Colonia;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface ColoniaRepository extends JpaRepository<Colonia, Long> {

    @Query("SELECT new dgtic.core.model.dto.colonia.ColoniaDTO(c.id_colonia,c.nombre) "
            + " FROM Colonia c WHERE c.codigoPostal.id_cp=:codigopostalID")
    List<ColoniaDTO> findColoniaByCP(@Param("codigopostalID") String codigopostalID);

    @Query("SELECT c FROM Colonia c " +
            "JOIN FETCH c.codigoPostal p " +
            "JOIN FETCH c.municipio m " +
            "JOIN FETCH m.estado")
    List<Colonia> findAllWithMunicipioCpAndEstado();



    Optional<Colonia> findByNombre(String nombre);





}
