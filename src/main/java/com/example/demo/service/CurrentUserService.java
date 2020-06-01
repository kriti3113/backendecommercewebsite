package com.example.demo.service;

import com.example.demo.model.Users;
import com.example.demo.repository.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
        import org.springframework.stereotype.Service;

        import java.security.Principal;
        import java.util.List;
        import java.util.Optional;
@Service
public class CurrentUserService {

    @Autowired
    UsersRepository UsersRepo;

    public Optional<Users> CurrentUser(Principal principal)
    {
        String name = principal.getName();
        return UsersRepo.findByUsername(name);
    }

    public Long getuserid(Principal principal) {

        String name = principal.getName();
        Long id = UsersRepo.findByUsername(name).get().getuserid();
        return id;
    }


    public String getuserrole(Principal principal)
    {
        return UsersRepo.findByUsername(principal.getName()).get().getRole();
    }


    public Optional<Users> getuserprofile(Principal principal)
    {
        return UsersRepo.findByUsername(principal.getName());
    }


}
