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

/**
 *
 * @author yosua
 */
public class DispatcherBeasiswa extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, ParseException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        String page = request.getParameter("page");
        RequestDispatcher dis = null;
        ControllerBeasiswa controller = new ControllerBeasiswa(request);
        Beasiswa beasiswa = new Beasiswa();
        String pesan = " ";
        request.setAttribute("pesan", pesan);

        if (page != null) {
            if (page.equals("listPilihBeasiswa")) {
                controller.setListBeasiswa();
                dis = request.getRequestDispatcher("daftarBeasiswa.jsp");
            }
            if (page.equals("daftarBeasiswa")) {
                controller.setBeasiswaPengajuan();
                dis = request.getRequestDispatcher("halamanDaftarBeasiswa.jsp");
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
                controller.setListBeasiswa();
                dis = request.getRequestDispatcher("pengaturanPost.jsp");
            }
            if (page.equals("editPost")) {
                controller.setPost(beasiswa);
                dis = request.getRequestDispatcher("editPost.jsp");
            }
            if (page.equals("goEditPost")) {
                controller.setEditPost(beasiswa);
                controller.setListBeasiswa();
                controller.setPost(beasiswa);
                dis = request.getRequestDispatcher("pengaturanPost.jsp");
            }
            if (page.equals("deletePost")) {
                controller.setDeletePost();
                controller.setListBeasiswa();
                dis = request.getRequestDispatcher("pengaturanPost.jsp");
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
            Logger.getLogger(DispatcherMahasiswa.class.getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(DispatcherMahasiswa.class.getName()).log(Level.SEVERE, null, ex);
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
