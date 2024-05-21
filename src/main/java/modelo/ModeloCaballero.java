package modelo;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class ModeloCaballero {

	public static ArrayList<Caballero> getTodos() throws ClassNotFoundException, SQLException {
		
		ArrayList<Caballero> caballeros = new ArrayList<Caballero>();
			
			Statement st = Conector.getConnection().createStatement();
			ResultSet rs = st.executeQuery("SELECT * FROM caballeros");
			
			while(rs.next()) {
			
			Caballero caballero = new Caballero();
			
			caballero.setId(rs.getInt("id"));
			caballero.setNombre(rs.getString("nombre"));
			caballero.setFuerza(rs.getInt("fuerza"));
			caballero.setExperiencia(rs.getInt("experiencia"));
			caballero.setFoto(rs.getString("foto"));
			caballero.setArma_id(rs.getInt("arma_id"));
			caballero.setEscudo_id(rs.getInt("escudo_id"));
			
			System.out.println(caballero);
			caballeros.add(caballero);
			}
			
			st.close();
			rs.close();		
		
		return caballeros;
	}
}