package modelo;

public class Validaciones {
	
	public static boolean nombreRellenado(Caballero caballero) {
		if(caballero.getNombre().equals("")) {
			return false;
		}
		return true;
	}
	
	public static boolean experienciaX(int experiencia) {
		if(experiencia >= 1 && experiencia <= 100) {
			return true;
		}
		return false;
	}
	
	public static boolean fuerzaX(int fuerza) {
		if(fuerza >= 1 && fuerza <= 100) {
			return true;
		}
		return false;
	}
}
