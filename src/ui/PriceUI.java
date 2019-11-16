package ui;
import manager.PriceManager;

public class PriceUI {
	
	private String temp;
	
	public PriceUI(String temp)
	{
		this.temp=temp;
	}
	
	public void callManager()
	{
		PriceManager manager = new PriceManager();
		
	}
	
}
