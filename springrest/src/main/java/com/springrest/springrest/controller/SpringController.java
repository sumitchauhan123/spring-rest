package com.springrest.springrest.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class SpringController {
    @GetMapping("/hello")
    public String HelloWorld(){
        return "hello world";
    }
    @GetMapping("hello/{name}")
    public String Name(@PathVariable("name") String name){
        return "Hello, "+ name;
    }
    //http://localhost:8080/hello/query?id=1&firstName=Sumit&lastName=Chauhan
    @GetMapping("hello/query")
        public String PathVar(@RequestParam("id") int id,
                                 @RequestParam("firstName") String firstName,
                                 @RequestParam("lastName") String lastName){
        return id+" "+firstName+" "+lastName;
    }
    @PostMapping("hello/post/{firstName}/{lastName}")
    public String PostMap(@PathVariable(value="lastName")String firstName1,
                          @PathVariable(value="firstName")String lastName1){
            return firstName1+" "+lastName1;
    }
    @PostMapping("json")
    @ResponseStatus(HttpStatus.CREATED)
    public String JsonReceiver(@RequestBody String jsondata){
        return jsondata;
    }

    @GetMapping("greetings")
    public ResponseEntity<String> getGreetings(){
        return ResponseEntity.ok().header("name","sumit chauhan").body("Hello world");
    }
}
