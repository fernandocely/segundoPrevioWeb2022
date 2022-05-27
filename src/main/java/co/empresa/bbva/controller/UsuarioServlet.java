package co.empresa.bbva.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.empresa.bbva.dao.UsuarioDao;
import co.empresa.bbva.dao.UsuarioDaoFactory;
import co.empresa.bbva.modelo.Usuario;

/**
 * Servlet implementation class UsuarioServlet
 */
@WebServlet("/")
public class UsuarioServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private UsuarioDao usuarioDao;
	
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UsuarioServlet() {
        super();
        // TODO Auto-generated constructor stub
    }
 
	/**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init() throws ServletException {
		// TODO Auto-generated method stub
		
		String type= getServletContext().getInitParameter("type");
		this.usuarioDao =  UsuarioDaoFactory.getUsuarioDao(type);
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String action = request.getServletPath();
		
		try {
		
		switch(action) {
		case "/new":
			showNewForm(request, response);
			break;
		case "/insert":
			insertarUsuario(request, response);
			break;
		case "/delete":
			eliminarUsuario(request, response);
			break;
		case "/edit":
			showEditForm(request, response);
			break;
		case "/update":
			actualizarUsuario(request, response);
			break;
		case "/enviarCorreo":
			enviarCorreo(request, response);
			break;
		
		default:
			listMovimientos(request, response);
			break;
		}
		}catch(SQLException e) {
			throw new ServletException(e);
			
		}
		
		
	}


	

	
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
	
	protected void showNewForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		RequestDispatcher dispatcher = request.getRequestDispatcher("usuario.jsp");
		dispatcher.forward(request, response);
	}
	
	protected void insertarUsuario(HttpServletRequest request, HttpServletResponse response) throws ServletException, SQLException, IOException {
		// TODO Auto-generated method stub
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		String email = request.getParameter("email");
		
		
		Usuario usuario = new Usuario(username,password,email);
		usuarioDao.insert(usuario);
		response.sendRedirect("list");
		
	}
	

	private void showEditForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, SQLException, IOException {
		// TODO Auto-generated method stub
		
		int id = Integer.parseInt(request.getParameter("id"));
		
		Usuario usuarioActual = usuarioDao.select(id);
		request.setAttribute("usuario", usuarioActual);
		RequestDispatcher dispatcher = request.getRequestDispatcher("usuario.jsp");
		dispatcher.forward(request, response);
	}
	
	private void actualizarUsuario(HttpServletRequest request, HttpServletResponse response) throws ServletException, SQLException, IOException {
		// TODO Auto-generated method stub
		int id = Integer.parseInt(request.getParameter("id"));
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		String email = request.getParameter("email");
		
		Usuario usuario = new Usuario(id,username,password,email);
		
		usuarioDao.update(usuario);
		response.sendRedirect("list");
	}
	
	private void eliminarUsuario(HttpServletRequest request, HttpServletResponse response) throws ServletException, SQLException, IOException {
		// TODO Auto-generated method stub
		int id = Integer.parseInt(request.getParameter("id"));		
		usuarioDao.delete(id);
		response.sendRedirect("list");
	}
	
	private void listMovimientos(HttpServletRequest request, HttpServletResponse response) throws ServletException, SQLException, IOException {
		// TODO Auto-generated method stub
		
		List <Usuario> listUsuarios  = usuarioDao.selectAll();
		request.setAttribute("listMovimientos", listUsuarios);
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("usuarioList.jsp");
		dispatcher.forward(request, response);
	}
	protected void enviarCorreo(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		int id = Integer.parseInt(request.getParameter("id"));
		
		Usuario usuarioActual = usuarioDao.select(id);
		request.setAttribute("usuario", usuarioActual);
		RequestDispatcher dispatcher = request.getRequestDispatcher("enviarMensaje.jsp");
		dispatcher.forward(request, response);
	}

	
	

}
