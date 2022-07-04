package com.jecrc.cheggbookmanagement.model.requests;

import com.jecrc.cheggbookmanagement.model.entities.UserInfo;
import lombok.*;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class CreateUserRequestDto {

    @NotBlank
    String name;

    @Email
    String email;

    @NotBlank
    String address;

    @NotNull
    Integer phoneNumber;

    public UserInfo toUser(){
        return UserInfo.builder()
                .name(name)
                .address(address)
                .email(email)
                .phoneNumber(phoneNumber)
                .build();
    }
}
