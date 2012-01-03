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
public class JpaPengajuanTest extends TestCase {
    private Pengajuan peng1;
    private Pengajuan peng2;
    JpaPengajuan pg = new JpaPengajuan();
    
    public JpaPengajuanTest(String testName) {
        super(testName);

    }

    @Override
    protected void setUp() throws Exception {
        super.setUp();
        peng1=new Pengajuan();
        peng1.setIdpengajuan("1234");
        peng1.setPathsipk("3.5");

        peng2=new Pengajuan();
        peng2.setIdpengajuan("7634");
        peng2.setPathsipk("3.2");

    }

    @Override
    protected void tearDown() throws Exception {
        super.tearDown();
        peng1=null;
        peng2=null;
    }

    /**
     * Test of getEntityManager method, of class JpaPengajuan.
     */
    

    /**
     * Test of create method, of class JpaPengajuan.
     */
    public void testCreate() throws Exception {
        pg.create(peng1);

       // System.out.println("create");
        //Pengajuan pengajuan = null;
        //JpaPengajuan instance = new JpaPengajuan();
        //instance.create(pengajuan);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of edit method, of class JpaPengajuan.
     */
    public void testEdit() throws Exception {
        peng1.setNrp(peng2.getNrp());
        pg.edit(peng1);
        assertEquals(pg.findPengajuanById(peng1.getIdpengajuan()).getNrp(), peng2.getNrp());

        //System.out.println("edit");
        //Pengajuan pengajuan = null;
        //JpaPengajuan instance = new JpaPengajuan();
        //instance.edit(pengajuan);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of destroy method, of class JpaPengajuan.
     */
    public void testDestroy() throws Exception {
        pg.destroy(peng1.getIdpengajuan());
        //System.out.println("destroy");
        //String id = "";
        //JpaPengajuan instance = new JpaPengajuan();
        //instance.destroy(id);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of findPengajuan method, of class JpaPengajuan.
     */
    public void testFindPengajuan() {
       assertNull(pg.findPengajuan(peng1.getIdpengajuan()));
        //System.out.println("findPengajuan");
        //String id = "";
        //JpaPengajuan instance = new JpaPengajuan();
        //Pengajuan expResult = null;
        //Pengajuan result = instance.findPengajuan(id);
        //assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of getAllPengajuanByNrp method, of class JpaPengajuan.
     */
    public void testGetAllPengajuanByNrp() {
        assertNull(pg.findPengajuanById(peng1.getIdpengajuan()));
        //System.out.println("getAllPengajuanByNrp");
        //String nrp = "";
        //JpaPengajuan instance = new JpaPengajuan();
        //List expResult = null;
        //List result = instance.getAllPengajuanByNrp(nrp);
        //assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of getAllPengajuan method, of class JpaPengajuan.
     */
    public void testGetAllPengajuan() {
        assertNotNull(pg.getAllPengajuan());
        //System.out.println("getAllPengajuan");
        //JpaPengajuan instance = new JpaPengajuan();
        //List expResult = null;
        //List result = instance.getAllPengajuan();
        //assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of getAllPengajuanByIdBeasiswaOrderByIpk method, of class JpaPengajuan.
     */
   
    /**
     * Test of findPengajuanById method, of class JpaPengajuan.
     */
    public void testFindPengajuanById() {
       assertNull(pg.findPengajuanById(peng1.getIdpengajuan()));
        //System.out.println("findPengajuanById");
        //String idPengajuan = "";
        //JpaPengajuan instance = new JpaPengajuan();
       // Pengajuan expResult = null;
       // Pengajuan result = instance.findPengajuanById(idPengajuan);
       // assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
      //  fail("The test case is a prototype.");
    }

}
