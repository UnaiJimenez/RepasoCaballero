package modelo;

public class Escudo {
	
	private int id;
	private String nombre;
	private int capacidad_defensa;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getCapacidad_defensa() {
		return capacidad_defensa;
	}
	public void setCapacidad_defensa(int capacidad_defensa) {
		this.capacidad_defensa = capacidad_defensa;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	@Override
	public String toString() {
		return "Escudo [id=" + id + ", capacidad_defensa=" + capacidad_defensa + ", nombre=" + nombre + "]";
	}
}