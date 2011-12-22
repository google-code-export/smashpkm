/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package controller;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import javax.persistence.EntityManager;
import junit.framework.TestCase;
import model.Beasiswa;

/**
 *
 * @author ROODHIN
 */
public class BeasiswaJpaControllerTest extends TestCase {
    private Beasiswa beasiswa1;
    private Beasiswa beasiswa2;

    BeasiswaJpaController eq = new BeasiswaJpaController();
    private MahasiswaJpaController Mah1;
    private MahasiswaJpaController Mah2;
    
    public BeasiswaJpaControllerTest(String testName) {
        super(testName);
    }

    @Override
    protected void setUp() throws Exception {
        super.setUp();
        String TanggalHabis = "11-11-2010";
        DateFormat formatter;
        Date dateHabis;
        formatter = new SimpleDateFormat("dd-MM-yyyy");
        dateHabis = (Date) formatter.parse(TanggalHabis);

        String TanggalKadaluwarsa = "11-11-2011";
        Date dateKadaluwarsa;
        formatter = new SimpleDateFormat("dd-MM-yyyy");
        dateKadaluwarsa = (Date) formatter.parse(TanggalKadaluwarsa);

        String TanggalMulai = "11-11-2011";
        Date dateMulai;
        formatter = new SimpleDateFormat("dd-MM-yyyy");
        dateMulai = (Date) formatter.parse(TanggalMulai);

        String TanggalPublish = "11-11-2011";
        Date datePublish;
        formatter = new SimpleDateFormat("dd-MM-yyyy");
        datePublish = (Date) formatter.parse(TanggalPublish);


        beasiswa1 = new Beasiswa();
        beasiswa1.setIdbeasiswa("1213");
        beasiswa1.setKeterangan("coba");
        beasiswa1.setNamabeasiswa("supersemar");
        beasiswa1.setTanggalhabis(dateHabis);
        beasiswa1.setTanggalkadaluwarsa(dateKadaluwarsa);
        beasiswa1.setTanggalmulai(dateMulai);
        beasiswa1.setTanggalpublish(datePublish);

        beasiswa2 = new Beasiswa();
        beasiswa2.setIdbeasiswa("77727");
        beasiswa2.setKeterangan("selalu");
        beasiswa2.setNamabeasiswa("BCA");
        beasiswa2.setTanggalhabis(dateHabis);
        beasiswa2.setTanggalkadaluwarsa(dateKadaluwarsa);
        beasiswa2.setTanggalmulai(dateMulai);
        beasiswa2.setTanggalpublish(datePublish);

        eq.create(beasiswa1);


    }

    @Override
    protected void tearDown() throws Exception {
        super.tearDown();
        eq.destroy("1213");
        beasiswa1 = null;
        beasiswa2 = null;

    }

    /**
     * Test of getEntityManager method, of class BeasiswaJpaController.
     */
        public void testGetEntityManager() {
        BeasiswaJpaController instance = new BeasiswaJpaController();
        EntityManager expResult = null;
        EntityManager result = instance.getEntityManager();
        assertEquals(expResult, result);
        System.out.println("getEntityManager");
        // TODO review the generated test code and remove the default call to fail.
        
    }

    /**
     * Test of create method, of class BeasiswaJpaController.
     */
    public void testCreate() throws Exception {
        System.out.println("create");
        Beasiswa beasiswa = null;
        BeasiswaJpaController instance = new BeasiswaJpaController();
        instance.create(beasiswa);
        // TODO review the generated test code and remove the default call to fail.
    }

    /**
     * Test of edit method, of class BeasiswaJpaController.
     */
    public void testEdit() throws Exception {
        beasiswa1 = eq.findBeasiswaById("1213");
        beasiswa1.setIdbeasiswa(beasiswa2.getIdbeasiswa());
        eq.edit(beasiswa1);
        assertEquals(beasiswa2.getIdbeasiswa(),eq.findBeasiswaById("1213"));
    }

    /**
     * Test of destroy method, of class BeasiswaJpaController.
     */
    

    /**
     * Test of findBeasiswaEntities method, of class BeasiswaJpaController.
     */
    public void testFindBeasiswaEntities_0args() {
        System.out.println("findBeasiswaEntities");
        BeasiswaJpaController instance = new BeasiswaJpaController();
        List expResult = null;
        List result = instance.findBeasiswaEntities();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of findBeasiswaEntities method, of class BeasiswaJpaController.
     */
    public void testFindBeasiswaEntities_int_int() {
        System.out.println("findBeasiswaEntities");
        int maxResults = 0;
        int firstResult = 0;
        BeasiswaJpaController instance = new BeasiswaJpaController();
        List expResult = null;
        List result = instance.findBeasiswaEntities(maxResults, firstResult);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of findBeasiswa method, of class BeasiswaJpaController.
     */
    public void testFindBeasiswa() {
        System.out.println("findBeasiswa");
        String id = "";
        BeasiswaJpaController instance = new BeasiswaJpaController();
        Beasiswa expResult = null;
        Beasiswa result = instance.findBeasiswa(id);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getBeasiswaCount method, of class BeasiswaJpaController.
     */
    public void testGetBeasiswaCount() {
        System.out.println("getBeasiswaCount");
        BeasiswaJpaController instance = new BeasiswaJpaController();
        int expResult = 0;
        int result = instance.getBeasiswaCount();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getAllBeasiswa method, of class BeasiswaJpaController.
     */
    public void testGetAllBeasiswa() {
        System.out.println("getAllBeasiswa");
        BeasiswaJpaController instance = new BeasiswaJpaController();
        List expResult = null;
        List result = instance.getAllBeasiswa();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of findBeasiswaById method, of class BeasiswaJpaController.
     */
    public void testFindBeasiswaById() {
        System.out.println("findBeasiswaById");
        String idBeasiswa = "";
        BeasiswaJpaController instance = new BeasiswaJpaController();
        Beasiswa expResult = null;
        Beasiswa result = instance.findBeasiswaById(idBeasiswa);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

}
