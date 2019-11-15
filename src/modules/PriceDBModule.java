package modules;
import managers.PriceDBManager;

public class PriceDBModule {
	
	private String temp;
	
	public PriceDBModule(String temp)
	{
		this.temp=temp;
	}
	
	public void callManager()
	{
		PriceDBManager manager = new PriceDBManager();
		
	}
	
}
