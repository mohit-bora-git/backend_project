package com.jecrc.cheggbookmanagement.model.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
@ToString
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class UserInfo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonIgnore
    Integer id;

    @NotNull
    String name;

    String email;

    String address;

    Integer phoneNumber;

    @OneToMany(mappedBy = "userInfo")
    @JsonIgnore
    List<Books> issuedBooks;

    @OneToMany(mappedBy = "transactUser")
    @JsonIgnore
    List<Orders> ordersList;

    @CreationTimestamp
    LocalDateTime creationDate;

    @UpdateTimestamp
    LocalDateTime modifiedDate;
}
