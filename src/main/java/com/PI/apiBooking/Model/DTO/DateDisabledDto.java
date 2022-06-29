package com.PI.apiBooking.Model.DTO;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDate;

@ToString
@Getter
@Setter
public class DateDisabledDto {

    private LocalDate arrival;
    private LocalDate departure;
}
