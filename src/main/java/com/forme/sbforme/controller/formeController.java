package com.forme.sbforme.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.forme.sbforme.properties.*;

@RestController
@RequestMapping(value = {"/lets"}, method = RequestMethod.GET)
public class formeController {

    @Autowired
    private GirlProperities girl;

   // @RequestMapping(value = {"/haha/{id}"}, method = RequestMethod.GET)
    @GetMapping(value = {"haha/{id}"})
    public String lets(@PathVariable("id") Integer id, @RequestParam(value = "name", required = false, defaultValue = "") String name) {
        return "lets rock " + girl.getCupSize() + " " + id + " " + name;
    }
}
