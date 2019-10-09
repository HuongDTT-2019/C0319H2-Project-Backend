package com.codegym.c0319h2.quanlycongty.controller;

import com.codegym.c0319h2.quanlycongty.model.EditUserProfileForm;
import com.codegym.c0319h2.quanlycongty.model.User;
import com.codegym.c0319h2.quanlycongty.service.UserService.UserService;
import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Optional;

import static org.apache.commons.io.FileUtils.getFile;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@PropertySource("classpath:application.properties")
public class UserController {
    @Autowired
    private UserService userService;

    @Value(value = "${file.upload-imageUser}")
    private String imgUser;

    @GetMapping("/getUser/{name}")
    public ResponseEntity<User> getUser(@PathVariable String name){
        Optional<User> user = userService.findByUserName(name);
        User user1 = user.get();
        if (user1 == null){
            return new ResponseEntity<User>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<User>(user1 , HttpStatus.OK);
    }


    @PutMapping(name = "/editUser/{username}", consumes = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<User> updateUser(@PathVariable String username,  EditUserProfileForm Edituser, @RequestParam("avatar") MultipartFile multipartFile) throws IOException {
        Optional<User> userOptional = userService.findByUserName(username);
        if (!userOptional.isPresent()){
            return new ResponseEntity<User>(HttpStatus.NOT_FOUND);
        }
        String fileName = multipartFile.getOriginalFilename();
        if (fileName.isEmpty()){
            fileName = userOptional.get().getAvatar();
            userOptional.get().setAvatar(fileName);

            userOptional.get().setAddress(Edituser.getAddress());

            userOptional.get().setBirthdate(Edituser.getBirthdate());
            userOptional.get().setPhonenumber(Edituser.getPhonenumber());
            User user = userOptional.get();
            userService.save(user);
        }
       if (userOptional.get().getAvatar()== null){
           //Luu file len serve
           try {
               FileCopyUtils.copy(multipartFile.getBytes(), new File(imgUser + fileName));
           } catch (IOException ex) {
               ex.printStackTrace();
           }
           ///////////////////////
       }else {
           //getImg va delete
           String pathFile = imgUser + userOptional.get().getAvatar();
           File file = getFile(pathFile);
           FileUtils.forceDelete(file);
           ////
       }

        //Luu file len serve
        File uploadedFile = new File(imgUser, fileName);

        try {
            FileCopyUtils.copy(multipartFile.getBytes(), new File(imgUser + fileName));
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        ///////////////////////
            userOptional.get().setAvatar(fileName);
            userOptional.get().setAddress(Edituser.getAddress());
            userOptional.get().setBirthdate(Edituser.getBirthdate());
            userOptional.get().setPhonenumber(Edituser.getPhonenumber());
            User user = userOptional.get();
            userService.save(user);
            return new ResponseEntity<User>(user , HttpStatus.OK);
    }

}
