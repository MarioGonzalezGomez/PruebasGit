package service;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * Esta clase prueba los métodos públicos de TiendaBuilder
 * 
 * @author Mario
 *
 */
public class TiendaBuilderTest {
	TiendaBuilder tiendaTest = new TiendaBuilder();

	/**
	 * Este test vigila que el Producto[] salida de generaTienda tenga el mismo
	 * length que la constante definida como NUM_PRODUCTOS
	 */
	@Test
	public void generaTiendaOk() {
		Assertions.assertEquals(20, tiendaTest.generaTienda().getProductos().length);
	}
}
