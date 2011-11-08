/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package controller;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Mahasiswa;

/**
 *
 * @author yosua
 */
public class Dispatcher extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        String page = request.getParameter("page");
        RequestDispatcher dis = null;
        Controller controller = new Controller(request);
        Mahasiswa mahasiswa = new Mahasiswa();


        if (page != null) {
            if (page.equals("home")) {
                dis = request.getRequestDispatcher("halamanUtamaPengguna.jsp");
            }
            if (page.equals("registrasi")) {
                dis = request.getRequestDispatcher("registrasi.jsp");
            }
            if (page.equals("goRegistrasi")) {
                controller.setRegistrasi(mahasiswa);
               if (mahasiswa.getLoginStat() == true) {
                    dis = request.getRequestDispatcher("halamanUtamaPengguna.jsp");
                } else {
                    dis = request.getRequestDispatcher("registrasi.jsp");
                }
            }
            if (page.equals("login")) {
                mahasiswa = controller.getLoginStat();
                if (mahasiswa.getLoginStat() == true) {
                    dis = request.getRequestDispatcher("halamanUtamaPengguna.jsp");
                } else {
                    dis = request.getRequestDispatcher("index.jsp");
                    out.println("anda gagal login");
                }
            }

            if (page.equals("pengaturanAkun")) {
                dis = request.getRequestDispatcher("pengaturanAkun.jsp");
                mahasiswa=controller.getMahasiswa();
                
                
            }
             if (page.equals("setPengaturanAkun")) {
                controller.setAturAkun(mahasiswa);
                 dis = request.getRequestDispatcher("pengaturanAkun.jsp");




            }
            if (page.equals("pengaturanPassword")) {
                dis = request.getRequestDispatcher("pengaturanPassword.jsp");

            }
            if (page.equals("setPengaturanPassword")) {
                controller.setAturPassword(mahasiswa);
                dis = request.getRequestDispatcher("pengaturanPassword.jsp");

            }
            if (page.equals("logout")) {
                controller.setLogout(mahasiswa);
                dis = request.getRequestDispatcher("index.jsp");
                out.println("anda berhasil logout");
            }
        } else {
            dis = request.getRequestDispatcher("index.jsp");
        }
        dis.include(request, response);
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
        processRequest(request, response);
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
        processRequest(request, response);
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
