package com.overtamilmatrinmony.core.mailer.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.stereotype.Service;

import com.overtamilmatrinmony.core.dto.User;
import com.overtamilmatrinmony.core.mailer.dao.MailerDao;
import com.overtamilmatrinmony.core.mailer.model.MailDetail;
import com.overtamilmatrinmony.core.model.UserModel;
import com.overtamilmatrinmony.core.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
import org.thymeleaf.context.Context;
import org.thymeleaf.spring4.SpringTemplateEngine;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.Map;

@Service("mailerService")
@PropertySource("classpath:mailer.properties")
@EnableScheduling
public class MailerServicesImpl implements MailerServices {

	@Autowired
	private MailerDao mailerDao;

	@Override
	public void triggerMailer() {
		// TODO Auto-generated method stub

	}

	@Autowired
	private JavaMailSenderImpl mailSender;
	@Autowired
	private SpringTemplateEngine templateEngine;

	public void sendWelcomeMail(MailDetail mail) throws MessagingException {
		Context context = new Context();
		// context.setVariables(mail.getModel());

		String html = templateEngine.process("email-template", context);
		MimeMessage message = mailSender.createMimeMessage();
		MimeMessageHelper helper = new MimeMessageHelper(message, MimeMessageHelper.MULTIPART_MODE_MIXED_RELATED,
				StandardCharsets.UTF_8.name());

		helper.addAttachment("logo.png", new ClassPathResource("memorynotfound-logo.png"));

		helper.setTo(mail.getTo());
		helper.setText(html, true);
		helper.setSubject(mail.getSubject());
		helper.setFrom(mailSender.getUsername());
		mailSender.send(message);
	}

	@Override
	public void sendWelcomeMail(User user) throws Exception {
		MailDetail mailDetail = new MailDetail();
		mailDetail.setUserId(user.getUserId());
		mailDetail.setUserName(user.getName() + " " + user.getUserDetail().getLName());
		mailDetail.setTo(user.getUserDetail().getEmail());
		mailDetail.setSend(true);
		mailDetail.setSubject("Test Welcome Mail after registration  from Kannan");
		mailerDao.sendWelcomeMail(mailDetail);
		 Map<String, Object> model = new HashMap<String, Object>();
	        model.put("name", user.getName()+user.getUserDetail().getLName());
	        /*model.put("location", "Belgium");
	        model.put("signature", "ht");
	        */mailDetail.setModel(model);

		sendWelcomeMail(mailDetail);
	}

}
