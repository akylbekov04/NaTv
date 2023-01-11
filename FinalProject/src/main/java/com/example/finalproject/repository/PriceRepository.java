package com.example.finalproject.repository;

import com.example.finalproject.models.entity.Price;
import com.example.finalproject.models.info.PriceInfo;
import feign.Param;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Date;
import java.util.List;

public interface PriceRepository extends BaseRepository<Price, Long> {
    @Query(value = """
        select 
        p.price 
        from prices p
        where p.startDate=(select max(pp.startDate) from prices pp where pp.channels.id=?1) and p.channels.id=?1 and p.startDate<?2 and ( ?2<p.endDate or p.endDate is null)
""",nativeQuery = true)
    int findPrice( Long channelId,Date day);
    @Query("""
    select
     (p.endDate-p.startDate) as range,
     p.startDate as startDate,
     p.endDate as endDate,
     p.price as price
    from prices p 
    where p.active = true and p.startDate<:minDate and (:maxDate<=p.endDate or p.endDate is null ) and p.channel.id = :id
    """)
    List<PriceInfo> getActualPriceInRange(@Param("id") Long id, @Param("minDate") Date minDate, @Param("maxDate") Date maxDate);

}