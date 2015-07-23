package com.finalTry.springservice.domain;

public class JsonTrainTicket {

	private String PNR;
	private String train;
	private String DOJ;
	private String seat;
	private String DepTime;
	private String fare;
	private String source;
	private String destination;

	public void setPNR(String PNR) {
		this.PNR = PNR;
	}

	public String getPNR() {
		return PNR;
	}

	public void setTrain(String train) {
		this.train = train;
	}

	public String getTrain() {
		return train;
	}

	public void setDOJ(String DOJ) {
		this.DOJ = DOJ;
	}

	public String getDOJ() {
		return DOJ;
	}

	public void setSeat(String seat) {
		this.seat = seat;
	}

	public String getSeat() {
		return seat;
	}

	public void setDepTime(String DepTime) {
		this.DepTime = DepTime;
	}

	public String getDepTime() {
		return DepTime;
	}

	public void setFare(String fare) {
		this.fare = fare;
	}

	public String getFare() {
		return fare;
	}

	public void setSource(String source) {
		this.source = source;
	}

	public String getSource() {
		return source;
	}

	public void setDestination(String destination) {
		this.destination = destination;
	}

	public String getDestination() {
		return destination;
	}

	@Override
	public String toString() {
		return "Ticket [PNR=" + PNR + ", source=" + source + ", destination="
				+ destination + "]";
	}

}
