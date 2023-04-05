package com.mtorresvalls.practica3pat.controller;


import java.util.ArrayList;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mtorresvalls.practica3pat.service.Form;

@RestController
public class FormController {

    private ArrayList<Form> forms = new ArrayList<>(); 

    @GetMapping("/getForms")
    public ResponseEntity<ArrayList<Form>> getForm(){
        System.out.println(forms);
        
        return new ResponseEntity<>(forms, HttpStatus.OK);
    }
    
    @PostMapping("/addNewForm")
    public ResponseEntity<String> addForm(@ModelAttribute Form form){
        form.setId(forms.size());
        String response = "<a href='inbox.html'>Volver</a>";

        if (form.getName() != null && form.getEmail() != null && form.getMessage() != null){
            forms.add(form); 

            System.out.println(form);
        
            return new ResponseEntity<>(response, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
        }
        
    }
}
