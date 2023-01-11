package com.example.finalproject.models.entity;

import javax.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;
import java.util.Date;

@Entity(name = "days")
@Getter
@Setter
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@ToString
public class Day extends BaseEntity{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    Boolean active;
    @JoinColumn(name = "id_order_detail")
    @ManyToOne
    OrderDetail orderDetail;
    Date day;
    @PrePersist
    void prePersist(){
        this.active=true;
    }
}
