package com.example.finalproject.repository;

import com.example.finalproject.models.entity.OrderDetail;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderDetailRepository extends BaseRepository<OrderDetail, Long> {
}