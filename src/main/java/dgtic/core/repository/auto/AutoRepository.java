package dgtic.core.repository.auto;

import dgtic.core.model.entity.auto.Auto;
import dgtic.core.model.entity.auto.Marca;
import dgtic.core.model.entity.auto.Modelo;
import dgtic.core.model.entity.auto.Version;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface AutoRepository extends JpaRepository<Auto,Long> {

    @Query("""
SELECT DISTINCT x FROM Auto a
JOIN a.modelo r
JOIN r.marca x
JOIN FETCH x.logo
WHERE a.anio.id_anio = :anio
""")
    List<Marca> obtenerMarcasAndImagenesPorAnio(@Param("anio") Long anio);



    @Query("""
SELECT DISTINCT m FROM Auto a
JOIN a.modelo r
JOIN r.marca m
WHERE a.anio.id_anio = :anio
""")
    List<Marca> obtenerMarcasPorAnio(@Param("anio") Long anio);

    @Query("""
SELECT DISTINCT s FROM Auto a
JOIN a.modelo s
JOIN s.marca m
WHERE a.anio.id_anio = :anio
AND m.id_marca = :marca
""")
    List<Modelo> obtenerModelosPorAnioYMarca(
            @Param("anio") Long anio,
            @Param("marca") Long marca
    );
    @Query("""
SELECT DISTINCT ve FROM Auto a
JOIN a.version ve
JOIN ve.modelo m
WHERE a.anio.id_anio = :anio
AND m.id_modelo = :modelo
""")
    List<Version> obtenerVersionesPorAñoYModelo(
            @Param("anio") Long anio,
            @Param("modelo") Long modelo
    );


   // String obtenerMarcaById(Long id);


}
