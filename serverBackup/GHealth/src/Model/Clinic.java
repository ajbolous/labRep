package Model;

import java.util.ArrayList;

import Users.ClinicEmployee;
import Users.Labrtorian;
import Users.Manager;
import Users.Secretary;

public class Clinic extends SerializedEntity{

	private String address;
	
	private String phone;
	
	
	private ArrayList<ClinicEmployee> employees;
	private Manager manager;
	private Labrtorian labrtorian;
	private Secretary secretary;

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}
	
	
	
	
	
	
	
	
	
	
}
