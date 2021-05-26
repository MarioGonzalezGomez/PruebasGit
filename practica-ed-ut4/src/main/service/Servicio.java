package service;

import java.math.BigDecimal;
import java.math.RoundingMode;
import entity.Tienda;

/**
 * En esta clase se almacenan los métodos utilizados en la clase Principal
 * 
 * @author Mario
 *
 */
public class Servicio {

	Tienda tienda = new Tienda();

	/**
	 * Contructor por defecto para la clase Servicio
	 */
	public Servicio() {

	}

	/**
	 * Este método recibe un objeto Tienda como parámetro, calcula y retorna en un
	 * array double[] los márgenes de beneficio tomando los datos de los objetos
	 * Producto introducidos en la Tienda
	 * 
	 * @param tienda Tienda
	 * @return arrayMargenes double[]
	 */
	public double[] margenBeneficio(Tienda tienda) {
		try {
			double[] arrayMargenes = new double[tienda.getProductos().length];

			for (int i = 0; i < tienda.getProductos().length; i++) {
				arrayMargenes[i] = BigDecimal
						.valueOf(((tienda.getProductos()[i].getPrecio() - tienda.getProductos()[i].getCostes())
								/ tienda.getProductos()[i].getPrecio()) * 100)
						.setScale(2, RoundingMode.HALF_UP).doubleValue();
			}
			tienda.setMargenBeneficio(arrayMargenes);
			return arrayMargenes;
		} catch (NullPointerException e) {
			return null;
		}
	}

	/**
	 * Compara los datos del double [] margenBeneficio de Tienda para obtener el
	 * mayor.
	 * 
	 * @param tienda Tienda
	 * @return margenMayor double
	 */
	public double mayorMargenBeneficio(Tienda tienda) {
		double aux = Double.MIN_VALUE;
		double margenMayor = 0;
		for (int i = 0; i < tienda.getMargenBeneficio().length; i++) {
			double margenMayorTemporal = tienda.getMargenBeneficio()[i];
			if (margenMayorTemporal > aux) {
				aux = margenMayorTemporal;
				margenMayor = margenMayorTemporal;
			}
		}
		return margenMayor;
	}

	/**
	 * Compara los datos del double [] margenBeneficio de Tienda para obtener el
	 * menor.
	 * 
	 * @param tienda Tienda
	 * @return margenMenor double
	 */
	public double menorMargenBeneficio(Tienda tienda) {
		double aux = Double.MAX_VALUE;
		double margenMenor = 0;
		for (int i = 0; i < tienda.getMargenBeneficio().length; i++) {
			double margenMenorTemporal = tienda.getMargenBeneficio()[i];
			if (margenMenorTemporal < aux) {
				aux = margenMenorTemporal;
				margenMenor = margenMenorTemporal;
			}
		}
		return margenMenor;
	}

	/**
	 * Este método compara el double margen introducido con los almacenados en
	 * margenesBeneficio[] de la tienda. Si encuentra una coincidencia, retorna el
	 * id del producto correspondiente a ese margen, y si no, devuelve 0
	 * 
	 * @param tienda Tienda
	 * @param margen double
	 * @return id del producto o 0 en caso de no encontrar coincidencia int
	 */
	public int obtenerIdMargen(Tienda tienda, double margen) {
		for (int i = 0; i < tienda.getProductos().length; i++) {
			if (margen == tienda.getMargenBeneficio()[i]) {
				return tienda.getProductos()[i].getId();
			}
		}
		return 0;

	}

	/**
	 * Este método recibe un objeto Tienda como parámetro y recorre su array de
	 * margenBeneficio. Si encuentra un valor menor a 10, recalcula el precio del
	 * Producto y lo introduce en un nuevo array
	 * 
	 * @param tienda Tienda
	 * @return arrayNuevoPrecio double[]
	 */
	public double[] nuevoPrecioMargenMenorDiez(Tienda tienda) {
		try {
			// declaro la variable para el 10% evitando magic numbers
			int porcentajeBeneficioPequenio = 10;
			double fraccionPorcentaje = 0.1;
			double[] arrayNuevoPrecio = new double[tienda.getProductos().length];
			for (int i = 0; i < tienda.getMargenBeneficio().length; i++) {
				if (tienda.getMargenBeneficio()[i] < porcentajeBeneficioPequenio) {
					arrayNuevoPrecio[i] = BigDecimal
							.valueOf((tienda.getProductos()[i].getCostes() / (1 - fraccionPorcentaje)))
							.setScale(2, RoundingMode.HALF_UP).doubleValue();
				}
			}
			tienda.setPreciosActualizados(arrayNuevoPrecio);
			return arrayNuevoPrecio;
		} catch (NullPointerException e) {
			return null;
		}
	}

	/**
	 * Este método recibe un objeto Tienda como parámetro y suma sus beneficios
	 * (precio- costes) de todos los Producto que contenga, devolviendo el resultado
	 * en un double. Si se introduce un objeto null, el método no cargará el valor
	 * en el return, devolviendo otro null
	 * 
	 * @param tienda Tienda
	 * @return beneficio double
	 */
	public double beneficioTotal(Tienda tienda) {
		double beneficio = tienda.getBeneficio();
		for (int i = 0; i < tienda.getProductos().length; i++) {
			beneficio = BigDecimal
					.valueOf(beneficio + (tienda.getProductos()[i].getPrecio() - tienda.getProductos()[i].getCostes()))
					.setScale(2, RoundingMode.HALF_UP).doubleValue();
		}
		tienda.setBeneficio(beneficio);
		return beneficio;
	}

	/**
	 * Este método recibe un objeto Tienda como parámetro y recorre los precios de
	 * los objeto Producto que contiene para crear un array, pensado para la
	 * posterior impresion de los datos con el método Arrays.toString(). En caso de
	 * introducir una tienda sin productos, devolverá un null.
	 * 
	 * @param tienda Tienda
	 * @return precios double[]
	 */
	public double[] crearArrayPrecios(Tienda tienda) {
		try {
			double[] precios = new double[tienda.getProductos().length];
			for (int i = 0; i < tienda.getProductos().length; i++) {
				precios[i] = tienda.getProductos()[i].getPrecio();
			}
			return precios;
		} catch (NullPointerException e) {
			return null;
		}
	}

	/**
	 * Este método recibe un objeto Tienda como parámetro y recorre los costes de
	 * los objeto Producto que contiene para crear un array, pensado para la
	 * posterior impresion de los datos con el método Arrays.toString(). En caso de
	 * introducir una tienda sin productos, devolverá un null.
	 * 
	 * @param tienda Tienda
	 * @return costes double[]
	 */
	public double[] crearArrayCostes(Tienda tienda) {
		try {
			double[] costes = new double[tienda.getProductos().length];
			for (int i = 0; i < tienda.getProductos().length; i++) {
				costes[i] = tienda.getProductos()[i].getCostes();

			}
			return costes;
		} catch (NullPointerException e) {
			return null;
		}
	}

}
