package com.plp.motiondetection.service;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.Response;

import org.json.simple.parser.ParseException;

import com.google.gson.JsonObject;
import com.plp.motiondetection.business.MotionBusiness;
import com.plp.motiondetection.model.Incident;

@Path("/motiondata")
public class MotionDetectionService {

	MotionBusiness motionBusiness = new MotionBusiness();
	
	@POST
	@Path("/save")
	@Consumes("application/json")
    public Response saveMotion(JsonObject motionJson) throws ParseException {
		
		System.out.println("Motion detected");
		Incident motion =  Incident.getFromJsonText(motionJson.toString());
        
        motionBusiness.save(motion);
		
        return Response.ok().build();
    }
	//curl -X POST -H "Content-Type: application/json" "http://localhost:8080/motiondata/save" -d '{"regionCoordinates" : [618, 317, 703, 493],"numberOfChanges" : 5446,"timestamp" : "1465894497","microseconds" : "5-97451","token" : 695,"pathToImage" : "1465894497_5-97451_frontdoor_618-317-703-493_5446_695.jpg","instanceName" : "frontdoor"}'
	
	@GET
	@Path("/getmotions")
	@Consumes("application/json")
    public Response getMotions(String dateFormat, String startDateIn, String endDateIn, int intervalMinutes ) throws ParseException, java.text.ParseException {
		DateFormat df = new SimpleDateFormat(dateFormat); 
	        
	    Date startDate = df.parse(startDateIn);
	    Date endDate = df.parse(endDateIn);
	        
	    //List<TimeSpacedIncident> Motions = motionBusiness.getIncidents(startDateTime, 
	    //endDateTime, spaceByMinutes, timegapIntervalLimit, postiveIncidentLimit)(startDate, endDate, intervalMinutes);

        return Response.ok().build();
    }
}
