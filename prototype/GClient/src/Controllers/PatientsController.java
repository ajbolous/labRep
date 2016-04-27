package Controllers;
import ClientUI.Application;
import Users.Patient;
import Utils.Request;
public class PatientsController
{
	public Patient getPatient(String id)
	{
		Request r=new Request("users\byId");
		r.addParam("id", id);
		Patient p=(Patient)Application.client.Request(r);
		return p;
	}
	public boolean addPatient(Patient p)
	{
		Request r=new Request("users\add");
		r.addParam("patient",p.getId(),p.getName());
	}

}
