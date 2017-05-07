package com.omisoft.basic_java.XML.Task2.SAX;

/**
 * Common class with getters and setters which contains all the attributes from the Duties_Additional table
 * @author bkoprinski
 *
 */
public class DutiesAdditional {
    
    /**
     * @return the nameDoctor
     */
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
    public float getPayCheck() {
        return payCheck;
    }
    /**
     * @param payCheck the payCheck to set
     */
    public void setPayCheck(float payCheck) {
        this.payCheck = payCheck;
    }
    /**
     * @return the idNumber
     */
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
     * @return the experience
     */
    public int getExperience() {
        return experience;
    }
    /**
     * @param experience the experience to set
     */
    public void setExperience(int experience) {
        this.experience = experience;
    }
    /**
     * @return the bonus
     */
    public float getBonus() {
        return bonus;
    }
    /**
     * @param bonus the bonus to set
     */
    public void setBonus(float bonus) {
        this.bonus = bonus;
    }
    /**
     * @return the daysOff
     */
    public int getDaysOff() {
        return daysOff;
    }
    /**
     * @param daysOff the daysOff to set
     */
    public void setDaysOff(int daysOff) {
        this.daysOff = daysOff;
    }
    /**
     * @return the infoNumber
     */
    public int getInfoNumber() {
        return infoNumber;
    }
    /**
     * @param infoNumber the infoNumber to set
     */
    public void setInfoNumber(int infoNumber) {
        this.infoNumber = infoNumber;
    }
    private String nameDoctor;
    private String workingPosition;
    private String education;
    private float payCheck;
    private int idNumber;
    private int dutieNumber;
    private int experience;
    private float bonus;
    private int daysOff;
    private int infoNumber;
    
    
    /* (non-Javadoc)
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() 
    {
	return "Doctor Name : " + this.nameDoctor + " WorkingPosition - " + this.workingPosition + " Education - " + this.education 
		+ " PayCheck - " + this.payCheck + " IdNumber - " + this.idNumber + " DutieNumber - " + this.dutieNumber
		+ "\nExperience : " + this.experience + " Bonus - " + this.bonus + " DaysOff - " + this.daysOff + " InfoNumber - " + this.infoNumber
		+"\n-------------------------------------------------------------------------------------------------------------------------------------";
    }
}
