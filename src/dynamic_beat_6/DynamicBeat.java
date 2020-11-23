package dynamic_beat_6;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionAdapter;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class DynamicBeat extends JFrame {

	private Image screenImage;
	private Graphics screenGraphic;

	private ImageIcon exitButtonEnterImage = new ImageIcon(Main.class.getResource("../images/exitButtonEnter.png"));
	private ImageIcon exitButtonImage = new ImageIcon(Main.class.getResource("../images/exitButton.png"));
	private ImageIcon startButtonEnterImage = new ImageIcon(Main.class.getResource("../images/startButtonEnter.png"));
	private ImageIcon startButtonImage = new ImageIcon(Main.class.getResource("../images/startButton.png"));
	private ImageIcon quitButtonEnterImage = new ImageIcon(Main.class.getResource("../images/quitButtonEnter.png"));
	private ImageIcon quitButtonImage = new ImageIcon(Main.class.getResource("../images/quitButton.png"));
	private ImageIcon rightButtonEnterImage = new ImageIcon(Main.class.getResource("../images/rightButtonEnter.png"));
	private ImageIcon rightButtonImage = new ImageIcon(Main.class.getResource("../images/rightButton.png"));

	private Image titleImage = new ImageIcon(Main.class.getResource("../images/ghost Title Image.png")).getImage();
	private Image selectedImage = new ImageIcon(Main.class.getResource("../images/ghost.jpg")).getImage();
	private Image background = new ImageIcon(Main.class.getResource("../images/login.jpg")).getImage();
	private JLabel menuBar = new JLabel(new ImageIcon(Main.class.getResource("../images/menuBar.png")));

	private JButton exitButton = new JButton(exitButtonImage);
	private JButton startButton = new JButton(startButtonImage);
	private JButton quitButton = new JButton(quitButtonImage);
	private JButton rightButton = new JButton(rightButtonImage);

	private int mouseX, mouseY;

	private boolean isMainScreen = false;

	public DynamicBeat() {
		setUndecorated(true);
		setTitle("Dynamic Beat");
		setSize(Main.SCREEN_WIDTH, Main.SCREEN_HEIGHT);
		setResizable(false);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
		setBackground(new Color(0, 0, 0, 0));
		setLayout(null);

		exitButton.setBounds(1245, 0, 30, 30);
		exitButton.setBorderPainted(false);
		exitButton.setContentAreaFilled(false);
		exitButton.setFocusPainted(false);
		exitButton.addMouseListener(new MouseListener() {

			@Override
			public void mouseReleased(MouseEvent e) {

			}

			@Override
			public void mousePressed(MouseEvent e) {
				System.exit(0);

			}

			@Override
			public void mouseExited(MouseEvent e) {
				exitButton.setIcon(exitButtonEnterImage);
				exitButton.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
			}

			@Override
			public void mouseEntered(MouseEvent e) {
				exitButton.setIcon(exitButtonEnterImage);
				exitButton.setCursor(new Cursor(Cursor.HAND_CURSOR));

			}

			@Override
			public void mouseClicked(MouseEvent e) {

			}
		});

		add(exitButton);

		startButton.setBounds(850, 430, 400, 80);
		startButton.setBorderPainted(false);
		startButton.setContentAreaFilled(false);
		startButton.setFocusPainted(false);
		startButton.addMouseListener(new MouseListener() {

			@Override
			public void mouseReleased(MouseEvent e) {

			}

			@Override
			public void mousePressed(MouseEvent e) {
				startButton.setVisible(false);
				quitButton.setVisible(false);
				rightButton.setVisible(true);
				background = new ImageIcon(Main.class.getResource("../images/background.jpg")).getImage();
				isMainScreen = true;
			}

			@Override
			public void mouseExited(MouseEvent e) {
				startButton.setIcon(startButtonEnterImage);
				startButton.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
			}

			@Override
			public void mouseEntered(MouseEvent e) {
				startButton.setIcon(startButtonEnterImage);
				startButton.setCursor(new Cursor(Cursor.HAND_CURSOR));

			}

			@Override
			public void mouseClicked(MouseEvent e) {

			}
		});

		add(startButton);

		quitButton.setBounds(850, 550, 400, 80);
		quitButton.setBorderPainted(false);
		quitButton.setContentAreaFilled(false);
		quitButton.setFocusPainted(false);
		quitButton.addMouseListener(new MouseListener() {

			@Override
			public void mouseReleased(MouseEvent e) {

			}

			@Override
			public void mousePressed(MouseEvent e) {
				System.exit(0);

			}

			@Override
			public void mouseExited(MouseEvent e) {
				quitButton.setIcon(quitButtonEnterImage);
				quitButton.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
			}

			@Override
			public void mouseEntered(MouseEvent e) {
				quitButton.setIcon(quitButtonEnterImage);
				quitButton.setCursor(new Cursor(Cursor.HAND_CURSOR));

			}

			@Override
			public void mouseClicked(MouseEvent e) {

			}
		});

		add(quitButton);
		rightButton.setVisible(false);
		rightButton.setBounds(1000, 600, 60, 60);
		rightButton.setBorderPainted(false);
		rightButton.setContentAreaFilled(false);
		rightButton.setFocusPainted(false);
		rightButton.addMouseListener(new MouseListener() {

			@Override
			public void mouseReleased(MouseEvent e) {

			}

			@Override
			public void mousePressed(MouseEvent e) {
				// 오른쪽 버튼

			}

			@Override
			public void mouseExited(MouseEvent e) {
				rightButton.setIcon(rightButtonEnterImage);
				rightButton.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
			}

			@Override
			public void mouseEntered(MouseEvent e) {
				rightButton.setIcon(rightButtonEnterImage);
				rightButton.setCursor(new Cursor(Cursor.HAND_CURSOR));

			}

			@Override
			public void mouseClicked(MouseEvent e) {

			}
		});

		add(rightButton);

		menuBar.setBounds(0, 0, 1280, 29);
		menuBar.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				mouseX = e.getX();
				mouseY = e.getY();
			}
		});
		menuBar.addMouseMotionListener(new MouseMotionAdapter() {
			@Override
			public void mouseDragged(MouseEvent e) {
				int x = e.getXOnScreen();
				int y = e.getYOnScreen();
				setLocation(x - mouseX, y - mouseY);
			}
		});
		add(menuBar);

		Music introMusic = new Music("intromusic.mp3", true);
		introMusic.start();

	}

	public void paint(Graphics g) {
		screenImage = createImage(Main.SCREEN_WIDTH, Main.SCREEN_HEIGHT);
		screenGraphic = screenImage.getGraphics();
		screenDraw(screenGraphic);
		g.drawImage(screenImage, 0, 0, null);

	}

	public void screenDraw(Graphics g) {
		g.drawImage(background, 0, 0, null);
		if (isMainScreen) {
			g.drawImage(selectedImage, 100, 200, null);
			g.drawImage(titleImage, 100, 0, null);
		}
		paintComponents(g);
		this.repaint();
	}

}
