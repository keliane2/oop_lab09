package it.unibo.mvc;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JFileChooser;

/**
 * A very simple program using a graphical interface.
 * 
 */
public final class SimpleGUIWithFileChooser {

    private final JFrame frame = new JFrame("My first java graphical interface");
    private Controller guiController;

    public SimpleGUIWithFileChooser(Controller controller){
        this.guiController=controller;
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
        //parte aggiuntiva
        JPanel innerPanel= new JPanel();
        innerPanel.setLayout(new BorderLayout());
        JTextField textField= new JTextField("Choosed file's name should be here");
        innerPanel.add(textField, BorderLayout.CENTER);
        textField.setEditable(false);
        JButton browse=new JButton("Browse");
        innerPanel.add(browse,BorderLayout.LINE_END);
        canvas.add(innerPanel, BorderLayout.NORTH);
        browse.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                JFileChooser fs= new JFileChooser();
                if (fs.showSaveDialog(browse)==JFileChooser.APPROVE_OPTION) {
                    if(guiController.setCurrentFile(fs.getSelectedFile())){
                        textField.setEditable(true);
                        System.out.println(fs.getSelectedFile().getPath());
                        textField.setText(fs.getSelectedFile().getPath());
                        textField.setEditable(false);
                    }
                }else if( fs.showSaveDialog(browse)== JFileChooser.CANCEL_OPTION){
                    
                }else{
                    JOptionPane.showMessageDialog(frame,"An error has occured");
                }
            }
            
        });
    }

    public static void main(final String... args){
        Controller controller=new Controller();
        new SimpleGUIWithFileChooser(controller);
    }
}


