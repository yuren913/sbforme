package com.forme.sbforme.service;

import com.forme.sbforme.domain.Girl;
import com.forme.sbforme.enums.ResultEnum;
import com.forme.sbforme.exception.GirlException;
import com.forme.sbforme.repository.GirlRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
public class GirlService {

    @Autowired
    private GirlRepository girlRepository;

    @Transactional
    public void insertTwo(){
        Girl girlA = new Girl();
        girlA.setCupSize("E");
        girlA.setAge(18);
        girlRepository.save(girlA);

        Girl girlB = new Girl();
        girlB.setCupSize("F");
        girlB.setAge(19);
        girlRepository.save(girlB);

    }

    public void getAge(Integer id) throws Exception{
        Girl girl = girlRepository.findById(id).get();
        Integer age = girl.getAge();
        if(age < 10){
            throw new GirlException(ResultEnum.ERROR_PRIMARY);
        }else if(age > 10 && age <16){
            throw new GirlException(ResultEnum.ERROR_SECONDARY);
        }
    }
}
