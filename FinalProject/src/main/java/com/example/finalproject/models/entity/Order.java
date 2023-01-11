package com.example.finalproject.models.entity;

import javax.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;
import java.util.Date;

@Entity(name = "orders")
@Setter
@Getter
@RequiredArgsConstructor
@ToString
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Order extends BaseEntity{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    Boolean active;
    String text;
    String name;
    String phone;
    String email;
    @JoinColumn(name="total_price")
    Double totalPrice;
    @Column(name="add_date")
    Date addDate;
    @Column(name = "edit_date")
    Date editDate;
    Boolean status;
    @PrePersist
    void prePersist(){
        this.addDate=new Date(System.currentTimeMillis());
        this.active=true;
    }

}
