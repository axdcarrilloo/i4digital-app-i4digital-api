package com.I4Digital.services;

import com.I4Digital.domain.entities.TypeAppointment;
import com.I4Digital.repositories.TypeAppointmentRepository;
import com.I4Digital.services.implementss.TypeAppointmentServiceImpl;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import reactor.core.publisher.Mono;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class TypeAppointmentServiceTest {

    @Mock
    private TypeAppointmentRepository typeAppointmentRepository;

    @InjectMocks
    private TypeAppointmentServiceImpl typeAppointmentSvc;

    @Test
    void getByIdTest() {
        when(typeAppointmentRepository.findById("qazxsw234")).thenReturn(Mono.just(getTypeAppointmentDefault()));

        typeAppointmentSvc.getById("qazxsw234").doOnNext(typeAppointment -> {
            assertNotNull(typeAppointment);
            assertEquals(typeAppointment.getId(), "qazxsw234");
        });
    }

    @Test
    void deleteByIdTest() {
        when(typeAppointmentRepository.findById("qazxsw234")).thenReturn(Mono.just(getTypeAppointmentDefault()));

        typeAppointmentSvc.deleteById("qazxsw234").doOnNext(idEliminado -> {
            assertNotNull(idEliminado);
            assertEquals(idEliminado, "qazxsw234");
        });
    }

    TypeAppointment getTypeAppointmentDefault() {
        return new TypeAppointment("qazxsw234", "Citas de pruebas", "Citas de pruebas",
                13, "QAZXSW33")
        ;
    }

}
