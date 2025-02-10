import java.util.Scanner;
/*
 * Inspired by https://www.youtube.com/watch?v=zCiMlbu1-aQ&ab_channel=choobtorials
 * 
 * AUTHOR: Amy C. Larson, Ph.D.
 * copyrighted 2022
 */

import java.awt.*;
import javax.swing.*;

public class DisplayTask extends JComponent implements Runnable {

    private int width;
    private int height;

    int sleep = 1000;

    long counter = 0;

    String userText = "user text";

    String toDraw = "STARTING ... ";

    public DisplayTask(int w, int h, String name, int sleep) {
        this.sleep = sleep;
        width = w;
        height = h;
        JFrame f = new JFrame();
        f.setSize(w + 20, h + 20);
        f.setTitle("Task " + name);
        f.add(this);
        f.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        f.setVisible(true);
    }

    public void displayText(String val) {
        userText = val;
    }

    public void run() {
    	//System.out.println("I am in run about to go infinite.");
        
        while (true) {
            try {
                Thread.sleep(sleep);
            } catch (Exception e) {

            }
            //System.out.println("here in the task.");
            toDraw = " RUNNING "+counter;
            counter++;
            repaint();
        }
    }

    @Override
    protected void paintComponent(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;

        g2d.setColor(Color.PINK);
        g2d.fillRect(0 + 10, 0 + 10, width - 20, height - 20);
        g2d.setColor(Color.BLACK);


        g2d.drawString(toDraw, 40, 40);
        g2d.drawString(userText, 40, 60);
    }
}
