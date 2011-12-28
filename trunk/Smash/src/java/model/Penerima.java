/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package model;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 *
 * @author yosua
 */
@Entity
@Table(name = "penerima")
@NamedQueries({
    @NamedQuery(name = "Penerima.findAll", query = "SELECT p FROM Penerima p")})
public class Penerima implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "IDPENERIMA", nullable = false)
    private Long idpenerima;

    
    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idpenerima != null ? idpenerima.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Penerima)) {
            return false;
        }
        Penerima other = (Penerima) object;
        if ((this.idpenerima == null && other.idpenerima != null) || (this.idpenerima != null && !this.idpenerima.equals(other.idpenerima))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.Penerima[id=" + idpenerima + "]";
    }

}
