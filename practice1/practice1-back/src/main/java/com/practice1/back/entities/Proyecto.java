package com.practice1.back.entities;

import java.math.BigDecimal;
import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "proyecto", schema = "proyectos")
public class Proyecto {
    @Id
    @Column
    private Integer id;

    @Column
    private String tipo;

    @Column
    private boolean recurrente;

    @Column
    private String arrastre;

    @Column(name = "denominacion")
    private String donominacion;

    @Column(name = "detalle_arrastre")
    private String detalleArrastre;

    @Column(name = "fecha_inicio")
    private Date fechaInicio;

    @Column(name = "fecha_fin")
    private Date fechaFin;

    @Column(name = "costo_proyecto")
    private BigDecimal costoProyecto;

    @Column
    private String objetivo;

    @Column(name = "descripcion_breve")
    private String descripcionBreve;

    @Column(name = "fecha_creacion")
    private Date fechaCreacion;

    @Column(name = "fecha_modificacion")
    private Date fechaModificacion;

    @Column
    private String estado;

    @Column(name = "creado_por")
    private String creadoPor;

    @Column(name = "modificado_por")
    private String modificadoPor;

    @ManyToOne
    @JoinColumn(name = "proceso")
    private Proceso proceso;

    @ManyToOne
    @JoinColumn(name = "area")
    private Area area;

    @ManyToOne
    @JoinColumn(name = "responsable")
    private Persona responsable;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public boolean isRecurrente() {
        return recurrente;
    }

    public void setRecurrente(boolean recurrente) {
        this.recurrente = recurrente;
    }

    public String getArrastre() {
        return arrastre;
    }

    public void setArrastre(String arrastre) {
        this.arrastre = arrastre;
    }

    public String getDonominacion() {
        return donominacion;
    }

    public void setDonominacion(String donominacion) {
        this.donominacion = donominacion;
    }

    public String getDetalleArrastre() {
        return detalleArrastre;
    }

    public void setDetalleArrastre(String detalleArrastre) {
        this.detalleArrastre = detalleArrastre;
    }

    public Date getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(Date fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public Date getFechaFin() {
        return fechaFin;
    }

    public void setFechaFin(Date fechaFin) {
        this.fechaFin = fechaFin;
    }

    public BigDecimal getCostoProyecto() {
        return costoProyecto;
    }

    public void setCostoProyecto(BigDecimal costoProyecto) {
        this.costoProyecto = costoProyecto;
    }

    public String getObjetivo() {
        return objetivo;
    }

    public void setObjetivo(String objetivo) {
        this.objetivo = objetivo;
    }

    public String getDescripcionBreve() {
        return descripcionBreve;
    }

    public void setDescripcionBreve(String descripcionBreve) {
        this.descripcionBreve = descripcionBreve;
    }

    public Date getFechaCreacion() {
        return fechaCreacion;
    }

    public void setFechaCreacion(Date fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }

    public Date getFechaModificacion() {
        return fechaModificacion;
    }

    public void setFechaModificacion(Date fechaModificacion) {
        this.fechaModificacion = fechaModificacion;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getCreadoPor() {
        return creadoPor;
    }

    public void setCreadoPor(String creadoPor) {
        this.creadoPor = creadoPor;
    }

    public String getModificadoPor() {
        return modificadoPor;
    }

    public void setModificadoPor(String modificadoPor) {
        this.modificadoPor = modificadoPor;
    }

    public Proceso getProceso() {
        return proceso;
    }

    public void setProceso(Proceso proceso) {
        this.proceso = proceso;
    }

    public Area getArea() {
        return area;
    }

    public void setArea(Area area) {
        this.area = area;
    }

    public Persona getResponsable() {
        return responsable;
    }

    public void setResponsable(Persona responsable) {
        this.responsable = responsable;
    }

    public Proyecto() {
    }

}
