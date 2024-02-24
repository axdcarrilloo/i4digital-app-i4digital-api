package com.I4Digital.domain.dtos;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class TypeAppointmentRegisterDto {
    private String name;
    private String description;
    private Integer durationMinutes;
    private String colorHexCode;
}
