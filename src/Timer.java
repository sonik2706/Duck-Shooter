public class Timer extends Thread {
    private int seconds = 0;

    public void run() {
        while (!isInterrupted()) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException ignored) {
                seconds = 0;
                System.out.println("Timer interrupted");
            }
            increaseTime();
        }
    }

    public synchronized void increaseTime() {
        seconds += 1;
    }

    public String getHours() {
        int hours = seconds / 3600;
        if (hours < 10)
            return "0" + hours;
        else
            return String.valueOf(seconds / 3600);
    }

    public String getMinutes() {
        int minutes = seconds / 60;
        if (minutes < 10)
            return "0" + minutes;
        else
            return String.valueOf(seconds / 60);
    }

    public String getSeconds() {
        if (seconds % 60 < 10)
            return "0" + seconds % 60;
        else
            return String.valueOf(seconds % 60);
    }

    public String getTime() {
        return getHours() + ":" + getMinutes() + ":" + getSeconds();
    }
}
