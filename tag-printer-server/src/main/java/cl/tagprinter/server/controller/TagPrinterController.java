package cl.tagprinter.server.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import cl.tagprinter.server.queue.QueueManager;

@Controller
public class TagPrinterController {

	@Autowired
	private QueueManager queueManager;

	@RequestMapping(value = "/imprimir/{tagType}", method = RequestMethod.POST)
	public ResponseEntity<?> printTagByType(@PathVariable("tagType") String type, HttpServletRequest request) {
		final String userIpAddress = request.getRemoteAddr();
		System.out.println("Called print type: " + type + " from: " + userIpAddress);
		Long jobId = queueManager.enqueuePrintJob(type, userIpAddress);

		return new ResponseEntity<Long>(jobId, HttpStatus.CREATED);
	}

}
