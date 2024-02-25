package com.I4Digital.routerfunctionconfig;

import com.I4Digital.domain.dtos.TypeAppointmentRegisterDto;
import com.I4Digital.utils.Route;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.reactive.AutoConfigureWebTestClient;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.reactive.server.WebTestClient;

@SpringBootTest
@AutoConfigureWebTestClient
public class TypeAppointmentRouterFunctionTest {

    @Autowired
    private WebTestClient webTestClient;

    @Test
    void deleteByIdTest() {
        webTestClient.delete()
                .uri(Route.URL_MAIN + "/deleteById/65da6638df9ccd0750ae5fe1")
                .exchange()
                .expectStatus().isOk()
                .expectHeader().contentType(MediaType.APPLICATION_JSON_UTF8)
        ;
    }

    @Test
    void getByIdTest() {
        webTestClient.get()
                .uri(Route.URL_MAIN + "/getById/65da6638df9ccd0750ae5fe1")
                .exchange()
                .expectStatus().isOk()
                .expectHeader().contentType(MediaType.APPLICATION_JSON_UTF8)
        ;
    }

    @Test
    void getAllTest() {
        webTestClient.get()
                .uri(Route.URL_MAIN + Route.GETALL)
                .exchange()
                .expectStatus().isOk()
                .expectHeader().contentType(MediaType.APPLICATION_JSON_UTF8)
        ;
    }

    @Test
    void registerTest() {
        TypeAppointmentRegisterDto typeAppointmentRegister = new TypeAppointmentRegisterDto("Citas de pruebas", "Citas de pruebas",
                13, "QAZXSW33");

        webTestClient.post()
                .uri(Route.URL_MAIN + Route.REGISTER)
                .contentType(MediaType.APPLICATION_JSON_UTF8)
                .bodyValue(typeAppointmentRegister)
                .exchange()
                .expectStatus().isCreated()
                .expectHeader()
                .contentType(MediaType.APPLICATION_JSON_UTF8)
                .expectBody(String.class).returnResult()
        ;
    }

}
