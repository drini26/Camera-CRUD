package com.example.camera.services;

import com.example.camera.models.Camera;
import com.example.camera.repositories.CameraRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional
public class CameraService {
    private final CameraRepository cameraRepository;

    @Autowired
    public CameraService(CameraRepository cameraRepository) {
        this.cameraRepository = cameraRepository;
    }

    public Camera createCamera(Camera newCamera) {
        return cameraRepository.save(newCamera);
    }
    public List<Camera> createCameras(List<Camera> newCameras) {
        return cameraRepository.saveAll(newCameras);
    }
    public List<Camera> readCameras(){
        return cameraRepository.findAll();
    }
    public Camera updateCamera(int id, Camera updatedCamera){
        Camera existingCamera = cameraRepository.findById((long)id).orElseThrow(()-> new IllegalArgumentException("Camera not found"));
        existingCamera.setName(updatedCamera.getName());
        existingCamera.setModel(updatedCamera.getModel());
        existingCamera.setResolution(updatedCamera.getResolution());
        existingCamera.setIp(updatedCamera.getIp());

        return cameraRepository.save(existingCamera);
    }
    public void deleteCamera(long id){
        cameraRepository.deleteById(id);
    }
}
