package controlador;

import java.io.IOException;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import modelo.Arma;
import modelo.Caballero;
import modelo.Escudo;
import modelo.ModeloArma;
import modelo.ModeloCaballero;
import modelo.ModeloEscudo;

/**
 * Servlet implementation class InsertarCaballero
 */
@WebServlet("/InsertarCaballero")
public class InsertarCaballero extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public InsertarCaballero() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		try {
			ArrayList<Arma> armas = ModeloArma.getTodos();
			ArrayList<Escudo> escudos = ModeloEscudo.getTodos();
			request.setAttribute("armas", armas);
			request.setAttribute("escudos", escudos);
			request.getRequestDispatcher("InsertarCaballero.jsp").forward(request, response);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String nombre = request.getParameter("nombre");
		int fuerza = Integer.parseInt(request.getParameter("fuerza"));
		int experiencia = Integer.parseInt(request.getParameter("experiencia"));
		String foto = request.getParameter("email");
		int arma_id = Integer.parseInt(request.getParameter("arma_id"));
		int escudo_id = Integer.parseInt(request.getParameter("escudo_id"));
		
		ModeloCaballero mc = new ModeloCaballero();
		
			Caballero caballero = new Caballero();
			caballero.setNombre(nombre);
			caballero.setFuerza(fuerza);
			caballero.setExperiencia(experiencia);
			caballero.setFoto(foto);
			
			Arma arma = new Arma();
			arma.setId(arma_id);
			caballero.setArma(arma);
			
			Escudo escudo = new Escudo();
			escudo.setId(escudo_id);
			caballero.setEscudo(escudo);

			try {
				mc.insertar(caballero);
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			request.getRequestDispatcher("CaballerosVerTodos").forward(request, response);
	}
}

