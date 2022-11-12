package com.junhyuk.mysnail.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.junhyuk.mysnail.domain.repositary.MysnailRepository;
import com.junhyuk.mysnail.dto.MysnailDto;

@Service
public class MysnailService {

    @Autowired
    private MysnailRepository mysnailRepository;

    @Transactional
    public Long savePost(MysnailDto mysnailDto) {
        return mysnailRepository.save(mysnailDto.toEntity()).getId();
    }   
}
