package entity;

import service.TiendaBuilder;

/**
 * En esta clase se almacenan los datos getters y setters relacionados con
 * Tienda
 * 
 * @author Mario
 *
 */
public class Tienda {

	private Producto[] productos;
	private double[] margenBeneficio;
	private double[] preciosActualizados;
	private double beneficio;

	/**
	 * Constructor por defecto con atributos productos, margenBeneficio, beneficio,
	 * y preciosActualizados.
	 */
	public Tienda() {
		productos = new Producto[TiendaBuilder.getNumProductos()];
		margenBeneficio = new double[TiendaBuilder.getNumProductos()];
		beneficio = 0;
		preciosActualizados = new double[TiendaBuilder.getNumProductos()];
	}

	/**
	 * Getter de la variable privada productos
	 * 
	 * @return productos Producto[]
	 */
	public Producto[] getProductos() {
		return productos;
	}

	/**
	 * Setter que carga un valor Producto[] introducido por parámetro en la variable
	 * productos
	 * 
	 * @param productos Producto[]
	 */
	public void setProductos(Producto[] productos) {
		this.productos = productos;
	}

	/**
	 * Getter de la variable privada beneficio
	 * 
	 * @return double beneficio
	 */
	public double getBeneficio() {
		return beneficio;
	}

	/**
	 * Setter que carga un valor double introducido por parámetro en la variable
	 * beneficio
	 * 
	 * @param beneficio double
	 */
	public void setBeneficio(double beneficio) {
		this.beneficio = beneficio;
	}

	/**
	 * Getter de la variable privada margenBeneficio
	 * 
	 * @return beneficio double[]
	 */
	public double[] getMargenBeneficio() {
		return margenBeneficio;
	}

	/**
	 * Setter que carga un valor double [] introducido por parámetro en la variable
	 * margenBeneficio
	 * 
	 * @param margenBeneficio double[]
	 */
	public void setMargenBeneficio(double[] margenBeneficio) {
		this.margenBeneficio = margenBeneficio;
	}

	/**
	 * Getter de la variable privada preciosActualizados
	 * 
	 * @return preciosActualizados double[]
	 */
	public double[] getPreciosActualizados() {
		return preciosActualizados;
	}

	/**
	 * Setter que carga un valor double [] introducido por parámetro en la variable
	 * preciosActualizados
	 * 
	 * @param preciosActualizados double[]
	 */
	public void setPreciosActualizados(double[] preciosActualizados) {
		this.preciosActualizados = preciosActualizados;
	}

}