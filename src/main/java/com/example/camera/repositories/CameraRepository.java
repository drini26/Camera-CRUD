package com.example.camera.repositories;

import com.example.camera.models.Camera;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository

public interface CameraRepository extends JpaRepository<Camera, Long> {
    Camera findCameraById(int id);
    List<Camera> findCameraByName(String name);
    List<Camera> findCameraByModel(String model);
    List<Camera> findCameraByResolution(int resolution);
    Camera findCameraByIp(String ip);

}
