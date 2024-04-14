package com.example.camera.models;


import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Data
@Entity
public class Room {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int roomId;
    private String roomName;

    @OneToMany(mappedBy = "room")
    @JsonIgnore
    @JsonIgnoreProperties(ignoreUnknown = true)
    private List<Camera> cameras;
}
