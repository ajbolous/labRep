package Model;

import java.util.Date;

import Users.Doctor;
import Users.Patient;
public class Appointment {
private Date date;
private Patient patient;
private Doctor doctor;
public Date getDate() {
	return date;
}
public void setDate(Date date) {
	this.date = date;
}
public Patient getPatient() {
	return patient;
}
public void setPatient(Patient patient) {
	this.patient = patient;
}
public Doctor getDoctor() {
	return doctor;
}
public void setDoctor(Doctor doctor) {
	this.doctor = doctor;
}

}
