package com.junhyuk.mysnail.service;

import java.time.LocalDateTime;
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
    public MysnailEntity getPost(Long id) {
        Optional<MysnailEntity> mysnailEntityWrapper = mysnailRepository.findById(id);
        MysnailEntity mysnailEntity = mysnailEntityWrapper.get();

        return mysnailEntity;
    }


    @Transactional
    public MysnailEntity savePost(MysnailDto mysnailDto) {
        MysnailEntity response = mysnailRepository.save(mysnailDto.toEntity());
        return response;
    }

    // @Transactional
    // public MysnailEntity updatePost(Long id, MysnailDto mysnailDto) {
    //     Optional<MysnailEntity> mydata = mysnailRepository.findById(id);
    //     MysnailEntity dto = mydata.get();
    //     dto.builder()
    //         .title(mysnailDto.getTitle())
    //         .content(mysnailDto.getContent())
    //         .modifiedDate(LocalDateTime.now())
    //         .build();
        
    //     return mysnailRepository.save(dto);
    // }

    @Transactional
    public MysnailEntity updatePost(Long id, MysnailDto mysnailDto){
        Optional<MysnailEntity> mydata = mysnailRepository.findById(id);

        return mydata.map(data -> {
            data.setTitle(mysnailDto.getTitle());
            data.setContent(mysnailDto.getContent());
            data.setModifiedDate(LocalDateTime.now());

            return data;
        })
        .map(data -> mysnailRepository.save(data))
        .map(data -> data)
        .orElseGet(() -> null);
    }

    @Transactional
    public void deletePost(Long id) {
        mysnailRepository.deleteById(id);
    }
}
