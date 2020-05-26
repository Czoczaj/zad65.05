package com.example.demo195;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class BrickController {

    @Autowired
    private BrickDao brickDao;

    @GetMapping("/user")
    String findAllUser(Model model){
        model.addAttribute("brickList", brickDao.findAll());
        return "indexUser";
    }
    @GetMapping("/admin")
    String findAllAdmin(Model model){
        model.addAttribute("brickList", brickDao.findAll());
        return "indexAdmin";
    }
    @GetMapping("/mod")
    String findAllMod(Model model){
        model.addAttribute("brickList", brickDao.findAll());
        return "indexMod";
    }
}
