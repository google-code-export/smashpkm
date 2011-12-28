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
    private static final String TMP_DIR_PATH = "C://tmp";
    private File tmpDir;
    private static final String DESTINATION_DIR_PATH = "gambar";
    private File destinationDir;

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
        // ControllerBeasiswa controller = new ControllerBeasiswa(request);
        response.setContentType("text/plain");



        DiskFileItemFactory fileItemFactory = new DiskFileItemFactory();
        /*
         *Set the size threshold, above which content will be stored on disk.
         */
        fileItemFactory.setSizeThreshold(1 * 1600 * 1600); //
		/*
         * Set the temporary directory to store the uploaded files of size above threshold.
         */


        fileItemFactory.setRepository(tmpDir);

        ServletFileUpload uploadHandler = new ServletFileUpload(fileItemFactory);

        try {
            /*
             * Parse the request
             */

            List items = uploadHandler.parseRequest(request);
            Iterator itr = items.iterator();


            PengajuanJpaController daftar = new PengajuanJpaController();
            MahasiswaJpaController cariMhs = new MahasiswaJpaController();
            BeasiswaJpaController cariBsw = new BeasiswaJpaController();
            Pengajuan pengajuan = new Pengajuan();
            Mahasiswa mahasiswa = new Mahasiswa();
            Beasiswa beasiswa = new Beasiswa();
            String nrp = request.getParameter("nrp");
            String idbeasiswa = request.getParameter("idbeasiswa");
            HttpSession session = request.getSession();
            Calendar currentDate = Calendar.getInstance();
            SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
            String dateNow = formatter.format(currentDate.getTime());

            mahasiswa = cariMhs.findMahasiswaByNrp(nrp);
            beasiswa = cariBsw.findBeasiswaById(idbeasiswa);
            pengajuan.setNrp(mahasiswa);
            beasiswa.setIdbeasiswa(idbeasiswa);
            pengajuan.setIdbeasiswa(beasiswa);
            pengajuan.setTanggalpengajuan(dateNow);
            pengajuan.setStatusPengajuan(false);

            while (itr.hasNext()) {
                FileItem item = (FileItem) itr.next();
                //item.
                /*
                 * Handle Form Fields.
                 */
                if (item.isFormField()) {
                   
                    out.print(item.getFieldName());
                } else {
                    if (item.getFieldName().equals("scan_gaji")) {
                        pengajuan.setPathsgaji(item.getName());
                        File file = new File(destinationDir, item.getName());
                        item.write(file);

                    }
                    if (item.getFieldName().equals("scan_ipk")) {
                        //      Handle Uploaded files.
                        pengajuan.setPathsipk(item.getName());
                        File file = new File(destinationDir, item.getName());
                        item.write(file);
                    }
                    if (item.getFieldName().equals("scan_surat_tidak_mampu")) {
                        //      Handle Uploaded files.
                        pengajuan.setPathssurattidakmampu(item.getName());
                        File file = new File(destinationDir, item.getName());
                        item.write(file);
                    }
                    if (item.getFieldName().equals("scan_ktm")) {
                        //      Handle Uploaded files.
                        pengajuan.setPathsktm(item.getName());
                        File file = new File(destinationDir, item.getName());
                        item.write(file);
                    }
                     if (item.getFieldName().equals("scan_ktp")) {
                        //      Handle Uploaded files.
                        pengajuan.setPathsktp(item.getName());
                        File file = new File(destinationDir, item.getName());
                        item.write(file);
                    }
                    if (item.getFieldName().equals("scan_kk")) {
                        //      Handle Uploaded files.
                        pengajuan.setPathskk(item.getName());
                        File file = new File(destinationDir, item.getName());
                        item.write(file);
                    }
                    if (item.getFieldName().equals("scan_cv")) {
                        //      Handle Uploaded files.
                        pengajuan.setPathscv(item.getName());
                        File file = new File(destinationDir, item.getName());
                        item.write(file);
                    }
                    if (item.getFieldName().equals("scan_sertifikat")) {
                        //      Handle Uploaded files.
                        pengajuan.setPathssertifikat(item.getName());
                        File file = new File(destinationDir, item.getName());
                        item.write(file);
                    }
                    if (item.getFieldName().equals("scan_rekening")) {
                        //      Handle Uploaded files.
                        pengajuan.setPathsrekening(item.getName());
                        File file = new File(destinationDir, item.getName());
                        item.write(file);
                    }
                }
            }
            try {
                daftar.create(pengajuan);
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
        controller.setListPengajuanByNrp(pengajuan);
        dis = request.getRequestDispatcher("listDaftarBeasiswa.jsp");
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
