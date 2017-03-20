package data;

import GUI.DrawPanel;

//Stworzy�em osobn� kals�, kt�rej obiekty b�de przekazywa� do Thread,
//Jest to troch� trudniejsze rozwi�zanie, ale za to uniwersalne, wi�c chcia�em tego u�y�
//W�tek zmienia wsp�rz�dne obiekt�w Circle, kt�re s� wyliczane na podstawie k�t�w
//Poruszanie si� okr�g�w polega na zwi�kszaniu k�ta
//Ka�dy w�tek ma swoje ko�o

public class Watek implements Runnable
{
	private double predkosc = Math.PI/100;
	private static DrawPanel panel=null;
	
	private String name="";
	private int sleeptime=200;
	
	private double cX=300, cY=300, R=200;// Zmienne opisuj�ce okr�g po kt�rym poruszaj� si� ko�a
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
					System.out.println("Koniec w�tku");
//					System.out.println(e.toString());
					break;
				}
			}
		}
}
