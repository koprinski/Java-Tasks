package com.omisoft.basic_java.XML.Task2.JAXB;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="DutiesPatients")
public class DutiesPatientsJAXB 
{
    /**
     * Default constructor
     */
    public DutiesPatientsJAXB(){}
    
    /**
     * Second constructor for JABX binding parser
     * @param nameDoctor
     */
    public DutiesPatientsJAXB(String nameDoctor)
    {
	this.nameDoctor=nameDoctor;
    }
    
    /**
     * @return the nameDoctor
     */
    @XmlElement
    public String getNameDoctor() {
        return nameDoctor;
    }
    /**
     * @param nameDoctor the nameDoctor to set
     */
    public void setNameDoctor(String nameDoctor) {
        this.nameDoctor = nameDoctor;
    }
    /**
     * @return the workingPosition
     */
    @XmlElement
    public String getWorkingPosition() {
        return workingPosition;
    }
    /**
     * @param workingPosition the workingPosition to set
     */
    public void setWorkingPosition(String workingPosition) {
        this.workingPosition = workingPosition;
    }
    /**
     * @return the education
     */
    @XmlElement
    public String getEducation() {
        return education;
    }
    /**
     * @param education the education to set
     */
    public void setEducation(String education) {
        this.education = education;
    }
    /**
     * @return the payCheck
     */
    @XmlElement
    public float getPayCheck() {
        return payCheck;
    }
    /**
     * @param f the payCheck to set
     */
    public void setPayCheck(float f) {
        this.payCheck = f;
    }
    /**
     * @return the idNumber
     */
    @XmlElement
    public int getIdNumber() {
        return idNumber;
    }
    /**
     * @param idNumber the idNumber to set
     */
    public void setIdNumber(int idNumber) {
        this.idNumber = idNumber;
    }
    /**
     * @return the dutieNumber
     */
    @XmlElement
    public int getDutieNumber() {
        return dutieNumber;
    }
    /**
     * @param dutieNumber the dutieNumber to set
     */
    public void setDutieNumber(int dutieNumber) {
        this.dutieNumber = dutieNumber;
    }
    /**
     * @return the namePatient
     */
    @XmlElement
    public String getNamePatient() {
        return namePatient;
    }
    /**
     * @param namePatient the namePatient to set
     */
    public void setNamePatient(String namePatient) {
        this.namePatient = namePatient;
    }
    /**
     * @return the age
     */
    @XmlElement
    public int getAge() {
        return age;
    }
    /**
     * @param age the age to set
     */
    public void setAge(int age) {
        this.age = age;
    }
    /**
     * @return the id
     */
    @XmlElement
    public String getId() {
        return id;
    }
    /**
     * @param id the id to set
     */
    public void setId(String id) {
        this.id = id;
    }
    private String nameDoctor;
    private String workingPosition;
    private String education;
    private float payCheck;
    private int idNumber;
    private int dutieNumber;
    private String namePatient;
    private int age;
    private String id;
 
    /* (non-Javadoc)
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString()
    {
	return "Doctor Name : " + this.nameDoctor + " WorkingPosition - " + this.workingPosition + " Education - " + this.education 
		+ " PayCheck - " + this.payCheck + " IdNumber - " + this.idNumber + " DutieNumber - " + this.dutieNumber
		+ "\nPatient Name : " + this.namePatient + " Patient Age - " + this.age + " Patient ID - " + this.id
		+"\n-------------------------------------------------------------------------------------------------------------------------------------";
    }
    
}
