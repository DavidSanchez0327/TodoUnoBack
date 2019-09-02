package co.com.todoUno.ApiRest.controller;

import java.io.IOException;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.servlet.http.HttpServlet;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import co.com.todoUno.ApiRest.dao.ProductsDAO;
import co.com.todoUno.ApiRest.model.Product;


@RequestScoped
@Path("productos")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class ProductController  {
	
	@Inject
	ProductsDAO dao;
	
	@GET
	public Response getAll() {
		
		return Response.ok(dao.getAll()).build();
	}
	
	
	@GET
	@Path("{id}")
	public Response getById(@PathParam("id") String id) {
		Product product = dao.findById(id);
		
		return Response.ok(product).build();
	}
	
	
	@PUT
	@Path("{id}")
	public Response update(@PathParam("id") String id, Product product) {
		Product productUpdate = dao.findById(id);
		productUpdate.setCantidad(product.getCantidad());
		productUpdate.setCategoria(product.getCategoria());
		productUpdate.setNombreProducto(product.getNombreProducto());
		productUpdate.setPrecio(product.getPrecio());
		dao.update(productUpdate);
		
		return Response.ok().build();
	}
	
	@POST
	public Response create(Product product) {
		dao.create(product);
		return Response.ok().build();
	}
	
	
	
	@DELETE
	@Path("{id}")
	public Response delete(@PathParam("id") String id) {
		Product productDelete = dao.findById(id);
		dao.delete(productDelete);
		
		return Response.ok().build();
	}
	
}




