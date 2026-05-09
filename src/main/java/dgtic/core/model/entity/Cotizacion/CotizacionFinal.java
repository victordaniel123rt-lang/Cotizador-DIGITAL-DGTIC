package dgtic.core.model.entity.Cotizacion;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;

@Entity
@Table(name = "cotizacion")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class CotizacionFinal {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private BigDecimal costo;

    @ManyToOne
    @JoinColumn(name = "cobertura_id")
    private Coberturas cobertura;

    @Override
    public String toString() {
        return "CotizacionFinal{" +
                "cobertura=" + cobertura +
                ", id=" + id +
                ", costo=" + costo +
                '}';
    }
}
