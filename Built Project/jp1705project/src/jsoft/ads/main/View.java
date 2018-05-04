package jsoft.ads.main;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
import java.util.*;

public class View extends HttpServlet {
    private static final String CONTENT_TYPE = "text/html";

    //Initialize global variables
    public void init() throws ServletException {
    }

    //Process the HTTP Get request
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws
            ServletException, IOException {
        response.setContentType(CONTENT_TYPE);
        PrintWriter out = response.getWriter();
        out.println("<html>");
        out.println("<head><title>View</title></head>");
        out.println("<body bgcolor=\"#ffffff\">");
        out.println("<p>The servlet has received a GET. This is the reply.</p>");
        out.println("</body>");
        out.println("</html>");
        out.close();
    }

    //Clean up resources
    public void destroy() {
    }
}
