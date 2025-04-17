package com.fitness.config;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.fitness.model.User;
import com.fitness.model.UserRole;
import com.fitness.repository.UserRepository;

@Configuration
public class StartupDataLoader {

    @Bean
    CommandLineRunner loadData(UserRepository userRepository)
    {
        return args ->
        {
            if (userRepository.count() == 0) {
                User admin = new User();
                admin.setEmail("sandeepborkar94@gmail.com");
                admin.setPassword("password");
                admin.setFirstName("Sandeep");
                admin.setLastName("Borkar");
                admin.setUserRole(UserRole.ADMIN);

                User user1 = new User();
                user1.setEmail("user1@example.com");
                user1.setPassword("password1");
                user1.setFirstName("User");
                user1.setLastName("One");
                user1.setUserRole(UserRole.USER);

                User user2 = new User();
                user2.setEmail("user2@example.com");
                user2.setPassword("password2");
                user2.setFirstName("User");
                user2.setLastName("Two");
                user2.setUserRole(UserRole.USER);

                userRepository.save(admin);
                userRepository.save(user1);
                userRepository.save(user2);
            }
        };
    }
}
