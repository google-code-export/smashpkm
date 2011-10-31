/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

/**
 *
 * @author yosua
 */
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import model.Mahasiswa;

/**
 *
 * @author yosua
 */
public class Controller {

    HttpServletRequest request;

    public Controller(HttpServletRequest request) {
        this.request = request;
    }

    public void setRegistrasi(Mahasiswa mahasiswa) {
        String nrp = request.getParameter("nrp");
        String nama = request.getParameter("nama");
        String password = request.getParameter("password");
        HttpSession session = request.getSession();
        MahasiswaJpaController registrasi = new MahasiswaJpaController();
        mahasiswa.setNrp(nrp);
        mahasiswa.setNama(nama);
        mahasiswa.setPassword(password);
        try {
            registrasi.create(mahasiswa);
            session.setAttribute("nrp", nrp);
            mahasiswa.setLoginStat(true);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public Mahasiswa getLoginStat() {
        String nrp = request.getParameter("nrp");
        String password = request.getParameter("password");
        HttpSession session = request.getSession();
        MahasiswaJpaController login = new MahasiswaJpaController();
        Mahasiswa mahasiswa = new Mahasiswa();
        login.findMahasiswaByNrp(nrp);
        if (login.findMahasiswaByNrp(nrp) != null) {
            mahasiswa = login.findMahasiswaByNrp(nrp);
            if (mahasiswa.getPassword().equals(password)) {
                mahasiswa.setLoginStat(true);
                session.setAttribute("nrp", nrp);
                session.setAttribute("mahasiswa", mahasiswa);
            } else {
                mahasiswa.setLoginStat(false);
            }
            try {
                login.edit(mahasiswa);
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
            }
        } else {
            mahasiswa.setLoginStat(false);
        }
        return mahasiswa;
    }

    public void setLogout(Mahasiswa mahasiswa) {
        MahasiswaJpaController logout = new MahasiswaJpaController();
        HttpSession session = request.getSession();
        mahasiswa = logout.findMahasiswaByNrp((String) session.getAttribute("nrp"));
        mahasiswa.setLoginStat(false);

        try {
            logout.edit(mahasiswa);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public Mahasiswa getAturAkun() {
        Mahasiswa mahasiswa = new Mahasiswa();
        MahasiswaJpaController aturAkun = new MahasiswaJpaController();
        HttpSession session = request.getSession();
        mahasiswa = aturAkun.findMahasiswaByNrp((String) session.getAttribute("nrp"));
        return mahasiswa;
    }

    public void setAturAkun(Mahasiswa mahasiswa) {
        String nrp = request.getParameter("nrp");
        String nama = request.getParameter("nama");

        MahasiswaJpaController aturAkun = new MahasiswaJpaController();
        HttpSession session = request.getSession();
        mahasiswa = aturAkun.findMahasiswaByNrp((String) session.getAttribute("nrp"));
    }
}
