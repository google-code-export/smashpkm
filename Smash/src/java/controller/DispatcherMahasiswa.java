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
            if (page.equals("home")) {//dispatch ke menu utama
                mahasiswa = controller.getMahasiswa();
                if (mahasiswa.getIsadmin() == false) {//validasi antara admin dan pengguna
                    dis = request.getRequestDispatcher("halamanUtamaPengguna.jsp");
                } else {
                    dis = request.getRequestDispatcher("halamanUtamaAdmin.jsp");
                }
            }
            if (page.equals("index")) {//dispatch ke index
                dis = request.getRequestDispatcher("index.jsp");
            }
            if (page.equals("registrasi")) {//dispatch ke laman registrasi
                dis = request.getRequestDispatcher("registrasi.jsp");
            }
            if (page.equals("goRegistrasi")) {//membuat pengguna baru
                controller.setRegistrasi(mahasiswa);
                if (mahasiswa.getLoginstat() == true) {//dispatch laman keberhasilan registrasi
                    dis = request.getRequestDispatcher("index.jsp");
                } else {
                    dis = request.getRequestDispatcher("registrasi.jsp");
                }
            }
            if (page.equals("login")) {//validasi login
                mahasiswa = controller.getLogin();
                if (mahasiswa.getIsadmin() == true) {//validasi admin dan pengguna
                    if (mahasiswa.getLoginstat() == true) {// validasi status login admin
                        dis = request.getRequestDispatcher("halamanUtamaAdmin.jsp");
                    } else {
                        dis = request.getRequestDispatcher("index.jsp");
                    }
                } else {
                    if (mahasiswa.getLoginstat() == true) {// validasi status login pengguna
                        dis = request.getRequestDispatcher("halamanUtamaPengguna.jsp");
                    } else if (mahasiswa.getLoginstat() == false) {
                        dis = request.getRequestDispatcher("index.jsp");
                    } else {
                        dis = request.getRequestDispatcher("index.jsp");
                    }
                }
            }
            if (page.equals("pengaturanAkun")) {//melakukan set data akun sebelumnya untuk ditampilkan
                controller.setMahasiswa();
                dis = request.getRequestDispatcher("pengaturanAkun.jsp");
            }
            if (page.equals("setPengaturanAkun")) {//menyimpan hasil perubahan data akun
                controller.setAturAkun();
                dis = request.getRequestDispatcher("pengaturanAkun.jsp");
            }
            if (page.equals("pengaturanPassword")) {//dispatch halaman pengaturan password
                dis = request.getRequestDispatcher("pengaturanPassword.jsp");
            }
            if (page.equals("setPengaturanPassword")) {//menyimpan hasil perubahan password
                controller.setAturPassword();
                dis = request.getRequestDispatcher("pengaturanPassword.jsp");
            }
            if (page.equals("pengaturanMember")) {//melakukan list mahasiswa untuk dipilih untuk di edit
                controller.setListMahasiswa();
                dis = request.getRequestDispatcher("member.jsp");

            }
            if (page.equals("buatMember")) {//membuat pengguna baru dari halaman admin
                dis = request.getRequestDispatcher("buatMember.jsp");

            }
            if (page.equals("goBuatMember")) {//menyimpan pengguna baru
                controller.setRegistrasi(mahasiswa);
                controller.setListMahasiswa();
                dis = request.getRequestDispatcher("buatMember.jsp");
            }
            if (page.equals("setPengaturanMember")) {//menyimpan hasil perubahan data akun member dari halaman admin
                controller.setAturAkun();
                dis = request.getRequestDispatcher("pengaturanMember.jsp");
            }
            if (page.equals("editMember")) {//menyimpan data member kedalam session dan menampilkan sebagai input awal data akun
                controller.setMember();
                dis = request.getRequestDispatcher("pengaturanMember.jsp");
            }
            if (page.equals("goEditMember")) {//menyimpan data hasil perubahan data member kemdian menampilkan kembali hasil perubahan
                controller.setAturAkunMember();
                controller.setAturPasswordMember();
                controller.setMember();
                dis = request.getRequestDispatcher("pengaturanMember.jsp");
            }
            if (page.equals("pengaturanPasswordMember")) {//menyimpan data member kedalam session dan menampilkan sebagai input awal password
                controller.setMember();
                dis = request.getRequestDispatcher("pengaturanPasswordMember.jsp");
            }
            if (page.equals("goAturPasswordMember")) {//menyimpan data hasil perubahan data member kemdian menampilkan kembali hasil perubahan
                controller.setAturPasswordMember();
                controller.setMember();
                dis = request.getRequestDispatcher("pengaturanPasswordMember.jsp");
            }
            if (page.equals("deleteMember")) {//menghapus member berdasarkan nrp member
                controller.setDeleteMahasiswa();
                controller.setListMahasiswa();
                dis = request.getRequestDispatcher("member.jsp");
            }
            if (page.equals("logout")) {//keluar dari aplikasi
                controller.setLogout();
                dis = request.getRequestDispatcher("index.jsp");
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
