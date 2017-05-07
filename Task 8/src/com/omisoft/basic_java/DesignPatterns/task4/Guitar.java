package com.omisoft.basic_java.DesignPatterns.task4;

/**
 * Creates a value object
 * @author bkoprinski
 *
 */
public class Guitar {
    private String model;
    private String postModel;
    private int serialNumber;
    private float price;
    
    /**
     * Constructor
     * @param model
     * @param postModel
     * @param price
     */
    public Guitar(String model, String postModel, float price)
    {
	this.setModel(model);
	this.setPostModel(postModel);
	this.setPrice(price);
    }

    /**
     * @return the postModel
     */
    public String getPostModel() {
	return postModel;
    }

    /**
     * @param postModel the postModel to set
     */
    public void setPostModel(String postModel) {
	this.postModel = postModel;
    }

    /**
     * @return the model
     */
    public String getModel() {
	return model;
    }

    /**
     * @param model the model to set
     */
    public void setModel(String model) {
	this.model = model;
    }

    /**
     * @return the serialNumber
     */
    public int getSerialNumber() {
	return serialNumber;
    }

    /**
     * @param serialNumber the serialNumber to set
     */
    public void setSerialNumber(int serialNumber) {
	this.serialNumber = serialNumber;
    }

    /**
     * @return the price
     */
    public float getPrice() {
	return price;
    }

    /**
     * @param price the price to set
     */
    public void setPrice(float price) {
	this.price = price;
    }
}
