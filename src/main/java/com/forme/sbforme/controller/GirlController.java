package com.forme.sbforme.controller;


import com.forme.sbforme.domain.Girl;
import com.forme.sbforme.repository.GirlRepository;
import com.forme.sbforme.service.GirlService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class GirlController {

    @Autowired
    private GirlRepository girlRepository;

    @Autowired
    private GirlService girlService;

    @GetMapping(value = "/girls")
    public List<Girl> girlList(){
        return girlRepository.findAll();
    }

    @PostMapping(value = "/girls")
    public Girl girlAdd(@RequestParam("cupSize") String cupSize,
                          @RequestParam("age") Integer age){
        Girl girl = new Girl();
        girl.setCupSize(cupSize);
        girl.setAge(age);
       return girlRepository.save(girl);
    }

    @GetMapping(value = "/girls/{id}")
    public Girl getGirlById(@PathVariable("id") Integer id){
        return girlRepository.findById(id).get();
    }

    @PutMapping(value = "/girls/{id}")
    public Girl updateGirlById(@PathVariable("id") Integer id,
                               @RequestParam("cupSize") String cupSize,
                               @RequestParam("age") Integer age){
        Girl girl = new Girl();
        girl.setId(id);
        girl.setAge(age);
        girl.setCupSize(cupSize);
        return girlRepository.save(girl);
    }

    @DeleteMapping(value = "/girls/{id}")
    public void deleteGirlById(@PathVariable("id") Integer id){
        girlRepository.deleteById(id);
    }

    @GetMapping(value = "/girls/age/{age}")
    public List<Girl> findGirlsByAge(@PathVariable("age") Integer age){
        return girlRepository.findByAge(age);
    }

    @PostMapping(value = "/girls/double")
    public void girlDoubleKill(){
        girlService.insertTwo();
    }
}
