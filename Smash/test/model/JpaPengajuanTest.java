
/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package model;

import controller.exceptions.NonexistentEntityException;
import java.util.logging.Level;
import java.util.logging.Logger;
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
public class JpaPengajuanTest {
    private Pengajuan user1;
    private Pengajuan user2;
    private Pengajuan user3;
    private Beasiswa bsw;
    private Mahasiswa mhs;
    JpaBeasiswa b=new JpaBeasiswa();
    JpaPengajuan p=new JpaPengajuan();
    JpaMahasiswa m=new JpaMahasiswa();

    public JpaPengajuanTest() {
    }

    @BeforeClass
    public static void setUpClass() throws Exception {
    }

    @AfterClass
    public static void tearDownClass() throws Exception {
    }

    @Before
    public void setUp() throws Exception {
        user1 = new Pengajuan();
        user1.setIdpengajuan("9898");
        user1.setPathscv("boda");
        //user1.setKeterangan(null)

        user2 = new Pengajuan();
        user2.setIdpengajuan("1234");
        user2.setPathscv("hahaha");

        user3 = new Pengajuan();
        user3.setIdpengajuan("AA");
        user3.setPathscv("ee");

        mhs=new Mahasiswa();
        mhs.setNrp("1264");
        m.create(mhs);
        bsw=new Beasiswa();
        bsw.setIdbeasiswa("5432");
        b.create(bsw);

        user1.setNrp(mhs);
        user1.setIdbeasiswa(bsw);

        user2.setNrp(mhs);
        user2.setIdbeasiswa(bsw);

        p.create(user2);
    }

    @After
    public void tearDown() {
        try {
            m.destroy(mhs.getNrp());
        } catch (NonexistentEntityException ex) {
            Logger.getLogger(JpaPengajuanTest.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            b.destroy(bsw.getIdbeasiswa());
        } catch (NonexistentEntityException ex) {
            Logger.getLogger(JpaPengajuanTest.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            p.destroy(user2.getIdpengajuan());
        } catch (NonexistentEntityException ex) {
            Logger.getLogger(JpaPengajuanTest.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Test of getEntityManager method, of class JpaPengajuan.
     */

    /**
     * Test of create method, of class JpaPengajuan.
     */
    @Test
    public void testCreate() throws Exception {
        p.create(user1);
    }

    /**
     * Test of edit method, of class JpaPengajuan.
     */
    @Test
    public void testEdit() throws Exception {
       user1.setPathscv(user2.getPathscv());
        p.edit(user1);
        assertEquals(p.findPengajuanById(user1.getIdpengajuan()).getPathscv(), user2.getPathscv());
    }

    /**
     * Test of destroy method, of class JpaPengajuan.
     */
    @Test
    public void testDestroy() throws Exception {
        p.destroy(user1.getIdpengajuan());
    }

    /**
     * Test of findPengajuan method, of class JpaPengajuan.
     */
 
    /**
     * Test of getAllPengajuanByNrp method, of class JpaPengajuan.
     */
    @Test
    public void testGetAllPengajuanByNrp() {
      assertNotNull(p.getAllPengajuanByNrp(mhs.getNrp()));
    }

    /**
     * Test of getAllPengajuan method, of class JpaPengajuan.
     */
    @Test
    public void testGetAllPengajuan() {
         assertNotNull(p.getAllPengajuan());
    }

    /**
     * Test of getAllPengajuanByIdBeasiswaOrderByIpk method, of class JpaPengajuan.
     */
    @Test
    public void testGetAllPengajuanByIdBeasiswaOrderByIpk() {
        assertNotNull(p.getAllPengajuanByIdBeasiswaOrderByIpk(bsw.getIdbeasiswa()));
    }

    /**
     * Test of getAllPengajuanByIdBeasiswaOrderByGaji method, of class JpaPengajuan.
     */
    @Test
    public void testGetAllPengajuanByIdBeasiswaOrderByGaji() {
        assertNotNull(p.getAllPengajuanByIdBeasiswaOrderByGaji(bsw.getIdbeasiswa()));
    }

    /**
     * Test of findPengajuanById method, of class JpaPengajuan.
     */
    @Test
    public void testFindPengajuanById() {
        assertNotNull(p.findPengajuanById(user2.getIdpengajuan()));
    }

}