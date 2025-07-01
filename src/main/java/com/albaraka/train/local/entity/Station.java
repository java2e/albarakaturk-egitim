package com.albaraka.train.local.entity;
import com.albaraka.train.core.service.BaseEntity;
import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;

@Entity
@Table(name = "station")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Station extends BaseEntity {

    @Column(nullable = false, unique = true, length = 10)
    private String code;

    @Column(nullable = false, length = 100)
    private String name;

    private BigDecimal latitude;
    private BigDecimal longitude;
}