/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.utap.controllers;

import co.edu.utap.domain.PlanPago;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.Locale;

/**
 *
 * @author Samsung
 */
@WebServlet(name = "ParcialController", urlPatterns = {"/ParcialController"})
public class ParcialController extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    
    
    int nroCuotas=Integer.valueOf(request.getParameter("CantiCuotas"));
    double valorPrestamo=Double.valueOf(request.getParameter("VlrPrestamo"));
    double tasa = Double.valueOf(request.getParameter("Tasa")) / 100;
        
        List<PlanPago> plan = new ArrayList<>();        
        double cuotaMensual = valorPrestamo*((tasa * (Math.pow((1+tasa),nroCuotas))) / ((Math.pow((1+tasa),nroCuotas)) - 1));
    
        
        
//VP * ((i * ((1+i) ^ n)) / (((1+i) ^ n) - 1))                 
            double abonoInt = 0;
            double abonoCap = 0;
            double nuevoSaldo = 0;
            
        for (int i = 0; i <= nroCuotas; i++) {
            PlanPago pago;

            
            
            
            if(i == 0){
                pago = new PlanPago(i, abonoInt, abonoCap, 0, valorPrestamo);
                
            }else{
                
                pago = new PlanPago(i, abonoInt, abonoCap, cuotaMensual, valorPrestamo);
            }
            abonoInt = valorPrestamo*tasa;
            abonoCap = cuotaMensual-abonoInt;
            nuevoSaldo = valorPrestamo-abonoCap;

            System.out.print(i + " - " +abonoInt + " - " + abonoCap + " - " +cuotaMensual + " - " + valorPrestamo);
            
            valorPrestamo=nuevoSaldo;
            plan.add(pago);
            
        }
        request.setAttribute("plan", plan);
        request.getRequestDispatcher("index.jsp").forward(request, response);
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
        processRequest(request, response);
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
        processRequest(request, response);
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
