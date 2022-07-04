package com.jecrc.cheggbookmanagement.model.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;
import lombok.extern.slf4j.Slf4j;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;

@Getter
@Setter
@ToString
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Slf4j
@Entity
@Table(name = "my_book",indexes ={@Index(name="uniqueISBN",columnList = "isbn")} )
public class Books {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonIgnore
    Integer id;

    String isbn;

    String name;

    Integer cost;

    @Enumerated(EnumType.STRING)
    BookStatus bookStatus;

    @ManyToOne
    @JoinColumn
    @JsonIgnore
    Author author;

    @ManyToOne
    @JoinColumn
    @JsonIgnore
    UserInfo userInfo;

    @OneToMany(mappedBy = "orderedBook")
    @JsonIgnore
    List<Orders> ordersList;

    @CreationTimestamp
    LocalDateTime creationDate;

    @UpdateTimestamp
    LocalDateTime modifiedDate;

    @PrePersist
    public void prePersistCheck(){
        log.info("----->prePersistCheck {}",this.bookStatus);
        if(Objects.isNull(this.bookStatus)){
            this.bookStatus=BookStatus.AVAILABLE;
        }
    }
}

