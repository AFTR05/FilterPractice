package co.edu.cue.cue.servlets;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;

@WebServlet(name = "main-servlet", value = "/main-servlet")
public class MainServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String metodoHTTP=request.getMethod();    //me dice si es un metodo put o post o get
        String requestURI=request.getRequestURI();  // me dice la URI, es decir toda la ruta hasta con el protocolo (HTTP o HTTPS etc)
        String requestURL=request.getRequestURL().toString();   // me dice la URI, solo la ruta de la web, sin protocolo
        String contextPath=request.getContextPath();  // me dice la parte principal de la web en este caso /home
        String servletPath=request.getServletPath();  // me dice la parte despues de /home en este caso /main-servlet
        String ipClinete=request.getRemoteAddr();    //me dice la ip de el cliente
        String ip=request.getLocalAddr();     // me dice la ip local
        int port=request.getLocalPort();    // me dice el puerto en el que corre
        String scheme=request.getScheme();  // me dice el protocolo en este caso http
        String host=request.getHeader("host");  // me dice donde esta el host, el puerto
        String url=scheme + "://" + host + contextPath + servletPath;  // me da la url con el localhost::8080
        String url2=scheme + "://" + ip + ":" + port + contextPath + servletPath; //me da la url con la ip local

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
