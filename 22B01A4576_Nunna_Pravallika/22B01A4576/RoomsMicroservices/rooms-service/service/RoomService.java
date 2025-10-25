package com.example.demo.service;

import com.example.demo.entity.RoomEntity;
import com.example.demo.repository.RoomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RoomService {

    @Autowired
    private RoomRepository roomRepository;

    public RoomEntity createRoom(RoomEntity room) {
        return roomRepository.save(room);
    }

    public List<RoomEntity> getAllRooms() {
        return roomRepository.findAll();
    }

    public RoomEntity getRoomById(Long id) {
        return roomRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Room not found with id " + id));
    }

    public RoomEntity updateRoom(Long id, RoomEntity roomDetails) {
        RoomEntity room = getRoomById(id);

        room.setDept(roomDetails.getDept());
        room.setCapacity(roomDetails.getCapacity());
        room.setBuildingName(roomDetails.getBuildingName());
        room.setBlock(roomDetails.getBlock());

        return roomRepository.save(room);
    }

    public void deleteRoom(Long id) {
        RoomEntity room = getRoomById(id);
        roomRepository.delete(room);
    }
}
