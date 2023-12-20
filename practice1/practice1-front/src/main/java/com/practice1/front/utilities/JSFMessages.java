/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.practice1.front.utilities;

import jakarta.faces.application.FacesMessage;
import jakarta.faces.context.FacesContext;

/**
 *
 * @author miguel
 */
public class JSFMessages {

    public static void crearMensaje(FacesMessage.Severity severidad, String mensaje, String detalle) {
        FacesMessage msg = new FacesMessage();
        msg.setSeverity(severidad);
        msg.setSummary(mensaje);
        msg.setDetail(detalle);
        FacesContext.getCurrentInstance().addMessage(null, msg);
    }

    public static void ERROR(String mensaje) {
        crearMensaje(FacesMessage.SEVERITY_ERROR, mensaje, null);
    }

    public static void WARN(String mensaje) {
        crearMensaje(FacesMessage.SEVERITY_WARN, mensaje, null);
    }

    public static void INFO(String mensaje) {
        crearMensaje(FacesMessage.SEVERITY_INFO, mensaje, null);
    }
}
