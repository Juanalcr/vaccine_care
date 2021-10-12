/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.project1.vaccine_care.controllers;

import com.project1.vaccine_care.interfaces.UserInterface;
import com.project1.vaccine_care.models.User;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

/**
 *
 * @author user
 */
@Controller
public class LoginController {

    @Autowired
    private UserInterface userInterface;

    @GetMapping("/login")
    public String index(Model model) {

        User user = new User();
        model.addAttribute("user", user);

        return "loginuser";
    }

    @PostMapping("/loginuser")
    public String store(@ModelAttribute("user") User user,
            HttpServletRequest request, RedirectAttributes ra) throws Exception {
        HttpSession session = request.getSession(true);

        User obj = userInterface.auth(user.getName(), user.getPhone_number());

        if (obj == null) {
            ra.addFlashAttribute("error", "Invalid username or phone_number!");
            return "redirect:/loginuser";
        }

        session.setAttribute("nik", obj.getNik());
       session.setAttribute("name", obj.getName());
         session.setAttribute("phone_number", obj.getPhone_number());
        session.setAttribute("loggedIn", true);

        return "redirect:/";
    }

}
