package com.example.camera.services;


import com.example.camera.models.Room;
import com.example.camera.repositories.RoomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import jakarta.transaction.Transactional;

import java.util.List;

@Service
@Transactional
public class RoomService {
    private final RoomRepository roomRepository;

    @Autowired
    public RoomService(RoomRepository roomRepository) {
        this.roomRepository = roomRepository;
    }
    public Room createRoom(Room newRoom){
        return roomRepository.save(newRoom);
    }
    public List<Room> createRooms(List<Room> newRooms){
        return roomRepository.saveAll(newRooms);
    }

    public List<Room> readRooms(){
        return roomRepository.findAll();
    }

    public Room updateRoom(int id , Room newRoom){
        Room existingRoom = roomRepository.findRoomByRoomId(id);
        existingRoom.setRoomName(newRoom.getRoomName());
        return roomRepository.save(newRoom);
    }

    public Room deleteRoom(int id){
        Room existingRoom = roomRepository.findById((long)id).orElseThrow(()-> new IllegalArgumentException("Room not found"));
        roomRepository.deleteById((long)id);
        return existingRoom;
    }
}
