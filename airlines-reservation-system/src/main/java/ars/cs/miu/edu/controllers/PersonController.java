package ars.cs.miu.edu.controllers;

import ars.cs.miu.edu.models.*;
import ars.cs.miu.edu.services.PersonServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
public class PersonController {
    @Autowired
    private PersonServiceImpl personService;

    @GetMapping("/persons")
    public ResponseEntity<List<Person>> findAllPersons() {
        List<Person> personList = personService.findAll();
        if(personList.isEmpty()){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(personList);
    }

    // Passenger CRUD
        @GetMapping("/passengers")
        public ResponseEntity<List<Passenger>> findAllPassengers () {
        List<Passenger> passengerList = personService.findAll();

        if (passengerList.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(passengerList);
    }
        @GetMapping("/passengers/{id}")
        public ResponseEntity<Person> getOnePassenger ( @PathVariable long id){
        Passenger passenger = (Passenger) personService.findOne(id);
        if (passenger == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(passenger);
    }
        @PostMapping("/passengers")
        public ResponseEntity<Person> addPerson (@RequestBody @Valid Passenger passenger){
        passenger.setRole(Role.PASSENGER);
        Passenger addedPassenger = (Passenger) personService.add(passenger);
        return ResponseEntity.ok(addedPassenger);
    }
        @PutMapping("passengers/{id}")
        public ResponseEntity<Passenger> updatePassenger ( @PathVariable long id, @RequestBody @Valid Passenger passenger){
        Passenger updatedPassenger = null;
        Passenger tobeUpdatePassenger = (Passenger) personService.findOne(id);
        if (tobeUpdatePassenger == null) {
            updatedPassenger = (Passenger) personService.add(passenger);
        } else {
            passenger.setId(tobeUpdatePassenger.getId());
            updatedPassenger = (Passenger) personService.update(passenger);
        }
        return ResponseEntity.ok(updatedPassenger);
    }

        @DeleteMapping("passengers/{id}")
        public ResponseEntity<Object> deletePassenger ( @PathVariable long id){
        personService.delete(id);
        return ResponseEntity.noContent().build();
    }

    //Admin CRUD
    @GetMapping("/admins")
    public ResponseEntity<List<Admin>> findAllAdmins() {
        List<Admin> adminList = personService.findAll();
        if(adminList.isEmpty()){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(adminList);
    }
    @GetMapping("/admins/{id}")
    public ResponseEntity<Admin> getOneAdmin(@PathVariable long id){
        Admin admin= (Admin) personService.findOne(id);
        if(admin==null){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(admin);
    }
    @PostMapping("/admins")
    public ResponseEntity<Admin> addadmin(@RequestBody @Valid Admin admin){
        admin.setRole(Role.PASSENGER);
        Admin addedAdmin= (Admin) personService.add(admin);
        return ResponseEntity.ok(addedAdmin);
    }
    @PutMapping("admins/{id}")
    public ResponseEntity<Admin> updateAdmin(@PathVariable long id, @RequestBody @Valid Admin admin){
        Admin updatedAdmin=null;
        Admin tobeUpdateAdmin = (Admin) personService.findOne(id);
        if(tobeUpdateAdmin==null){
            updatedAdmin= (Admin) personService.add(admin);
        }else {
            admin.setId(tobeUpdateAdmin.getId());
            updatedAdmin=(Admin) personService.update(admin);
        }
        return  ResponseEntity.ok(updatedAdmin);
    }

    @DeleteMapping("admins/{id}")
    public ResponseEntity<Object>  deleteAdmin(@PathVariable long id){
        personService.delete(id);
        return ResponseEntity.noContent().build();
    }

    //Agent CRUD
    @GetMapping("/agents")
    public ResponseEntity<List<Agent>> findAllAgents() {
        List<Agent> agentList = personService.findAll();
        if(agentList.isEmpty()){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(agentList);
    }
    @GetMapping("/agents/{id}")
    public ResponseEntity<Agent> getOneAgent(@PathVariable long id){
        Agent agent= (Agent) personService.findOne(id);
        if(agent==null){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(agent);
    }
    @PostMapping("/agents")
    public ResponseEntity<Agent> addAgent(@RequestBody @Valid Agent agent){
        agent.setRole(Role.PASSENGER);
        Agent addedAgent= (Agent) personService.add(agent);
        return ResponseEntity.ok(addedAgent);
    }
    @PutMapping("agents/{id}")
    public ResponseEntity<Agent> updateAgent(@PathVariable long id, @RequestBody @Valid Agent agent){
        Agent updatedAgent=null;
        Agent tobeUpdateAgent = (Agent) personService.findOne(id);
        if(tobeUpdateAgent==null){
            updatedAgent= (Agent) personService.add(agent);
        }else {
            agent.setId(tobeUpdateAgent.getId());
            updatedAgent=(Agent) personService.update(agent);
        }
        return  ResponseEntity.ok(updatedAgent);
    }

    @DeleteMapping("agents/{id}")
    public ResponseEntity<Object>  deleteAgent(@PathVariable long id){
        personService.delete(id);
        return ResponseEntity.noContent().build();
    }
}