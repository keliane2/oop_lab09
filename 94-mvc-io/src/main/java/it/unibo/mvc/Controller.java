package it.unibo.mvc;

import java.util.List;
/**
 *
 */
public interface Controller {
    public void setNextString(String nextString);

    public String getNextString();

    public List<String> getPrintedStringHistory();

    public void printCurrentString(String curreString);
}
