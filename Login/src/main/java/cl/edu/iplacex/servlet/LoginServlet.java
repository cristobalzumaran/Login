package cl.edu.iplacex.servlet;

import java.io.IOException;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import cl.edu.iplacex.LoginBean;
import cl.edu.iplacex.dao.LoginDao;



/**
 * 
 */

//@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
    private static final long serialVersionUID = 1 ;
    private LoginDao loginDao;

    public void init() {
        loginDao = new LoginDao();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {

        String username = request.getParameter("username");
        String password = request.getParameter("password");
        LoginBean loginBean = new LoginBean();
        loginBean.setUsername(username);
        loginBean.setPassword(password);

        try {
            if (loginDao.validate(loginBean)) {
                //HttpSession session = request.getSession();
                // session.setAttribute("username",username);
                response.sendRedirect("loginsuccess.jsp");
            } else {
                HttpSession session = request.getSession();
                //session.setAttribute("user", username);
                request.setAttribute("mensaje", "Usuario o contraseña invalidos");
//                response.sendRedirect("index.jsp");
                request.getRequestDispatcher("index.jsp").forward(request, response);
                
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
