package br.com.mariojp.condominio.controllers;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import br.com.mariojp.condominio.dao.UsuarioDAO;
import br.com.mariojp.condominio.model.Usuario;

@WebServlet("/login")
public class LoginController extends HttpServlet{
	
	
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String login = req.getParameter("login");
		String senha = req.getParameter("senha");

		UsuarioDAO usuariodao = new UsuarioDAO();
		
		Usuario user = usuariodao.findByLogin(login);
		
		
		if(user != null) {
			
			if(senha.equals(user.getSenha()) ) {
				
				req.getSession().setAttribute("login", login);
				resp.sendRedirect("./lista");
				
			}
		}else {

			resp.sendRedirect("./login.jsp");
		}
		
	}

}
