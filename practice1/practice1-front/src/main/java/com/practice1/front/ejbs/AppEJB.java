/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.practice1.front.ejbs;

import jakarta.ejb.Singleton;
import jakarta.enterprise.context.ApplicationScoped;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.Arrays;
import java.util.List;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;
import com.practice1.front.interfaces.AppServices;
import jakarta.ejb.LocalBean;

/**
 *
 * @author miguel
 */
@Singleton
@ApplicationScoped
@LocalBean
public class AppEJB implements AppServices {

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
        } catch (URISyntaxException | RestClientException e) {
            System.err.println(e.getMessage());
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
        } catch (URISyntaxException | RestClientException e) {
            System.err.println(e.getMessage());

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
        } catch (URISyntaxException | RestClientException e) {
            System.err.println(e.getMessage());
        }
        return null;
    }
    
    @Override
    public Object methodPUT(Object data, String url, Class clazz) {
        System.out.println("com.practice1.front.ejbs.AppEJB.methodPUT()" + url);
        try {
            RestTemplate restTemplate = new RestTemplate();
            HttpHeaders headers = new HttpHeaders();
            headers.setContentType(MediaType.APPLICATION_JSON);
            URI uri = new URI(url);
            HttpEntity<Object> entity = new HttpEntity<>(data, headers);
            ResponseEntity<Object> response = restTemplate.exchange(uri, HttpMethod.PUT, entity, clazz);
            if (response != null) {
                return response.getBody();
            }
            return null;
        } catch (URISyntaxException | RestClientException e) {
            e.printStackTrace();
            System.err.println(e.getMessage());
        }
        return null;
    }
    
    @Override
    public Object methodDELETE(String url, Class clazz) {
        System.out.println("com.practice1.front.ejbs.AppEJB.methodDELETE()" + url);
        try {
            RestTemplate restTemplate = new RestTemplate();
            HttpHeaders headers = new HttpHeaders();
            headers.setContentType(MediaType.APPLICATION_JSON);
            URI uri = new URI(url);
            HttpEntity<Object> entity = new HttpEntity<>( headers);
            ResponseEntity<Object> response = restTemplate.exchange(uri, HttpMethod.DELETE, entity, clazz);
            if (response != null) {
                return response.getBody();
            }
            return null;
        } catch (URISyntaxException | RestClientException e) {
            e.printStackTrace();
            System.err.println(e.getMessage());
        }
        return null;
    }

    @Override
    public List methodListPOST(Object data, String url, Class clazz) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

}
