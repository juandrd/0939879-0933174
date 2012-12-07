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
@Table(name = "tarjetas_genericas")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TarjetasGenericas.findAll", query = "SELECT t FROM TarjetasGenericas t"),
    @NamedQuery(name = "TarjetasGenericas.findByPinTarjeta", query = "SELECT t FROM TarjetasGenericas t WHERE t.pinTarjeta = :pinTarjeta"),
    @NamedQuery(name = "TarjetasGenericas.findByNroPasajes", query = "SELECT t FROM TarjetasGenericas t WHERE t.nroPasajes = :nroPasajes"),
    @NamedQuery(name = "TarjetasGenericas.findByEstado", query = "SELECT t FROM TarjetasGenericas t WHERE t.estado = :estado")})
public class TarjetasGenericas implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "pin_tarjeta")
    private String pinTarjeta;
    @Column(name = "nro_pasajes")
    private Integer nroPasajes;
    @Column(name = "estado")
    private String estado;

    public TarjetasGenericas() {
    }

    public TarjetasGenericas(String pinTarjeta) {
        this.pinTarjeta = pinTarjeta;
    }

    public String getPinTarjeta() {
        return pinTarjeta;
    }

    public void setPinTarjeta(String pinTarjeta) {
        this.pinTarjeta = pinTarjeta;
    }

    public Integer getNroPasajes() {
        return nroPasajes;
    }

    public void setNroPasajes(Integer nroPasajes) {
        this.nroPasajes = nroPasajes;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (pinTarjeta != null ? pinTarjeta.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TarjetasGenericas)) {
            return false;
        }
        TarjetasGenericas other = (TarjetasGenericas) object;
        if ((this.pinTarjeta == null && other.pinTarjeta != null) || (this.pinTarjeta != null && !this.pinTarjeta.equals(other.pinTarjeta))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entidades.TarjetasGenericas[ pinTarjeta=" + pinTarjeta + " ]";
    }
    
}
