package Controller;

import javax.swing.*;
import java.awt.*;
import java.io.*;
import java.util.ArrayList;
import java.util.concurrent.CopyOnWriteArrayList;

import Model.*;
import View.*;

public class Game extends JPanel implements Runnable {

    private static Game instance;
    Thread  gameThread,
            duckThread,
            obstacleThread;
    View.Timer time;
    JLabel  timeLabel = new JLabel(),
            healthLabel = new JLabel(),
            scoreLabel = new JLabel(),
            weaponDamage = new JLabel();

    private boolean stopped = false;
    private int level = 1;
    private Weapon weapon;
    private int FPS = 60;
    private int points = 0;
    private int health = 100;

    CopyOnWriteArrayList<Duck> duckList = new CopyOnWriteArrayList<>();
    ArrayList<Obstacle> obstacleList = new ArrayList<>();

    public Game() {
        instance = this;
        setBackground(new java.awt.Color(204, 255, 255));

        weapon = new Weapon();
        add(weapon);
        add(weaponDamage);
        startGame();
        this.setDoubleBuffered(true);
//        setLayout(null);
    }

    public void startGame() {
        time = new View.Timer();
        gameThread = new Thread(this);
        duckThread = new Thread(() -> {
            while (!duckThread.isInterrupted()) {
                try {
                    Thread.sleep(3000/level);
                    Duck duck = switch ((int) (Math.random()*3 + 1)) {
                        default -> new YellowDuck(-25, (int) (Math.random() * 350 + 50 + 1));
                        case 2 -> new RedDuck(-25, (int) (Math.random() * 350 + 50 + 1));
                        case 3 -> new PurpleDuck(-25, (int) (Math.random() * 350 + 50 + 1));
                        case 4 -> new GreenDuck(-25, (int) (Math.random() * 350 + 50 + 1));
                    };
                    add(duck);
                    duckList.add(duck);
                } catch (InterruptedException ignored) {
                }
            }
        });

        obstacleThread = new Thread(()->{
            while (!obstacleThread.isInterrupted()) {
                try {
                    Thread.sleep(6000/level);
                    Obstacle cloud = new Cloud(-100, (int) (Math.random() * 250 + 50 + 1));
                    Obstacle tree = new Tree(-150, 375);
                    add(cloud);
                    add(tree);
                    obstacleList.add(cloud);
                    obstacleList.add(tree);
                } catch (InterruptedException ignored) {
                }
            }
        });
        time.start();
        gameThread.start();
        duckThread.start();
        obstacleThread.start();

        add(timeLabel);
        add(scoreLabel);
        add(healthLabel);
    }

    public void endGame() {
        stopped = true;
        String nickname = JOptionPane.showInputDialog(null, "Nickname: ", null, JOptionPane.INFORMATION_MESSAGE);
        Score sc = new Score(nickname, points, time.getTime());
        ArrayList<Score> scores = new ArrayList<>();

        try {
            FileInputStream fis = new FileInputStream("data/highscores.bin");
            ObjectInputStream ois = new ObjectInputStream(fis);

            scores = (ArrayList<Score>) ois.readObject();
            ois.close();
            fis.close();
        } catch (IOException | ClassNotFoundException ioe) {
            ioe.printStackTrace();
        }

        scores.add(sc);
        try {
            FileOutputStream fos = new FileOutputStream("data/highscores.bin");
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(scores);
            oos.close();
            fos.close();
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }

        SwingUtilities.invokeLater(() -> {
            JFrame f = (JFrame) SwingUtilities.getAncestorOfClass(JFrame.class, this);
            f.dispose();
            new Menu(500, 500);
        });

        time.interrupt();
        gameThread.stop();
    }

    public void update() {
        if (points >= 500 && weapon.getWeaponLevel() == 1) {
            System.out.println("Upgrade to rifle");
            points -= weapon.upgradeWeapon();
        }
        else if (points >= 1000 && weapon.getWeaponLevel() == 2){
            System.out.println("Upgrade to machinegun");
            points -= weapon.upgradeWeapon();
        }

        for (Duck duck : duckList) {
            duck.move(1);

            if (duck.reachedEnd()) {
                if (duck instanceof YellowDuck)
                    health -= 10;
                else if (duck instanceof RedDuck)
                    health -= 11;
                else if (duck instanceof PurpleDuck)
                    health -= 12;
                else if (duck instanceof GreenDuck)
                    health -= 13;
                duckList.remove(duck);
            }
            if (health <= 0)
                endGame();
        }

        for (Obstacle obstacle : obstacleList){
            obstacle.setX(obstacle.getX()+1);
        }
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        timeLabel.setBounds(25,25, 50, 25);
        timeLabel.setText(time.getTime());
        healthLabel.setBounds(25,10, 50, 20);
        healthLabel.setText(health + "%");
        scoreLabel.setBounds(100, 10, 50, 20);
        scoreLabel.setText(points + "pts");

        weaponDamage.setText("Damage: " + weapon.getDamage());
        weaponDamage.setBounds(400, 10, 60, 10);
        weapon.setBounds(400,25, weapon.getWidth(), weapon.getHeight());

        for (Duck duck : duckList) {
            duck.setBounds(duck.getX(), duck.getY(), duck.getWidth(), duck.getHeight());
        }

        for (Obstacle obstacle : obstacleList) {
            obstacle.setBounds(obstacle.getX(), obstacle.getY(), obstacle.getWidth(), obstacle.getHeight());
        }
    }

    // Start: Author: RyiSnow  https://www.youtube.com/watch?v=VpH33Uw-_0E
    @Override
    public void run() {
        double drawInterval = 1000000000/FPS;
        double delta = 0;
        long lastTime = System.nanoTime();
        long currentTime;

        while (!stopped) {
            currentTime = System.nanoTime();
            delta += (currentTime - lastTime) / drawInterval;
            lastTime = currentTime;

            if (delta >= 1) {
                update();
                repaint();
                delta--;
            }

        }
    }
    // END

    public static Game getInstance(){
        return instance;
    }

    public CopyOnWriteArrayList<Duck> getDuckList() {
        return duckList;
    }

    public int getPoints() {
        return points;
    }

    public void setPoints(int points) {
        this.points = points;
    }

    public ArrayList<Obstacle> getObstacleList() {
        return obstacleList;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public Weapon getWeapon() {
        return weapon;
    }
}
