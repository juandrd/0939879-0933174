/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package entidades;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 *
 * @author chokuno
 */
@Embeddable
public class PasajerosPersonalizadasPK implements Serializable {
    @Basic(optional = false)
    @Column(name = "identificacion")
    private String identificacion;
    @Basic(optional = false)
    @Column(name = "pin_tarjeta")
    private String pinTarjeta;

    public PasajerosPersonalizadasPK() {
    }

    public PasajerosPersonalizadasPK(String identificacion, String pinTarjeta) {
        this.identificacion = identificacion;
        this.pinTarjeta = pinTarjeta;
    }

    public String getIdentificacion() {
        return identificacion;
    }

    public void setIdentificacion(String identificacion) {
        this.identificacion = identificacion;
    }

    public String getPinTarjeta() {
        return pinTarjeta;
    }

    public void setPinTarjeta(String pinTarjeta) {
        this.pinTarjeta = pinTarjeta;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (identificacion != null ? identificacion.hashCode() : 0);
        hash += (pinTarjeta != null ? pinTarjeta.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PasajerosPersonalizadasPK)) {
            return false;
        }
        PasajerosPersonalizadasPK other = (PasajerosPersonalizadasPK) object;
        if ((this.identificacion == null && other.identificacion != null) || (this.identificacion != null && !this.identificacion.equals(other.identificacion))) {
            return false;
        }
        if ((this.pinTarjeta == null && other.pinTarjeta != null) || (this.pinTarjeta != null && !this.pinTarjeta.equals(other.pinTarjeta))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entidades.PasajerosPersonalizadasPK[ identificacion=" + identificacion + ", pinTarjeta=" + pinTarjeta + " ]";
    }
    
}
