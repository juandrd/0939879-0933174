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
@Table(name = "buses")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Buses.findAll", query = "SELECT b FROM Buses b"),
    @NamedQuery(name = "Buses.findByPlaca", query = "SELECT b FROM Buses b WHERE b.placa = :placa"),
    @NamedQuery(name = "Buses.findByMarca", query = "SELECT b FROM Buses b WHERE b.marca = :marca"),
    @NamedQuery(name = "Buses.findByNroChasis", query = "SELECT b FROM Buses b WHERE b.nroChasis = :nroChasis"),
    @NamedQuery(name = "Buses.findByTipo", query = "SELECT b FROM Buses b WHERE b.tipo = :tipo"),
    @NamedQuery(name = "Buses.findByNroAsientos", query = "SELECT b FROM Buses b WHERE b.nroAsientos = :nroAsientos"),
    @NamedQuery(name = "Buses.findByCapacidad", query = "SELECT b FROM Buses b WHERE b.capacidad = :capacidad"),
    @NamedQuery(name = "Buses.findByRuta", query = "SELECT b FROM Buses b WHERE b.ruta = :ruta")})
public class Buses implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "placa")
    private String placa;
    @Column(name = "marca")
    private String marca;
    @Column(name = "nro_chasis")
    private String nroChasis;
    @Column(name = "tipo")
    private String tipo;
    @Column(name = "nro_asientos")
    private Integer nroAsientos;
    @Column(name = "capacidad")
    private Integer capacidad;
    @Column(name = "ruta")
    private String ruta;

    public Buses() {
    }

    public Buses(String placa) {
        this.placa = placa;
    }

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getNroChasis() {
        return nroChasis;
    }

    public void setNroChasis(String nroChasis) {
        this.nroChasis = nroChasis;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public Integer getNroAsientos() {
        return nroAsientos;
    }

    public void setNroAsientos(Integer nroAsientos) {
        this.nroAsientos = nroAsientos;
    }

    public Integer getCapacidad() {
        return capacidad;
    }

    public void setCapacidad(Integer capacidad) {
        this.capacidad = capacidad;
    }

    public String getRuta() {
        return ruta;
    }

    public void setRuta(String ruta) {
        this.ruta = ruta;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (placa != null ? placa.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Buses)) {
            return false;
        }
        Buses other = (Buses) object;
        if ((this.placa == null && other.placa != null) || (this.placa != null && !this.placa.equals(other.placa))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entidades.Buses[ placa=" + placa + " ]";
    }
    
}
