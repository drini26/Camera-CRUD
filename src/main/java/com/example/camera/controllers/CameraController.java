package com.example.camera.controllers;

import com.example.camera.models.Camera;
import com.example.camera.services.CameraService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/camera/")
public class CameraController {
    private final CameraService cameraService;
    @Autowired
        public CameraController(CameraService cameraService){
             this.cameraService=cameraService;
        }

    @PostMapping("create/")
    public ResponseEntity<Camera> createCamera(@RequestBody Camera camera){
    Camera savedCamera= cameraService.createCamera(camera);
    return ResponseEntity.ok(savedCamera);
}
    @PostMapping("create/list/")
    public ResponseEntity<List<Camera>> createCameras(@RequestBody List<Camera> cameras){
        List<Camera> savedCameras= cameraService.createCameras(cameras);
        return ResponseEntity.ok(savedCameras);
    }
    @GetMapping("read/")
    public ResponseEntity<List<Camera>> readCamera(){
        List<Camera> cameras= cameraService.readCameras();
        return ResponseEntity.ok(cameras);
    }

    @PutMapping("update/{id}/")
    public ResponseEntity<Camera> updateCamera(@PathVariable int id ,@RequestBody Camera camera){
        Camera updatedCamera = cameraService.updateCamera(id,camera);
        return ResponseEntity.ok(updatedCamera);
    }

    @DeleteMapping("delete/{id}/")
    public void deleteCamera(@PathVariable long id){
        cameraService.deleteCamera(id);
    }

}
