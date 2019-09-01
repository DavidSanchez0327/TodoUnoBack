package co.com.todoUno.services;

import java.io.IOException;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.com.todoUno.dao.ProductsDAO;
import co.com.todoUno.model.Products;


@WebServlet(name="ProductsController", urlPatterns={"/producto"})
public class ProductsController {

@EJB ProductsDAO productsdao;

    public ProductsController() {
        super();
    }
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

            request.setAttribute("guests", productsdao.getAllGuests());
            request.getRequestDispatcher("/guest.jsp").forward(request, response);
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
    
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String nombreProducto = request.getParameter("name");
        if (nombreProducto != null)
        	productsdao.persist(new Products());
		doGet(request, response);
	}
}
