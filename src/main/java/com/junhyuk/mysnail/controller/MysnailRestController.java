package com.junhyuk.mysnail.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.junhyuk.mysnail.dto.MysnailDto;
import com.junhyuk.mysnail.service.MysnailService;

@RestController
public class MysnailRestController {
    @Autowired
    MysnailService mysnailService;
    

    @GetMapping("/mysnail/all")
    public List<MysnailDto> list() {
        return mysnailService.getPostList();
    }


    @PostMapping("/mysnail/new")
    public MysnailDto insert(@RequestBody MysnailDto mysnailDto) {
        return mysnailService.savePost(mysnailDto);
    }


    // 회원 상세
    @GetMapping("/mysnail/{id}")
    public MysnailDto getPost(@PathVariable Long id) {
        return mysnailService.getPost(id);
    }

    @PutMapping("/mysnail/{id}")
    public MysnailDto updateMysnail(@PathVariable Long id, @RequestBody MysnailDto mysnailDto){

        return mysnailService.updatePost(id, mysnailDto);
    }

    // 회원 삭제
    @DeleteMapping("/mysnail/{id}")
    public void deletePost(@PathVariable Long id) {

        mysnailService.deletePost(id);
    }
}
