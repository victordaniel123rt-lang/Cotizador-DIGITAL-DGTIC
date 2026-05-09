package dgtic.core.repository.usuarios;

import dgtic.core.model.entity.Asesor;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface AsesorRepository extends JpaRepository<Asesor,Long>{
    Optional<Asesor> findByUsuario(String username);
}
