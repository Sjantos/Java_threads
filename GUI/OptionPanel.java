package GUI;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JPanel;
import data.Circle;
import data.MyThread;
import data.Watek;

//Panel zawieraj¹cy opcje programu, metody dodaj i usuñ w¹tek s¹ bardzo podobne.
//Najpierw usuwaj¹ wszystkie okrêgi i w¹tki, a potem na nowo tworza i rozmieszczaj¹ odpowiedni¹ liczbê w¹tków / okrêgów
//Nastêpnie odœwie¿aj¹ zawartoœæ okna

public class OptionPanel extends JPanel
{
	RamkaWatkow rw= null;
	
	private static int n=0;
	private double cX=300, cY=300, R=200;
	public OptionPanel(Ramka r)
	{
		super();
		setMaximumSize(new Dimension(200, r.getHeight()));
		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		rw=new RamkaWatkow(r);
		
		add(Box.createVerticalGlue());
		JButton b0 = new JButton("Info");
		b0.setAlignmentX(CENTER_ALIGNMENT);
		b0.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				new RamkaInfo(r);
			}
		});
		add(b0);
		add(Box.createVerticalStrut(20));
		
		JButton b1 = new JButton("Dodaj w¹tek");
		b1.setAlignmentX(CENTER_ALIGNMENT);
		b1.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				double x=0.0, y=0.0;
				boolean okno=false;
				if(rw.isVisible()) okno=true;
				n++;
				DrawPanel.add();
				DrawPanel.getLista().clear();
				rw.listaClear();
				for(int i=0; i<n; i++)
				{
					x=cX+R*Math.cos(2*i*Math.PI/n);//+kat);
					y=cY+R*Math.sin(2*i*Math.PI/n);//+kat);
					DrawPanel.getLista().add(new Circle(x, y, 20, 2*i*Math.PI/n, i));
				}
				rw.dispose();
				DrawPanel.getListaWatkow().clear();
				for(int i=0; i<n; i++)
				{
					DrawPanel.getListaWatkow().add(new MyThread(new Watek(i)));
					DrawPanel.getListaWatkow().get(i).start();					
					rw.listaAdd(i);
				}
				rw=new RamkaWatkow(r);
				if(okno) rw.setVisible(true);
			}
		});
		add(b1);
		add(Box.createVerticalStrut(20));

		JButton b2 = new JButton("Usuñ w¹tek");
		b2.setAlignmentX(CENTER_ALIGNMENT);
		b2.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				double x=0.0, y=0.0;
				boolean okno=false;
				if(rw.isVisible()) okno=true;
				if(n>0)	n--;
				DrawPanel.remove();
				DrawPanel.getLista().clear();
				rw.listaClear();
				for(int i=0; i<n; i++)
				{
					x=cX+R*Math.cos(2*i*Math.PI/n);//+kat);
					y=cY+R*Math.sin(2*i*Math.PI/n);//+kat);
					DrawPanel.getLista().add(new Circle(x, y, 20, 2*i*Math.PI/n, i));
				}
				rw.dispose();
				DrawPanel.getListaWatkow().clear();
				for(int i=0; i<n; i++)
				{
					DrawPanel.getListaWatkow().add(new MyThread(new Watek(i)));
					DrawPanel.getListaWatkow().get(i).start();					
					rw.listaAdd(i);
				}
				rw=new RamkaWatkow(r);
				if(okno) rw.setVisible(true);

			}
		});
		add(b2);
		add(Box.createVerticalStrut(20));

		JButton b3 = new JButton("Edytuj w¹tki");
		b3.setAlignmentX(CENTER_ALIGNMENT);
		b3.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				rw.setVisible(true);
			}
		});
		add(b3);
		add(Box.createVerticalGlue());
	}
}
