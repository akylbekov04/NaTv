package com.example.finalproject.services.Impl;

import com.example.finalproject.exceptions.NotFoundException;
import com.example.finalproject.models.entity.BaseEntity;
import com.example.finalproject.models.entity.Order;
import com.example.finalproject.models.mapper.BaseMapper;
import com.example.finalproject.models.mapper.OrderMapper;
import com.example.finalproject.repository.BaseRepository;
import com.example.finalproject.services.BaseService;
import com.example.finalproject.utils.RBundle;
import org.springframework.data.domain.PageRequest;

import java.util.List;

public class BaseServiceImpl<E extends BaseEntity, D> implements BaseService<D> {
    private BaseRepository<E, Long> rep;
    private BaseMapper<E,D> mapper;

    public BaseServiceImpl(BaseRepository<E, Long> repository, BaseMapper<E, D> mapper) {
        this.rep = repository;
        this.mapper = mapper;
    }

    @Override
    public D save(D d) {
        return mapper.toDto(rep.save(mapper.toEntity(d)));
    }

    @Override
    public D findById(Long id) {
        D dto = mapper.toDto(rep.findById(id).orElse(null));
        if(dto==null){
            throw new NotFoundException(RBundle.SINGLETON.periodMessage("notFound"));
        }
        return mapper.toDto(rep.findById(id).orElseThrow());
    }

    @Override
    public List<D> findAll(PageRequest pageable) {
        return mapper.toDtos(rep.findAll(pageable).toList());
    }

    @Override
    public int deleteById(Long id) {
        return rep.updateActiveById(false,id);
    }
}
