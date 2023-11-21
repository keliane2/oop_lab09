package it.unibo.mvc;

import java.util.List;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import javax.swing.JButton;
import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * A very simple program using a graphical interface.
 * 
 */
public final class SimpleGUI {

    private final JFrame frame = new JFrame();
    //private Controller controller;

    private SimpleGUI(Controller controller){
        //this.controller=controller;
        JPanel canvas=new JPanel();
        canvas.setLayout(new BorderLayout());
        JPanel textFieldJPanel=new JPanel();
        textFieldJPanel.setLayout(new BorderLayout());
        canvas.add(textFieldJPanel,BorderLayout.NORTH);
        JTextField textField=new JTextField("My textfield");
        textFieldJPanel.add(textField,BorderLayout.CENTER);
        JPanel textARJPanel=new JPanel();
        textARJPanel.setLayout(new BorderLayout());
        canvas.add(textARJPanel,BorderLayout.CENTER);
        JTextArea textArea=new JTextArea();
        textARJPanel.add(textArea,BorderLayout.CENTER);
        JPanel buttonsJPanel=new JPanel();
        buttonsJPanel.setLayout(new BorderLayout());
        canvas.add(buttonsJPanel,BorderLayout.SOUTH);
        JButton print=new JButton("Print");
        buttonsJPanel.add(print,BorderLayout.WEST);
        JButton show=new JButton("Show history");
        buttonsJPanel.add(show,BorderLayout.EAST);
        frame.setContentPane(canvas);
        frame.setVisible(true);
        //frame.setLocationByPlatform(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        print.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                controller.setNextString(textField.getText());
                controller.printCurrentString(textField.getText());
            }
            
        });

        show.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                List<String> myHistory= controller.getPrintedStringHistory();
                String history="";
                for (String element : myHistory) {
                    history=history+element+"\n";
                }
                textArea.setText(history);
            }
        
        });
    }

    
    public static void main(String[] args) {
        Controller controller=new SimpleController();
        new SimpleGUI(controller);
    }

}
