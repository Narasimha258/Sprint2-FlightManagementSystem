
INSERT INTO Flight(flight_number,carrier_name,flight_model,seat_capacity) VALUES('6E 1232','Indigo','6E4499',120);
INSERT INTO Flight(flight_number,carrier_name,flight_model,seat_capacity) VALUES('6E 1210','AirAsia','6E4789',120);
INSERT INTO Flight(flight_number,carrier_name,flight_model,seat_capacity) VALUES('6E 1211','Indigo','6E4789',220);
INSERT INTO Flight(flight_number,carrier_name,flight_model,seat_capacity) VALUES('6E 1212','AirAsia','6E4789',320);

INSERT INTO Airport(airport_code,airport_location,airport_name) VALUES('VTZ','vizag','vishakapatnam airport');
INSERT INTO Airport(airport_code,airport_location,airport_name) VALUES('DEL','Delhi','Indhiragandhi airport');
INSERT INTO Airport(airport_code,airport_location,airport_name) VALUES('HYB','Hyderabad','Rajiv gandhi airport');
INSERT INTO Airport(airport_code,airport_location,airport_name) VALUES('CDP','Cuddapah','Cuddapah Airport');
INSERT INTO Airport(airport_code,airport_location,airport_name) VALUES('LUH','Ludhiana','Amritsar Airport');
INSERT INTO Airport(airport_code,airport_location,airport_name) VALUES('GWL','Gwalior','Gwalior Airport');

INSERT INTO SCHEDULE(SCHEDULE_ID,ARRIVAL_TIME,DEPARTURE_TIME,AVAILABLE_SEATS,TICKET_COST,DEST_AIRPORT_CODE,FLIGHT,SOURCE_AIRPORT_CODE) VALUES(1,to_date('09:43:00', 'hh24:mi:ss'),to_date('11:43:00', 'hh24:mi:ss'),550,5500,'DEL','6E 1232','VTZ');
INSERT INTO SCHEDULE(SCHEDULE_ID,ARRIVAL_TIME,DEPARTURE_TIME,AVAILABLE_SEATS,TICKET_COST,DEST_AIRPORT_CODE,FLIGHT,SOURCE_AIRPORT_CODE) VALUES(2,to_date('08:48:00', 'hh24:mi:ss'),to_date('10:55:00', 'hh24:mi:ss'),560,6500,'GWL','6E 1232','DEL');
INSERT INTO SCHEDULE(SCHEDULE_ID,ARRIVAL_TIME,DEPARTURE_TIME,AVAILABLE_SEATS,TICKET_COST,DEST_AIRPORT_CODE,FLIGHT,SOURCE_AIRPORT_CODE) VALUES(3,to_date('12:24:00', 'hh24:mi:ss'),to_date('14:23:00', 'hh24:mi:ss'),550,5500,'VTZ','6E 1232','HYB');
INSERT INTO SCHEDULE(SCHEDULE_ID,ARRIVAL_TIME,DEPARTURE_TIME,AVAILABLE_SEATS,TICKET_COST,DEST_AIRPORT_CODE,FLIGHT,SOURCE_AIRPORT_CODE) VALUES(4,to_date('06:13:00', 'hh24:mi:ss'),to_date('08:12:00', 'hh24:mi:ss'),550,4500,'DEL','6E 1232','HYB');
INSERT INTO SCHEDULE(SCHEDULE_ID,ARRIVAL_TIME,DEPARTURE_TIME,AVAILABLE_SEATS,TICKET_COST,DEST_AIRPORT_CODE,FLIGHT,SOURCE_AIRPORT_CODE) VALUES(5,to_date('05:28:00', 'hh24:mi:ss'),to_date('11:43:00', 'hh24:mi:ss'),550,7500,'LUH','6E 1232','HYB');
INSERT INTO SCHEDULE(SCHEDULE_ID,ARRIVAL_TIME,DEPARTURE_TIME,AVAILABLE_SEATS,TICKET_COST,DEST_AIRPORT_CODE,FLIGHT,SOURCE_AIRPORT_CODE) VALUES(6,to_date('23:43:00', 'hh24:mi:ss'),to_date('01:37:00', 'hh24:mi:ss'),550,8500,'DEL','6E 1232','CDP');
INSERT INTO SCHEDULE(SCHEDULE_ID,ARRIVAL_TIME,DEPARTURE_TIME,AVAILABLE_SEATS,TICKET_COST,DEST_AIRPORT_CODE,FLIGHT,SOURCE_AIRPORT_CODE) VALUES(7,to_date('02:43:00', 'hh24:mi:ss'),to_date('04:53:00', 'hh24:mi:ss'),550,5500,'DEL','6E 1232','LUH');