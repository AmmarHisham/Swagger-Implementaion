package webapp.domain.response;

import java.util.ArrayList;
import java.util.List;

import io.swagger.annotations.ApiModelProperty;

public class ResponseObject {
   private int count;
   private List<? extends Object> data;
   
  public ResponseObject(int count,List<? extends Object> objList){
	  this.count = count;
	  this.data = objList;
  }
  
  public ResponseObject(String errorMsg){
	  List<String> errorList = new ArrayList<String>();
	  errorList.add(errorMsg);
	  this.data = errorList; 
  }
  
public ResponseObject() {
	// TODO Auto-generated constructor stub
}
/**
 * @return the count
 */
@ApiModelProperty(notes = "Size of data for passed parameters", required = false)
public int getCount() {
	return count;
}
/**
 * @param count the count to set
 */
public void setCount(int count) {
	this.count = count;
}
/**
 * @return the data
 */
@ApiModelProperty(notes = "List of actual data for passed parameters", required = false)
public List<? extends Object> getData() {
	return data;
}
/**
 * @param data the data to set
 */
public void setData(List<? extends Object> data) {
	this.data = data;
}

   
}
