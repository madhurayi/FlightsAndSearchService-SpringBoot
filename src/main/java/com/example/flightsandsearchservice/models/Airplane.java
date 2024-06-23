package com.example.flightsandsearchservice.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EntityListeners;
import lombok.*;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@Entity
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@EntityListeners(AuditingEntityListener.class)
public class Airplane extends BaseModel {

    @Column( nullable = false)
    private String modelNumber;

    @Column( nullable = false,columnDefinition = "int default 200")
    private int capacity;
}
