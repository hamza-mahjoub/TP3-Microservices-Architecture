package com.example.auth.Services;

import com.example.auth.models.User;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component("authService")
public class authService {

    private List<User> users = new ArrayList<User>();

    private User user = null;

    public authService(){
        User u  = new User(1,"hamza","hamza@gmail.com","12345");
        User u1 = new User(2,"malek","malek@gmail.com","12345");
        User u2 = new User(3,"sami","sami@gmail.com","12345");
        User u3 = new User(4,"fathi","fathi@gmail.com","12345");
        this.users.add(u);
        this.users.add(u1);
        this.users.add(u2);
        this.users.add(u3);
    }

    public boolean checkUser(String email, String password) {
        for(int i =0;i<this.users.size();i++){
            if(this.users.get(i).getEmail().equals(email) && this.users.get(i).getPassword().equals(password))
            {
                user = this.users.get(i);
                return true;
            }
        }
        return false;
    }

    public boolean isLoggedIn(){
        return  this.user != null;
    }

    public void logout(){
        this.user = null;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
