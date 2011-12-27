/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package controller;

import java.util.List;
import javax.persistence.EntityManager;
import junit.framework.TestCase;
import model.Beasiswa;

/**
 *
 * @author ROODHIN
 */
public class BeasiswaJpaControllerTest extends TestCase {
    private Beasiswa user1;
    private Beasiswa user2;
    BeasiswaJpaController uq = new BeasiswaJpaController();
    
    public BeasiswaJpaControllerTest(String testName) {
        super(testName);
    }

    @Override
    protected void setUp() throws Exception {
        super.setUp();
        user1 = new Beasiswa();
        user1.setIdbeasiswa("9898");
        user1.setNamabeasiswa("boda");
        //user1.setKeterangan(null)

        user2 = new Beasiswa();
        user2.setIdbeasiswa("1234");
        user2.setNamabeasiswa("hahaha");

        
        
    }

    @Override
    protected void tearDown() throws Exception {
        super.tearDown();
        
        user1=null;
        user2=null;


    }

    /**
     * Test of getEntityManager method, of class BeasiswaJpaController.
     */
    public void testGetEntityManager() {
        System.out.println("getEntityManager");
        BeasiswaJpaController instance = new BeasiswaJpaController();
        EntityManager expResult = null;
        EntityManager result = instance.getEntityManager();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of create method, of class BeasiswaJpaController.
     */
    public void testCreate() throws Exception {
        
uq.create(user1);

       // System.out.println("create");
        //Beasiswa beasiswa = null;
        //BeasiswaJpaController instance = new BeasiswaJpaController();
        //instance.create(beasiswa);
        // TODO review the generated test code and remove the default call to fail.
   }

    /**
     * Test of edit method, of class BeasiswaJpaController.
     */
    public void testEdit() throws Exception {
        user1.setNamabeasiswa(user2.getNamabeasiswa());
        uq.edit(user1);
        assertEquals(uq.findBeasiswaById(user1.getIdbeasiswa()).getNamabeasiswa(), user2.getNamabeasiswa());
        //user1.getNamabeasiswa()=uq.findBeasiswaById(user1.getIdbeasiswa()).getNamabeasiswa();
        //Beasiswa beasiswa = null;
        //BeasiswaJpaController instance = new BeasiswaJpaController();
        //instance.edit(beasiswa);
        // TODO review the generated test code
    }

    /**
     * Test of destroy method, of class BeasiswaJpaController.
     */
    public void testDestroy() throws Exception {
        uq.destroy(user1.getIdbeasiswa());
        //user1 = ;
        //user2 = null;

        //System.out.println("destroy");
        //String id = "";
        //BeasiswaJpaController instance = new BeasiswaJpaController();
        //instance.destroy(id);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

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
