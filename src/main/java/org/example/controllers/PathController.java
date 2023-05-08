package org.example.controllers;

import org.example.models.Rate;
import org.example.models.SimpleClass;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Random;

@RestController
@RequestMapping("contoller2")
public class PathController {
    @GetMapping(value = "/uuid")
    public ResponseEntity<SimpleClass> handleGetAllTasks() {
        int id = (int)((Math.random() * (10000 - 1)) + 1);
        return ResponseEntity.ok()
                .contentType(MediaType.APPLICATION_JSON)
                .body(new SimpleClass(id));
    }

    @GetMapping(value = "/exchange/{currency}")
    public ResponseEntity<Rate> getRate(@PathVariable("currency") String curr) {
        float rate = new Random().nextFloat();
        return ResponseEntity.ok()
                .contentType(MediaType.APPLICATION_JSON)
                .body(new Rate( curr, rate));
    }

}
