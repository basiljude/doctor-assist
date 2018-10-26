package com.lxisoft.byta.web.rest;

import java.text.ParseException;
import java.time.ZonedDateTime;
import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.lxisoft.byta.service.SlotsService;

@RestController
public class Controller {
   @Autowired
	SlotsService service;

	/*@RequestMapping("/admin")
	public void save(Slotes slote) {

		servic.save(slote);

	}


	
	*/
	
	

	@RequestMapping("/createSlote")
	public String createSlotes(@DateTimeFormat(pattern="hh:mm:ss") @RequestParam Date fromTime,@DateTimeFormat(pattern="hh:mm:ss") @RequestParam Date endTime,@RequestParam int sloteIntervell) throws ParseException
	{
		
		
		 /* System.out.println("#################################"+fromTime);
		    System.out.println("#################################"+endTime);*/
		service.createSlot(fromTime,endTime,sloteIntervell);
		/*Date fromTim1=null;
		Date endTim2=null;
	    Calendar c = Calendar.getInstance();
	    
	    
	    c.setTime(fromTime);
	    System.out.println("#################################"+fromTime);
	    System.out.println("#################################"+endTime);
	    
	    System.out.println(c.getTime().before(endTime)+"#####################################");
	    
		while (c.getTime().before(endTime)) {
		    c.add(Calendar.MINUTE, sloteIntervell);
		 	endTim2=c.getTime();
		 	fromTim1=new Date((c.getTime().getTime())-(sloteIntervell*60000));
		 	Slotes slote=new Slotes(fromTim1,endTim2);
		 	servic.save(slote);

		 	
		}*/
		
		
		
	
		
		return "success";
		
		
		
	}
		
		
		
		
	
		
		
		
	}
	




