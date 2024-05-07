package lib;

import java.util.HashMap;
import java.util.Map;

public class Sdk {
	
	// Función de depuración para imprimir arrays formateadamente
	// Usamos <T> para aceptar cualquier tipo de dato en forma de array
	public static <T> void pl_dump( T[] array ) {
		
		int index = 0;
		while( index < 75 ) {
			System.out.println( "-" );
			index++;
		}
		
		Map<T, T> array_map = new HashMap<>();
		
	}
	
}
