/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package entidades;

import java.io.Serializable;
import javax.persistence.*;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author chokuno
 */
@Entity
@Table(name = "directores_estacion")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "DirectoresEstacion.findAll", query = "SELECT d FROM DirectoresEstacion d"),
    @NamedQuery(name = "DirectoresEstacion.findByIdentificacion", query = "SELECT d FROM DirectoresEstacion d WHERE d.identificacion = :identificacion")})
public class DirectoresEstacion implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "identificacion")
    private String identificacion;

    public DirectoresEstacion() {
    }

    public DirectoresEstacion(String identificacion) {
        this.identificacion = identificacion;
    }

    public String getIdentificacion() {
        return identificacion;
    }

    public void setIdentificacion(String identificacion) {
        this.identificacion = identificacion;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (identificacion != null ? identificacion.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof DirectoresEstacion)) {
            return false;
        }
        DirectoresEstacion other = (DirectoresEstacion) object;
        if ((this.identificacion == null && other.identificacion != null) || (this.identificacion != null && !this.identificacion.equals(other.identificacion))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entidades.DirectoresEstacion[ identificacion=" + identificacion + " ]";
    }
    
}
