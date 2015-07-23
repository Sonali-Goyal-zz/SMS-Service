package com.finalTry.springservice.controller;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import org.json.JSONException;
import org.json.JSONObject;
import org.omg.CORBA.portable.InputStream;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.finalTry.springservice.dao.TicketService;
import com.finalTry.springservice.domain.JsonMovieTicket;
import com.finalTry.springservice.domain.JsonTrainTicket;
import com.google.gson.Gson;

@RestController
@RequestMapping("/service/user")
public class SpringServiceController {

	TicketService ticketService = new TicketService();
	int flag;
	String[] parts;
	String tvText = "null", json = null;
	
	@RequestMapping(value = "/{msg}", method = RequestMethod.POST, headers = "Accept=application/json")
	public @ResponseBody String userAuthenticate(@RequestBody String msg)
			throws JSONException {
		JSONObject jsonObj = new JSONObject(msg);
		String sender = jsonObj.getString("sender");
		String text = jsonObj.getString("message");

		Gson gson = new Gson();
		InputStream inputStream = null;
		File file = new File("/Applications/Mamp/htdocs/admin/test.txt");
		FileInputStream fis = null;

		try {
			fis = new FileInputStream(file);
			System.out.println(fis);
			BufferedReader reader = new BufferedReader(new InputStreamReader(
					fis));
			String line;
			flag = 1;
			while ((line = reader.readLine()) != null) {
				parts = line.split("_");
				if (parts[0].equals(sender)) {
					flag = 0;
					break;
				}

			}
			if (flag == 0) {
				JsonTrainTicket ticket = null;
				text = text.concat(".Smsregex");
				if (parts[3].equals("Train")) {
					ticket = ticketService.getTrainTicket(sender, text,
							parts[1], parts[2]);
					json = gson.toJson(ticket);
				}
				if (parts[3].equals("movie")) {

					JsonMovieTicket movieTicket = null;
					movieTicket = ticketService.getMovieTicket(sender, text,
							parts[1], parts[2]);
					json = gson.toJson(movieTicket);
					if (json.equals("{}")) {
						json = "Template might have been changed";
					}
				}

			} else {
				json = "TEMPLATE NOT AVAILABLE";
				try (PrintWriter out = new PrintWriter(new BufferedWriter(
						new FileWriter(
								"/Applications/Mamp/htdocs/admin/tryRead.txt",
								true)))) {
					out.println(sender + "_" + text);
				} catch (IOException e) {
					// exception handling left as an exercise for the reader
				}
			}

		} catch (IOException e) {
			System.out.println("====inside catch");
			e.printStackTrace();
		} finally {
			if (inputStream != null) {
				try {
					inputStream.close();
				} catch (IOException e) {
					e.printStackTrace();
				}

			}

		}
		return json;

	}

}
