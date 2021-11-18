package nl.novi.hello.controller;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.ArrayList;

@RestController
public class NameController {

    //attribute
    private List<String> names = new ArrayList<>();

    //constructor
    public NameController(){
        names.add("Michelle");
        names.add("Lianne");
        names.add("Elena");
    }

    @GetMapping(value = "/names")
    @ResponseStatus (HttpStatus.OK)
    public List<String> getNames(){
        return names;
    }

    @GetMapping(value = "/names/{id}")
    @ResponseStatus (HttpStatus.OK)
    public String getNames(@PathVariable int id) {
        return names.get(id);
    }

    @DeleteMapping (value = "/names/{id}")
    @ResponseStatus(HttpStatus.CREATED)
    public String DeleteName(@PathVariable int id){
        names.remove(id);
        return "Deleted!";
    }

    @PostMapping(value = "/names")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public String addName(@RequestBody String name) {
        names.add(name);
        return "Added!";
    }
}
