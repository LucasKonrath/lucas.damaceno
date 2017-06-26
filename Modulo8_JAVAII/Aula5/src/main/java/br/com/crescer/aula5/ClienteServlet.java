/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.crescer.aula5;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


/**
 *
 * @author lucas.damaceno
 */
public class ClienteServlet extends HttpServlet {
    
    private Set<String> clientes = new HashSet<>();
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
      
         response.setContentType("text/html");
        try (final PrintWriter out = response.getWriter();) {
            out.append("<!DOCTYPE html>");
            out.append("<html>");
            out.append("<head>");
            out.append("<title>Java - aula5</title>");
            out.append("<meta charset=\"UTF-8\">");
            out.append("<meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">");
            out.append("</head>");
            out.append("<body>");
            out.append("<form action=\"/Aula5/cliente\" method=\"POST\">");
            out.append("<input type=\"text\" name=\"nome\">" );
            out.append("<input type=\"submit\">");
            out.append("</form>");
            out.append("</body>");
            out.append("</html>");
            
            for(String cli : clientes){
            out.append(cli);
            }
        }
          
    }
    
    
    
    protected void doPost(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
        
        final String nome = request.getParameter("nome");
        clientes.add(nome);
        response.sendRedirect("/Aula5/cliente");
      
    }
}
