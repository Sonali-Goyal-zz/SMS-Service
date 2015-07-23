package com.finalTry.springservice.dao;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.finalTry.springservice.domain.JsonMovieTicket;
import com.finalTry.springservice.domain.JsonTrainTicket;

public class TicketService {

	String totalLine = "";
	int i = 0;

	public JsonTrainTicket getTrainTicket(String sender, String message,
			String template, String order) {
		JsonTrainTicket ticket = new JsonTrainTicket();

		System.out.println("\n" + sender + "\n" + message + "\n" + template
				+ "\n" + order);
		template = template.concat(".Smsregex");
		String[] orderTerms = order.split(",");
		System.out.println("\n" + message + "\n" + template);
		Pattern pattern = Pattern.compile(template);
		Matcher matcher = pattern.matcher(message);
		i = 0;
		if (matcher.find()) {
			while (i < orderTerms.length) {
				System.out.println("\n value of i is " + i + " order term is "
						+ orderTerms[i]);
				System.out.println("\n value of match group "
						+ matcher.group(i));

				if (orderTerms[i].equalsIgnoreCase("PNR")) {
					ticket.setPNR(matcher.group(i + 1));
				} else if (orderTerms[i].equalsIgnoreCase("Train")) {
					ticket.setTrain(matcher.group(i + 1));
				} else if (orderTerms[i].equalsIgnoreCase("DOJ")) {
					ticket.setDOJ(matcher.group(i + 1));
				} else if (orderTerms[i].equalsIgnoreCase("Seat")) {
					ticket.setSeat(matcher.group(i + 1));
				} else if (orderTerms[i].equalsIgnoreCase("From")) {
					ticket.setSource(matcher.group(i + 1));
				} else if (orderTerms[i].equalsIgnoreCase("To")) {
					ticket.setDestination(matcher.group(i + 1));
				} else if (orderTerms[i].equalsIgnoreCase("DepTime")) {
					ticket.setDepTime(matcher.group(i + 1));
				} else if (orderTerms[i].equalsIgnoreCase("Fare")) {
					ticket.setFare(matcher.group(i + 1));
				}

				i++;
			}

		}

		return ticket;

	}

	public JsonMovieTicket getMovieTicket(String sender, String message,
			String template, String order) {
		JsonMovieTicket ticket = new JsonMovieTicket();

		System.out.println("\n" + sender + "\n" + message + "\n" + template
				+ "\n" + order);
		template = template.concat(".Smsregex");
		String[] orderTerms = order.split(",");
		System.out.println("\n" + message + "\n" + template);
		Pattern pattern = Pattern.compile(template);
		Matcher matcher = pattern.matcher(message);
		i = 0;
		if (matcher.find()) {
			while (i < orderTerms.length) {
				System.out.println("\n value of i is " + i + " order term is "
						+ orderTerms[i]);
				System.out.println("\n value of match group "
						+ matcher.group(i));
				if (orderTerms[i].equalsIgnoreCase("theatre")) {
					ticket.setTheatre(matcher.group(i + 1));
				} else if (orderTerms[i].equalsIgnoreCase("seat")) {
					ticket.setSeat(matcher.group(i + 1));
				} else if (orderTerms[i].equalsIgnoreCase("showTime")) {
					ticket.setShowTime(matcher.group(i + 1));
				} else if (orderTerms[i].equalsIgnoreCase("Seat")) {
					ticket.setSeat(matcher.group(i + 1));
				} else if (orderTerms[i].equalsIgnoreCase("showDate")) {
					ticket.setDate(matcher.group(i + 1));
				} else if (orderTerms[i].equalsIgnoreCase("movie")) {
					ticket.setMovie(matcher.group(i + 1));
				}

				i++;
			}

		}

		return ticket;

	}

}
