/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.LoginDAO;
import entity.Clients;
import java.io.IOException;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author thanh
 */
@WebServlet(name = "LoginCtrl", urlPatterns = {"/LoginCtrl"})
public class LoginCtrl extends HttpServlet {

    private EntityManager em;
    private EntityManagerFactory emf;
    private LoginDAO loginDAO;

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

        // Kiểm tra email
        
        String email = request.getParameter("email");
        String iDProd = request.getParameter("iDProd");
        String url = "/ProductDetailCtrl";

        emf = Persistence.createEntityManagerFactory("WebdoanPU");
        em = emf.createEntityManager();
        loginDAO = new LoginDAO(emf);

        Clients clients = new Clients();
        clients = loginDAO.searchById(email);

        // Load lại trang login nếu người dùng chưa nhập gì
        if (email == "") {
            url = "/login.jsp";
        }
        else if (iDProd==""){
            url="/productP";
            // Tạo user mới nếu email được đăng nhập lần đầu
            if (clients == null) {
                Clients client = new Clients(email);
                loginDAO.addClient(client);
            }
            // Tạo session để duy trì đăng nhập cho tài khoản
            HttpSession session = request.getSession(true);
            session.setMaxInactiveInterval(1800);
            session.setAttribute("email", email);
        }
        else {
            // Tạo user mới nếu email được đăng nhập lần đầu
            if (clients == null) {
                Clients client = new Clients(email);
                loginDAO.addClient(client);
            }

            // Tạo session để duy trì đăng nhập cho tài khoản
            HttpSession session = request.getSession(true);
            session.setMaxInactiveInterval(1800);
            session.setAttribute("email", email);
            request.setAttribute("iDProd", iDProd);
        }
        getServletContext()
                .getRequestDispatcher(url)
                .forward(request, response);
        
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>
}
