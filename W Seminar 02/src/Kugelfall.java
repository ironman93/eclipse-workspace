import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Color;
import java.awt.Graphics2D;

import javax.swing.Timer;


public class Kugelfall extends StandardAnwendung implements ActionListener{

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		starteAnwendung();
	}

	int fallpos = 10;
	double v = 0;
	final double a = 9.81;
	
	public Kugelfall() {
		super("titel", 50, 500);
		this.setBackground(Color.BLACK);
		Timer frame = new Timer(40, this);
		frame.start();
	}
	
	public int returnFallpos() {
		return fallpos;
	}
	
	@Override
	public void zeichne(Graphics2D g) {
		g.setColor(Color.GREEN);
		g.fillOval(50, fallpos, 15, 15);
		
	}
	
	@Override
	public void actionPerformed(ActionEvent arg0) {
		v = a * 0.04 + v;
		fallpos = (int)(v * 0.04 + fallpos);
		if(fallpos > 550) {
			fallpos = 10;
		}
		this.repaint();
		System.out.println(fallpos);
	}
}