package GUI;

import java.awt.Dimension;
import java.util.ArrayList;

import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

//Okno s³u¿¹ce do zmiany parametrów w¹tków
public class RamkaWatkow extends JFrame
{
	private static ArrayList<PanelWatku> lista = new ArrayList<>();
	private JPanel p = new JPanel();
	
	
	public RamkaWatkow(Ramka r)
	{
		super("Wizualizacja");
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setMinimumSize(new Dimension(400, 640));
		p.setLayout(new BoxLayout(p, BoxLayout.Y_AXIS));
		setLocation(r.getWidth(), 0);
		for(int i=0; i<lista.size(); i++)
		{
			p.add(lista.get(i));
		}
		getContentPane().add(new JScrollPane(p));
	}
	
	public static void listaAdd(int i)
	{
		lista.add(new PanelWatku(i));
	}

	public void listaClear()
	{
		lista.clear();
	}
	
}
