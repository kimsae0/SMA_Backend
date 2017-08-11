package com.eightlegged.smabackend.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.eightlegged.smabackend.entity.Meeting;
import com.eightlegged.smabackend.repository.MeetingRepository;
import com.eightlegged.smabackend.service.MeetingService;


/**
 * @author Kim Sae-Young(heehouse1@gmail.com)
 *
 * @FileName MeetingController.java
 * @Project smabackend
 * @Date 2017. 8. 5.
 */

@RestController
public class MeetingController {
	
	@Autowired
	MeetingService meetingservice;
	
	@Autowired
	MeetingRepository meetingrepository;
	
	@RequestMapping(
			value="/meeting/add", method=RequestMethod.POST,
			consumes= {MediaType.APPLICATION_JSON_VALUE},
			produces= {MediaType.APPLICATION_JSON_VALUE})
	public String createmeeting(@RequestBody Meeting meeting){
		return meetingservice.createMeeting(meeting);
	}
	
	@RequestMapping(
			value="/meeting", method=RequestMethod.GET,
			produces= {MediaType.APPLICATION_JSON_VALUE})
	public List<Meeting> meetinginfo(){
		return meetingrepository.findAll();
	}
	
	@RequestMapping(
			value="/meeting/delete/{id}", method=RequestMethod.DELETE)
	public String deletemeeting(@PathVariable Long id) {
		return meetingservice.deleteMeetingById(id);
	}
	
	@RequestMapping(
			value="/meeting/start", method=RequestMethod.POST,
			consumes= {MediaType.APPLICATION_JSON_VALUE},
			produces= {MediaType.APPLICATION_JSON_VALUE})
	public String startmeeting(@RequestBody Long id) {
		return meetingservice.startMeeting(id);
	}
	
	@RequestMapping(
			value="/meeting/end", method=RequestMethod.POST,
			consumes= {MediaType.APPLICATION_JSON_VALUE},
			produces= {MediaType.APPLICATION_JSON_VALUE})
	public String completemeeting(@RequestBody Long id) {
		return meetingservice.completeMeeting(id);
	}

}
