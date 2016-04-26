package Model;

import java.util.Date;

public class ExaminationReferral  {
	private int id;
	private Patient patient;
	private Date time;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Patient getPatient() {
		return patient;
	}
	public void setPatient(Patient patient) {
		this.patient = patient;
	}
	public Date getTime() {
		return time;
	}
	public void setTime(Date time) {
		this.time = time;
	}
	public String getComments() {
		return comments;
	}
	public void setComments(String comments) {
		this.comments = comments;
	}
	public Labratory getLabratory() {
		return labratory;
	}
	public void setLabratory(Labratory labratory) {
		this.labratory = labratory;
	}
	private String comments;
	private Labratory labratory;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Patient getPatient() {
		return patient;
	}
	public void setPatient(Patient patient) {
		this.patient = patient;
	}
	public Date getTime() {
		return time;
	}
	public void setTime(Date time) {
		this.time = time;
	}
	public String getComments() {
		return comments;
	}
	public void setComments(String comments) {
		this.comments = comments;
	}
	public Labratory getLabratory() {
		return labratory;
	}
	public void setLabratory(Labratory labratory) {
		this.labratory = labratory;
	}
}
