package com.cg.fms.model;

import java.io.Serializable;
import java.time.LocalTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;



//This will Create a Schedule
@Entity
@Table(name = "Schedule")
public class Schedule implements Serializable {

    @Id
	public int ScheduleId;

	@ManyToOne
	@JoinColumn(name = "SourceAirportCode", referencedColumnName = "AirportCode")
	public Airport sourceAirport;

	@ManyToOne
	@JoinColumn(name = "DestAirportCode", referencedColumnName = "AirportCode")
	public Airport destinationAirport;

	
	public LocalTime ArrivalTime;
	
	
	public LocalTime DepartureTime;

	@JoinColumn(name = "flight", referencedColumnName = "FlightNumber")
	@ManyToOne(optional = false)
	Flight flight;

	@Column(length=10)
	int availableSeats;

	@Column(length=10)
	int ticketCost;
	


	
	public int getTicketCost() {
		return ticketCost;
	}

	public void setTicketCost(int ticketCost) {
		this.ticketCost = ticketCost;
	}

	public Schedule() {
	}

	public Schedule(int ScheduledId) {

		this.ScheduleId = ScheduleId;

	}

	public Schedule(int ScheduleId, Airport sourceAirport, Airport destinationAirport,LocalTime ArrivalTime,
			LocalTime DepartureTime, Flight flight, int availableSeats, int ticketCost) {

		this.ScheduleId = ScheduleId;
		this.sourceAirport = sourceAirport;
		this.destinationAirport = destinationAirport;

		this.ArrivalTime = ArrivalTime;
		this.DepartureTime = DepartureTime;
		this.flight = flight;
		this.availableSeats = availableSeats;
		this.ticketCost = ticketCost;

	}

	public Flight getFlight() {
		return flight;
	}

	public void setFlight(Flight flight) {
		this.flight = flight;
	}

	public int getAvailableSeats() {
		return availableSeats;
	}

	public void setAvailableSeats(int availableSeats) {
		this.availableSeats = availableSeats;
	}

	public int getScheduleId() {
		return ScheduleId;
	}

	public void setScheduleId(int scheduleId) {
		this.ScheduleId = scheduleId;
	}

	public Airport getSourceAirport() {
		return sourceAirport;
	}

	public void setSourceAirport(Airport sourceAirport) {
		this.sourceAirport = sourceAirport;
	}

	public Airport getDestinationAirport() {
		return destinationAirport;
	}

	public void setDestinationAirport(Airport destinationAirport) {
		this.destinationAirport = destinationAirport;
	}

	public LocalTime getArrivalTime() {
		return ArrivalTime;
	}

	public void setArrivalTime(LocalTime arrivalTime) {
		this.ArrivalTime = arrivalTime;
	}

	public LocalTime getDepartureTime() {
		return DepartureTime;
	}

	public void setDepartureTime(LocalTime departureTime) {
		this.DepartureTime = departureTime;
	}

}
