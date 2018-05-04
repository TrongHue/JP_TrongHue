package j2se;

import java.io.*;

import javax.servlet.*;

/**
 * <p>Title: jp1705</p>
 *
 * <p>Description: </p>
 *
 * <p>Copyright: Copyright (c) 2017</p>
 *
 * <p>Company: </p>
 *
 * @author Nguyen Trong Hue
 * @version 1.0
 */
public class MyServlet2 extends GenericServlet {
    public MyServlet2() {
    }

    /**
     * service
     *
     * @param servletRequest ServletRequest
     * @param servletResponse ServletResponse
     * @throws ServletException
     * @throws IOException
     * @todo Implement this javax.servlet.Servlet method
     */
    public void service(ServletRequest servletRequest,
                        ServletResponse servletResponse) throws
            ServletException, IOException {
    }

    public static void main(String[] args) {
        MyServlet2 myservlet2 = new MyServlet2();
    }
}
