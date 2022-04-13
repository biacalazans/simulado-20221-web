package br.com.mariojp.condominio.controllers;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.util.List;

import br.com.mariojp.condominio.dao.UsuarioDAO;
import br.com.mariojp.condominio.model.Usuario;


@WebServlet("/lista")
public class UsuarioListController extends HttpServlet{
	
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		
//		req.getRequestDispatcher("/lista.jsp").forward(req, resp);
		
		UsuarioDAO usuariodao = new UsuarioDAO();
		List<Usuario> lista = usuariodao.findAll();
		PrintWriter writer = resp.getWriter();
		
		req.setAttribute("lista", lista);
		RequestDispatcher dispatcher  = req.getRequestDispatcher("./lista.jsp");
		dispatcher.forward(req, resp);
		

//		 writer.println("<html><title>Etapa 1</title><body>");
//	        writer.println("<h1>BOA SORTE!</h1>");
//		for (Usuario user: usuarios ) {
//			writer.println("<p>" +user.getLogin()+"</p>");
//			writer.println(user.getSenha());
			
		}
		
		@Override
		protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("teste");
		String login = req.getParameter("login");
		req.getSession().setAttribute("login", login);
		resp.sendRedirect("./lista.jsp");
	
	}

}
