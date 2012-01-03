
/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import controller.exceptions.PreexistingEntityException;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author yosua
 */
public class JpaBeasiswaTest {

    private Beasiswa user1;
    private Beasiswa user2;
    private Beasiswa user3;
    JpaBeasiswa uq = new JpaBeasiswa();

    public JpaBeasiswaTest() {
    }

    @BeforeClass
    public static void setUpClass() throws Exception {
    }

    @AfterClass
    public static void tearDownClass() throws Exception {
    }

    @Before
    public void setUp() {

        user1 = new Beasiswa();
        user1.setIdbeasiswa("9898");
        user1.setNamabeasiswa("boda");
        //user1.setKeterangan(null)

        user2 = new Beasiswa();
        user2.setIdbeasiswa("1234");
        user2.setNamabeasiswa("hahaha");

        user3 = new Beasiswa();
        user3.setIdbeasiswa("AA");
        user3.setNamabeasiswa("ee");

    }

    @After
    public void tearDown() {
        user1 = null;
        user2 = null;
        user3 = null;
    }

    /**
     * Test of getEntityManager method, of class JpaBeasiswa.
     */
  


    /**
     * Test of create method, of class JpaBeasiswa.
     */
    @Test
    public void testCreate() throws Exception {
        uq.create(user1);
    }

    /**
     * Test of edit method, of class JpaBeasiswa.
     */
    @Test
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
    @Test
    public void testDestroy() throws Exception {
         uq.destroy(user1.getIdbeasiswa());
    }

    /**
     * Test of findBeasiswa method, of class JpaBeasiswa.
     */


    /**
     * Test of getAllBeasiswa method, of class JpaBeasiswa.
     */
    @Test
    public void testGetAllBeasiswa() {
        assertNotNull(uq.getAllBeasiswa());
    }

    /**
     * Test of findBeasiswaById method, of class JpaBeasiswa.
     */
    @Test
    public void testFindBeasiswaById() throws PreexistingEntityException, Exception {
        uq.create(user3);
        assertNotNull(uq.findBeasiswaById(user3.getIdbeasiswa()));
    }
}
