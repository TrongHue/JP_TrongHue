package jsoft.ads.user;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
import java.util.*;

import jsoft.*;
import jsoft.objects.*;

public class UserLogin extends HttpServlet {
    // Khai bao kieu noi dung xuat ve trinh khach
    private static final String CONTENT_TYPE = "text/html;charset=utf-8";

    //Initialize global variables
    public void init() throws ServletException {
    }

    //Phuong thuc cung cap cau truc HTML ve trinh duyet
    //Process the HTTP Get request
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws
            ServletException, IOException {
        //Xac dinh kieu noi dung xuat ve trinh khach
        response.setContentType(CONTENT_TYPE);

        //Tao doi tuong xuat noi dung ve trinh khach
        PrintWriter out = response.getWriter();

        //Tim tham so bao loi (neu co)
        String error = request.getParameter("err");
        String message = "";
        if(error != null){
            if(error.equalsIgnoreCase("param")){
                message = "Tham so lay gia tri khong chinh xac";
            }else if(error.equalsIgnoreCase("value")){
                message = "Loi gia tri ";
            }else if(error.equalsIgnoreCase("notok")){
                message = "Dang nhap khong thanh cong";
            }else{
                message = "Khong thanh cong";
            }
        }

        //Thuc hien xuat noi dung
        out.print("<html>");
        out.print("<head>");
        out.print("<title>\u0110\u0103ng nh\u1EADp</title>");
        out.print(
                "<link href=\"/adv/advcss/login.css\" type=\"text/css\" rel=\"stylesheet\"/>");
        out.print(
                "<script language=\"JavaScript\" src=\"/adv/advjs/login.js\"> </script>");
        out.print("</head>");
        out.print("<body>");
        out.print("<div id=\"loginView\" class=\"loginView\">");
        out.print("<form name=\"frmLogin\" action=\"\" method=\"\"/>");
        out.print("<table cellspacing=\"0\"> ");

        if(!message.equalsIgnoreCase("")){
            out.print("<tr>");
            out.print("<td colspan=2 align\"center\">");
            out.print("<h1 style=\"color: red;\">"+message+"</h1>");
            out.print("</td>");
            out.print("</tr>");
        }


        out.print("<tr> ");
        out.print("<th colspan=\"2\">\u0110\u0103ng nh\u1EADp</th>");
        out.print("</tr>");
        out.print("<tr>");
        out.print("<td class=\"lc\">T�n \u0111\u0103ng nh\u1EADp</td>");
        out.print("<td><input type=\"text\" name=\"txtUserName\" placeholder=\"T�n ho\u1EB7c h\u1ED9p th\u01B0\"/> </td>");
        out.print("</tr>");
        out.print("<tr>");
        out.print("<td class=\"lc\">M\u1EADt kh\u1EA9u</td>");
        out.print("<td><input type=\"password\" name=\"txtUserPass\" placeholder=\"M\u1EADt kh\u1EA9u\"/> </td>");
        out.print("</tr>");
        out.print("<tr>");
        out.print(
                "<td class=\"lc\"> <input type=\"checkbox\" id=\"chkCheck\"/> </td>");
        out.print("<td>");
        out.print(
                "<label for=\"chkCheck\">L\u01B0u th�ng tin \u0111\u0103ng nh\u1EADp</label>");
        out.print("</td>");
        out.print("</tr>");
        out.print("<tr>");
        out.print("<td colspan=\"2\" align=\"center\">");
        out.print("<a href=\"#\">Qu�n m\u1EADt kh\u1EA9u</a>");
        out.print("</td>");
        out.print("</tr>");
        out.print("<tr>");
        out.print("<td colspan=\"2\" align=\"center\"> ");
        out.print("<input type=\"button\" value=\"\u0110\u0103ng nh\u1EADp\" onclick=\"login(this.form)\"/>");
        out.print("<input type=\"button\" value=\"Tho�t\"/>");
        out.print("</td>");
        out.print("</tr>");
        out.print("<tr>");
        out.print("<td colspan=\"2\" align=\"right\">");
        out.print("<a href=\"#\">English</a>");
        out.print("</td>");
        out.print("</tr>");
        out.print("</table>");
        out.print("</form>");
        out.print("</div>");
        out.print("</body>");
        out.print("</html>");

        //Dong luong xuat
        out.close();
    }

    //Process the HTTP Post request
    // Duoc goi thong qua su kien cua form menthod="post"

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws
            ServletException, IOException {

        // lay thong tin dang nhap
        String userName = request.getParameter("txtUserName");
        String userPass = request.getParameter("txtUserPass");

        //Kiem tra su tong tai cua tham so
        if (userName != null && userPass != null) {
            // cat bo khoang trong truoc sau
            userName = userName.trim();
            userPass = userPass.trim();

            // kiem tra su ton tai cua gia tri
            if (!userName.equalsIgnoreCase("") && !userPass.equalsIgnoreCase("")) {

                // tham chieu ngu canh ung dung servlet
                ServletContext application = getServletConfig().getServletContext();

                //tim bo quan ly ket noi trong ngu canh
                ConnectionPool cp = (ConnectionPool) application.getAttribute("cPool");

                //tao doi tuong thuc thi chuc nang
                UserControl uc = new UserControl(cp);
                if(cp==null){
                    application.setAttribute("cPool",uc.getCP());
                }

                // thuc hien dang nhap
                UserObject user = uc.getUserObject(userName,userPass);

                //tra ve ket noi
                uc.releaseConnection();

                // kiem tra ket qua dang nhap
                if(user!=null){
                    //tham chieu phien lam viec
                    HttpSession session = request.getSession(true);

                    //dua thong tin dang nhap vao phien
                    session.setAttribute("userLogined",user);

                    //chuyen ve giao dien chinh
                    response.sendRedirect("/adv/view");


                }else{
                    response.sendRedirect("/adv/user/login?err=notok");
                }

            } else {
                response.sendRedirect("/adv/user/login?err=value");
            }

        } else {
            // tro lai giao dien dang nhap va bao loi
            // loi dc xu ly thong qua tham so tren url
            response.sendRedirect("/adv/user/login?err=para");
        }
    }

    //Clean up resources
    public void destroy() {
    }
}
