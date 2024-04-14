package com.example.camera.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
public class Camera {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private String model;
    private int resolution;
    private String ip;

    @ManyToOne
    @JoinColumn(name = "room_id")
    @JsonIgnore
    @JsonIgnoreProperties(ignoreUnknown = true)
    private Room room;

}
