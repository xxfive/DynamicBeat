package dynamic_beat_10;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.RenderingHints;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionAdapter;
import java.util.ArrayList;

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
	private ImageIcon leftButtonEnterImage = new ImageIcon(Main.class.getResource("../images/leftButtonEnter.png"));
	private ImageIcon leftButtonImage = new ImageIcon(Main.class.getResource("../images/leftButton.png"));
	private ImageIcon rightButtonEnterImage = new ImageIcon(Main.class.getResource("../images/rightButtonEnter.png"));
	private ImageIcon rightButtonImage = new ImageIcon(Main.class.getResource("../images/rightButton.png"));
	private ImageIcon backButtonEnterImage = new ImageIcon(Main.class.getResource("../images/backButtonEnter.png"));
	private ImageIcon backButtonImage = new ImageIcon(Main.class.getResource("../images/backButton.png"));
	private ImageIcon easyButtonImage = new ImageIcon(Main.class.getResource("../images/easyButton.png"));
	private ImageIcon hardButtonImage = new ImageIcon(Main.class.getResource("../images/hardButton.png"));

	private Image gameInfoImage = new ImageIcon(Main.class.getResource("../images/gameInfo.png")).getImage();
	private Image judgementLineImage = new ImageIcon(Main.class.getResource("../images/judgementLine.png")).getImage();
	private Image noteRouteImage = new ImageIcon(Main.class.getResource("../images/noteRoute.png")).getImage();
	private Image noteRouteLineImage = new ImageIcon(Main.class.getResource("../images/noteRouteLine.png")).getImage();
	private Image noteBasicImage = new ImageIcon(Main.class.getResource("../images/noteBasic.png")).getImage();
	private Image background = new ImageIcon(Main.class.getResource("../images/login.jpg")).getImage();
	private JLabel menuBar = new JLabel(new ImageIcon(Main.class.getResource("../images/menuBar.png")));

	private JButton exitButton = new JButton(exitButtonImage);
	private JButton startButton = new JButton(startButtonImage);
	private JButton quitButton = new JButton(quitButtonImage);
	private JButton leftButton = new JButton(leftButtonImage);
	private JButton rightButton = new JButton(rightButtonImage);
	private JButton easyButton = new JButton(easyButtonImage);
	private JButton hardButton = new JButton(hardButtonImage);
	private JButton backButton = new JButton(backButtonImage);

	private int mouseX, mouseY;

	private boolean isMainScreen = false;
	private boolean isGameScreen = false;

	ArrayList<Track> trackList = new ArrayList<Track>();

	private Image titleImage;
	private Image selectedImage;
	private Music selectedMusic;
	private int nowSelected = 0;

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

		Music introMusic = new Music("intromusic.mp3", true);
		introMusic.start();

		trackList.add(
				new Track("ghost Title Image.png", "ghost.jpg", "ghost Start.jpg", "ghost Sample.mp3", "ghost.mp3"));
		trackList.add(
				new Track("canon Title Image.png", "canon.jpg", "canon Start.jpg", "canon Sample.mp3", "canon.mp3"));
		trackList.add(new Track("v3 Title Image.png", "v3.jpg", "v3 Start.jpg", "v3 Sample.mp3", "v3.mp3"));

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
				introMusic.close();
				selectTrack(0);
				startButton.setVisible(false);
				quitButton.setVisible(false);
				leftButton.setVisible(true);
				rightButton.setVisible(true);
				easyButton.setVisible(true);
				hardButton.setVisible(true);
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

		leftButton.setVisible(false);
		leftButton.setBounds(150, 600, 60, 60);
		leftButton.setBorderPainted(false);
		leftButton.setContentAreaFilled(false);
		leftButton.setFocusPainted(false);
		leftButton.addMouseListener(new MouseListener() {

			@Override
			public void mouseReleased(MouseEvent e) {

			}

			@Override
			public void mousePressed(MouseEvent e) {
				selectLeft();

			}

			@Override
			public void mouseExited(MouseEvent e) {
				leftButton.setIcon(leftButtonEnterImage);
				leftButton.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
			}

			@Override
			public void mouseEntered(MouseEvent e) {
				leftButton.setIcon(leftButtonEnterImage);
				leftButton.setCursor(new Cursor(Cursor.HAND_CURSOR));

			}

			@Override
			public void mouseClicked(MouseEvent e) {

			}
		});

		add(leftButton);

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
				selectRight();

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

		easyButton.setVisible(false);
		easyButton.setBounds(300, 650, 250, 67);
		easyButton.setBorderPainted(false);
		easyButton.setContentAreaFilled(false);
		easyButton.setFocusPainted(false);
		easyButton.addMouseListener(new MouseListener() {

			@Override
			public void mouseReleased(MouseEvent e) {

			}

			@Override
			public void mousePressed(MouseEvent e) {
				gameStart(nowSelected, "easy");

			}

			@Override
			public void mouseExited(MouseEvent e) {

			}

			@Override
			public void mouseEntered(MouseEvent e) {

			}

			@Override
			public void mouseClicked(MouseEvent e) {

			}
		});

		add(easyButton);

		hardButton.setVisible(false);
		hardButton.setBounds(650, 650, 250, 67);
		hardButton.setBorderPainted(false);
		hardButton.setContentAreaFilled(false);
		hardButton.setFocusPainted(false);
		hardButton.addMouseListener(new MouseListener() {

			@Override
			public void mouseReleased(MouseEvent e) {

			}

			@Override
			public void mousePressed(MouseEvent e) {
				gameStart(nowSelected, "hard");

			}

			@Override
			public void mouseExited(MouseEvent e) {

			}

			@Override
			public void mouseEntered(MouseEvent e) {

			}

			@Override
			public void mouseClicked(MouseEvent e) {

			}
		});

		add(hardButton);

		backButton.setVisible(false);
		backButton.setBounds(20, 50, 60, 60);
		backButton.setBorderPainted(false);
		backButton.setContentAreaFilled(false);
		backButton.setFocusPainted(false);
		backButton.addMouseListener(new MouseListener() {

			@Override
			public void mouseReleased(MouseEvent e) {

			}

			@Override
			public void mousePressed(MouseEvent e) {
				backMain();

			}

			@Override
			public void mouseExited(MouseEvent e) {
				backButton.setIcon(backButtonEnterImage);
				backButton.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
			}

			@Override
			public void mouseEntered(MouseEvent e) {
				backButton.setIcon(backButtonImage);
				backButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
			}

			@Override
			public void mouseClicked(MouseEvent e) {

			}
		});

		add(backButton);

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

	}

	public void paint(Graphics g) {
		screenImage = createImage(Main.SCREEN_WIDTH, Main.SCREEN_HEIGHT);
		screenGraphic = screenImage.getGraphics();
		screenDraw((Graphics2D) screenGraphic);
		g.drawImage(screenImage, 0, 0, null);

	}

	public void screenDraw(Graphics2D g) {
		g.drawImage(background, 0, 0, null);
		if (isMainScreen) {
			g.drawImage(selectedImage, 300, 200, null);
			g.drawImage(titleImage, 100, 0, null);
		}
		if (isGameScreen) {
			g.drawImage(noteRouteImage, 228, 30, null);
			g.drawImage(noteRouteImage, 332, 30, null);
			g.drawImage(noteRouteImage, 436, 30, null);
			g.drawImage(noteRouteImage, 540, 30, null);
			g.drawImage(noteRouteImage, 640, 30, null);
			g.drawImage(noteRouteImage, 744, 30, null);
			g.drawImage(noteRouteImage, 848, 30, null);
			g.drawImage(noteRouteImage, 952, 30, null);
			g.drawImage(noteRouteLineImage, 224, 30, null);
			g.drawImage(noteRouteLineImage, 328, 30, null);
			g.drawImage(noteRouteLineImage, 432, 30, null);
			g.drawImage(noteRouteLineImage, 536, 30, null);
			g.drawImage(noteRouteLineImage, 740, 30, null);
			g.drawImage(noteRouteLineImage, 844, 30, null);
			g.drawImage(noteRouteLineImage, 948, 30, null);
			g.drawImage(noteRouteLineImage, 1052, 30, null);
			g.drawImage(gameInfoImage, 0, 660, null);
			g.drawImage(judgementLineImage, 0, 580, null);
			g.drawImage(noteBasicImage, 228, 120, null);
			g.drawImage(noteBasicImage, 332, 580, null);
			g.drawImage(noteBasicImage, 436, 500, null);
			g.drawImage(noteBasicImage, 540, 340, null);
			g.drawImage(noteBasicImage, 640, 340, null);
			g.drawImage(noteBasicImage, 744, 325, null);
			g.drawImage(noteBasicImage, 848, 305, null);
			g.drawImage(noteBasicImage, 952, 305, null);
			g.setColor(Color.white);
			g.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING, RenderingHints.VALUE_TEXT_ANTIALIAS_ON);
			g.setFont(new Font("Arial", Font.BOLD, 30));
			g.drawString("The Festival of Ghost", 20, 702);
			g.drawString("Easy", 1190, 702);
			g.setFont(new Font("Arial", Font.PLAIN, 26));
			g.setColor(Color.DARK_GRAY);
			g.drawString("S", 270, 620);
			g.drawString("D", 374, 620);
			g.drawString("F", 478, 620);
			g.drawString("Space Bar", 580, 620);
			g.drawString("J", 784, 620);
			g.drawString("K", 889, 620);
			g.drawString("L", 993, 620);
			g.setColor(Color.LIGHT_GRAY);
			g.setFont(new Font("Elephant", Font.BOLD, 30));
			g.drawString("000000", 565, 702);
		}
		paintComponents(g);
		this.repaint();
	}

	public void selectTrack(int nowSelected) {
		if (selectedMusic != null)
			selectedMusic.close();
		titleImage = new ImageIcon(Main.class.getResource("../images/" + trackList.get(nowSelected).getTitleImage()))
				.getImage();
		selectedImage = new ImageIcon(Main.class.getResource("../images/" + trackList.get(nowSelected).getStartImage()))
				.getImage();
		selectedMusic = new Music(trackList.get(nowSelected).getStartMusic(), true);
		selectedMusic.start();

	}

	public void selectLeft() {
		if (nowSelected == 0)
			nowSelected = trackList.size() - 1;
		else
			nowSelected--;
		selectTrack(nowSelected);
	}

	public void selectRight() {
		if (nowSelected == trackList.size() - 1)
			nowSelected = 0;
		else
			nowSelected++;
		selectTrack(nowSelected);
	}

	public void gameStart(int nowSelected, String difficulty) {
		if (selectedMusic != null)
			selectedMusic.close();
		isMainScreen = false;
		leftButton.setVisible(false);
		rightButton.setVisible(false);
		easyButton.setVisible(false);
		hardButton.setVisible(false);
		background = new ImageIcon(Main.class.getResource("../images/" + trackList.get(nowSelected).getGameImage()))
				.getImage();
		backButton.setVisible(true);
		isGameScreen = true;
	}

	public void backMain() {
		isMainScreen = true;
		leftButton.setVisible(true);
		rightButton.setVisible(true);
		easyButton.setVisible(true);
		hardButton.setVisible(true);
		background = new ImageIcon(Main.class.getResource("../images/background.jpg")).getImage();
		backButton.setVisible(false);
		selectTrack(nowSelected);
		isGameScreen = false;
	}
}
