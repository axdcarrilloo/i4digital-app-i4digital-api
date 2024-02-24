package com.I4Digital.utils;

import com.I4Digital.domain.dtos.TypeAppointmentRegisterDto;
import com.I4Digital.services.TypeAppointmentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class LoadTypesAppointments {

    private TypeAppointmentService typeAppointmentScv;

    @Autowired
    public LoadTypesAppointments(TypeAppointmentService typeAppointmentScv) {
        this.typeAppointmentScv = typeAppointmentScv;
    }

    @EventListener
    public void onApplicationEvent(ApplicationReadyEvent event) {
        if(typeAppointmentScv.getAll().count().block() < 1) {
            initializeData();
        }
    }

    private void initializeData() {
        // Insertar registros al iniciar la aplicación
        typeAppointmentScv.register(new TypeAppointmentRegisterDto("Cita de revisión odontológica primera vez", "Cita de revisión odontológica primera vez",
                32, "QQAAZ12")).subscribe();
        typeAppointmentScv.register(new TypeAppointmentRegisterDto("Cita de revisión odontológica control", "Cita de revisión odontológica control",
                30, "QQAAZ10")).subscribe();
        typeAppointmentScv.register(new TypeAppointmentRegisterDto("Cita medicina general primera vez", "Cita medicina general primera vez",
                35, "QQAAZ11")).subscribe();
        typeAppointmentScv.register(new TypeAppointmentRegisterDto("Cita medicina general control", "Cita medicina general control",
                33, "QQAAZ13")).subscribe();
        typeAppointmentScv.register(new TypeAppointmentRegisterDto("Cita con especialista de pediatría primera vez", "Cita con especialista de pediatría primera vez",
                41, "QQAAZ15")).subscribe();
    }
}
