/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Controller;



/**
 *
 * @author yosua
 */

import Model.GoRegistrasi;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import Model.KoneksiDB;
import Model.Registrasi;
import java.io.PrintWriter;
import javax.servlet.http.HttpSession;



/**
 *
 * @author yosua
 */
public class SimpanRegistrasi extends HttpServlet {


    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException, Exception{
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        RequestDispatcher dis=null;
        
        GoRegistrasi registrasi=new GoRegistrasi(request);

        dis=request.getRequestDispatcher(registrasi.Registrasi());
        out.println(registrasi.pesan());
        



  /*
        String nama=request.getParameter("nama");
        String nrp=request.getParameter("nrp");
        String password=request.getParameter("password");
        String passwordUlangi=request.getParameter("password_ulangi");
    

 
        KoneksiDB kondb=new KoneksiDB();
        Registrasi reg=new Registrasi(kondb.getConnection());


        try{
         GoRegistrasi goRegistrasi=new GoRegistrasi(request);
        HttpSession session=request.getSession();
        reg.insertReg(nama,nrp,password);
        dis=request.getRequestDispatcher("/HalamanUtamaPengguna.jsp");
    }
    catch(Exception ex){

         out.println("Maaf,NRP telah digunakan");
         dis=request.getRequestDispatcher("/Registrasi.jsp");
         kondb.CloseConnection();
    
  
    }*/
        
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
            Logger.getLogger(SimpanRegistrasi.class.getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(SimpanRegistrasi.class.getName()).log(Level.SEVERE, null, ex);
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
