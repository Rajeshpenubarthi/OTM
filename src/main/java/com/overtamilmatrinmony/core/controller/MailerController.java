package com.overtamilmatrinmony.core.controller;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;  
import org.springframework.web.bind.annotation.RequestMethod;  
import org.springframework.web.bind.annotation.RestController;

import com.overtamilmatrinmony.core.mailer.service.MailerServices;

//@RestController
//@RequestMapping(value="mailer")
public class MailerController {

	/*@Autowired
	MailerServices mailerServices;

	static final Logger logger = Logger.getLogger(MailerController.class);

	@RequestMapping(value = "/trigger", method = RequestMethod.GET) 
	public void scheduleBatch() {
		 try {
			mailerServices.triggerMailer();
			System.out.println(" trigger : Mailer");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		return ;
	}
	
	*/
}
