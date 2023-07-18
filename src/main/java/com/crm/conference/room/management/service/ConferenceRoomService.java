package com.crm.conference.room.management.service;

import com.crm.conference.room.management.entity.ConferenceRoom;
import com.crm.conference.room.management.entity.Floor;
import com.crm.conference.room.management.repository.ConferenceRoomRepo;
import com.crm.conference.room.management.repository.FloorRepo;
import org.springframework.stereotype.Service;

@Service
public class ConferenceRoomService {

    private final ConferenceRoomRepo conferenceRoomRepository;
    private final FloorRepo floorRepository;

    public ConferenceRoomService(ConferenceRoomRepo conferenceRoomRepository, FloorRepo floorRepository) {
        this.conferenceRoomRepository = conferenceRoomRepository;
        this.floorRepository = floorRepository;
    }

    public void addConferenceRoom(String buildingName, int floorNumber, String roomId) throws Exception {
        Floor floor = floorRepository.findByBuildingAndNumber(buildingName, floorNumber);
        if (floor == null) {
            throw new Exception("Floor not found");
        }

        ConferenceRoom conferenceRoom = new ConferenceRoom();
        conferenceRoom.setRoomId(roomId);
        conferenceRoom.setFloor(floor);
        conferenceRoomRepository.save(conferenceRoom);
    }
}