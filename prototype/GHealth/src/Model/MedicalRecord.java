package Model;

import java.util.ArrayList;
import java.util.Date;

public class MedicalRecord {
	
	private ArrayList<Treatment> treatments;
	private ArrayList<Examination> examinations;
	
	private Date openDate;
	private Date closeDate;	
	
	private Person person;
	private Doctor doctor;
	
	public ArrayList<Treatment> getTreatments() {
		return treatments;
	}
	
	public void setTreatments(ArrayList<Treatment> treatments) {
		this.treatments = treatments;
	}
	public ArrayList<Examination> getExaminations() {
		return examinations;
	}
	public void setExaminations(ArrayList<Examination> examinations) {
		this.examinations = examinations;
	}
	public Date getOpenDate() {
		return openDate;
	}
	public void setOpenDate(Date openDate) {
		this.openDate = openDate;
	}
	public Date getCloseDate() {
		return closeDate;
	}
	public void setCloseDate(Date closeDate) {
		this.closeDate = closeDate;
	}
	public Person getPerson() {
		return person;
	}
	public void setPerson(Person person) {
		this.person = person;
	}
	public Doctor getDoctor() {
		return doctor;
	}
	public void setDoctor(Doctor doctor) {
		this.doctor = doctor;
	}
}
