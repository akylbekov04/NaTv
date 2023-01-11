package com.example.finalproject.models.entity;

import javax.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;
import java.util.LinkedHashSet;
import java.util.Set;

@ToString
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity(name="channels")
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Channel extends BaseEntity{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    Boolean active;
    @Column(unique = true)
    String name;
    Integer orderNum;
    String photo;

    @OneToMany(mappedBy = "channel")
    private Set<Price> prices = new LinkedHashSet<>();
    @OneToMany(mappedBy = "channel")
    private Set<OrderDetail> orderDetails = new LinkedHashSet<>();
    @OneToMany(mappedBy = "channel")
    private Set<Discount> discounts = new LinkedHashSet<>();
    @PrePersist
    void prePersist(){
        this.active = true;
    }
}
