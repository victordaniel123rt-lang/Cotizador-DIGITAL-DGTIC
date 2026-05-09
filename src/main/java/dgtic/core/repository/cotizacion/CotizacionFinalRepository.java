package dgtic.core.repository.cotizacion;

import dgtic.core.model.dto.Cotizacion.CotizacionFinalDTO;
import dgtic.core.model.entity.Cotizacion.Coberturas;
import dgtic.core.model.entity.Cotizacion.CotizacionFinal;
import dgtic.core.model.entity.auto.Marca;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface CotizacionFinalRepository extends JpaRepository<CotizacionFinal, Long>{
    @Query("""
SELECT a FROM CotizacionFinal a
WHERE a.cobertura.id = :cobertura
""")
    CotizacionFinal obtenerCotizacionPorCobertura(@Param("cobertura") Long cobertura);

}
