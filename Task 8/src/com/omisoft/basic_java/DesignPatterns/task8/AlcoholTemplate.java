package com.omisoft.basic_java.DesignPatterns.task8;

public abstract class AlcoholTemplate {

    /**
     * Creating template method
     */
    public final void makeAlcohol()
    {
	distilation();
	aging();
	bottling();
	exporting();
	System.out.println("This alcohol is made.");
    }

    /**
     * Default implementation
     */
    private void exporting() 
    {
	System.out.println("This alcohol is exported in Europe.");
    }

    /**
     * Default implementation
     */
    private void bottling() 
    {
	System.out.println("This alcohol is poured in glass bottles.");	
    }
    
    /**
     * Methods implemented by the subclasses
     */
    public abstract void distilation();
    public abstract void aging();
    
}
