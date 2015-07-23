package com.finalTry.springservice.domain;

public class JsonMovieTicket {

	private String theatre;
	private String seat;
	private String showTime;
	private String showDate;
	private String movie;

	public void setTheatre(String theatre) {
		this.theatre = theatre;
	}

	public String getTheatre() {
		return theatre;
	}

	public void setSeat(String seat) {
		this.seat = seat;
	}

	public String getSeat() {
		return seat;
	}

	public void setShowTime(String showTime) {
		this.showTime = showTime;
	}

	public String getShowTime() {
		return showTime;
	}

	public void setDate(String showDate) {
		this.showDate = showDate;
	}

	public String getDate() {
		return showDate;
	}

	public void setMovie(String movie) {
		this.movie = movie;
	}

	public String getMovie() {
		return movie;
	}

	@Override
	public String toString() {
		return "Ticket [Theatre=" + theatre + ", seat=" + seat + ", shoeTime="
				+ showTime + "]";
	}

}
