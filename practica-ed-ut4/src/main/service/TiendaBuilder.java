package service;

import entity.Producto;
import entity.Tienda;
import simulador.DatosPrueba;

/**
 * En esta clase se almacenan los m�todos para la generaci�n de un objeto Tienda
 * 
 * @author Mario
 *
 */
public class TiendaBuilder {
	DatosPrueba random = new DatosPrueba();
	/**
	 * Esta constante determina el tama�o de las tiendas generadas
	 */
	public final static int NUM_PRODUCTOS = 20;

	/**
	 * Este m�todo genera un array de Producto con productos con datos obtenidos de
	 * los m�todos de {@link DatosPrueba} y lo introduce en un objeto Tienda
	 * 
	 * @return tienda Tienda
	 */
	public Tienda generaTienda() {
		Tienda tienda = new Tienda();
		Producto[] productos = new Producto[NUM_PRODUCTOS];
		double[] precios = random.generadorPrecios();
		double[] costes = random.generadorCostes();
		for (int i = 0; i < productos.length; i++) {
			Producto producto = new Producto();
			producto.setPrecio(precios[i]);
			producto.setCostes(costes[i]);
			productos[i] = producto;
		}
		tienda.setProductos(productos);
		return tienda;
	}

	/**
	 * Getter de la constante NUM_PRODUCTOS
	 * 
	 * @return NUM_PRODUCTOS int
	 */
	public static int getNumProductos() {
		return NUM_PRODUCTOS;
	}
}
