package dgtic.core.repository.auto;

import dgtic.core.model.entity.auto.Version;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VersionRepository extends JpaRepository<Version, Long> {
}
