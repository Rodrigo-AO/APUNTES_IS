package fp.compras.utiles;

public class Validators {

	public static Boolean validarDNI(String dni) {
		return dni.length()== 9  
				&& sonDigitos(dni.substring(0, dni.length()-2)) 
				&& Character.isLetter(dni.charAt(dni.length()-1));
	}
	
	public static Boolean sonDigitos(String cadena) {
		return cadena.chars()
				.allMatch(ch->Character.isDigit(ch));
	}
	
	
}
