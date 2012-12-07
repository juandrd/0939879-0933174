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
@Table(name = "pasajeros")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Pasajeros.findAll", query = "SELECT p FROM Pasajeros p"),
    @NamedQuery(name = "Pasajeros.findByIdentificacion", query = "SELECT p FROM Pasajeros p WHERE p.identificacion = :identificacion"),
    @NamedQuery(name = "Pasajeros.findByNombres", query = "SELECT p FROM Pasajeros p WHERE p.nombres = :nombres"),
    @NamedQuery(name = "Pasajeros.findByApellidos", query = "SELECT p FROM Pasajeros p WHERE p.apellidos = :apellidos"),
    @NamedQuery(name = "Pasajeros.findByTelefono", query = "SELECT p FROM Pasajeros p WHERE p.telefono = :telefono"),
    @NamedQuery(name = "Pasajeros.findByDireccion", query = "SELECT p FROM Pasajeros p WHERE p.direccion = :direccion"),
    @NamedQuery(name = "Pasajeros.findByGenero", query = "SELECT p FROM Pasajeros p WHERE p.genero = :genero"),
    @NamedQuery(name = "Pasajeros.findByEmail", query = "SELECT p FROM Pasajeros p WHERE p.email = :email")})
public class Pasajeros implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "identificacion")
    private String identificacion;
    @Column(name = "nombres")
    private String nombres;
    @Column(name = "apellidos")
    private String apellidos;
    @Column(name = "telefono")
    private String telefono;
    @Column(name = "direccion")
    private String direccion;
    @Column(name = "genero")
    private String genero;
    @Column(name = "email")
    private String email;

    public Pasajeros() {
    }

    public Pasajeros(String identificacion) {
        this.identificacion = identificacion;
    }

    public String getIdentificacion() {
        return identificacion;
    }

    public void setIdentificacion(String identificacion) {
        this.identificacion = identificacion;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
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
        if (!(object instanceof Pasajeros)) {
            return false;
        }
        Pasajeros other = (Pasajeros) object;
        if ((this.identificacion == null && other.identificacion != null) || (this.identificacion != null && !this.identificacion.equals(other.identificacion))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entidades.Pasajeros[ identificacion=" + identificacion + " ]";
    }
    
}
