/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PresentationLayer;

import DBAccess.UserMapper;
import FunctionLayer.LogicFacade;
import FunctionLayer.Order;
import FunctionLayer.Calculator;
import FunctionLayer.LoginSampleException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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
            throws ServletException, IOException, LoginSampleException {
        Calculator cal = new Calculator();
        response.setContentType("text/html;charset=UTF-8");

        int length = Integer.parseInt(request.getParameter("length"));
        int width = Integer.parseInt(request.getParameter("width"));
        int height = Integer.parseInt(request.getParameter("height"));
        int sBricksl = cal.calculatorS(length);
        System.out.println("1");
        int mBricksl = cal.calculatorM(length);
        System.out.println("2");
        int lBricksl = cal.calculatorL(length);
        System.out.println("3");
        int sBricksw = cal.calculatorS(width);
        System.out.println("4");
        int mBricksw = cal.calculatorM(width);
        System.out.println("5");
        int lBricksw = cal.calculatorL(width);
        System.out.println("6");
        int mBricks2l = cal.calculator2M(length);
        System.out.println("7");
        int lBricks2l = cal.calculator2L(length);
        System.out.println("8");
        int mBricks2w = cal.calculator2M(width);
        System.out.println("9");
        int lBricks2w = cal.calculator2L(width);
        System.out.println("10");
        int totalLBricks = cal.totalLBricks(height, lBricksl, lBricksw, lBricks2l, lBricks2w);
        System.out.println("11");
        int totalMBricks = cal.totalMBricks(height, mBricksl, mBricksw, mBricks2l, mBricks2w);
        System.out.println("12");
        int totalSBricks = cal.totalSBricks(height, sBricksl, sBricksw);
        System.out.println("13");
        Order order = new Order(totalSBricks, totalMBricks, totalLBricks, false);
        System.out.println("14");
        UserMapper.createOrder(order);
        System.out.println("15");
        response.sendRedirect("confirmation.jsp");
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
            processRequest(request, response);
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
            processRequest(request, response);
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
