package com.staffan.controllers;

import java.net.URI;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.io.File;

import java.util.Properties;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.ResourceUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.util.UriComponentsBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;

// https://stackoverflow.com/questions/74658603/restcontroller-method-returned-content-type-application-javascript-in-spring-4
// https://docs.spring.io/spring-framework/docs/current/javadoc-api/org/springframework/http/ResponseEntity.html

@Controller
public class Js {
    @Autowired
    private ResourceLoader resourceLoader;

    @RequestMapping(value = "/assets/index.js", method = RequestMethod.GET)
    public ResponseEntity <Resource> index(Model model) {
        Resource resource = resourceLoader.getResource("classpath:" + "/templates/assets/index.js");
        HttpHeaders responseHeaders = new HttpHeaders();
        responseHeaders.add(HttpHeaders.CONTENT_TYPE, "application/javascript");
        return new ResponseEntity<Resource>(resource, responseHeaders, HttpStatus.OK);
    }
}