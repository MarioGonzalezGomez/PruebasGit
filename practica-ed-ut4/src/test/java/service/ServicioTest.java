package service;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import entity.Producto;
import entity.Tienda;

/**
 * Esta clase prueba los métodos públicos de Servicios
 * 
 * @author Mario
 *
 */
public class ServicioTest {
	Servicio servtest = new Servicio();
	Tienda tiendaTest = new Tienda();

	/**
	 * Este test vigila que el double[] salida de margenBeneficio tenga el mismo
	 * length que el número de Producto contenido en un objeto Tienda
	 */
	@Test
	public void margenBeneficioSalidaOk() {
		Producto prodTest1 = new Producto(1, 1);
		Producto prodTest2 = new Producto(1, 1);
		Producto prodTest3 = new Producto(1, 1);
		Producto[] productos = { prodTest1, prodTest2, prodTest3 };
		tiendaTest.setProductos(productos);
		Assertions.assertEquals(3, servtest.margenBeneficio(tiendaTest).length);
	}

	/**
	 * Este test vigila que el funcionamiento de margenBeneficio sea correcto,
	 * introduciendo unos datos de testeo y comparando el resultado esperado con la
	 * salida
	 */
	@Test
	public void margenBeneficioCalculoOk() {
		Producto prodTest1 = new Producto(100, 50);
		Producto[] productos = { prodTest1 };
		tiendaTest.setProductos(productos);
		Assertions.assertEquals(50.0, servtest.margenBeneficio(tiendaTest)[0]);
	}

	/**
	 * Este test vigila que el funcionamiento de margenBeneficio sea correcto en el
	 * caso de encontrarse un producto con margen de beneficio 0
	 * 
	 */
	@Test
	public void margenBeneficio0() {
		Producto prodTest1 = new Producto(100, 100);
		Producto[] productos = { prodTest1 };
		tiendaTest.setProductos(productos);
		Assertions.assertEquals(0.0, servtest.margenBeneficio(tiendaTest)[0]);
	}

	/**
	 * Este test vigila que el funcionamiento de margenBeneficio sea correcto en el
	 * caso de encontrarse un producto con margen de beneficio negativo
	 * 
	 */
	@Test
	public void margenBeneficioNegativo() {
		Producto prodTest1 = new Producto(50, 100);
		Producto[] productos = { prodTest1 };
		tiendaTest.setProductos(productos);
		Assertions.assertEquals(-100.0, servtest.margenBeneficio(tiendaTest)[0]);
	}

	/**
	 * Este test vigila que el try-catch funciona correctamente y que se obtiene la
	 * salida esperada al encontrarse con un parámetro introducido null
	 */
	@Test
	public void margenBeneficioIfNull() {
		Assertions.assertEquals(null, servtest.margenBeneficio(tiendaTest));
	}

	/**
	 * Este test vigila que el funcionamiento de mayorMargenBeneficio sea correcto,
	 * introduciendo unos datos de testeo y comparando el resultado esperado con la
	 * salida
	 */
	@Test
	public void mayorMargenBeneficioCalculoOk() {
		Producto prodTest1 = new Producto(4, 1);
		Producto prodTest2 = new Producto(4, 3);
		Producto prodTest3 = new Producto(4, 2);
		Producto[] productos = { prodTest1, prodTest2, prodTest3 };
		tiendaTest.setProductos(productos);
		double[] beneficios = { 75.0, 25.0, 50.0 };
		tiendaTest.setMargenBeneficio(beneficios);
		Assertions.assertEquals(75.0, servtest.mayorMargenBeneficio(tiendaTest));
	}

	/**
	 * Este test comprueba que el método no da errores en caso de encontrarse con
	 * dos beneficios iguales, siendo ambos los mayores del array
	 */
	@Test
	public void mayorMargenBeneficioEmpate() {
		Producto prodTest1 = new Producto(4, 1);
		Producto prodTest2 = new Producto(4, 3);
		Producto prodTest3 = new Producto(4, 1);
		Producto[] productos = { prodTest1, prodTest2, prodTest3 };
		tiendaTest.setProductos(productos);
		double[] beneficios = { 75.0, 25.0, 75.0 };
		tiendaTest.setMargenBeneficio(beneficios);
		Assertions.assertEquals(75.0, servtest.mayorMargenBeneficio(tiendaTest));
	}

	/**
	 * Este test vigila que el método funciona correctamente en caso de obtener por
	 * parámetro un objeto null
	 */
	@Test
	public void mayorMargenBeneficioIfNull() {
		// el método devolvería 0 al no encontrar otros valores con los que comparar y
		// modificar el mayorMargenBeneficioAux
		Assertions.assertEquals(0.0, servtest.mayorMargenBeneficio(tiendaTest));
	}

	/**
	 * Este test vigila que el funcionamiento de menorMargenBeneficio sea correcto,
	 * introduciendo unos datos de testeo y comparando el resultado esperado con la
	 * salida
	 */
	@Test
	public void menorMargenBeneficioCalculoOk() {
		Producto prodTest1 = new Producto(4, 1);
		Producto prodTest2 = new Producto(4, 3);
		Producto prodTest3 = new Producto(4, 2);
		Producto[] productos = { prodTest1, prodTest2, prodTest3 };
		tiendaTest.setProductos(productos);
		double[] beneficios = { 75.0, 25.0, 50.0 };
		tiendaTest.setMargenBeneficio(beneficios);
		Assertions.assertEquals(25.0, servtest.menorMargenBeneficio(tiendaTest));
	}

	/**
	 * Este test comprueba que el método no da errores en caso de encontrarse con
	 * dos beneficios iguales, siendo ambos los menores del array
	 */
	@Test
	public void menorMargenBeneficioEmpate() {
		Producto prodTest1 = new Producto(4, 3);
		Producto prodTest2 = new Producto(4, 3);
		Producto prodTest3 = new Producto(4, 1);
		Producto[] productos = { prodTest1, prodTest2, prodTest3 };
		tiendaTest.setProductos(productos);
		double[] beneficios = { 25.0, 25.0, 75.0 };
		tiendaTest.setMargenBeneficio(beneficios);
		Assertions.assertEquals(25.0, servtest.menorMargenBeneficio(tiendaTest));
	}

	/**
	 * Este test vigila que el método funciona correctamente en caso de obtener por
	 * parámetro un objeto null
	 */
	@Test
	public void menorMargenBeneficioIfNull() {
		// el método devolvería 0 al no encontrar otros valores con los que comparar y
		// modificar el menorMargenBeneficioAux
		Assertions.assertEquals(0.0, servtest.menorMargenBeneficio(tiendaTest));
	}

	/**
	 * Este test vigila que el funcionamiento de obtenerIdMargen sea correcto,
	 * introduciendo unos datos de testeo y comparando el resultado esperado con la
	 * salida (id del producto)
	 */
	@Test
	public void obtenerIdMargenOk() {
		Producto prodTest1 = new Producto(100, 50);
		Producto prodTest2 = new Producto(100, 60);
		Producto prodTest3 = new Producto(90, 70);
		Producto[] productos = { prodTest1, prodTest2, prodTest3 };
		tiendaTest.setProductos(productos);
		servtest.margenBeneficio(tiendaTest);
		Assertions.assertEquals(1, servtest.obtenerIdMargen(tiendaTest, 50.0));
	}

	/**
	 * Este test vigila que el funcionamiento de obtenerIdMargen sea correcto,
	 * introduciendo unos datos de testeo y comparando el resultado esperado con la
	 * salida (0) al no encontrar coincidencia
	 */
	@Test
	public void obtenerIdMargenNoEncontrado() {
		Producto prodTest1 = new Producto(100, 50);
		Producto prodTest2 = new Producto(100, 60);
		Producto prodTest3 = new Producto(90, 70);
		Producto[] productos = { prodTest1, prodTest2, prodTest3 };
		tiendaTest.setProductos(productos);
		servtest.margenBeneficio(tiendaTest);
		// Utilizo 1,7 como un valor cualquiera que no está en el margenBeneficio[]
		Assertions.assertEquals(0, servtest.obtenerIdMargen(tiendaTest, 1.7));
	}

	/**
	 * Este test vigila que el método funciona correctamente en caso de obtener por
	 * parámetro un objeto null
	 */
	@Test
	public void obtenerIdMargenIfNull() {
		// Utilizo 1,7 como un valor cualquiera
		// El método devuelve el valor por defecto 0 si no encuentra el valor. Al
		// introducir un objeto vacío, no se realiza la comparación y devuelve
		// automáticamente 0
		Assertions.assertEquals(0, servtest.obtenerIdMargen(tiendaTest, 1.7));
	}

	/**
	 * Este test vigila que el funcionamiento de nuevoPrecio sea correcto,
	 * introduciendo unos datos de testeo. Se testea con el Producto 3, que tiene
	 * menos de un 10% de margen de beneficio, esperando que el método devuelva un
	 * valor distinto de 0 en su posición
	 */
	@Test
	public void nuevoPrecioModificaOk() {
		Producto prodTest1 = new Producto(100, 50);
		Producto prodTest2 = new Producto(10, 10);
		Producto[] productos = { prodTest1, prodTest2 };
		tiendaTest.setProductos(productos);
		servtest.margenBeneficio(tiendaTest);
		// prodTest2 tenía un margen de 0, por lo que el método
		// nuevoPrecioMargenMenorDiez() modifica su valor
		Assertions.assertNotEquals(0.0, servtest.nuevoPrecioMargenMenorDiez(tiendaTest)[1]);
	}

	/**
	 * Este test comprueba si el comportamiento del método es el adecuado en el caso
	 * de encontrarse un producto de beneficio 0
	 */
	@Test
	public void nuevoPrecioCalculoOkBeneficio0() {
		Producto prodTest1 = new Producto(1, 1);
		Producto[] productos = { prodTest1 };
		tiendaTest.setProductos(productos);
		servtest.margenBeneficio(tiendaTest);
		Assertions.assertEquals(1.11, servtest.nuevoPrecioMargenMenorDiez(tiendaTest)[0]);
	}

	/**
	 * Este test comprueba si el comportamiento del método es el adecuado en el caso
	 * de encontrarse un producto de beneficio menor que 0
	 */
	@Test
	public void nuevoPrecioCalculoOkBeneficioNegativo() {
		Producto prodTest1 = new Producto(1, 2);
		Producto[] productos = { prodTest1 };
		tiendaTest.setProductos(productos);
		servtest.margenBeneficio(tiendaTest);
		Assertions.assertEquals(2.22, servtest.nuevoPrecioMargenMenorDiez(tiendaTest)[0]);
	}

	/**
	 * Este test vigila que el try-catch funciona correctamente y que se obtiene la
	 * salida esperada al encontrarse con un parámetro introducido null
	 */
	@Test
	public void nuevoPrecioIfNull() {
		Assertions.assertEquals(null, servtest.nuevoPrecioMargenMenorDiez(tiendaTest));
	}

	/**
	 * Este test vigila que el funcionamiento de beneficioTotal sea correcto,
	 * introduciendo unos datos de testeo y comparando el resultado esperado con la
	 * salida. Incluye beneficio 0 y negativo.
	 */
	@Test
	public void beneficioTotalCalculoOk() {
		Producto prodTest1 = new Producto(100, 50);
		Producto prodTest2 = new Producto(100, 100);
		Producto prodTest3 = new Producto(100, 110);
		Producto[] productos = { prodTest1, prodTest2, prodTest3 };
		tiendaTest.setProductos(productos);
		Assertions.assertEquals(40.0, servtest.beneficioTotal(tiendaTest));
	}
	
	/**
	 * Este test vigila que el método funciona correctamente y que se obtiene la
	 * salida esperada al encontrarse con un parámetro introducido null
	 */
	@Test
	public void beneficioTotalIfNull() {
		Assertions.assertEquals(null, servtest.nuevoPrecioMargenMenorDiez(tiendaTest));
	}

	/**
	 * Este test vigila que el double[] salida de crearArrayPrecios tenga el mismo
	 * length que el número de Producto contenido en un objeto Tienda
	 */
	@Test
	public void crearArrayPreciosOk() {
		Producto prodTest1 = new Producto();
		Producto prodTest2 = new Producto();
		Producto prodTest3 = new Producto();
		Producto[] productos = { prodTest1, prodTest2, prodTest3 };
		tiendaTest.setProductos(productos);
		Assertions.assertEquals(3, servtest.crearArrayPrecios(tiendaTest).length);
	}

	/**
	 * Este test vigila que el try-catch funciona correctamente y que se obtiene la
	 * salida esperada al encontrarse con un parámetro introducido null
	 */
	@Test
	public void crearArrayPreciosIfNull() {
		Assertions.assertEquals(null, servtest.crearArrayPrecios(tiendaTest));
	}

	/**
	 * Este test vigila que el double[] salida de crearArrayCostes tenga el mismo
	 * length que el número de Producto contenido en un objeto Tienda
	 */
	@Test
	public void crearArrayCostesOk() {
		Producto prodTest1 = new Producto();
		Producto prodTest2 = new Producto();
		Producto prodTest3 = new Producto();
		Producto[] productos = { prodTest1, prodTest2, prodTest3 };
		tiendaTest.setProductos(productos);
		Assertions.assertEquals(3, servtest.crearArrayCostes(tiendaTest).length);
	}

	/**
	 * Este test vigila que el try-catch funciona correctamente y que se obtiene la
	 * salida esperada al encontrarse con un parámetro introducido null
	 */
	@Test
	public void crearArrayCostesIfNull() {
		Assertions.assertEquals(null, servtest.crearArrayCostes(tiendaTest));
	}

}
