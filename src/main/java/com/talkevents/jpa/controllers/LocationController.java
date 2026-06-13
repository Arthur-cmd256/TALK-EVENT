package com.talkevents.jpa.controllers;

import java.util.List;
import java.util.UUID;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.talkevents.jpa.dtos.SaveLocationRecordDto;
import com.talkevents.jpa.dtos.UpdateLocationRecordDto;
import com.talkevents.jpa.entities.Location;
import com.talkevents.jpa.services.LocationService;

@RestController
@RequestMapping("/location")
public class LocationController {

    private final LocationService locationService;

    public LocationController(LocationService locationService) {
        this.locationService = locationService;
    }

    @PostMapping
    public ResponseEntity<Location> saveLocation(@RequestBody SaveLocationRecordDto input) {
        return ResponseEntity.status(HttpStatus.CREATED).body(locationService.saveLocation(input));
    }

    @PutMapping
    public ResponseEntity<Void> updateLocation(@RequestBody UpdateLocationRecordDto input) {
        locationService.updateLocation(input);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteLocation(@PathVariable UUID id) {
        locationService.deleteLocation(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping
    public ResponseEntity<List<Location>> getAllLocations() {
        return ResponseEntity.ok(locationService.getAllLocations());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Location> getLocationById(@PathVariable UUID id) {
        return ResponseEntity.ok(locationService.getLocation(id));
    }
}
