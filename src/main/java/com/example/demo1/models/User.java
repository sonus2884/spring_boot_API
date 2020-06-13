package com.example.demo1.models;

import com.example.demo1.utils.Constants;
import lombok.Getter;
import lombok.Setter;
import java.util.UUID;


@Getter
@Setter
public class User {

    private UUID uuid;
    private String name;
    private Constants.Gender gender;
    private boolean isDeleted;

    public void setDeleted(boolean deleted) {
        isDeleted = deleted;
    }

    public User(){}
    public User(String name, Constants.Gender gender, boolean isDeleted){
        this.uuid = UUID.randomUUID();
        this.name=name;
        this.gender = gender;
        this.isDeleted = isDeleted;
    }

    @Override
    public String toString(){
        return uuid+" "+name+" "+gender+" "+isDeleted;
    }


}
