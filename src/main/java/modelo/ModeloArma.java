package modelo;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class ModeloArma {

	public static ArrayList<Arma> getTodos() throws ClassNotFoundException, SQLException{
		
		ArrayList<Arma> armas = new ArrayList<Arma>();
		
		Statement st = Conector.getConnection().createStatement();
		ResultSet rs = st.executeQuery("SELECT * FROM armas");
		
		while(rs.next()) {
			
			Arma arma = new Arma();
			
			arma.setId(rs.getInt("id"));
			arma.setNombre(rs.getString("nombre"));
			arma.setCapacidad_danio(rs.getInt("capacidad_danio"));
			arma.setFoto(rs.getString("foto"));
			
			armas.add(arma);		
			
		}
		st.close();
		rs.close();
		
		return armas;
	}
}