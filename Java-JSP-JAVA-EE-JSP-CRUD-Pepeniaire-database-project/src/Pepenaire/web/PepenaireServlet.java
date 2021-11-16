package Pepenaire.web;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Pepenaire.Dao.PepenaireDao;
import Pepenaire.Domain.Pepenaire;

/**
 * Servlet implementation class PepenaireServlet
 */
@WebServlet("/")
public class PepenaireServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private PepenaireDao pepenaireDao;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PepenaireServlet() {
    	this.pepenaireDao=new PepenaireDao();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action=request.getServletPath();
		switch(action) {
		case "/new":showNewForm(request, response);
			break;
		case "/insert":try {
				insertPepenaire(request,response);
			} catch (SQLException | IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			break;
		case "/delete":
			try {
				deletePepenaire(request,response);
			} catch (SQLException | IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			break;
		case "/edit":try {
				showEditForm(request,response);
			} catch (SQLException | ServletException | IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			break;
		case "/update":
		
			try {
				updatePepenaire(request,response);
			} catch (SQLException | IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		
			break;
		case"/search":try {
				listSearchPepenaire(request,response);
			} catch (SQLException | IOException | ServletException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			break;
		default:	try {
				listPepenaire(request,response);
			} catch (SQLException | IOException | ServletException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			break;
		    
		
		}
	}
    private void showNewForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	RequestDispatcher dispatcher = request.getRequestDispatcher("Pepinaire-form.jsp");
    	dispatcher.forward(request, response);
    }
	private void listSearchPepenaire(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException, ServletException {
		String search =request.getParameter("search");
		//System.out.print(search);
		List<Pepenaire> listPepenaire = pepenaireDao.search(search);
		request.setAttribute("listPepenaire", listPepenaire);
		RequestDispatcher dispatcher = request.getRequestDispatcher("Pepinaire.jsp");
		dispatcher.forward(request, response);
	}
	private void listPepenaire (HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException, ServletException {
		List<Pepenaire> listPepenaire = pepenaireDao.getAll();
		request.setAttribute("listPepenaire", listPepenaire);
		RequestDispatcher dispatcher = request.getRequestDispatcher("Pepinaire.jsp");
		dispatcher.forward(request, response);
	}
	private void deletePepenaire(HttpServletRequest request, HttpServletResponse response) 
			throws SQLException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		pepenaireDao.delet(id);
		response.sendRedirect("list");

	}
    private void insertPepenaire(HttpServletRequest request, HttpServletResponse response) 
			throws SQLException, IOException {
		String nom = request.getParameter("nom");
		String cate = request.getParameter("cate");
	
		Pepenaire newUser = new Pepenaire(nom,cate);
		pepenaireDao.save(newUser);
		response.sendRedirect("list");
	}
	private void showEditForm(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		Pepenaire existingPepenaire = pepenaireDao.getById(id);
		RequestDispatcher dispatcher = request.getRequestDispatcher("Pepinaire-form.jsp");
		request.setAttribute("Pepinaire", existingPepenaire);
		dispatcher.forward(request, response);

	}
	private void updatePepenaire(HttpServletRequest request, HttpServletResponse response) 
			throws SQLException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		String nom = request.getParameter("nom");
		String cate = request.getParameter("cate");
		Pepenaire book = new Pepenaire(id, nom, cate);
		pepenaireDao.update(book);
		response.sendRedirect("list");
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.doGet(request, response);
	}

}
