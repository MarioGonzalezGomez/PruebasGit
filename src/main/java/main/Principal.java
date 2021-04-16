package main;

import java.util.Arrays;

import entity.Tienda;
import service.Servicio;
import service.TiendaBuilder;

/**
 * La clase principal del proyecto. LLama a métodos e instancia objetos de las
 * otras clases. Imprime el resultado
 * 
 * @author Mario
 *
 */
public class Principal {
/**
 * Método main
 * @param args argumentos
 */
	public static void main(String[] args) {
		Servicio servicios = new Servicio();
		TiendaBuilder constructor = new TiendaBuilder();
		Tienda tienda1 = constructor.generaTienda();
		servicios.margenBeneficio(tienda1);
		servicios.nuevoPrecioMargenMenorDiez(tienda1);
		servicios.beneficioTotal(tienda1);
		System.out.println("Array Precio: " + Arrays.toString(servicios.crearArrayPrecios(tienda1)));
		System.out.println("Array Costes: " + Arrays.toString(servicios.crearArrayCostes(tienda1)));
		System.out.println("Array Margen: " + Arrays.toString(tienda1.getMargenBeneficio()));
		System.out.println("Array Nuevo: " + Arrays.toString(tienda1.getPreciosActualizados()));
		System.out.println("Margen Maximo: " + servicios.mayorMargenBeneficio(tienda1));
		System.out.println("Margen Minimo: " + servicios.menorMargenBeneficio(tienda1));
		System.out.println("Id producto margen maximo: " + servicios.obtenerIdMargen(tienda1, servicios.mayorMargenBeneficio(tienda1)));
		System.out.println("Id producto margen minimo: " + servicios.obtenerIdMargen(tienda1, servicios.menorMargenBeneficio(tienda1)));
		System.out.println("Beneficio total: " + tienda1.getBeneficio());
	}

}
