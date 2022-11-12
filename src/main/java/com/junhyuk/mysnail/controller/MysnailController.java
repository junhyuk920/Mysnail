package com.junhyuk.mysnail.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import com.junhyuk.mysnail.dto.MysnailDto;
import com.junhyuk.mysnail.service.MysnailService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


@Controller
public class MysnailController {

    private MysnailService mysnailService;

    public MysnailController(MysnailService mysnailService){
        this.mysnailService = mysnailService;
    }

    @GetMapping("/")
    public String mainpage(){
        return "mysnail/home.html";
    }

    @GetMapping("/home")
    public String home(){
        return "mysnail/home.html";
    }

    @GetMapping("/dictionary")
    public String dictionary(){
        return "mysnail/dictionary.html";
    }

    @GetMapping("/picture")
    public String picture(){
        return "mysnail/picture.html";
    }

    @RequestMapping(value="/mysnail/picturewrite", method=RequestMethod.GET)
	public String openpicturewrite() throws Exception {
		return "/mysnail/picturewrite";
	}

    @RequestMapping(value="/mysnail/picturewrite", method=RequestMethod.POST)
	public String savePost(MysnailDto mysnailDto) throws Exception {
        mysnailService.savePost(mysnailDto);
		return "redirect:/picture";
	}


    @GetMapping("/information")
    public String information(){
        return "mysnail/information.html";
    }
}
