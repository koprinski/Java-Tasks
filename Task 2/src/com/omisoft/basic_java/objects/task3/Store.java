package com.omisoft.basic_java.objects.task3;
/**
 * Creating main class Store
 * @author bkoprinski
 *
 */
public class Store {
	private String identNumber;
	private int count;
	/**
	 * Initialize Store
	 * @param identNumber - string for identification number
	 * @param count - int for counting
	 */
	public Store(String identNumber,int count)
	{
		this.setIdentNumber(identNumber);
		this.setCount(count);
	}
	/**
	 * Getter
	 * @return - identNumber
	 */
	public String getIdentNumber() {
		return identNumber;
	}
	/**
	 * Setter
	 * @param identNumber
	 */
	public void setIdentNumber(String identNumber) {
		this.identNumber = identNumber;
	}
	/**
	 * Getter
	 * @return - count
	 */
	public int getCount() {
		return count;
	}
	/**
	 * Setter
	 * @param count
	 */
	public void setCount(int count) {
		this.count = count;
	}

}
