package com.I4Digital.routerfunctionconfig;

import com.I4Digital.handlers.TypeAppointmentHandler;
import com.I4Digital.utils.Route;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.ServerResponse;

import static org.springframework.web.reactive.function.server.RequestPredicates.*;
import static org.springframework.web.reactive.function.server.RouterFunctions.route;

@SuppressWarnings("unused")
@Configuration
public class TypeAppointmentRouterFunction {
    @Bean
    public RouterFunction<ServerResponse> routes(TypeAppointmentHandler handler) {
        return route(POST(Route.URL_MAIN + Route.REGISTER), handler::register)
                .andRoute(GET(Route.URL_MAIN + Route.GETALL), handler::getAll)
                .andRoute(DELETE(Route.URL_MAIN + Route.DELETE_BYID), handler::deleteById)
                .andRoute(GET(Route.URL_MAIN + Route.GET_BYID), handler::getById)
        ;
    }
}
