import javax.swing.*;
import java.awt.*;
import java.util.concurrent.CopyOnWriteArrayList;

public class GamePanel extends JPanel implements Runnable {

    Thread gameThread, duckThread;
    int level = 1;
    int numberOfDucks = 5;
    int FPS = 60;
    Image img;
    CopyOnWriteArrayList<Duck> duckList = new CopyOnWriteArrayList<>();

    public GamePanel(){
//        Image img = new ImageIcon("background.jpg").getImage();
        setBackground(Color.CYAN);
        startGameThread();
        this.setDoubleBuffered(true);
    }

    public void startGameThread(){
        gameThread = new Thread(this);

        duckThread = new Thread(()->{
            while(!duckThread.isInterrupted()){
                try {
                    Thread.sleep(1500);
                    Duck duck = new YellowDuck(0, (int)(Math.random() * 400 + 1));
                    addDuck(duck);

                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        duckThread.start();
        gameThread.start();
    }

    public void addDuck(Duck d) {
        System.out.println(duckList);
        duckList.add(d);
    }

    public void update(){
        for (Duck duck: duckList) {
            duck.move(level);
        }
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        Graphics2D graphics2D = (Graphics2D) g;
        graphics2D.setColor(Color.BLACK);

        for (Duck duck: duckList){
            graphics2D.drawRect(duck.getX(), duck.getY(), 25,25);
        }

        graphics2D.dispose();
    }

    @Override
    public void run() {
        double drawInterval = 1000000000/FPS;
        double delta = 0;
        long lastTime = System.nanoTime();
        long currentTime;

        while(gameThread != null){
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
