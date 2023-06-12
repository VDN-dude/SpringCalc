package by.tms.controller;

import by.tms.dto.LoginUserDto;
import by.tms.dto.RegUserDto;
import by.tms.entity.SessionUser;
import by.tms.service.UserService;
import org.hibernate.exception.ConstraintViolationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.util.Optional;

@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/reg")
    public String reg(Model model){
        model.addAttribute("newUser", new RegUserDto());
        return "reg";
    }

    @PostMapping("/reg")
    public String reg(@ModelAttribute("newUser") @Valid RegUserDto regUserDto,
                      BindingResult bindingResult,
                      Model model){
        if (bindingResult.hasErrors()){
            return "reg";
        }
        try {
            userService.save(regUserDto);
        } catch (ConstraintViolationException e){
            model.addAttribute("regError", "User with this username and email already exist");
            return "reg";
        }
        return "redirect:/user/login";
    }

    @GetMapping("login")
    public String login(Model model){
        model.addAttribute("newLoginUser", new LoginUserDto());
        return "login";
    }

    @PostMapping("login")
    public String login(@ModelAttribute("newLoginUser") @Valid LoginUserDto loginUserDto,
                        BindingResult bindingResult,
                        HttpSession httpSession,
                        Model model){
        if (bindingResult.hasErrors()){
            return "login";
        }
        Optional<SessionUser> sessionUser = userService.login(loginUserDto);
        if (sessionUser.isPresent()){
            httpSession.setAttribute("sessionUser", sessionUser.get());
            return "redirect:/calc";
        } else {
            model.addAttribute("loginInvalid", "Email or password is wrong, please try again");
            return "login";
        }
    }
}
