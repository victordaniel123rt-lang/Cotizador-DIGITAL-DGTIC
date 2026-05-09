package dgtic.core.service.Vehiculo.Version;

import dgtic.core.model.dto.auto.VersionDTO;

import java.util.List;


public interface VersionService {
    List<VersionDTO> findAll();
    VersionDTO findById(Long id);
    VersionDTO save(VersionDTO versionDTO);
    void deleteById(Long id);
}
