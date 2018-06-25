package com.forme.sbforme.controller;


import com.forme.sbforme.domain.Girl;
import com.forme.sbforme.domain.Result;
import com.forme.sbforme.repository.GirlRepository;
import com.forme.sbforme.service.GirlService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
public class GirlController {
    private final static Logger logger = LoggerFactory.getLogger(GirlController.class);

    @Autowired
    private GirlRepository girlRepository;

    @Autowired
    private GirlService girlService;

    @GetMapping(value = "/girls")
    public List<Girl> girlList(){
        return girlRepository.findAll();
    }

    @PostMapping(value = "/girls")
    public Result<Girl> girlAdd(@Valid Girl girl, BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            Result result = new Result();
            result.setCode(1);
            result.setMsg(bindingResult.getFieldError().getDefaultMessage());
            return result;
        }
        Result result = new Result();
        girl.setCupSize(girl.getCupSize());
        girl.setAge(girl.getAge());
        result.setCode(0);
        result.setMsg("success");
        result.setData(girlRepository.save(girl));
        return result;
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
