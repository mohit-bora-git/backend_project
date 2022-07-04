package com.jecrc.cheggbookmanagement.model.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Getter
@Setter
@ToString
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Orders {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonIgnore
    Integer id;

    String orderReference;

    double rentCost;

    double fine;

    LocalDate dueDate;

    @Enumerated(value = EnumType.STRING)
    OrderStatus orderStatus;

    @ManyToOne
    @JoinColumn
    UserInfo transactUser;

    @ManyToOne
    @JoinColumn
    Books orderedBook;


    @CreationTimestamp
    LocalDateTime creationDate;

    @UpdateTimestamp
    LocalDateTime modifiedDate;
}
