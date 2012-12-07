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
@Table(name = "pasajeros_personalizadas")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "PasajerosPersonalizadas.findAll", query = "SELECT p FROM PasajerosPersonalizadas p"),
    @NamedQuery(name = "PasajerosPersonalizadas.findByIdentificacion", query = "SELECT p FROM PasajerosPersonalizadas p WHERE p.pasajerosPersonalizadasPK.identificacion = :identificacion"),
    @NamedQuery(name = "PasajerosPersonalizadas.findByPinTarjeta", query = "SELECT p FROM PasajerosPersonalizadas p WHERE p.pasajerosPersonalizadasPK.pinTarjeta = :pinTarjeta")})
public class PasajerosPersonalizadas implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected PasajerosPersonalizadasPK pasajerosPersonalizadasPK;

    public PasajerosPersonalizadas() {
    }

    public PasajerosPersonalizadas(PasajerosPersonalizadasPK pasajerosPersonalizadasPK) {
        this.pasajerosPersonalizadasPK = pasajerosPersonalizadasPK;
    }

    public PasajerosPersonalizadas(String identificacion, String pinTarjeta) {
        this.pasajerosPersonalizadasPK = new PasajerosPersonalizadasPK(identificacion, pinTarjeta);
    }

    public PasajerosPersonalizadasPK getPasajerosPersonalizadasPK() {
        return pasajerosPersonalizadasPK;
    }

    public void setPasajerosPersonalizadasPK(PasajerosPersonalizadasPK pasajerosPersonalizadasPK) {
        this.pasajerosPersonalizadasPK = pasajerosPersonalizadasPK;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (pasajerosPersonalizadasPK != null ? pasajerosPersonalizadasPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PasajerosPersonalizadas)) {
            return false;
        }
        PasajerosPersonalizadas other = (PasajerosPersonalizadas) object;
        if ((this.pasajerosPersonalizadasPK == null && other.pasajerosPersonalizadasPK != null) || (this.pasajerosPersonalizadasPK != null && !this.pasajerosPersonalizadasPK.equals(other.pasajerosPersonalizadasPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entidades.PasajerosPersonalizadas[ pasajerosPersonalizadasPK=" + pasajerosPersonalizadasPK + " ]";
    }
    
}
