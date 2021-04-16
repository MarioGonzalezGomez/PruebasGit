package simulador;

import java.math.BigDecimal;
import java.math.RoundingMode;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * Esta clase prueba los métodos públicos de DatosPrueba
 * 
 * @author Mario
 *
 */
public class DatosPruebaTest {
	DatosPrueba dptest = new DatosPrueba();

	/**
	 * Este test vigila que el double[] salida de generadorPrecios tenga el mismo
	 * length que el número de Producto contenido en un objeto Tienda
	 */
	@Test
	public void generadorPreciosOk() {
		Assertions.assertEquals(20, dptest.generadorPrecios().length);
	}

	/**
	 * Este test comprueba que el generador no devuelve un precio 0 aunque el
	 * math.random de este resultado
	 */
	@Test
	public void generadorPrecios0() {
		Assertions.assertNotEquals(0,
				BigDecimal.valueOf(0 * dptest.getMaxCoste() + 1).setScale(2, RoundingMode.HALF_UP).doubleValue());
	}

	/**
	 * Este test vigila que el double[] salida de generadorCostes tenga el mismo
	 * length que el número de Producto contenido en un objeto Tienda
	 */
	@Test
	public void generadorCostesOk() {
		Assertions.assertEquals(20, dptest.generadorCostes().length);
	}

}
