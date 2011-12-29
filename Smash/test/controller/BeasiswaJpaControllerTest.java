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
    JpaBeasiswa uq = new JpaBeasiswa();
    
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
     * Test of getEntityManager method, of class JpaBeasiswa.
     */
   

    /**
     * Test of create method, of class JpaBeasiswa.
     */
    public void testCreate() throws Exception {
        
uq.create(user1);

       // System.out.println("create");
        //Beasiswa beasiswa = null;
        //JpaBeasiswa instance = new JpaBeasiswa();
        //instance.create(beasiswa);
        // TODO review the generated test code and remove the default call to fail.
   }

    /**
     * Test of edit method, of class JpaBeasiswa.
     */
    public void testEdit() throws Exception {
        user1.setNamabeasiswa(user2.getNamabeasiswa());
        uq.edit(user1);
        assertEquals(uq.findBeasiswaById(user1.getIdbeasiswa()).getNamabeasiswa(), user2.getNamabeasiswa());
        //user1.getNamabeasiswa()=uq.findBeasiswaById(user1.getIdbeasiswa()).getNamabeasiswa();
        //Beasiswa beasiswa = null;
        //JpaBeasiswa instance = new JpaBeasiswa();
        //instance.edit(beasiswa);
        // TODO review the generated test code
    }

    /**
     * Test of destroy method, of class JpaBeasiswa.
     */
    public void testDestroy() throws Exception {
        uq.destroy(user1.getIdbeasiswa());
        //user1 = ;
        //user2 = null;

        //System.out.println("destroy");
        //String id = "";
        //JpaBeasiswa instance = new JpaBeasiswa();
        //instance.destroy(id);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of findBeasiswaEntities method, of class JpaBeasiswa.
     */
   
    /**
     * Test of getAllBeasiswa method, of class JpaBeasiswa.
     */
    public void testGetAllBeasiswa() {
        assertNotNull(uq.getAllBeasiswa());
        //uq.getAllBeasiswa();
        
        //System.out.println("getAllBeasiswa");
        //JpaBeasiswa instance = new JpaBeasiswa();
        //List expResult = null;
        //List result = instance.getAllBeasiswa();
        //assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of findBeasiswaById method, of class JpaBeasiswa.
     */
    public void testFindBeasiswaById() {
        assertNull(uq.findBeasiswaById(user1.getIdbeasiswa()));
        
        //System.out.println("findBeasiswaById");
        //String idBeasiswa = "";
        //JpaBeasiswa instance = new JpaBeasiswa();
        //Beasiswa expResult = null;
        //Beasiswa result = instance.findBeasiswaById(idBeasiswa);
        //assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

}
