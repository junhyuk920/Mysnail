package com.junhyuk.mysnail.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class MysnailController {

    @GetMapping("/")
    public String mainpage() {
        return "mysnail/home.html";
    }

    @GetMapping("/home")
    public String home() {
        return "mysnail/home.html";
    }

    @GetMapping("/dictionary")
    public String dictionary() {
        return "mysnail/dictionary.html";
    }

    @GetMapping("/picture")
    public String picture() {
        return "mysnail/picture.html";
    }

    @GetMapping("/information")
    public String information() {
        return "mysnail/information.html";
    }

    /*
     * @RequestMapping(value="/mysnail/picturewrite", method=RequestMethod.GET)
     * public String openpicturewrite() throws Exception {
     * return "/mysnail/picturewrite";
     * }
     * 
     * @RequestMapping(value="/mysnail/picturewrite", method=RequestMethod.POST)
     * public String savePost(MysnailDto mysnailDto) throws Exception {
     * mysnailService.savePost(mysnailDto);
     * return "redirect:/picture";
     * }
     */
    // 회원가입 페이지
    
    @GetMapping("/mysnail/picturewrite")
    public String dispwrite() {
        return "/mysnail/picturewrite";
    }

    //
    @GetMapping("/mysnail/mysnailList")
    public String mysnailList() {
        return "/mysnail/mysnailList";
    }

    // 회원 상세보기
    @GetMapping("{id}")
    public String getPost(@PathVariable Long id) {

        return "mysnail/mysnaildetail";
    }

}
