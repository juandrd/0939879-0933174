/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package entidades;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author chokuno
 */
@Entity
@Table(name = "movilizacion")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Movilizacion.findAll", query = "SELECT m FROM Movilizacion m"),
    @NamedQuery(name = "Movilizacion.findByPasajero", query = "SELECT m FROM Movilizacion m WHERE m.movilizacionPK.pasajero = :pasajero"),
    @NamedQuery(name = "Movilizacion.findByRuta", query = "SELECT m FROM Movilizacion m WHERE m.movilizacionPK.ruta = :ruta"),
    @NamedQuery(name = "Movilizacion.findByFecha", query = "SELECT m FROM Movilizacion m WHERE m.movilizacionPK.fecha = :fecha")})
public class Movilizacion implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected MovilizacionPK movilizacionPK;

    public Movilizacion() {
    }

    public Movilizacion(MovilizacionPK movilizacionPK) {
        this.movilizacionPK = movilizacionPK;
    }

    public Movilizacion(String pasajero, String ruta, Date fecha) {
        this.movilizacionPK = new MovilizacionPK(pasajero, ruta, fecha);
    }

    public MovilizacionPK getMovilizacionPK() {
        return movilizacionPK;
    }

    public void setMovilizacionPK(MovilizacionPK movilizacionPK) {
        this.movilizacionPK = movilizacionPK;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (movilizacionPK != null ? movilizacionPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Movilizacion)) {
            return false;
        }
        Movilizacion other = (Movilizacion) object;
        if ((this.movilizacionPK == null && other.movilizacionPK != null) || (this.movilizacionPK != null && !this.movilizacionPK.equals(other.movilizacionPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidades.Movilizacion[ movilizacionPK=" + movilizacionPK + " ]";
    }
    
}
