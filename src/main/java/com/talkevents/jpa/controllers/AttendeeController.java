package com.talkevents.jpa.controllers;

import java.util.List;
import java.util.UUID;

import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.talkevents.jpa.dtos.SaveAttendeeRecordDto;
import com.talkevents.jpa.dtos.UpdateAttendeeRecordDto;
import com.talkevents.jpa.entities.Attendee;
import com.talkevents.jpa.services.AttendeeService;

@RestController
@RequestMapping("/attendee")
public class AttendeeController {
	private final AttendeeService attendeeService;
	
	public AttendeeController(AttendeeService attendeeService) {
		this.attendeeService =  attendeeService;
	}
	
	@PostMapping
	public ResponseEntity<Attendee> saveAttendee(@RequestBody SaveAttendeeRecordDto input){
		return ResponseEntity.status(HttpStatus.CREATED).body(attendeeService.saveAttendee(input));
	}
	
	@PutMapping
	public ResponseEntity<Void> updateAttendee(@RequestBody UpdateAttendeeRecordDto input){
		attendeeService.updateAttendee(input);
		return ResponseEntity.noContent().build();
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deleteAttendee(@PathVariable UUID id){
		attendeeService.deleteAttendee(id);
		return ResponseEntity.noContent().build();
	}
	
	@GetMapping
	public ResponseEntity<List<Attendee>> getAllAttendees() {
		return ResponseEntity.ok(attendeeService.getAllAttendees());
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Attendee> getAttendeeById(@PathVariable UUID id){
		return ResponseEntity.ok(attendeeService.getAttendee(id));
	}
}
