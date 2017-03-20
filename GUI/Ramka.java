package GUI;

import java.awt.Dimension;
import java.awt.GridLayout;

import javax.swing.BoxLayout;
import javax.swing.JFrame;

public class Ramka extends JFrame
{
	public Ramka()
	{
		super("Wizualizacja");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setMinimumSize(new Dimension(700, 640));
		setLayout(new BoxLayout(getContentPane(), BoxLayout.X_AXIS));
		
		DrawPanel panel = new DrawPanel();
		add(panel);
		
		OptionPanel optpanel = new OptionPanel(this);
		add(optpanel);
		
		pack();
		setVisible(true);
	}
}
