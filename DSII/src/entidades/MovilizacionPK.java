/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package entidades;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;

/**
 *
 * @author chokuno
 */
@Embeddable
public class MovilizacionPK implements Serializable {
    @Basic(optional = false)
    @Column(name = "pasajero")
    private String pasajero;
    @Basic(optional = false)
    @Column(name = "ruta")
    private String ruta;
    @Basic(optional = false)
    @Column(name = "fecha")
    @Temporal(TemporalType.DATE)
    private Date fecha;

    public MovilizacionPK() {
    }

    public MovilizacionPK(String pasajero, String ruta, Date fecha) {
        this.pasajero = pasajero;
        this.ruta = ruta;
        this.fecha = fecha;
    }

    public String getPasajero() {
        return pasajero;
    }

    public void setPasajero(String pasajero) {
        this.pasajero = pasajero;
    }

    public String getRuta() {
        return ruta;
    }

    public void setRuta(String ruta) {
        this.ruta = ruta;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (pasajero != null ? pasajero.hashCode() : 0);
        hash += (ruta != null ? ruta.hashCode() : 0);
        hash += (fecha != null ? fecha.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof MovilizacionPK)) {
            return false;
        }
        MovilizacionPK other = (MovilizacionPK) object;
        if ((this.pasajero == null && other.pasajero != null) || (this.pasajero != null && !this.pasajero.equals(other.pasajero))) {
            return false;
        }
        if ((this.ruta == null && other.ruta != null) || (this.ruta != null && !this.ruta.equals(other.ruta))) {
            return false;
        }
        if ((this.fecha == null && other.fecha != null) || (this.fecha != null && !this.fecha.equals(other.fecha))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidades.MovilizacionPK[ pasajero=" + pasajero + ", ruta=" + ruta + ", fecha=" + fecha + " ]";
    }
    
}
