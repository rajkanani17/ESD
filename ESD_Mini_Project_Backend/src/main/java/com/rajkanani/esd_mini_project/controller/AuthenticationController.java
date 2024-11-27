package com.rajkanani.esd_mini_project.controller;

import com.rajkanani.esd_mini_project.dto.LoginRequest;
import com.rajkanani.esd_mini_project.service.EmployeesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/home")
@CrossOrigin("http://localhost:5173")
public class AuthenticationController {

    @Autowired
    private EmployeesService employeesService;

    @PostMapping("/authenticate")
    public ResponseEntity<String> authenticate(@RequestBody @Validated LoginRequest loginRequest) throws Exception{
////        System.out.println("Login ......");
//        try{
//            Employees employee = employeesService.authenticate(loginRequest);
//            return ResponseEntity.status(200).body(employee);
////        }catch (Exception ex){
////            return ResponseEntity.badRequest().body(ex.getMessage());
//        }catch (Exception e){
//            throw new Exception("authetication failed");
//        }
        return ResponseEntity.ok(employeesService.authenticate(loginRequest));
    }
}
