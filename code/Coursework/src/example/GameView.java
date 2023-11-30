package example;

import javax.swing.*;
import java.awt.*;

public class GameView implements View {
    Model model;
    Controller controller;
    int frameHeight, frameWidth;
    JFrame frame;
    JPanel topPanel, gamePanel;
    public Image background = ImageUtil.images.get("UI-background");
    public Image fail = ImageUtil.images.get("game-scene-01");

    @Override
    public void initialise(Model model, Controller controller, int height, int width) {
        this.model = model;
        this.controller = controller;
        this.frameHeight = height;
        this.frameWidth = width;
        this.createFrame();
        frame = new JFrame();
        topPanel = new JPanel(new GridLayout(1, 4));
        gamePanel = new JPanel();
    }

    private void createFrame() {
        frame.setIconImage(Toolkit.getDefaultToolkit().getImage(
                MyFrame.class.getResource("snake-logo.png"
                )));
        frame.setLocationRelativeTo(null);
        frame.getContentPane().setLayout(new BorderLayout());
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setTitle("Snake Yippee");
        frame.add(topPanel, BorderLayout.NORTH);
        frame.add(gamePanel, BorderLayout.CENTER);


    }

    @Override
    public void refreshView() {

    }

    @Override
    public void feedbackToUser() {

    }
}
