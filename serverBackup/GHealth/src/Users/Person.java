package Users;

import java.io.Serializable;

import Model.SerializedEntity;

public class Person extends SerializedEntity
{
  private int id;
  private String name;
  
 

public String getName() {
	return name;
}

public void setName(String name) {
	this.name = name;
}

public int getId() {
	return id;
}

public void setId(int id) {
	this.id = id;
}
  
  
 
}
