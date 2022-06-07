package com.PI.apiBooking.Model.DTO.Post;

import com.PI.apiBooking.Model.Product;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.util.Set;

@ToString
@Getter
@Setter
public class PolicyDto {

    private Long id;
    private String type;
    private String description;

    //Constructor for test
    public PolicyDto(String type, String description) {
        this.type = type;
        this.description = description;
    }

    //Default
    public PolicyDto() {
    }
}
