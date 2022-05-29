package com.PI.apiBooking.Service.Interfaces;

import com.PI.apiBooking.Model.DTO.ImageDto;
import com.PI.apiBooking.Model.Image;
import com.PI.apiBooking.Service.ICheckId;
import com.PI.apiBooking.Service.IServices;

public interface IImagenServices extends IServices<ImageDto>, ICheckId<Image> {
}
