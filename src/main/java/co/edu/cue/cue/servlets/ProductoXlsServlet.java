package co.edu.cue.cue.servlets;

import co.edu.cue.cue.model.Product;
import co.edu.cue.cue.service.ProductService;
import co.edu.cue.cue.service.impl.ProductServiceImp;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

@WebServlet({"/productos.xls","/productos.html","/productos"})
public class ProductoXlsServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ProductService service=new ProductServiceImp();
        List<Product> products=service.listar();
        response.setContentType("text/html;charset=UTF-8");
        String servletPath = request.getServletPath();
        Boolean esXls=servletPath.endsWith(".xls");
        if (esXls){
            response.setContentType("application/vnd.ms-excel");
            response.setHeader("Content-Disposition", "attachment; filename=productos.xls");
        }
        try (PrintWriter out=response.getWriter()){
            if (!esXls){
                out.println("<!DOCTYPE html>");
                out.println("<html>");
                out.println("   <head>");
                out.println("       <meta charset=\"UTF-8\">");
                out.println("       <title>listado de productos</title>");
                out.println("   </head>");
                out.println("   <body>");
                out.println("       <h1>Listado de productos</h1>");
                out.println("       <p><a href=\""+request.getContextPath()+"/productos.xls"+"\">exportar a xls</a></p>");
                out.println("       <p><a href=\""+request.getContextPath()+"/productos.json"+"\">mostrar json</a></p>");
            }
            out.println("       <table>");
            out.println("           <tr>");
            out.println("               <th>id</th>");
            out.println("               <th>nombre</th>");
            out.println("               <th>tipo</th>");
            out.println("               <th>precio</th>");
            out.println("           </tr>");
            products.forEach(p->{
                out.println("           <tr>");
                out.println("               <th>"+p.getId()+"</th>");
                out.println("               <th>"+p.getName()+"</th>");
                out.println("               <th>"+p.getTipo()+"</th>");
                out.println("               <th>"+p.getPrice()+"</th>");
                out.println("           </tr>");
            });
            if (!esXls) {
                out.println("       </table>");
                out.println("   </body>");
                out.println("</html>");
            }
        }
    }

    //diferencia entre sendredirect y getRequestDispatcher
    //sendRedirect se usa para redirigirse a otra pagina, el parametro lo lleva a la pagina indicada
    //getrequestDispatcher se usa para reenviar una solicitud a la direccion actual

/*    Respuestas informativas (100–199),
    Respuestas satisfactorias (200–299),
    Redirecciones (300–399),
    Errores de los clientes (400–499),
    y errores de los servidores (500–599).*/

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }

}
