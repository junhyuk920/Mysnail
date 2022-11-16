package com.junhyuk.mysnail.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.junhyuk.mysnail.domain.entity.MysnailEntity;
import com.junhyuk.mysnail.domain.repositary.MysnailRepository;
import com.junhyuk.mysnail.dto.MysnailDto;

@Service
public class MysnailService {

    @Autowired
    private MysnailRepository mysnailRepository;

    @Transactional
    public List<MysnailDto> getPostList() {
        List<MysnailEntity> mysnailEntities = mysnailRepository.findAll();
        List<MysnailDto> mysnailDtoList = new ArrayList<>();

        for (MysnailEntity mysnailEntity : mysnailEntities) {
            MysnailDto mysnailDTO = MysnailDto.builder()
                    .id(mysnailEntity.getId())
                    .title(mysnailEntity.getTitle())
                    .content(mysnailEntity.getContent())
                    .createdDate(mysnailEntity.getCreatedDate())
                    .build();

            mysnailDtoList.add(mysnailDTO);
        }
        return mysnailDtoList;
    }

    @Transactional
    public MysnailDto getPost(Long id) {
        Optional<MysnailEntity> mysnailEntityWrapper = mysnailRepository.findById(id);
        MysnailEntity mysnailEntity = mysnailEntityWrapper.get();

        return MysnailDto.builder()
                .id(mysnailEntity.getId())
                .title(mysnailEntity.getTitle())
                .content(mysnailEntity.getContent())
                .createdDate(mysnailEntity.getCreatedDate())
                .build();
    }


    @Transactional
    public MysnailDto savePost(MysnailDto mysnailDto) {
        mysnailRepository.save(mysnailDto.toEntity());
        return mysnailDto;
    }

    @Transactional
    public MysnailDto updatePost(MysnailDto mysnailDto) {
        mysnailRepository.save(mysnailDto.toEntity());
        return mysnailDto;
    }

    @Transactional
    public void deletePost(Long id) {
        mysnailRepository.deleteById(id);
    }
}
