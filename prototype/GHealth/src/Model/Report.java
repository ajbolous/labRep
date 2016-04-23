package Model;
import java.io.Serializable;
public class Report implements Serializable {
	private int id;
	private String date;
	public Report(int id,String date)
	{
		this.id=id;
		this.date=date;
	}
	public int getid()
	{
	return id;
	}
	public String getDate(){
		return date;
	}
	public void setid(int id) {
		this.id = id;
	}
	public void setDate(String date) {
		this.date= date;
	}
	public String toString() {
		return String.format("<Report %d, date %s>", id, date);
	}



}
