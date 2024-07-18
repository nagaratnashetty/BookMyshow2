package com.example.bookmyshow.Services;

import com.example.bookmyshow.Models.User;
import com.example.bookmyshow.Repositories.UserRepository;
import com.example.bookmyshow.Requests.AddUserRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private JavaMailSender javaMailSender;

    public String addUser(AddUserRequest userRequest){

        User user = User.builder().age(userRequest.getAge())
                .emailId(userRequest.getEmailId())
                .name(userRequest.getName())
                .mobileNo(userRequest.getMobileNo())
                .build();


        SimpleMailMessage mailMessage = new SimpleMailMessage();

        mailMessage.setTo(userRequest.getEmailId());
        mailMessage.setFrom("springacciojob@gmail.com");
        mailMessage.setSubject("Welcome to Book My Show Application !!");

        String body = "Hi "+userRequest.getName()+" !" +
                "Welcome to Book My Show Application, Enjoy WELCOME10 to get 10% off on tickets";
        mailMessage.setText(body);

        javaMailSender.send(mailMessage);

        user = userRepository.save(user);
        return "User has been saved to the DB with userId "+user.getUserId();
    }

}