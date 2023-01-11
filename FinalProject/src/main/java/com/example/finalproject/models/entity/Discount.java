package com.example.finalproject.models.entity;

import javax.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.Date;
@Entity(name = "discount")
@Getter
@Setter
@ToString
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Discount extends BaseEntity{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    Boolean active;
    @ManyToOne
    @JoinColumn(name = "channel_id")
    Channel channel;
    Double percent;
    @Column(name = "start_date")
    Date startDate;
    @Column(name = "end_date")
    Date endDate;
    @Column(name = "min_day")
    int minDay;
    @PrePersist
    void prePersis(){
        this.active=true;
    }

}
