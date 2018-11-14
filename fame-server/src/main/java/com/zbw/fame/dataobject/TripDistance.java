package com.zbw.fame.dataobject;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "trip_distance")
public class TripDistance {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String vin;
    private String distance;
    private String start_time;
    private String end_time;
    private String duration;
}