package entity;

/**
 * En esta clase se almacenan los datos getters y setters relacionados con
 * Producto
 * 
 * @author Mario
 *
 */
public class Producto {

	/*
	 * Creamos un contador para conocer cuantos productos se han generado a traves
	 * de los distintos constructores. Lo utilizaremos para igualarlo a un atributo
	 * id. De este modo podremos actualizar una id en específico mediante su setter,
	 * evitando modificar el contador, que podría generar valores no deseados en
	 * futuras creaciones de producto. Es private porque solo se necesita su uso en
	 * la clase y static porque puede ser llamado y modificado desde varios
	 * constructores.
	 */
	private static int contador;
	private int id;
	private double precio;
	private double costes;

	/**
	 * Constructor por defecto con valores iniciados a 0, salvo el id, que lo
	 * inicializa teniendo en cuenta su orden de generación. Inicialmente incrementa
	 * ese contador para que el producto generado tenga una id un valor por encima
	 * de la anterior.
	 */
	public Producto() {
		contador++;
		id = contador;
		precio = 0;
		costes = 0;
	}

	/**
	 * Contructor con precio y coste como parámetros de entrada.El id se
	 * incrementará con cada llamada al método
	 * 
	 * @param precio double
	 * @param coste  double
	 */
	public Producto(double precio, double coste) {
		contador++;
		id = contador;
		this.precio = precio;
		this.costes = coste;
	}

	/**
	 * Getter de la variable privada estática contador
	 * 
	 * @return static int contador
	 */
	public static int getContador() {
		return contador;
	}

	/**
	 * Getter de la variable privada id
	 * 
	 * @return int id
	 */
	public int getId() {
		return id;
	}

	/**
	 * Setter que carga un valor int introducido por parámetro en la variable id
	 * 
	 * @param id int
	 */
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * Getter de la variable privada precio
	 * 
	 * @return double precio
	 */
	public double getPrecio() {
		return precio;
	}

	/**
	 * Setter que carga un valor double introducido por parámetro en la variable
	 * precio
	 * 
	 * @param precio double
	 */
	public void setPrecio(double precio) {
		this.precio = precio;
	}

	/**
	 * Getter de la variable privada costes
	 * 
	 * @return double costes
	 */
	public double getCostes() {
		return costes;
	}

	/**
	 * Setter que carga un valor double introducido por parámetro en la variable
	 * costes
	 * 
	 * @param coste double
	 */
	public void setCostes(double coste) {
		this.costes = coste;
	}
}
