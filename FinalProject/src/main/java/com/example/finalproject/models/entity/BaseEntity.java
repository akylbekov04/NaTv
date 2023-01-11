package com.example.finalproject.models.entity;

import javax.persistence.Column;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.MappedSuperclass;
import java.util.Date;

@MappedSuperclass
@Getter
@Setter
@ToString
@RequiredArgsConstructor
public class BaseEntity {
    boolean active;
    @Column(name = "add_date")
    Date addDate;
    @Column(name = "edit_date")
    Date editDate;
}
