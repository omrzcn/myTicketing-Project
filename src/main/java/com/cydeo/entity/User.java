package com.cydeo.entity;

import com.cydeo.enums.Gender;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
//@AllArgsConstructor - if we extends super class, we need to create constructor manually.
public class User extends BaseEntity {

    private String firstName;
    private String lastName;
    private String userName;
    private String passWord;
    private boolean enabled; // this is for security. Like confirm your email ...
    private String phone;
    private Role role;
    private Gender gender;


    public User(Long id, LocalDateTime insertDateTime, Long insertUserId, LocalDateTime lastUpdateDateTime, Long LastUpdateUserId, String firstName, String lastName, String userName, String passWord, boolean enabled, String phone, Role role, Gender gender) {
        super(id, insertDateTime, insertUserId, lastUpdateDateTime, LastUpdateUserId);
        this.firstName = firstName;
        this.lastName = lastName;
        this.userName = userName;
        this.passWord = passWord;
        this.enabled = enabled;
        this.phone = phone;
        this.role = role;
        this.gender = gender;
    }


}
