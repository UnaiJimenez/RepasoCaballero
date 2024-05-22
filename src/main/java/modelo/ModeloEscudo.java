package modelo;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class ModeloEscudo {

	public static ArrayList<Escudo> getTodos() throws SQLException, ClassNotFoundException {
			
			ArrayList<Escudo> escudos = new ArrayList<Escudo>();
			
			Statement st = Conector.getConnection().createStatement();
			ResultSet rs = st.executeQuery("SELECT * FROM escudos");
			
			while(rs.next()) {
				
				Escudo escudo = new Escudo();
				
				escudo.setId(rs.getInt("id"));
				escudo.setNombre(rs.getString("nombre"));
				escudo.setCapacidad_defensa(rs.getInt("capacidad_defensa"));
				
				escudos.add(escudo);
				
			}
			st.close();
			rs.close();
			
			return escudos;	
	}
}
