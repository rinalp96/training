package com.miq.springBootcamp.springBootcamp.controller;

import com.miq.springBootcamp.springBootcamp.model.employee;
import com.miq.springBootcamp.springBootcamp.repository.employeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@RestController
@RequestMapping("/employee")
public class employeeController {
    @Autowired
    private employeeRepository employeeRepository;

    @RequestMapping(value = "/add", method = RequestMethod.POST, consumes = "application/json", produces = "application/json")
    public ResponseEntity<employee> addNewEmployee(@Valid @RequestBody employee employee) {

        employee savedEmployee = employeeRepository.save(employee);

        return new ResponseEntity<employee>(savedEmployee, HttpStatus.OK);
    }

    @RequestMapping(value = "/list", method = RequestMethod.GET, produces = "application/json")
    public ResponseEntity<List<employee>> returnAllEmployees() {
        return new ResponseEntity<List<employee>>(employeeRepository.findAll(), HttpStatus.OK);
    }

    @RequestMapping(value = "/get/{employeeId}", method = RequestMethod.GET, produces = "application/json")
    public ResponseEntity<?> returnEmployee(@PathVariable("employeeId") long employeeId) {
        try {
            return new ResponseEntity<employee>(employeeRepository.findById(employeeId).get(), HttpStatus.OK);
        }
        catch (NoSuchElementException e){
            return new ResponseEntity<String>("No employee id", HttpStatus.OK);
        }
    }

    @RequestMapping(value = "getByEmail", method = RequestMethod.GET, produces = "application/json")
    public ResponseEntity<employee> returnOneEmployeeByEmail(@RequestParam("email") String email) {
        return new ResponseEntity<employee>(employeeRepository.findByEmail(email).get(), HttpStatus.OK);
    }


    @RequestMapping(value = "updateSalary", method = RequestMethod.POST, produces = "application/json")
    public ResponseEntity<?> updateSalary(@RequestParam("employeeId") long employeeId,@RequestParam("value") int value) {
        Optional<employee> employeeOptional = employeeRepository.findById(employeeId);

        if(!employeeOptional.isPresent()){
            return new ResponseEntity<String>("employee not found", HttpStatus.OK);
        }
        else{
            employee emp = employeeOptional.get();
            emp.setSalary(emp.getSalary() + value);
            employeeRepository.save(emp);
            return new  ResponseEntity<employee>(emp, HttpStatus.OK);

        }
    }

}
