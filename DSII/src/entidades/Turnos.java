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
@Table(name = "turnos")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Turnos.findAll", query = "SELECT t FROM Turnos t"),
    @NamedQuery(name = "Turnos.findByConductor", query = "SELECT t FROM Turnos t WHERE t.turnosPK.conductor = :conductor"),
    @NamedQuery(name = "Turnos.findByBus", query = "SELECT t FROM Turnos t WHERE t.turnosPK.bus = :bus"),
    @NamedQuery(name = "Turnos.findByHoraInicio", query = "SELECT t FROM Turnos t WHERE t.turnosPK.horaInicio = :horaInicio"),
    @NamedQuery(name = "Turnos.findByHoraFin", query = "SELECT t FROM Turnos t WHERE t.horaFin = :horaFin")})
public class Turnos implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected TurnosPK turnosPK;
    @Column(name = "hora_fin")
    @Temporal(TemporalType.TIME)
    private Date horaFin;

    public Turnos() {
    }

    public Turnos(TurnosPK turnosPK) {
        this.turnosPK = turnosPK;
    }

    public Turnos(String conductor, String bus, Date horaInicio) {
        this.turnosPK = new TurnosPK(conductor, bus, horaInicio);
    }

    public TurnosPK getTurnosPK() {
        return turnosPK;
    }

    public void setTurnosPK(TurnosPK turnosPK) {
        this.turnosPK = turnosPK;
    }

    public Date getHoraFin() {
        return horaFin;
    }

    public void setHoraFin(Date horaFin) {
        this.horaFin = horaFin;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (turnosPK != null ? turnosPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Turnos)) {
            return false;
        }
        Turnos other = (Turnos) object;
        if ((this.turnosPK == null && other.turnosPK != null) || (this.turnosPK != null && !this.turnosPK.equals(other.turnosPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entidades.Turnos[ turnosPK=" + turnosPK + " ]";
    }
    
}
