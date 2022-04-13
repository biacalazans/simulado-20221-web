package br.com.mariojp.condominio.controllers;


import java.io.IOException;


import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import br.com.mariojp.condominio.dao.UsuarioDAO;

@WebServlet("/criar")
public class UsuarioCreateController extends HttpServlet {

	private static final long serialVersionUID = 1L;
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		
	String email = req.getParameter("email");
	String senha = req.getParameter("senha");
	
	UsuarioDAO usuariodao = new UsuarioDAO();
	usuariodao.save(email, senha);
	
	}


}
