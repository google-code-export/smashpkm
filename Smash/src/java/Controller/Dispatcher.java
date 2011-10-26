/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Controller;



/**
 *
 * @author yosua
 */

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;




/**
 *
 * @author yosua
 */
public class Dispatcher extends HttpServlet {


    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException, Exception{
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        String page = request.getParameter("page");
        RequestDispatcher dis=null;
        if (page != null) {
            if (page.equals("registrasi")) {
                
                dis = request.getRequestDispatcher("Registrasi.jsp");
            
        }  if (page.equals("goRegistrasi")) {

                GoRegistrasi goRegistrasi=new GoRegistrasi(request);
                dis = request.getRequestDispatcher(goRegistrasi.Registrasi());
                //out.println(goRegistrasi.getPesan());
               out.println("<p><font size='3' id='pesan'>"+goRegistrasi.getPesan()+" </font></p>");
                

        }if (page.equals("login")) {
                
                GoLogin goLogin=new GoLogin(request);
                dis=request.getRequestDispatcher(goLogin.Login());

        }if (page.equals("pengaturanAkun")) {

                dis = request.getRequestDispatcher("Pengaturan.jsp");

        }
        
    }else {
            dis = request.getRequestDispatcher("index.jsp");
        }
        
        dis.include(request,response);
        
        
        
        
        
    
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
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
        } catch (Exception ex) {
            Logger.getLogger(Dispatcher.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Handles the HTTP <code>POST</code> method.
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
        } catch (Exception ex) {
            Logger.getLogger(Dispatcher.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Returns a short description of the servlet.
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
