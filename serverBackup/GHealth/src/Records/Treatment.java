package Records;

import java.util.ArrayList;
import java.util.Date;

import Users.Patient;

public class Treatment {
	private int id;
	private Date startTime;
	private Date finishTime;
	private Patient patient;
	private ArrayList<Visit> visits;
	private ArrayList<Examination> examinations;
	private String comments;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Date getStartTime() {
		return startTime;
	}
	public void setStartTime(Date startTime) {
		this.startTime = startTime;
	}
	public Date getFinishTime() {
		return finishTime;
	}
	public void setFinishTime(Date finishTime) {
		this.finishTime = finishTime;
	}
	public Patient getPatient() {
		return patient;
	}
	public void setPatient(Patient patient) {
		this.patient = patient;
	}
	public String getComments() {
		return comments;
	}
	public void setComments(String comments) {
		this.comments = comments;
	}
	public ArrayList<Visit> getVisits() {
		return visits;
	}
	public void setVisits(ArrayList<Visit> visits) {
		this.visits = visits;
	}
	public ArrayList<Examination> getExaminations() {
		return examinations;
	}
	public void setExaminations(ArrayList<Examination> examinations) {
		this.examinations = examinations;
	}
	
}
