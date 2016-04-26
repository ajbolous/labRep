package Model;
import java.io.Serializable;
public class Report implements Serializable {
	
	private int rNum;
	private Date date;
	private String name;

	public Report(int rNum,String date)
	{
		this.rNum=rNum;
		this.date=date;
	}
	public int getRNum()
	{
	return rNum;
	}
	public String getDate(){
		return date;
	}
	public void setRNum(int rNum) {
		this.rNum = rNum;
	}
	public void setDate(String date) {
		this.date= date;
	}
	public String toString() {
		return String.format("<Report %d, date %s>", rNum, date);
	}



}
