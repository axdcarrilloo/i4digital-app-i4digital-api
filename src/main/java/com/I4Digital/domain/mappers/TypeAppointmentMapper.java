package com.I4Digital.domain.mappers;

import com.I4Digital.domain.dtos.TypeAppointmentRegisterDto;
import com.I4Digital.domain.entities.TypeAppointment;

public class TypeAppointmentMapper {

    public static TypeAppointment convertToEntity(TypeAppointmentRegisterDto typeAppointmentDto) {
        return new TypeAppointment(null, typeAppointmentDto.getName(), typeAppointmentDto.getDescription(), typeAppointmentDto.getDurationMinutes(),
                typeAppointmentDto.getColorHexCode());
    }

}
