package dgtic.core.model.dto.auto;


import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class MarcaDTO {
    private Long idMarca;
    private String marca;
    private Long logo;

    public MarcaDTO(String marca) {
        this.marca = marca;
    }

    @Override
    public String toString() {
        return marca;
    }
}
