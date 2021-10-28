import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Color;
import java.awt.Graphics2D;
import javax.swing.*;

import javax.swing.Timer;


public class Kugelfall extends StandardAnwendung implements ActionListener{

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		starteAnwendung();
	}

	int fallpos = 25;
	double t = 0;
	double v = 0;
	double dt = 0.017;
	double k = 0.5;
	double g = 9.81;
	double a = g;
	double m = 100;
	double x = 25;
	Color bg = new Color(100,100,100);
	Color ball = new Color(0,220,255);
	Timer timer = new Timer((int)(dt*1000), this);
	
	public Kugelfall() {
		super("titel", 250, 500);
		this.setBackground(bg);
		JButton startButton = new JButton("start");
		add(startButton);
		startButton.setVisible(true);
		startButton.addActionListener(this);
	}
	
	public void calcAccelaration() {
		a = g-(k/m)*v*v;
	}
	
	public void calcVelocity() {
		v = a*dt+v;
	}
	
	public void calcDistance() {
		x = v*dt+x;
	}
	
	public void fall() {
		calcAccelaration();
		calcVelocity();
		calcDistance();
		if(x > 550) {
			x = 10;
		}
		this.repaint();
		System.out.println(v);
	}
	
	@Override
	public void zeichne(Graphics2D g) {
		g.setColor(ball);
		g.fillOval(50, (int)x, 20, 20);
		
	}
	
	
	@Override
	public void actionPerformed(ActionEvent arg0) {
		timer.start();
		fall();
	}
}
