package es.cifpcm.vidicdaliborkamiali.web;

import es.cifpcm.vidicdaliborkamiali.dao.UsersRepository;
import es.cifpcm.vidicdaliborkamiali.model.Users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
public class UsersController {
    @Autowired
    UsersRepository usersRepository;

    @RequestMapping("/users")
    public String users(Model model){
//        List<Users> lusers = new ArrayList<>();
//        lusers = usersRepository.findAll();
        model.addAttribute("users", usersRepository.findAll());
        return "users/users";
    }
}
