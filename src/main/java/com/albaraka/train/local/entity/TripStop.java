package com.albaraka.train.local.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalTime;

@Entity
@Table(name = "trip_stop",
        uniqueConstraints = @UniqueConstraint(columnNames = {"trip_id", "stop_sequence"}))
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class TripStop {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long tripStopId;      // trip_stop_id

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "trip_id", nullable = false)
    private Trip trip;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "station_id", nullable = false)
    private Station station;

    @Column(nullable = false)
    private Integer stopSequence;

    private LocalTime arrivalTime;

    @Column(nullable = false)
    private Integer dwellMinutes;
}