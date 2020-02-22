/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelos;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author efrai
 */
@Entity
@Table(name = "asignacion_curso")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "AsignacionCurso.findAll", query = "SELECT a FROM AsignacionCurso a")
    , @NamedQuery(name = "AsignacionCurso.findByIdasignacionCurso", query = "SELECT a FROM AsignacionCurso a WHERE a.idasignacionCurso = :idasignacionCurso")})
public class AsignacionCurso implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idasignacion_curso")
    private Integer idasignacionCurso;
    @JoinColumn(name = "inscripcion_idinscripcion", referencedColumnName = "idinscripcion")
    @ManyToOne(optional = false)
    private Inscripcion inscripcionIdinscripcion;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "asignacionCursoIdasignacionCurso")
    private Collection<Curso> cursoCollection;

    public AsignacionCurso() {
    }

    public AsignacionCurso(Integer idasignacionCurso) {
        this.idasignacionCurso = idasignacionCurso;
    }

    public Integer getIdasignacionCurso() {
        return idasignacionCurso;
    }

    public void setIdasignacionCurso(Integer idasignacionCurso) {
        this.idasignacionCurso = idasignacionCurso;
    }

    public Inscripcion getInscripcionIdinscripcion() {
        return inscripcionIdinscripcion;
    }

    public void setInscripcionIdinscripcion(Inscripcion inscripcionIdinscripcion) {
        this.inscripcionIdinscripcion = inscripcionIdinscripcion;
    }

    @XmlTransient
    public Collection<Curso> getCursoCollection() {
        return cursoCollection;
    }

    public void setCursoCollection(Collection<Curso> cursoCollection) {
        this.cursoCollection = cursoCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idasignacionCurso != null ? idasignacionCurso.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof AsignacionCurso)) {
            return false;
        }
        AsignacionCurso other = (AsignacionCurso) object;
        if ((this.idasignacionCurso == null && other.idasignacionCurso != null) || (this.idasignacionCurso != null && !this.idasignacionCurso.equals(other.idasignacionCurso))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Modelos.AsignacionCurso[ idasignacionCurso=" + idasignacionCurso + " ]";
    }
    
}
