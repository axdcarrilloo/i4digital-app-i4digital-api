package com.I4Digital.services.implementss;

import com.I4Digital.domain.dtos.TypeAppointmentRegisterDto;
import com.I4Digital.domain.entities.TypeAppointment;
import com.I4Digital.domain.mappers.TypeAppointmentMapper;
import com.I4Digital.repositories.TypeAppointmentRepository;
import com.I4Digital.services.TypeAppointmentService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Slf4j
@RequiredArgsConstructor
@Service
public class TypeAppointmentServiceImpl implements TypeAppointmentService {

    private final TypeAppointmentRepository typeAppointmentRepository;

    @Override
    public Mono<String> deleteById(String id) {
        log.info("TypeAppointmentServiceImpl.class - deleteById() -> Eliminando tipo cita por id");
        return getById(id).flatMap(typeAppointment -> typeAppointmentRepository.delete(typeAppointment)
                .then(Mono.just(id)))
        ;
    }

    @Override
    public Mono<TypeAppointment> getById(String id) {
        log.info("TypeAppointmentServiceImpl.class - getById() -> Consultando por id de tipo de cita");
        return typeAppointmentRepository.findById(id);
    }

    @Override
    public Flux<TypeAppointment> getAll() {
        log.info("TypeAppointmentServiceImpl.class - getAll() -> Mostrando todos los tipos de citas disponibles");
        return typeAppointmentRepository.findAll();
    }

    @Override
    public Mono<String> register(TypeAppointmentRegisterDto typeAppointment) {
        log.info("TypeAppointmentServiceImpl.class - register() -> Registrando tipo de cita");
        return typeAppointmentRepository.save(TypeAppointmentMapper.convertToEntity(typeAppointment))
                .map(TypeAppointment::getId);
    }
}
