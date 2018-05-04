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
public class MyServlet1 implements Servlet {
    public MyServlet1() {
    }

    /**
     * destroy
     *
     * @todo Implement this javax.servlet.Servlet method
     */
    public void destroy() {
    }

    /**
     * getServletConfig
     *
     * @return ServletConfig
     * @todo Implement this javax.servlet.Servlet method
     */
    public ServletConfig getServletConfig() {
        return null;
    }

    /**
     * getServletInfo
     *
     * @return String
     * @todo Implement this javax.servlet.Servlet method
     */
    public String getServletInfo() {
        return "";
    }

    /**
     * init
     *
     * @param servletConfig ServletConfig
     * @throws ServletException
     * @todo Implement this javax.servlet.Servlet method
     */
    public void init(ServletConfig servletConfig) throws ServletException {
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
    }
}
