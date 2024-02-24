package com.I4Digital.repositories;

import com.I4Digital.domain.entities.TypeAppointment;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TypeAppointmentRepository extends ReactiveMongoRepository<TypeAppointment, String> {
}
