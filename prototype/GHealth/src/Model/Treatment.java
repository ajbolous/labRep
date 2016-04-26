package Model;

import java.util.ArrayList;
import java.util.Date;

public class Treatment {
	private int id;
	private Date startTime;
	private Date finishTime;
	private Patient patient;
	private ArrayList<Visit> visits;
	private ArrayList<Examination> examinations;
	private String comments;
	
}
