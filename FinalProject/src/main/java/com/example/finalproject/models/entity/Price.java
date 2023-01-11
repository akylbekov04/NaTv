package com.example.finalproject.models.entity;

import javax.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

import java.util.Date;

@Entity(name = "prices")
@Getter
@Setter
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Price extends BaseEntity{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    Boolean active;

    @ManyToOne
    @JoinColumn(name="channel_id")
    Channel channel;
@Column(name="start_date")
    Date startDate;
    @Column(name="end_date")
    Date endDate;

    Double price;

    @PrePersist
    void prePersist(){
        this.active = true;
    }
}
