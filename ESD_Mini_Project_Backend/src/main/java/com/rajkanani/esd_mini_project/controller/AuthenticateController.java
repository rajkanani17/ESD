package com.rajkanani.esd_mini_project.controller;

import com.rajkanani.esd_mini_project.dto.LoginRequest;
import com.rajkanani.esd_mini_project.model.Employees;
import com.rajkanani.esd_mini_project.service.EmployeesService;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.naming.AuthenticationException;

@RestController
@CrossOrigin("http://localhost:5173")
@RequestMapping("/api/home")
public class AuthenticateController {

    @Autowired
    private EmployeesService employeesService;

    @PostMapping("/authenticate")
    public ResponseEntity<Employees> authenticate(@RequestBody LoginRequest loginRequest) throws Exception{
//        System.out.println("Login ......");
        try{
            Employees employee = employeesService.authenticate(loginRequest);
            return ResponseEntity.status(200).body(employee);
//        }catch (Exception ex){
//            return ResponseEntity.badRequest().body(ex.getMessage());
        }catch (Exception e){
            throw new Exception("authetication failed");
        }
    }
}
