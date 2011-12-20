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
@Table(name = "penerima", catalog = "Smash", schema = "")
@NamedQueries({
    @NamedQuery(name = "Penerima.findAll", query = "SELECT p FROM Penerima p"),
    @NamedQuery(name = "Penerima.findById", query = "SELECT p FROM Penerima p WHERE p.id = :id")})
public class Penerima implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "ID", nullable = false)
    private Long id;

    public Penerima() {
    }

    public Penerima(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Penerima)) {
            return false;
        }
        Penerima other = (Penerima) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.Penerima[id=" + id + "]";
    }

}
