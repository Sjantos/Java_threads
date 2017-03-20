package GUI;

import javax.swing.JPanel;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.Ellipse2D;
import java.util.ArrayList;
import javax.swing.Timer;

import data.Circle;
import data.MyThread;
import data.Watek;

//Kiedy szybko latajace kolo musi poczekac to czeka ale siê przesuwa o drobne kroki

public class DrawPanel extends JPanel implements ActionListener
{
	Timer t = new Timer(100, this);
	private JPanel panel;
	private double cX=300, cY=300, R=200;
	private double x=cX+R*Math.cos(2*Math.PI), y=cY+R*Math.sin(2*Math.PI);
	private double kat=0.0;
	private static int n=0;
	private boolean first=true;
	
//	Listy aktualnie istniej¹cych w¹tków i reprezentujacych ich okrêgów
	private static ArrayList<Circle> lista = new ArrayList<>();
	private static ArrayList<MyThread> listaWatkow = new ArrayList<>();
	
	public DrawPanel()
	{
		JPanel panel = new JPanel(null);		
		t.start();
		Watek.przypisz(this);
	}
	
	public static void add()
	{
		n++;
	}
	
	public static void remove()
	{
		if(n>0) n--;
	}
	
	public static ArrayList<Circle> getLista() { return lista; }
	public static ArrayList<MyThread> getListaWatkow() { return listaWatkow; }
	public DrawPanel getDrawPanel() { return this; }
	
	protected void paintComponent(Graphics g)
	{
		super.paintComponent(g);
		Graphics2D g2d=(Graphics2D) g;
		
		for(int i=0; i<n; i++)
		{
			g2d.draw(new Ellipse2D.Double(lista.get(i).getX(), lista.get(i).getY(), lista.get(i).getR(), lista.get(i).getR()));
			g2d.drawString(lista.get(i).getNumer(), (int)(lista.get(i).getX()+lista.get(i).getR()/4), (int)(lista.get(i).getY()+2*lista.get(i).getR()/3));
		}
	}
	
	public JPanel getPanel()
	{
		return panel;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
//		Odœwie¿anie rysunku zgodnie z timerem
		repaint();
	}
	
//	Metoda zmieniaj¹ca wspo³rzêdne okrêgów, wywo³uje metodê sprawdzaj¹c¹
	public synchronized void change(double predkosc, int i)
	{
		if(sprawdz(predkosc, i))
		{
			lista.get(i).setKat(lista.get(i).getKat()+predkosc);
			lista.get(i).setX(x=cX+R*Math.cos(lista.get(i).getKat()));
			lista.get(i).setY(y=cY+R*Math.sin(lista.get(i).getKat()));
		}
	}
	
//	metoda sprawdzajaca, czy okrêgi po poruszeniu siê pokryj¹
	public synchronized boolean sprawdz(double predkosc, int i)
	{
		if(lista.size()==1) return true;
		double kat=lista.get(i).getKat()+predkosc;
		double tmpX=cX+R*Math.cos(kat);
		double tmpY=cY+R*Math.sin(kat);
		double odl;
		for(int j=0; j<lista.size(); j++)
		{
			if(j!=i)
			{
				odl=Math.sqrt(Math.pow(lista.get(j).getX()-tmpX, 2)+Math.pow(lista.get(j).getY()-tmpY, 2));
				if(odl<20) 
					{
					try {
						wait();
					} catch (Exception e) {
						// TODO: handle exception
						System.out.println("WAIT nie pykn¹³");
					}
					
						return false;
					}
			}
		}
		notifyAll();
		return true;
	}
}
