package org.example.eccommerceinspringboot.runner;

import lombok.RequiredArgsConstructor;
import org.example.eccommerceinspringboot.entity.User;
import org.example.eccommerceinspringboot.repo.UserRepo;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component("componentRunner")


public class Runner implements CommandLineRunner {
    private final PasswordEncoder passwordEncoder;
    private final UserRepo userRepo;
  @Value("${spring.jpa.hibernate.ddl-auto}")
    private String ddt;

    @Override
    public void run(String... args) throws Exception{
        if (ddt.equals("create")){
            userRepo.save(new User(1, "sanjar", passwordEncoder.encode("2008"), passwordEncoder.encode("Sanjar Ismailov")));
        }
    }
}
