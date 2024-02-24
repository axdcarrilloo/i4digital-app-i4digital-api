package com.I4Digital.domain.entities;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Document("types_appointments")
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class TypeAppointment {
    @Id
    private String id;
    @Field("name")
    private String name;
    @Field("description")
    private String description;
    @Field("duration_minutes")
    private int durationMinutes;
    @Field("color_hex_code")
    private String colorHexCode;
    /*
    @Id
    @Column("id")
    private Integer id;
    @Column("name")
    private String name;
    @Column("description")
    private String description;
    @Column("duration_minutes")
    private int durationMinutes;
    @Column("color_hex_code")
    private String colorHexCode;
    */

}
