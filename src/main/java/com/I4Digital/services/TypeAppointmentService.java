package com.I4Digital.services;

import com.I4Digital.domain.dtos.TypeAppointmentRegisterDto;
import com.I4Digital.domain.entities.TypeAppointment;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface TypeAppointmentService {

    Mono<String> deleteById(String id);

    Mono<TypeAppointment> getById(String id);

    Flux<TypeAppointment> getAll();

    Mono<String> register(TypeAppointmentRegisterDto typeAppointment);

}
