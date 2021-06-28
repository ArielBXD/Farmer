package game;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

import gui.Button;
import gui.Launcher;
import gui.LevelFinish;

public class MouseInput implements MouseListener, MouseMotionListener{
	
	public static int x, y;
	private static final int clWidth = 208, clHeight = 118, clDisWidth = 80, clDisHeight = 43;
	private static int clX = 211, clY = 173, nextLine = 0;
	private static int bX, bY, bWidth, bHeight;
	
	public void mouseDragged(MouseEvent e) {
		
		
	}
	
	public void mouseMoved(MouseEvent e) {
		x = e.getX();
		y = e.getY();	
	}
	public void mouseClicked(MouseEvent e) {
	}
	public void mousePressed(MouseEvent e) {
		if(e.getButton() == MouseEvent.BUTTON1)
			Button.clicked = true;
	}
	
	public void mouseReleased(MouseEvent e) {
		if(e.getButton() == MouseEvent.BUTTON1)
			Button.clicked = false;
	}

	public void mouseEntered(MouseEvent e) {
		
	}
	public void mouseExited(MouseEvent e) {
		
	}
}
