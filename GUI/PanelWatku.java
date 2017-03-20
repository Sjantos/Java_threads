package GUI;

import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

//Panel opisuj¹cy w¹tek, podaje informacje oraz daje mo¿liwoœæ zmiany parametrów za pomoc¹ suwaków
//pierwszy suwak jest od prêdkoœci, drugi od czasu uœpienia

public class PanelWatku extends JPanel 
{
	public PanelWatku(int numer)
	{
		super();
		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		
		add(new JLabel(DrawPanel.getListaWatkow().get(numer).getname()));
		JLabel s = new JLabel("Lag "+DrawPanel.getListaWatkow().get(numer).getSleeptime());
		add(s);
		JLabel p = new JLabel("Prêdkosæ "+DrawPanel.getListaWatkow().get(numer).getPredkosc());
		add(p);
		JSlider ps = new JSlider(2, 402, (int)(1/DrawPanel.getListaWatkow().get(numer).getPredkosc()*Math.PI));
		ps.setMajorTickSpacing(100);
		ps.setMinorTickSpacing(40);
		ps.setPaintTicks(true);
		ps.setPaintLabels(true);
		ps.addChangeListener(new ChangeListener() 
		{	
			@Override
			public void stateChanged(ChangeEvent e) {
				// TODO Auto-generated method stub
				DrawPanel.getListaWatkow().get(numer).setPredkosc(Math.PI/(404-ps.getValue()));
				p.setText(""+Math.PI/(404-ps.getValue()));
				validate();
			}
		});
		add(ps);
		
		JSlider ss = new JSlider(0, 1000, DrawPanel.getListaWatkow().get(numer).getSleeptime());
		ss.setMajorTickSpacing(100);
		ss.setMinorTickSpacing(40);
		ss.setPaintTicks(true);
		ss.setPaintLabels(true);
		ss.addChangeListener(new ChangeListener() 
		{
			
			@Override
			public void stateChanged(ChangeEvent e) {
				// TODO Auto-generated method stub
				DrawPanel.getListaWatkow().get(numer).setSleeptime(ss.getValue());
				s.setText(""+ss.getValue());
				validate();
			}
		});
		add(ss);
		
	}
}
