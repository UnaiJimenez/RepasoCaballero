package modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
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
			Arma arma = getArma(rs.getInt("arma_id"));
			caballero.setArma(arma);
			Escudo escudo = getEscudo(rs.getInt("escudo_id"));
			caballero.setEscudo(escudo);
			
			caballeros.add(caballero);
			}
			
			st.close();
			rs.close();		
		
		return caballeros;
	}
	
	public static Arma getArma(int id) throws SQLException, ClassNotFoundException {
		
		Connection con = Conector.getConnection();
		
		PreparedStatement pst = con.prepareStatement("SELECT * FROM armas WHERE id = ?");
		pst.setInt(1, id);
		ResultSet rs = pst.executeQuery();
		
		if(rs.next()) {
			
			Arma arma = new Arma();
			arma.setId(rs.getInt("id"));
			arma.setNombre(rs.getString("nombre"));
			arma.setCapacidad_danio(rs.getInt("capacidad_danio"));
			arma.setFoto(rs.getString("foto"));
			
			return arma;
		}
		return null;
}
	
	public static Escudo getEscudo(int id) throws ClassNotFoundException, SQLException {
		
		Connection con = Conector.getConnection();
		
		PreparedStatement pst = con.prepareStatement("SELECT * FROM escudos WHERE id = ?");
		pst.setInt(1, id);
		ResultSet rs = pst.executeQuery();
		
		if(rs.next()) {
			
			Escudo escudo = new Escudo();
			escudo.setId(rs.getInt("id"));
			escudo.setNombre(rs.getString("nombre"));
			escudo.setCapacidad_defensa(rs.getInt("capacidad_defensa"));

			
			return escudo;
		}
		return null;	
	}
	
	public static void insertar(Caballero caballero) throws ClassNotFoundException, SQLException{
		
		Connection con = Conector.getConnection();
		
		PreparedStatement pst = con.prepareStatement("INSERT INTO caballeros (nombre, fuerza, experiencia, foto, arma_id, escudo_id) VALUES (?,?,?,?,?,?)");
		pst.setString(1, caballero.getNombre());
		pst.setInt(2, caballero.getFuerza());
		pst.setInt(3, caballero.getExperiencia());
		pst.setString(4, caballero.getFoto());
		pst.setInt(5, caballero.getArma().getId());
		pst.setInt(6, caballero.getEscudo().getId());
		
		pst.execute();	
	}
	
	public static boolean nombreRepetido(Caballero caballero) throws ClassNotFoundException, SQLException {
		
		Connection con = Conector.getConnection();
		
		PreparedStatement pst = con.prepareStatement("SELECT nombre FROM caballeros WHERE nombre = ?");
		pst.setString(1, caballero.getNombre());
		
		ResultSet rs = pst.executeQuery();
		if(rs.next()) {
			return true;
		} else {
			return false;
		}
	}
}