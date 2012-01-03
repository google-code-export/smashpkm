
/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package model;

import controller.exceptions.NonexistentEntityException;
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
public class JpaMahasiswaTest {
    private Mahasiswa user1;
    private Mahasiswa user2;
    private Mahasiswa user3;
    JpaMahasiswa uq = new JpaMahasiswa();


    public JpaMahasiswaTest() {
    }

    @BeforeClass
    public static void setUpClass() throws Exception {
    }

    @AfterClass
    public static void tearDownClass() throws Exception {
    }

    @Before
    public void setUp() throws  Exception {
        user1 = new Mahasiswa();
        user1.setNrp("9898");
        user1.setNama("boda");
        //user1.setKeterangan(null)

        user2 = new Mahasiswa();
        user2.setNrp("1234");
        user2.setNama("hahaha");

        user3 = new Mahasiswa();
        user3.setNrp("AA");
        user3.setNama("ee");
       
    }

    @After
    public void tearDown() throws NonexistentEntityException {
        user1 = null;
        user2 = null;
        user3=null;
        //uq.destroy(user3.getNrp());
    }

    /**
     * Test of getEntityManager method, of class JpaMahasiswa.
     */



    /**
     * Test of create method, of class JpaMahasiswa.
     */
    @Test
    public void testCreate() throws Exception {
        uq.create(user1);
    }

    /**
     * Test of edit method, of class JpaMahasiswa.
     */
    @Test
    public void testEdit() throws Exception {
         user1.setNama(user2.getNama());
        uq.edit(user1);
        assertEquals(uq.findMahasiswaByNrp(user1.getNrp()).getNama(), user2.getNama());
        //user1.getNamabeasiswa()=uq.findBeasiswaById(user1.getIdbeasiswa()).getNamabeasiswa();
        //Beasiswa beasiswa = null;
        //JpaBeasiswa instance = new JpaBeasiswa();
        //instance.edit(beasiswa);
        // TODO review the generated test code
    }

    /**
     * Test of destroy method, of class JpaMahasiswa.
     */
    @Test
    public void testDestroy() throws Exception {
        uq.destroy(user1.getNrp());
    }

    /**
     * Test of findMahasiswa method, of class JpaMahasiswa.
     */
    

    /**
     * Test of findMahasiswaByNrp method, of class JpaMahasiswa.
     */
    @Test
    public void testFindMahasiswaByNrp() throws PreexistingEntityException, Exception {
        
        assertNotNull(uq.findMahasiswaByNrp(user3.getNrp()));
    }

    /**
     * Test of getAllMahasiswa method, of class JpaMahasiswa.
     */
    @Test
    public void testGetAllMahasiswa() {
        assertNotNull(uq.getAllMahasiswa());
    }

    /**
     * Test of findBeasiswaById method, of class JpaMahasiswa.
     */

}