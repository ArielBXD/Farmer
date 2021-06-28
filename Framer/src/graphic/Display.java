package graphic;

import java.awt.Canvas;
import java.awt.Dimension;

import javax.swing.JFrame;

public class Display extends JFrame {
	private Canvas canvas;
	private String title;
	private int width;
	private int height;

	public Display(String title, int width, int height) {
		this.title = title;
		this.width = width;
		this.height = height;

		createDisplay();
	}

	private void createDisplay() {
		setTitle(title);
		setSize(width, height);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setResizable(false);
		setLocationRelativeTo(null);
		setUndecorated(true);
		setExtendedState(JFrame.MAXIMIZED_BOTH);
		setVisible(true);

		canvas = new Canvas();
		canvas.setPreferredSize(new Dimension(getWidth(), getHeight()));
		canvas.setMaximumSize(new Dimension(getWidth(), getHeight()));
		canvas.setMinimumSize(new Dimension(getWidth(), getHeight()));
		canvas.setFocusable(true);

		add(canvas);
		pack();

	}

	public Canvas GetCanvas() {
		return canvas;
	}

}
