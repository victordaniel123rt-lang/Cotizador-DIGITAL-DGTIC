package dgtic.core.model.dto.auto;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class VersionDTO {
    private Long idVersion;
    private String version;
    private Long modelo;

    @Override
    public String toString() {
        return version;
    }
}
