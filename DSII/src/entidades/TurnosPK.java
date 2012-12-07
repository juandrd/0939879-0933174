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
public class TurnosPK implements Serializable {
    @Basic(optional = false)
    @Column(name = "conductor")
    private String conductor;
    @Basic(optional = false)
    @Column(name = "bus")
    private String bus;
    @Basic(optional = false)
    @Column(name = "hora_inicio")
    @Temporal(TemporalType.TIME)
    private Date horaInicio;

    public TurnosPK() {
    }

    public TurnosPK(String conductor, String bus, Date horaInicio) {
        this.conductor = conductor;
        this.bus = bus;
        this.horaInicio = horaInicio;
    }

    public String getConductor() {
        return conductor;
    }

    public void setConductor(String conductor) {
        this.conductor = conductor;
    }

    public String getBus() {
        return bus;
    }

    public void setBus(String bus) {
        this.bus = bus;
    }

    public Date getHoraInicio() {
        return horaInicio;
    }

    public void setHoraInicio(Date horaInicio) {
        this.horaInicio = horaInicio;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (conductor != null ? conductor.hashCode() : 0);
        hash += (bus != null ? bus.hashCode() : 0);
        hash += (horaInicio != null ? horaInicio.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TurnosPK)) {
            return false;
        }
        TurnosPK other = (TurnosPK) object;
        if ((this.conductor == null && other.conductor != null) || (this.conductor != null && !this.conductor.equals(other.conductor))) {
            return false;
        }
        if ((this.bus == null && other.bus != null) || (this.bus != null && !this.bus.equals(other.bus))) {
            return false;
        }
        if ((this.horaInicio == null && other.horaInicio != null) || (this.horaInicio != null && !this.horaInicio.equals(other.horaInicio))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entidades.TurnosPK[ conductor=" + conductor + ", bus=" + bus + ", horaInicio=" + horaInicio + " ]";
    }
    
}
