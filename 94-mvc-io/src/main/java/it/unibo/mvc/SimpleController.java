package it.unibo.mvc;

import java.util.*;
/**
 * 
 *
 */
public final class SimpleController implements Controller {
    private String nextString;
    private List<String> printedStringHistory=new ArrayList<>();

    @Override
    public void setNextString(String nextString) {
        this.nextString=nextString;
    }

    @Override
    public String getNextString() {
        return this.nextString;
    }

    @Override
    public List<String> getPrintedStringHistory() {
        return this.printedStringHistory;
    }

    @Override
    public void printCurrentString(String currentString) {
        if (currentString!=null) {
            System.out.println(currentString);
            this.printedStringHistory.add(currentString);
        }else{
            throw new IllegalStateException("Current string is unset");
        }
    }
}
