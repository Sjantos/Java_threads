package data;

import GUI.DrawPanel;

//Stworzy³em osobn¹ kalsê, której obiekty bêde przekazywaæ do Thread,
//Jest to trochê trudniejsze rozwi¹zanie, ale za to uniwersalne, wiêc chcia³em tego u¿yæ
//W¹tek zmienia wspó³rz¹dne obiektów Circle, które s¹ wyliczane na podstawie k¹tów
//Poruszanie siê okrêgów polega na zwiêkszaniu k¹ta
//Ka¿dy w¹tek ma swoje ko³o

public class Watek implements Runnable
{
	private double predkosc = Math.PI/100;
	private static DrawPanel panel=null;
	
	private String name="";
	private int sleeptime=200;
	
	private double cX=300, cY=300, R=200;// Zmienne opisuj¹ce okr¹g po którym poruszaj¹ siê ko³a
	private double x=cX+R*Math.cos(2*Math.PI), y=cY+R*Math.sin(2*Math.PI);
	private double kat=0.0;
	
	private int numer=0;
	
	public Watek(int i1)
	{
		numer=i1;
		name="W "+numer;
	}
	
	public static void przypisz(DrawPanel p)
	{
		panel=p.getDrawPanel();
	}
	
	public String getName() { return name; }
	public int getNumer() { return numer; }
	public int getSleeptime() { return sleeptime; }
	public double getPredkosc() { return predkosc; }
	public Watek getWatek() { return this; }
	public void setSleeptime(int l) { sleeptime=l; }
	public void setPredkosc(double l) { predkosc=l; }

	@Override
	public void run() {
		// TODO Auto-generated method stub
			while(true)
			{
				try 
				{
//					System.out.println(name+"   "+predkosc);
					panel.change(predkosc, numer);
					MyThread.sleep(sleeptime);
				}catch (Exception e) {
					// TODO: handle exception
					System.out.println("Koniec w¹tku");
//					System.out.println(e.toString());
					break;
				}
			}
		}
}
