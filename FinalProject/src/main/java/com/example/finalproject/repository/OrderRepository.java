package com.example.finalproject.repository;

import com.example.finalproject.models.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends BaseRepository<Order, Long> {
}