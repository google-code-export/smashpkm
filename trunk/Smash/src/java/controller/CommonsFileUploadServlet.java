/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Iterator;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.Beasiswa;
import model.Mahasiswa;
import model.Pengajuan;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

/**
 *
 * @author yosua
 */
public class CommonsFileUploadServlet extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code> methods.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */

     /**
     * Membuat direktori temporari dalam poject dan file
     */
    private static final String TMP_DIR_PATH = "C://tmp";
    private File tmpDir;
    private static final String DESTINATION_DIR_PATH = "gambar";
    private File destinationDir;


    /**
     * Melakukan inisialisasi dari direktori yang telah dibuat sebelumnya
     */
    @Override
    public void init(ServletConfig config) throws ServletException {

        super.init(config);
        tmpDir = new File(TMP_DIR_PATH);
        if (!tmpDir.isDirectory()) {
            throw new ServletException(TMP_DIR_PATH + " is not a directory");
        }
        String realPath = getServletContext().getRealPath(DESTINATION_DIR_PATH);
        System.out.println(realPath);
        destinationDir = new File(realPath);
        if (!destinationDir.isDirectory()) {
            throw new ServletException(DESTINATION_DIR_PATH + " is not a directory");
        }

    }

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        PrintWriter out = response.getWriter();
        RequestDispatcher dis = null;
        response.setContentType("text/plain");
        DiskFileItemFactory fileItemFactory = new DiskFileItemFactory();
        /*
         * Membatasi dimensi dari file yang akan di-upload
         */
        fileItemFactory.setSizeThreshold(1 * 1600 * 1600);
        /*
         * Melakukan pengaturan direktori temporari
         */
        fileItemFactory.setRepository(tmpDir);

        ServletFileUpload uploadHandler = new ServletFileUpload(fileItemFactory);

        try {
            /*
             * Memasukkan semua file yang ada (request) kedalam list item yang nantinya akan
             * di iterasi untuk disimpan sesuai kolomnya dalam db
             */
            List items = uploadHandler.parseRequest(request);
            Iterator itr = items.iterator();

            /**
             * Membuat objek-objek untuk proses penyimpanan path dari file kedalam db.
             * Nantinya semua file akan di simpan dalam folder gambar dan path-nya akan disimpan dalam db
             * sesuai dengan nama file-nya masing-masing
             */
            JpaPengajuan daftar = new JpaPengajuan();
            JpaMahasiswa cariMhs = new JpaMahasiswa();
            JpaBeasiswa cariBsw = new JpaBeasiswa();
            Pengajuan pengajuan = new Pengajuan();
            Mahasiswa mahasiswa = new Mahasiswa();
            Beasiswa beasiswa = new Beasiswa();
            String nrp = request.getParameter("nrp"); //Menentukan record pengguna yang akan di-edit
            String idbeasiswa = request.getParameter("idbeasiswa"); //Menentukan record beasiswa yang akan diedit
            HttpSession session = request.getSession();
            Calendar currentDate = Calendar.getInstance(); //Melakukan pengaturan tanggal
            SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
            String dateNow = formatter.format(currentDate.getTime());

            mahasiswa = cariMhs.findMahasiswaByNrp(nrp);
            beasiswa = cariBsw.findBeasiswaById(idbeasiswa);
            pengajuan.setNrp(mahasiswa);
            beasiswa.setIdbeasiswa(idbeasiswa);
            pengajuan.setIdbeasiswa(beasiswa);
            pengajuan.setTanggalpengajuan(dateNow);
            pengajuan.setStatuspengajuan("Daftar");
                //item.
                /*
                 * Melakukan proses iterasi dari list yang sudah didapat
                 * list satu persatu melakukan create pengajuan dimana setiap file jpeg akan di
                 * simpan sesuai dengan nama file dalam db
                 */
            while (itr.hasNext()) {
                FileItem item = (FileItem) itr.next();
                
                if (item.isFormField()) {

                    out.print(item.getFieldName());
                } else {
                    if (item.getFieldName().equals("scan_gaji")) { //melakukan pencocokan nama field
                        pengajuan.setPathsgaji(item.getName()); //melakuan set sesuai dengan nama file
                        File file = new File(destinationDir, item.getName());
                        item.write(file);

                    }
                    if (item.getFieldName().equals("scan_ipk")) {//melakukan pencocokan nama field
                        pengajuan.setPathsipk(item.getName());//melakuan set sesuai dengan nama file
                        File file = new File(destinationDir, item.getName());
                        item.write(file);
                    }
                    if (item.getFieldName().equals("scan_surat_tidak_mampu")) {//melakukan pencocokan nama field
                        pengajuan.setPathssurattidakmampu(item.getName());//melakuan set sesuai dengan nama file
                        File file = new File(destinationDir, item.getName());
                        item.write(file);
                    }
                    if (item.getFieldName().equals("scan_ktm")) {//melakukan pencocokan nama field
                        pengajuan.setPathsktm(item.getName());//melakuan set sesuai dengan nama file
                        File file = new File(destinationDir, item.getName());
                        item.write(file);
                    }
                    if (item.getFieldName().equals("scan_ktp")) {//melakukan pencocokan nama field
                        pengajuan.setPathsktp(item.getName());//melakuan set sesuai dengan nama file
                        File file = new File(destinationDir, item.getName());
                        item.write(file);
                    }
                    if (item.getFieldName().equals("scan_kk")) {//melakukan pencocokan nama field
                        pengajuan.setPathskk(item.getName());//melakuan set sesuai dengan nama file
                        File file = new File(destinationDir, item.getName());
                        item.write(file);
                    }
                    if (item.getFieldName().equals("scan_cv")) {//melakukan pencocokan nama field
                        pengajuan.setPathscv(item.getName());//melakuan set sesuai dengan nama file
                        File file = new File(destinationDir, item.getName());
                        item.write(file);
                    }
                    if (item.getFieldName().equals("scan_sertifikat")) {//melakukan pencocokan nama field
                        pengajuan.setPathssertifikat(item.getName());//melakuan set sesuai dengan nama file
                        File file = new File(destinationDir, item.getName());
                        item.write(file);
                    }
                    if (item.getFieldName().equals("scan_rekening")) {//melakukan pencocokan nama field
                        pengajuan.setPathsrekening(item.getName());//melakuan set sesuai dengan nama file
                        File file = new File(destinationDir, item.getName());
                        item.write(file);
                    }
                }
            }
            try {
                daftar.create(pengajuan);//menyimpan file
            } catch (Exception e) {
                e.printStackTrace();
            }
        } catch (FileUploadException ex) {
            log("Error encountered while parsing the request", ex);
        } catch (Exception ex) {
            log("Error encountered while uploading file", ex);
        }
        Pengajuan pengajuan = new Pengajuan();
        ControllerPengajuan controller = new ControllerPengajuan(request);
        controller.setListPengajuanByNrp();
        dis = request.getRequestDispatcher("listDaftarBeasiswa.jsp"); //dispatch ke halaman listDaftarBeasiswa
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
