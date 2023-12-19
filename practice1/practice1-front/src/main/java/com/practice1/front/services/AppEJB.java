/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.practice1.front.services;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.practice1.front.services.interfaces.AppServices;
import jakarta.ejb.Singleton;
import jakarta.enterprise.context.ApplicationScoped;
import java.net.URI;
import java.util.List;
import java.util.Arrays;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

/**
 *
 * @author miguel
 */
@Singleton
@ApplicationScoped
public class AppEJB implements AppServices {

    private Gson gson;
    private GsonBuilder builder;

    public AppEJB() {
        builder = new GsonBuilder();
        gson = builder.create();
    }

    @Override
    public Object methodGET(String url, Class clazz) {
        try {

            RestTemplate restTemplate = new RestTemplate();
            HttpHeaders headers = new HttpHeaders();
            headers.setContentType(MediaType.APPLICATION_JSON);
            URI uri = new URI(url);
            HttpEntity<String> entity = new HttpEntity<>(headers);
            ResponseEntity<Object> response = restTemplate.exchange(uri,
                    HttpMethod.GET, entity, clazz);
            if (response != null) {
                return response.getBody();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List methodListGET(String url, Class clazz) {
        try {

            RestTemplate restTemplate = new RestTemplate();
            HttpHeaders headers = new HttpHeaders();
            headers.setContentType(MediaType.APPLICATION_JSON);
            URI uri = new URI(url);
            HttpEntity<String> entity = new HttpEntity<>(headers);
            ResponseEntity<Object[]> response = restTemplate.exchange(uri,
                    HttpMethod.GET, entity, clazz);
            if (response != null) {
                return Arrays.asList(response.getBody());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public Object methodPOST(Object data, String url, Class clazz) {
        try {
            RestTemplate restTemplate = new RestTemplate();
            HttpHeaders headers = new HttpHeaders();
            headers.setContentType(MediaType.APPLICATION_JSON);
            URI uri = new URI(url);
            HttpEntity<Object> entity = new HttpEntity<>(data, headers);
            ResponseEntity<Object> response = restTemplate.exchange(uri, HttpMethod.POST, entity, clazz);
            if (response != null) {
                return response.getBody();
            }
            return null;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List methodListPOST(Object data, String url, Class clazz) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

}
