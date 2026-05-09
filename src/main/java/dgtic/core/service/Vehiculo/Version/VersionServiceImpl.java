package dgtic.core.service.Vehiculo.Version;

import dgtic.core.mapping.Mapper;
import dgtic.core.model.dto.auto.VersionDTO;
import dgtic.core.model.entity.auto.Version;
import dgtic.core.repository.auto.VersionRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class VersionServiceImpl implements VersionService{
    VersionRepository versionRepository;

    @Override
    public List<VersionDTO> findAll() {
        return List.of();
    }

    @Override
    public VersionDTO findById(Long id) {
        Version version = versionRepository.findById(id).orElseThrow(
                ()-> new RuntimeException("No se encontro la version con el id:" + id)
        );
        return Mapper.toVersionDTO(version);
    }

    @Override
    public VersionDTO save(VersionDTO versionDTO) {
        return null;
    }

    @Override
    public void deleteById(Long id) {

    }
}
