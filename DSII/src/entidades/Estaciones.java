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
@Table(name = "estaciones")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Estaciones.findAll", query = "SELECT e FROM Estaciones e"),
    @NamedQuery(name = "Estaciones.findByNombre", query = "SELECT e FROM Estaciones e WHERE e.nombre = :nombre"),
    @NamedQuery(name = "Estaciones.findByUbicacion", query = "SELECT e FROM Estaciones e WHERE e.ubicacion = :ubicacion"),
    @NamedQuery(name = "Estaciones.findByDirector", query = "SELECT e FROM Estaciones e WHERE e.director = :director")})
public class Estaciones implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "nombre")
    private String nombre;
    @Column(name = "ubicacion")
    private String ubicacion;
    @Column(name = "director")
    private String director;

    public Estaciones() {
    }

    public Estaciones(String nombre) {
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getUbicacion() {
        return ubicacion;
    }

    public void setUbicacion(String ubicacion) {
        this.ubicacion = ubicacion;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (nombre != null ? nombre.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Estaciones)) {
            return false;
        }
        Estaciones other = (Estaciones) object;
        if ((this.nombre == null && other.nombre != null) || (this.nombre != null && !this.nombre.equals(other.nombre))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entidades.Estaciones[ nombre=" + nombre + " ]";
    }
    
}
