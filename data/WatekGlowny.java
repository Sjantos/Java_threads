package data;

import java.awt.EventQueue;

import GUI.Ramka;

public class WatekGlowny 
{
	public static void main(String ... args)
	{
		EventQueue.invokeLater(new Runnable() {
			
			@Override
			public void run() {
				// TODO Auto-generated method stub
				Ramka okno = new Ramka();
			}
		});
	}
	
}
