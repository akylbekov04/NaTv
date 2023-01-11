package com.example.finalproject.services.Impl;

import com.example.finalproject.exceptions.NotFoundException;
import com.example.finalproject.exceptions.SaveForException;
import com.example.finalproject.microService.MicroServiceForImage;
import com.example.finalproject.models.dto.ChannelDto;
import com.example.finalproject.models.entity.Channel;
import com.example.finalproject.models.mapper.ChannelMapper;
import com.example.finalproject.models.response.GetChannelResponse;
import com.example.finalproject.repository.ChannelRepository;
import com.example.finalproject.services.ChannelService;
import com.example.finalproject.services.PriceService;
import com.example.finalproject.utils.RBundle;
import org.springframework.data.domain.Pageable;
import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import java.util.List;

@Service
@FieldDefaults(level = AccessLevel.PRIVATE)
public class ChannelServiceImpl extends BaseServiceImpl<Channel, ChannelDto> implements ChannelService {
    private final ChannelRepository rep;
    private final MicroServiceForImage microServiceForImage;
    private final PriceService priceService;

    private final ChannelMapper mapper = ChannelMapper.INSTANCE;


    private ChannelServiceImpl(ChannelRepository rep, MicroServiceForImage microServiceForImage, PriceService priceService) {
        super(rep, ChannelMapper.INSTANCE);
        this.rep = rep;
        this.microServiceForImage = microServiceForImage;
        this.priceService = priceService;
    }

    @Override
    public List<GetChannelResponse> getChannels(Pageable pageable) {
        return rep.findAlll(pageable).getContent();
    }


    @Override
    public ChannelDto save(String name, int orderNum, MultipartFile photo, Double price) throws NotFoundException {
        if (rep.existsByName(name))
            throw new SaveForException(RBundle.SINGLETON.periodMessage("channelNameExist"));//TODO Нужно добавить текст в properties
        if (rep.existsByOrderNum(orderNum))
            throw new SaveForException(RBundle.SINGLETON.periodMessage("notFound"));//TODO Нужно добавить текст в properties
        ChannelDto dto = new ChannelDto();
        dto.setName(name);
        dto.setOrderNum(orderNum);
        dto.setPhoto(microServiceForImage.upload(photo).getDownloadUri());
        priceService.save(dto,price);
        return super.save(dto);
    }
}
