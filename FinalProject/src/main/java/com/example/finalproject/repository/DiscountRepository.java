package com.example.finalproject.repository;

import com.example.finalproject.models.entity.Discount;
import com.example.finalproject.models.info.ActualDiscount;
import feign.Param;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface DiscountRepository extends BaseRepository<Discount, Long> {
    @Query("""
            select
            max(d.minDay)  as minDay,
            d.percent as percent
            from discount d
            where d.active = true and d.channel.id = :id and d.minDay<=:dayCount and
            d.startDate < CURRENT_DATE and (d.endDate >CURRENT_DATE or d.endDate is null)
            group by d.id
            """)
    ActualDiscount getActualDiscount(@Param("id") Long id, @Param("dayCount") int dayCount);

}