package com.PI.apiBooking.Service;

import com.PI.apiBooking.Exceptions.ResourceNotFoundException;
import com.PI.apiBooking.Model.DTO.Image_ProductDto;
import com.PI.apiBooking.Model.DTO.Post.ImageDto;
import com.PI.apiBooking.Service.Impl.ImageService;
import org.junit.FixMethodOrder;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
class ImageServiceTest {

    @Autowired
    private ImageService imageService;

    public void logInfo(){

        imageService.save(new ImageDto("Habitación", "url1", "Habitación", true));
        imageService.save(new ImageDto("Baño", "url2", "Baño", false));
        imageService.save(new ImageDto("Pileta", "url3", "Pileta", false));
    }

    @Test
    public void saveAndFindImages() throws ResourceNotFoundException {
        ImageDto c1 = imageService.save(new ImageDto("Habitación", "url1", "Habitación", true));
        ImageDto c2 = imageService.save(new ImageDto("Baño", "url2", "Baño", false));
        ImageDto c3 = imageService.save(new ImageDto("Pileta", "url3", "Pileta", false));
        assertNotNull(imageService.findById(c1.getId()));
        assertNotNull(imageService.findById(c2.getId()));
        assertNotNull(imageService.findById(c3.getId()));
    }

    @Test
    public void findAllImages() {
        logInfo();
        Set<Image_ProductDto> imagesDto = imageService.findAll();
        assertFalse(imagesDto.isEmpty());
        System.out.println(imagesDto);
    }

    @Test
    public void deleteImage() throws ResourceNotFoundException {
        boolean ex = false;
        ImageDto c4 = imageService.save(new ImageDto("Salón comedor", "url4", "Salón comedor", false));
        imageService.delete(c4.getId());
        try{
            imageService.findById(c4.getId());
        }catch (ResourceNotFoundException e){
            ex = true;
        }
        assertTrue(ex);
    }

    @Test
    public void updateImage() throws ResourceNotFoundException {
        ImageDto c5 = imageService.save(new ImageDto("Hal", "url5", "Hal", false));
        ImageDto c6 = (new ImageDto("Hall", "url5", "Hall", false));
        c6.setId(c5.getId());
        imageService.save(c6);
        assertEquals(c6.toString(), imageService.findById(c6.getId()).toString());
    }
}
