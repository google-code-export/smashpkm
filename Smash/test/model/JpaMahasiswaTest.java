/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package model;

import java.util.List;
import javax.persistence.EntityManager;
import junit.framework.TestCase;

/**
 *
 * @author ROODHIN
 */
public class JpaMahasiswaTest extends TestCase {
    private Mahasiswa mah1;
    private Mahasiswa mah2;
    JpaMahasiswa mh = new JpaMahasiswa();
    
    public JpaMahasiswaTest(String testName) {
        super(testName);
    }

    @Override
    protected void setUp() throws Exception {
        super.setUp();
        mah1 = new Mahasiswa();
        mah1.setNama("roodhin");
        mah1.setNrp("5209100050");

        mah2 = new Mahasiswa();
        mah2.setNama("sammi");
        mah2.setNrp("12345");
    }

    @Override
    protected void tearDown() throws Exception {
        super.tearDown();
        mah1 = null;
        mah2 = null;
    }

    /**
     * Test of getEntityManager method, of class JpaMahasiswa.
     */
    //public void testGetEntityManager() {
      //  System.out.println("getEntityManager");
        //JpaMahasiswa instance = new JpaMahasiswa();
        //EntityManager expResult = null;
        //EntityManager result = instance.getEntityManager();
        //assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
  //  }

    /**
     * Test of create method, of class JpaMahasiswa.
     */
    public void testCreate() throws Exception {
        mh.create(mah1);


        //System.out.println("create");
        //Mahasiswa mahasiswa = null;
        //JpaMahasiswa instance = new JpaMahasiswa();
        //instance.create(mahasiswa);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of edit method, of class JpaMahasiswa.
     */
    public void testEdit() throws Exception {
        mah1.setNama(mah2.getNama());
        mh.edit(mah1);
        assertEquals(mh.findMahasiswaByNrp(mah1.getNrp()).getNama(), mah2.getNama());
        //System.out.println("edit");
        //Mahasiswa mahasiswa = null;
        //JpaMahasiswa instance = new JpaMahasiswa();
        //instance.edit(mahasiswa);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of destroy method, of class JpaMahasiswa.
     */
    public void testDestroy() throws Exception {
        mh.destroy(mah1.getNrp());
        //System.out.println("destroy");
        //String id = "";
        //JpaMahasiswa instance = new JpaMahasiswa();
        //instance.destroy(id);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of findMahasiswa method, of class JpaMahasiswa.
     */
    public void testFindMahasiswa() {
        assertNull(mh.findMahasiswa(mah1.getNrp()));
    }
    /**
     * Test of findMahasiswaByNrp method, of class JpaMahasiswa.
     */
    public void testFindMahasiswaByNrp() {
       assertNull(mh.findMahasiswaByNrp(mah1.getNrp()));

        //System.out.println("findMahasiswaByNrp");
        //String nrp = "";
       // JpaMahasiswa instance = new JpaMahasiswa();
        //Mahasiswa expResult = null;
        //Mahasiswa result = instance.findMahasiswaByNrp(nrp);
        //assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
       // fail("The test case is a prototype.");
    }

    /**
     * Test of getAllMahasiswa method, of class JpaMahasiswa.
     */
    public void testGetAllMahasiswa() {
        assertNotNull(mh.getAllMahasiswa());
    }

    /**
     * Test of findBeasiswaById method, of class JpaMahasiswa.
     */
    
    

}
