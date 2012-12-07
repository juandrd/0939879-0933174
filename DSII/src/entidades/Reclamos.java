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
@Table(name = "reclamos")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Reclamos.findAll", query = "SELECT r FROM Reclamos r"),
    @NamedQuery(name = "Reclamos.findByCodigo", query = "SELECT r FROM Reclamos r WHERE r.codigo = :codigo"),
    @NamedQuery(name = "Reclamos.findByDescripcion", query = "SELECT r FROM Reclamos r WHERE r.descripcion = :descripcion"),
    @NamedQuery(name = "Reclamos.findByEstacion", query = "SELECT r FROM Reclamos r WHERE r.estacion = :estacion"),
    @NamedQuery(name = "Reclamos.findByPasajero", query = "SELECT r FROM Reclamos r WHERE r.pasajero = :pasajero")})
public class Reclamos implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "codigo")
    private String codigo;
    @Column(name = "descripcion")
    private String descripcion;
    @Column(name = "estacion")
    private String estacion;
    @Column(name = "pasajero")
    private String pasajero;

    public Reclamos() {
    }

    public Reclamos(String codigo) {
        this.codigo = codigo;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getEstacion() {
        return estacion;
    }

    public void setEstacion(String estacion) {
        this.estacion = estacion;
    }

    public String getPasajero() {
        return pasajero;
    }

    public void setPasajero(String pasajero) {
        this.pasajero = pasajero;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codigo != null ? codigo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Reclamos)) {
            return false;
        }
        Reclamos other = (Reclamos) object;
        if ((this.codigo == null && other.codigo != null) || (this.codigo != null && !this.codigo.equals(other.codigo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entidades.Reclamos[ codigo=" + codigo + " ]";
    }
    
}
