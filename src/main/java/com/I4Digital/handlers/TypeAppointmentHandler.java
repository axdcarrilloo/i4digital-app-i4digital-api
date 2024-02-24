package com.I4Digital.handlers;

import com.I4Digital.domain.dtos.TypeAppointmentRegisterDto;
import com.I4Digital.domain.entities.TypeAppointment;
import com.I4Digital.services.TypeAppointmentService;
import com.I4Digital.services.implementss.TypeAppointmentServiceImpl;
import lombok.RequiredArgsConstructor;
import org.apache.catalina.Server;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.validation.BeanPropertyBindingResult;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.net.URI;
import java.util.ArrayList;
import java.util.List;

import static org.springframework.web.reactive.function.BodyInserters.fromObject;
import static org.springframework.web.reactive.function.BodyInserters.fromProducer;

@Component
@RequiredArgsConstructor
public class TypeAppointmentHandler {

    private final TypeAppointmentService typeAppointmentSvc;

    private final Validator validator;

    public Mono<ServerResponse> getById(ServerRequest request) {
        String id = request.pathVariable("id");

        return typeAppointmentSvc.getById(id).flatMap(typeAppointment -> ServerResponse.ok().contentType(MediaType.APPLICATION_JSON_UTF8)
                .body(fromObject(typeAppointment)))
                .switchIfEmpty(ServerResponse.notFound().build())
        ;
    }

    public Mono<ServerResponse> deleteById(ServerRequest request) {
        String id = request.pathVariable("id");

        return typeAppointmentSvc.deleteById(id).flatMap(idDeleted -> ServerResponse.ok()
                .contentType(MediaType.APPLICATION_JSON_UTF8)
                .body(fromObject(idDeleted)))
                .switchIfEmpty(ServerResponse.notFound().build());
    }

    public Mono<ServerResponse> getAll(ServerRequest request) {
        return ServerResponse.ok().contentType(MediaType.APPLICATION_JSON_UTF8)
                .body(typeAppointmentSvc.getAll(), TypeAppointment.class);
    }

    public Mono<ServerResponse> register(ServerRequest serverRequest) {
        Mono<TypeAppointmentRegisterDto> typeAppointmentMn = serverRequest.bodyToMono(TypeAppointmentRegisterDto.class);

        return typeAppointmentMn.flatMap(typeAppointment -> {
            Errors errors = new BeanPropertyBindingResult(typeAppointment, TypeAppointment.class.getName());
            validator.validate(typeAppointment, errors);
            if(errors.hasErrors()) {
                return Flux.fromIterable(errors.getFieldErrors())
                        .map(fieldError -> "El campo "+fieldError.getField()+ " " + fieldError.getDefaultMessage())
                        .collectList()
                        .flatMap(list -> ServerResponse.badRequest().body(fromObject(list)));
            } else {
                return typeAppointmentSvc.register(typeAppointment).flatMap(id -> ServerResponse
                        .created(URI.create("/typeAppointment/register/".concat(id)))
                        .contentType(MediaType.APPLICATION_JSON_UTF8)
                        .body(fromObject(id)));
            }
        });
    }

}
