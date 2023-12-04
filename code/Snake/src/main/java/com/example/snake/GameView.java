package com.example.snake;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.image.BufferedImage;

public class GameView extends JPanel implements View  {
    Model model;
    Controller controller;
    int frameHeight, frameWidth;
    JFrame frame = new JFrame();
    JLabel score = new JLabel("Score : 0");
    JLabel name = new JLabel("Anonymous");
    JLabel hScore = new JLabel("High Score : 0");
    JButton start;
    String buttonText = "Play";
    JPanel infoPanel = new JPanel();
    JLabel gamePanel = new JLabel();
    public Image background = ImageUtil.images.get("UI-background");
    public Image fail = ImageUtil.images.get("game-scene-01");
    private static final BufferedImage IMG_SNAKE_HEAD = (BufferedImage) ImageUtil.images.get("snake-head-right");
    static  Snake snake = new Snake(20, 20, IMG_SNAKE_HEAD);
    Food food = new Food();

    @Override
    public void initialise(Model model, Controller controller, int height, int width) {
        this.model = model;
        this.controller = controller;
        this.frameHeight = height;
        this.frameWidth = width;
        this.createFrame();


    }

    private void createFrame() {
        frame.setIconImage(Toolkit.getDefaultToolkit().getImage(
                MyFrame.class.getResource("snake-logo.png"
                )));
        frame.setLocationRelativeTo(null);
        frame.getContentPane().setLayout(new BorderLayout());
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setTitle("Snake Yippee");
        this.setDoubleBuffered(true);
        frame.add(infoPanel, BorderLayout.NORTH);
        infoPanel.setLayout(new GridLayout(1, 4));
        infoPanel.add(score);
        infoPanel.add(name);
        infoPanel.add(hScore);
        start = new JButton("Pause");
        start.setBackground(Color.green);
        start.setBorder(null);
        start.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String i = start.getText();
                start.setText(buttonText);
                buttonText = i;
            }
        });
        infoPanel.add(start);
        frame.add(this, BorderLayout.CENTER);
        //frame.addKeyListener(this);

        //frame.setTitle("Snakee Yipee");
        frame.setSize(870, 560);
        frame.setLocationRelativeTo(null);

        frame.setVisible(true);
        /*frame.setIconImage(Toolkit.getDefaultToolkit().getImage(
                MyFrame.class.getResource("snake-logo.png"
                )));
        frame.setLocationRelativeTo(null);
        frame.getContentPane().setLayout(new GridLayout(2, 1));
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setTitle("Snake Yippee");

        frame.add(infoPanel);
        frame.add(this);

        frame.setMinimumSize( new Dimension(frameWidth, frameHeight) );


        gamePanel.setBackground(Color.green);
        infoPanel.setBackground(Color.white);
        infoPanel.setLayout(new GridLayout(1, 4));
        infoPanel.add(score);
        infoPanel.add(name);
        infoPanel.add(hScore);
        start = new JButton("Pause");
        start.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String i = start.getText();
                start.setText(buttonText);
                buttonText = i;
            }
        });

        gamePanel.setIcon(new ImageIcon(background));
        infoPanel.add(start);
        //infoPanel.setSize(new Dimension(800, 20));

        frame.pack();
        frame.setVisible(true);
        //this.paint(gamePanel);*/
    }


    public static void main(String[] args) {

        new GameView().initialise(null, null, 800, 800);
    }
    @Override
    public void refreshView() {

    }

    @Override
    public void feedbackToUser() {

    }




    @Override
    protected void paintComponent(Graphics g) {

        super.paintComponent(g);
        g.drawImage(background, 0, 0, null);
    }
}
