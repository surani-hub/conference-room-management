package com.crm.conference.room.management.service;

import com.crm.conference.room.management.entity.ConferenceRoom;
import org.apache.catalina.LifecycleState;

import java.util.List;

public interface BuildingService {

    List<ConferenceRoom> findConferenceRoomByBuilding(String buildingName, String status);
}
