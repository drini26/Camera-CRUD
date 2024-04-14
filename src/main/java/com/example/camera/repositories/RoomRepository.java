package com.example.camera.repositories;


import com.example.camera.models.Room;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoomRepository extends JpaRepository<Room, Long> {
    Room findRoomByRoomId(int roomId);
}
