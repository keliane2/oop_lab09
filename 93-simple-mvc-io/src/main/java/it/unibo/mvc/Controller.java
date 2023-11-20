package it.unibo.mvc;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;

/**
 * Application controller. Performs the I/O.
 */
public class Controller {
    private static File currentFile=new File(System.getProperty("user.home")+File.separator+"output.txt");

    public void setCurrentFile(File f){
        this.currentFile=f;
    }

    public File getCurrentFile(){
        return this.currentFile;
    }

    public String getCurrentFilePath(){
        return this.currentFile.getPath();
    }

    public void writeInCurrentFile(String s){
        try {
            PrintStream ps = new PrintStream(this.currentFile);
            ps.print(s);
        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}
