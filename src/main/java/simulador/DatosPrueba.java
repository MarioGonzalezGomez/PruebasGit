package simulador;

import java.math.BigDecimal;
import java.math.RoundingMode;

import service.TiendaBuilder;

/**
 * En esta clase se almacenan los métodos para la generación de arrays de
 * precios y costes con datos randomizados
 * 
 * @author Mario
 *
 */
public class DatosPrueba {

	private int maxPrecio = 2000;
	private int maxCoste = 1000;

	// Genera precio random entre 0 y 2000
	/**
	 * Este método genera un array con la capacidad definida en NUM_PRODUCTOS con
	 * precios aleatorios desde 0 hasta maxPrecio
	 * 
	 * @return arrayPrecios double[]
	 */
	public double[] generadorPrecios() {
		double[] arrayPrecios = new double[TiendaBuilder.getNumProductos()];
		for (int i = 0; i < arrayPrecios.length; i++) {
			arrayPrecios[i] = BigDecimal.valueOf(Math.random() * maxPrecio + 1).setScale(2, RoundingMode.HALF_UP)
					.doubleValue();

		}
		return arrayPrecios;
	}

	// Genera coste random entre 0 y 1000
	/**
	 * Este método genera un array con la capacidad definida en NUM_PRODUCTOS con
	 * costes aleatorios desde 0 hasta maxCoste
	 * 
	 * @return arrayCoste double[]
	 */
	public double[] generadorCostes() {
		double[] arrayCoste = new double[TiendaBuilder.getNumProductos()];
		for (int i = 0; i < arrayCoste.length; i++) {
			arrayCoste[i] = BigDecimal.valueOf(Math.random() * maxCoste).setScale(2, RoundingMode.HALF_UP)
					.doubleValue();
		}
		return arrayCoste;
	}

	/**
	 * Getter de la variable privada maxPrecio
	 * 
	 * @return maxPrecio int
	 */
	public int getMaxPrecio() {
		return maxPrecio;
	}

	/**
	 * Setter que carga un valor int introducido por parámetro en la variable
	 * maxPrecio
	 * 
	 * @param maxPrecio int
	 */
	public void setMaxPrecio(int maxPrecio) {
		this.maxPrecio = maxPrecio;
	}

	/**
	 * Getter de la variable privada maxCoste
	 * 
	 * @return maxCoste int
	 */
	public int getMaxCoste() {
		return maxCoste;
	}

	/**
	 * Getter de la variable privada maxCoste
	 * 
	 * @param maxCoste int
	 */
	public void setMaxCoste(int maxCoste) {
		this.maxCoste = maxCoste;
	}

}
