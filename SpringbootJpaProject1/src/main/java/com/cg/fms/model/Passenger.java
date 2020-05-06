package com.cg.fms.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
//this will create a Passenger
@Entity
@Table(name="Passenger")
public class Passenger implements Serializable {
	
	          @Id
	          long pnrNumber;
	          String passengerName;
	          int passengerAge;
	          double luggage;
	          
	          
			public long getPnrNumber() {
				return pnrNumber;
			}
			public void setPnrNumber(long pnrNumber) {
				this.pnrNumber = pnrNumber;
			}
			public String getPassengerName() {
				return passengerName;
			}
			public void setPassengerName(String passengerName) {
				this.passengerName = passengerName;
			}
			public int getPassengerAge() {
				return passengerAge;
			}
			public void setPassengerAge(int passengerAge) {
				this.passengerAge = passengerAge;
			}
			public double getLuggage() {
				return luggage;
			}
			public void setLuggage(double luggage) {
				this.luggage = luggage;
			}
	          
	          
	      

}

