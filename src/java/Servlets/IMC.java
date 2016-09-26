
package Servlets;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(value="/Exercicio03")
public class IMC extends HttpServlet {
    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response)
                throws ServletException, IOException{
        response.setContentType("text/xml");
        try (PrintWriter out = response.getWriter()) {
            String nome = request.getParameter("nome");
            double peso = Double.parseDouble(request.getParameter("peso"));
            double altura = Double.parseDouble(request.getParameter("altura"));
            String sexo = request.getParameter("sexo");
            String resultado = "Defina seu peso";
           
            String radio = request.getParameter("resultado");
            //if(radio == )
            double imc = (peso / (Math.pow(altura, 2)));
            if(imc  < 19.1  || imc < 20.7){
                resultado = "Abaixo do Peso";
            }
            if(imc  > 19.1 && imc < 25.8 || imc > 20.7 && imc < 26.4 ){
                resultado = "No peso Normal";
            }
            if(imc  > 25.8 && imc < 27.3 || imc > 26.4 && imc < 27.8 ){
                resultado = "Marginalmente acima do Peso";
            }
            if(imc  > 27.3 && imc < 32.3 || imc > 27.8 && imc < 31.1 ){
                resultado = "Acima do Peso Ideal";
            }
            if(imc  > 32.3 || imc > 31.1 ){
                resultado = "OBESO!!";
            }
            
            
            out.println("<imc>");
            out.println("     <dados>");
            out.println("          <nome> "+ nome +" </nome>");
            out.println("          <peso> "+ peso +" </peso>");
            out.println("          <altura> "+ altura +" </altura>");
            out.println("          <sexo> "+ sexo +" </sexo>");
            out.println("     </dados>");
            out.println("     <resultado>");
            out.println("           <valor> " + imc +"</valor>");
            out.println("           <condicao> " + resultado +"</condicao>");
            out.println("     </resultado>");
            out.println("</imc>");
        }
    }
    
}
