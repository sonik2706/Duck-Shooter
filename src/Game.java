import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.*;
import java.util.ArrayList;
import java.util.concurrent.CopyOnWriteArrayList;

import Duck.*;

public class Game extends JPanel implements Runnable {

    Thread gameThread, duckThread, cloudThread, ShootingThread;
    Timer time;
    int level = 1;
    int FPS = 60;
    int points = 0;
    int health = 100;
    int speed = 1500;
    CopyOnWriteArrayList<Duck> duckList = new CopyOnWriteArrayList<>();
    CopyOnWriteArrayList<Cloud> cloudList = new CopyOnWriteArrayList<>();
    private Image backgroundImage;

    public Game() throws IOException {
        startGameThread();
        setBackground(new java.awt.Color(204, 255, 255));
        this.setDoubleBuffered(true);
    }

    public void startGameThread() {
        time = new Timer();
        gameThread = new Thread(this);
        duckThread = new Thread(() -> {
            while (!duckThread.isInterrupted()) {
                try {
                    Thread.sleep(speed);
                    Duck duck;
                    switch (level) {
                        default:
                            duck = new YellowDuck(-25, (int) (Math.random() * 350 + 50 + 1));
                            break;
                        case 2:
                            duck = new RedDuck(-25, (int) (Math.random() * 350 + 50 + 1));
                            break;
                        case 3:
                            duck = new PurpleDuck(-25, (int) (Math.random() * 350 + 50 + 1));
                            break;
                        case 4:
                            duck = new GreenDuck(-25, (int) (Math.random() * 350 + 50 + 1));
                            break;
                    }

                    duckList.add(duck);
                } catch (InterruptedException ignored) {
                }
            }
        });

        cloudThread = new Thread(()->{
            while (!cloudThread.isInterrupted()) {
                try {
                    Thread.sleep(speed*3);
                    Cloud cloud = new Cloud(-100, (int) (Math.random() * 350 + 50 + 1));
                    cloudList.add(cloud);
                } catch (InterruptedException ignored) {
                }
            }
        });

        ShootingThread = new Thread(() -> {
            this.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    for (Duck d : duckList) {
                        if (d.gotHit(e)) {
                            d.setHealth(d.getHealth() - 1);
                        }
                        if (d.getHealth() <= 0) {
                            duckList.remove(d);
                            points += (10) * level;
                        }
                    }
                }
            });
        });

        time.start();
        gameThread.start();
        duckThread.start();
        cloudThread.start();
        ShootingThread.start();
    }

    public void endGame() {
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
//        gameThread.interrupt();
    }

    public void update() {
        for (Duck duck : duckList) {
            duck.move(1);

            if (duck.reachedEnd()) {
                if (duck instanceof YellowDuck)
                    health -= 10;
                else if (duck instanceof RedDuck)
                    health -= 12;
                else if (duck instanceof PurpleDuck)
                    health -= 14;
                else if (duck instanceof GreenDuck)
                    health -= 16;

                duckList.remove(duck);
            }

            level = 1+Integer.parseInt(time.getSeconds())/30;

            if (health <= 0)
                endGame();
        }

        for (Cloud cloud: cloudList){
            cloud.setX(cloud.getX()+1);
        }
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        Graphics2D graphics2D = (Graphics2D) g;
        graphics2D.setColor(Color.BLACK);
        graphics2D.drawString(time.getTime(), 25, 25);
        graphics2D.drawString("Points: " + points, 100, 25);
        graphics2D.drawString("Health: " + health + "%", 25, 50);
        for (Duck duck : duckList) {
            graphics2D.drawImage(duck.getImage(), duck.getX(), duck.getY(), null);
        }

        for (Cloud cloud : cloudList) {
            graphics2D.drawImage(cloud.getImage(), cloud.getX(), cloud.getY(), null);
        }

        graphics2D.dispose();
    }

    @Override
    public void run() {
        double drawInterval = 1000000000 / FPS;
        double delta = 0;
        long lastTime = System.nanoTime();
        long currentTime;

        while (!Thread.interrupted()) {
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
}
