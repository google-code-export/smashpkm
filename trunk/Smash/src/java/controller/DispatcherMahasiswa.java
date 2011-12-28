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
import model.Mahasiswa;

/**
 *
 * @author yosua
 */
public class DispatcherMahasiswa extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, ParseException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        String page = request.getParameter("page");
        RequestDispatcher dis = null;
        ControllerMahasiswa controller = new ControllerMahasiswa(request);
        Mahasiswa mahasiswa = new Mahasiswa();
        String pesan = "  ";
        request.setAttribute("pesan", pesan);
        if (page != null) {
            if (page.equals("home")) {
                mahasiswa = controller.getMahasiswa();
                if (mahasiswa.getIsadmin() == false) {
                    dis = request.getRequestDispatcher("halamanUtamaPengguna.jsp");
                } else {
                    dis = request.getRequestDispatcher("halamanUtamaAdmin.jsp");
                }
            }

            if (page.equals("index")) {
                dis = request.getRequestDispatcher("index.jsp");
            }
            if (page.equals("registrasi")) {
                dis = request.getRequestDispatcher("registrasi.jsp");
            }
            if (page.equals("goRegistrasi")) {
                controller.setRegistrasi(mahasiswa);

                if (mahasiswa.getLoginstat() == true) {
                    dis = request.getRequestDispatcher("index.jsp");
                } else {
                    dis = request.getRequestDispatcher("registrasi.jsp");
                }

            }
            if (page.equals("login")) {
                mahasiswa = controller.getLogin();
                if (mahasiswa.getIsadmin() == true) {
                    if (mahasiswa.getLoginstat() == true) {
                        dis = request.getRequestDispatcher("halamanUtamaAdmin.jsp");
                    } else {
                        dis = request.getRequestDispatcher("index.jsp");
                    }

                } else {
                    if (mahasiswa.getLoginstat() == true) {
                        dis = request.getRequestDispatcher("halamanUtamaPengguna.jsp");
                    } else if (mahasiswa.getLoginstat() == false) {
                        dis = request.getRequestDispatcher("index.jsp");
                    } else {
                        dis = request.getRequestDispatcher("index.jsp");
                    }
                }
            }

            if (page.equals("pengaturanAkun")) {
                mahasiswa = controller.getMahasiswa();
                dis = request.getRequestDispatcher("pengaturanAkun.jsp");

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
            if (page.equals("pengaturanMember")) {
                controller.setListMahasiswa();
                dis = request.getRequestDispatcher("member.jsp");

            }
            if (page.equals("buatMember")) {
                dis = request.getRequestDispatcher("buatMember.jsp");

            }
            if (page.equals("goBuatMember")) {
                controller.setRegistrasi(mahasiswa);
                controller.setListMahasiswa();
                dis = request.getRequestDispatcher("member.jsp");

            }
            if (page.equals("setPengaturanMember")) {
                controller.setAturAkun(mahasiswa);
                dis = request.getRequestDispatcher("pengaturanMember.jsp");

            }

            if (page.equals("editMember")) {
                controller.setMahasiswa(mahasiswa);
                dis = request.getRequestDispatcher("pengaturanMember.jsp");

            }
            if (page.equals("goEditMember")) {
                controller.setAturAkun(mahasiswa);
                dis = request.getRequestDispatcher("pengaturanMember.jsp");

            }
            if (page.equals("pengaturanPasswordMember")) {
                controller.setMahasiswa(mahasiswa);
                dis = request.getRequestDispatcher("pengaturanPasswordMember.jsp");

            }
            if (page.equals("goAturPasswordMember")) {
                controller.setAturPasswordMember(mahasiswa);
                controller.setMahasiswa(mahasiswa);
                dis = request.getRequestDispatcher("pengaturanPasswordMember.jsp");

            }

            if (page.equals("deleteMember")) {
                controller.setDeleteMahasiswa();
                controller.setListMahasiswa();
                dis = request.getRequestDispatcher("member.jsp");

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
