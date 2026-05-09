package dgtic.core.model.dto.auto;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class LogoDTO {
    private Long logoid;
    private String urlogo;
    private Long marca;
}
