package com.PI.apiBooking.Service.Interfaces;

import com.PI.apiBooking.Model.DTO.ImageDto;
import com.PI.apiBooking.Model.Image;
import com.PI.apiBooking.Service.ICheckId;
import com.PI.apiBooking.Service.IService;

public interface IImagenService extends IService<ImageDto>, ICheckId<Image> {
}
