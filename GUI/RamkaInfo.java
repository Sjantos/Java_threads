package GUI;

import java.awt.Dimension;

import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class RamkaInfo extends JFrame
{
	public RamkaInfo(Ramka r)
	{
		super("Info");
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setMinimumSize(new Dimension(400, 640));
		setLocation(r.getWidth(), 0);
		
		JTextArea text = new JTextArea();
		text.setLineWrap(true);
		text.setWrapStyleWord(true);
		String instrukcja="Program info";
		text.append(instrukcja);
		text.setEditable(false);
		
		JScrollPane scroll = new JScrollPane(text);
		add(scroll);
		
//		add(text);
		
		setVisible(true);
	}
}
