package com.crm.conference.room.management.service;

import com.crm.conference.room.management.entity.Building;
import com.crm.conference.room.management.entity.ConferenceRoom;
import com.crm.conference.room.management.repository.BuildingRepo;
import com.crm.conference.room.management.repository.ConferenceRoomRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BuildingServiceImpl implements BuildingService{

    @Autowired
    private ConferenceRoomRepo conferenceRoomRepo;

    @Autowired
    private BuildingRepo buildingRepo;

    @Override
    public List<ConferenceRoom> findConferenceRoomByBuilding(String buildingName, String available) {
        Building buildingObj = buildingRepo.findRoomsByBuildingName(buildingName);
        List<ConferenceRoom> availableRoomList = buildingObj.getConferenceRoom();
        conferenceRoomRepo.findRoomsByStatus(available);
        return null;

    }
}
