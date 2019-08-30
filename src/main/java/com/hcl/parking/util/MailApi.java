package com.hcl.parking.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;

import org.springframework.stereotype.Component;

/**
 * Class to generate send mail
 * 
 * @author 5180858
 *
 */

@Component
public class MailApi {
	@Autowired
	private JavaMailSender mailSender;

	/**
	 * Method to send mail
	 * 
	 * @param mailId
	 * @param allocationNumber
	 * @param slotNumber
	 */
	public void sendMail(String mailId,int slotNumber) {
		String message2 = "Your parking slot booking is successful!!! Parking Slot Number is " + slotNumber;
		SimpleMailMessage mail = new SimpleMailMessage();
		mail.setFrom("sai555977charan@gmail.com");
		mail.setSubject("Your Parking Slot Details");
		mail.setTo(mailId);
		mail.setText(message2);
		mailSender.send(mail);
	}
}