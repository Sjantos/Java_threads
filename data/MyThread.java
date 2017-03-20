package data;

//Klasa Thread rozszerzona tylko po to, aby m�c edytowa� w�tki,
//by mie� dost�p do obiekt�w klasy W�tek, kiedy mam tylko tablic� obiekt�w MyThread

public class MyThread extends Thread
{
	Watek wskaznik=null;
	
	public MyThread(Watek w)
	{
		super(w);
		wskaznik=w.getWatek();
	}
	
	public String getname() { return "W"+wskaznik.getNumer(); }
	public int getSleeptime() { return wskaznik.getSleeptime(); }
	public double getPredkosc() { return wskaznik.getPredkosc(); }	
	
	public void setSleeptime(int l) 
	{ 
		wskaznik.setSleeptime(l);
	}
	public void setPredkosc(double l) 
	{ 
		wskaznik.setPredkosc(l);
	}
}
