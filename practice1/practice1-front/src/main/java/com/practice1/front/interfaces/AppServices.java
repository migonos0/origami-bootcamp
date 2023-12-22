/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.practice1.front.interfaces;

import jakarta.ejb.Local;
import java.util.List;

/**
 *
 * @author miguel
 */
@Local
public interface AppServices {

    public Object methodGET(String url, Class clazz);

    public List methodListGET(String url, Class clazz);

    public Object methodPOST(Object data, String url, Class clazz);

    public Object methodPUT(Object data, String url, Class clazz);

    public Object methodDELETE(String url, Class clazz);

    public List methodListPOST(Object data, String url, Class clazz);
}
