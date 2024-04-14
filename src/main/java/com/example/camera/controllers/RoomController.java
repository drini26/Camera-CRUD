package com.example.camera.controllers;

import com.example.camera.models.Room;
import com.example.camera.services.RoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/room/")
public class RoomController {

    private final RoomService roomService;
    @Autowired
    public RoomController(RoomService roomService){
        this.roomService=roomService;
    }

    @PostMapping("create/")
    public ResponseEntity<Room> createRoom(@RequestBody Room room){
        return ResponseEntity.ok(roomService.createRoom(room));
    }

    @PostMapping("create/rooms/")
    public ResponseEntity<List<Room>> createRooms(@RequestBody List<Room> rooms){
        return ResponseEntity.ok(roomService.createRooms(rooms));
    }

    @GetMapping("read/")
    public ResponseEntity<List<Room>> readRoom(){
        return ResponseEntity.ok(roomService.readRooms());
    }

    @PutMapping("update/{id}/")
    public ResponseEntity<Room> updateRooms(@RequestParam int id ,@RequestBody Room room){
        return ResponseEntity.ok(roomService.updateRoom(id,room));
    }

    @DeleteMapping("delete/{id}/")
    public ResponseEntity<Room> deleteRoom(@RequestParam int id){
        return ResponseEntity.ok(roomService.deleteRoom(id));
    }



}
