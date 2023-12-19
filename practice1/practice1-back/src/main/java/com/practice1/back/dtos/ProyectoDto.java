package com.practice1.back.dtos;

import java.util.Date;

public class ProyectoDto {
    private Integer id;

    private String tipo;

    private boolean recurrente;

    private boolean arrastre;

    private String donominacion;

    private String detalleArrastre;

    private Date fechaInicio;

    private Date fechaFin;

    private float costoProyecto;

    private String objetivo;

    private String descripcionBreve;

    private Date fechaCreacion;

    private Date fechaModificacion;

    private String estado;

    private String creadoPor;

    private String modificadoPor;

    private ProcesoDto proceso;

    private AreaDto area;

    private PersonaDto responsable;

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

    public boolean getArrastre() {
        return arrastre;
    }

    public void setArrastre(boolean arrastre) {
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

    public float getCostoProyecto() {
        return costoProyecto;
    }

    public void setCostoProyecto(float costoProyecto) {
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

    public PersonaDto getResponsable() {
        return responsable;
    }

    public void setResponsable(PersonaDto responsable) {
        this.responsable = responsable;
    }

    public ProyectoDto() {
    }

    public ProcesoDto getProceso() {
        return proceso;
    }

    public void setProceso(ProcesoDto proceso) {
        this.proceso = proceso;
    }

    public AreaDto getArea() {
        return area;
    }

    public void setArea(AreaDto area) {
        this.area = area;
    }

}
