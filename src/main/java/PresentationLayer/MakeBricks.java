/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PresentationLayer;

import FunctionLayer.User;
import DBAccess.UserMapper;
import FunctionLayer.LogicFacade;
import FunctionLayer.Order;
import FunctionLayer.Calculator;
import FunctionLayer.LoginSampleException;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Morten
 */
@WebServlet(name = "MakeBricks", urlPatterns = {"/MakeBricks"})
public class MakeBricks extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code> methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, LoginSampleException, SQLException, ClassNotFoundException{
        Calculator cal = new Calculator();
        response.setContentType("text/html;charset=UTF-8");

        int length = Integer.parseInt(request.getParameter("length"));
        int width = Integer.parseInt(request.getParameter("width"));
        int height = Integer.parseInt(request.getParameter("height"));
        int sBricksl = cal.calculatorS(length);
        int mBricksl = cal.calculatorM(length);
        int lBricksl = cal.calculatorL(length);
        int sBricksw = cal.calculatorS(width-4);
        int mBricksw = cal.calculatorM(width-4);
        int lBricksw = cal.calculatorL(width-4);
        int mBricks2l = cal.calculator2M(length);
        int lBricks2l = cal.calculator2L(length);
        int mBricks2w = cal.calculator2M(width-4);
        int lBricks2w = cal.calculator2L(width-4);
        int totalLBricks = cal.totalLBricks(height, lBricksl, lBricksw, lBricks2l, lBricks2w);
        int totalMBricks = cal.totalMBricks(height, mBricksl, mBricksw, mBricks2l, mBricks2w);
        int totalSBricks = cal.totalSBricks(height, sBricksl, sBricksw);  
        HttpSession session = request.getSession();
        User u = (User) session.getAttribute("user");
        LogicFacade.createOrder(totalLBricks, totalMBricks, totalSBricks, u);
        RequestDispatcher dispatcher=getServletContext().getRequestDispatcher( "/WEB-INF/confirmation.jsp" );
        dispatcher.forward( request, response );
        //response.sendRedirect("confirmation.jsp");
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            try {
                processRequest(request, response);
            } catch (SQLException ex) {
                Logger.getLogger(MakeBricks.class.getName()).log(Level.SEVERE, null, ex);
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(MakeBricks.class.getName()).log(Level.SEVERE, null, ex);
            }
        } catch (LoginSampleException ex) {
            Logger.getLogger(MakeBricks.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            try {
                processRequest(request, response);
            } catch (SQLException ex) {
                Logger.getLogger(MakeBricks.class.getName()).log(Level.SEVERE, null, ex);
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(MakeBricks.class.getName()).log(Level.SEVERE, null, ex);
            }
        } catch (LoginSampleException ex) {
            Logger.getLogger(MakeBricks.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
