/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Beasiswa;
import model.Mahasiswa;

/**
 *
 * @author yosua
 */
public class Dispatcher extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, ParseException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        String page = request.getParameter("page");
        RequestDispatcher dis = null;
        Controller controller = new Controller(request);
        Mahasiswa mahasiswa = new Mahasiswa();
        Beasiswa beasiswa =new Beasiswa();
        String pesan = " ";
        request.setAttribute("pesan", pesan);


        if (page != null) {
            if (page.equals("home")) {
                mahasiswa=controller.getMahasiswa();
                if (mahasiswa.getIsadmin()==false) {
                    dis = request.getRequestDispatcher("halamanUtamaPengguna.jsp");
                } else {
                    dis = request.getRequestDispatcher("halamanUtamaAdmin.jsp");
                    
                }
            }
            if (page.equals("registrasi")) {
                dis = request.getRequestDispatcher("registrasi.jsp");
            }
            if (page.equals("goRegistrasi")) {
                controller.setRegistrasi(mahasiswa);

                if (mahasiswa.getLoginstat() == true) {
                    dis = request.getRequestDispatcher("halamanUtamaPengguna.jsp");
                } else {
                    dis = request.getRequestDispatcher("registrasi.jsp");
                }


               if (mahasiswa.getLoginstat() == true) {
                    dis = request.getRequestDispatcher("halamanUtamaPengguna.jsp");
                } else {
                    dis = request.getRequestDispatcher("registrasi.jsp");
                }

            }
            if (page.equals("login")) {
                mahasiswa = controller.getLogin();
                if(mahasiswa.getIsadmin()==true){
                     if (mahasiswa.getLoginstat() == true) {
                    dis = request.getRequestDispatcher("halamanUtamaAdmin.jsp");
                } else {
                    dis = request.getRequestDispatcher("index.jsp");
                }
                    
                }else{
                if (mahasiswa.getLoginstat() == true) {
                    dis = request.getRequestDispatcher("halamanUtamaPengguna.jsp");
                } else {
                    dis = request.getRequestDispatcher("index.jsp");
                }
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
            if (page.equals("daftarBeasiswa")) {
                controller.setListBeasiswa();
                dis = request.getRequestDispatcher("daftarBeasiswa.jsp");

            }
            if (page.equals("pengaturanPost")) {
                controller.setListBeasiswa();
                dis = request.getRequestDispatcher("pengaturanPost.jsp");

            }
            if (page.equals("membuatPost")) {
                dis = request.getRequestDispatcher("buatPost.jsp");

            }
            if (page.equals("goBuatPost")) {
                controller.setBuatBeasiswa(beasiswa);
                dis = request.getRequestDispatcher("buatPost.jsp");

            }
            if (page.equals("editPost")) {
                controller.setPost(beasiswa);
                dis = request.getRequestDispatcher("buatPost.jsp");

            }
            if (page.equals("goEditPost")) {
                controller.setEditPost(beasiswa);
                dis = request.getRequestDispatcher("buatPost.jsp");

            }
            if (page.equals("deletePost")) {
                controller.setDeletePost();
                controller.setListBeasiswa();
                dis = request.getRequestDispatcher("pengaturanPost.jsp");

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
        try {
            processRequest(request, response);
        } catch (ParseException ex) {
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
        } catch (ParseException ex) {
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
