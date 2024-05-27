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
import modelo.Validaciones;

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
		
		boolean insertarOk = false;
		boolean nombreNoOk = false;
		boolean nombreRepetido = false;
		boolean armaEscudoNull = false;
		int fuerza , experiencia, arma_id = 0, escudo_id = 0;
		
		String nombre = request.getParameter("nombre");
		
		if (request.getParameter("fuerza").equals("")) {
			fuerza = 0;
		} else {
			fuerza = Integer.parseInt(request.getParameter("fuerza"));
		}
		
		if(request.getParameter("experiencia").equals("")) {
			experiencia = 0;
		} else {
			experiencia = Integer.parseInt(request.getParameter("experiencia"));
		}
		
		String foto = request.getParameter("foto");
		
		if(request.getParameter("arma_id").equals("")) {
			armaEscudoNull = true;
		} else {
			arma_id = Integer.parseInt(request.getParameter("arma_id"));
		}
		
		if(request.getParameter("escudo_id").equals("")) {
			armaEscudoNull = true;
		} else {
			escudo_id = Integer.parseInt(request.getParameter("escudo_id"));
		}
		
		
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

			if(request.getParameter("arma_id").equals("") || request.getParameter("escudo_id").equals("")) {
				armaEscudoNull = true;
			} else {
				if(Validaciones.nombreRellenado(caballero) == true) {
					try {
						if(ModeloCaballero.nombreRepetido(caballero) == false) {
							try {
								mc.insertar(caballero);
								insertarOk = true;
							} catch (ClassNotFoundException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							} catch (SQLException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
						} else {
							nombreRepetido = true;
						}
					} catch (ClassNotFoundException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				} else {
					nombreNoOk = true;
				}
			}
			
			request.setAttribute("insertarOk", insertarOk);
			request.setAttribute("nombreNoOk", nombreNoOk);
			request.setAttribute("nombreRepetido", nombreRepetido);
			request.setAttribute("armaEscudoNull", armaEscudoNull);
			request.getRequestDispatcher("CaballerosVerTodos").forward(request, response);
	}
}