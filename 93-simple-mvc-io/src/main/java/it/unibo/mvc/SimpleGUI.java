package it.unibo.mvc;

import java.awt.BorderLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;

/**
 * A very simple program using a graphical interface.
 * 
 */
public final class SimpleGUI {

    private final JFrame frame = new JFrame("My first java graphical interface");

    public SimpleGUI(){
        JPanel canvas=new JPanel();
        canvas.setLayout(new BorderLayout());
        JTextArea textArea=new JTextArea();
        canvas.add(textArea, BorderLayout.CENTER);
        JButton save = new JButton("Save");
        canvas.add(save, BorderLayout.PAGE_END);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setContentPane(canvas);
        frame.setLocationByPlatform(true);
        frame.setVisible(true);
    }

    public static void main(final String... args){
        new SimpleGUI();
    }
}
