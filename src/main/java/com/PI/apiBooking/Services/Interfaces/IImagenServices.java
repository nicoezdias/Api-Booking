package com.PI.apiBooking.Services.Interfaces;

import com.PI.apiBooking.Model.DTO.ImageDto;
import com.PI.apiBooking.Model.Image;
import com.PI.apiBooking.Services.ICheckId;
import com.PI.apiBooking.Services.IServices;

public interface IImagenServices extends IServices<ImageDto>, ICheckId<Image> {
}
