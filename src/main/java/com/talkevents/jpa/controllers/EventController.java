package com.talkevents.jpa.controllers;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.talkevents.jpa.dtos.SaveEventRecordDto;
import com.talkevents.jpa.entities.Event;
import com.talkevents.jpa.services.EventService;

@RestController
@RequestMapping("/event")
public class EventController {

	private final EventService eventService;
	
	public EventController(EventService eventService) {
		this.eventService = eventService;
	}
	
	@PostMapping
	public ResponseEntity<Event> saveEvent(@RequestBody SaveEventRecordDto input){
		return ResponseEntity.status(HttpStatus.CREATED).body(eventService.saveEvent(input));
	}
	
	@GetMapping
	public ResponseEntity<List<Event>> getAllEvents() {
		return ResponseEntity.ok(eventService.getAllEvents());
	}
}
