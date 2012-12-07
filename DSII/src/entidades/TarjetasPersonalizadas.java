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
@Table(name = "tarjetas_personalizadas")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TarjetasPersonalizadas.findAll", query = "SELECT t FROM TarjetasPersonalizadas t"),
    @NamedQuery(name = "TarjetasPersonalizadas.findByPinTarjeta", query = "SELECT t FROM TarjetasPersonalizadas t WHERE t.pinTarjeta = :pinTarjeta"),
    @NamedQuery(name = "TarjetasPersonalizadas.findByNroPasajes", query = "SELECT t FROM TarjetasPersonalizadas t WHERE t.nroPasajes = :nroPasajes"),
    @NamedQuery(name = "TarjetasPersonalizadas.findByEstado", query = "SELECT t FROM TarjetasPersonalizadas t WHERE t.estado = :estado"),
    @NamedQuery(name = "TarjetasPersonalizadas.findByAdelantoDisponible", query = "SELECT t FROM TarjetasPersonalizadas t WHERE t.adelantoDisponible = :adelantoDisponible")})
public class TarjetasPersonalizadas implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "pin_tarjeta")
    private String pinTarjeta;
    @Column(name = "nro_pasajes")
    private Integer nroPasajes;
    @Column(name = "estado")
    private String estado;
    @Column(name = "adelanto_disponible")
    private Integer adelantoDisponible;

    public TarjetasPersonalizadas() {
    }

    public TarjetasPersonalizadas(String pinTarjeta) {
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

    public Integer getAdelantoDisponible() {
        return adelantoDisponible;
    }

    public void setAdelantoDisponible(Integer adelantoDisponible) {
        this.adelantoDisponible = adelantoDisponible;
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
        if (!(object instanceof TarjetasPersonalizadas)) {
            return false;
        }
        TarjetasPersonalizadas other = (TarjetasPersonalizadas) object;
        if ((this.pinTarjeta == null && other.pinTarjeta != null) || (this.pinTarjeta != null && !this.pinTarjeta.equals(other.pinTarjeta))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entidades.TarjetasPersonalizadas[ pinTarjeta=" + pinTarjeta + " ]";
    }
    
}
