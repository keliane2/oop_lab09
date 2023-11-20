package it.unibo.mvc.view;


import it.unibo.mvc.api.DrawNumberController;
import it.unibo.mvc.api.DrawNumberView;
import it.unibo.mvc.api.DrawResult;

public class DrawNumberOutputView implements DrawNumberView {

    private DrawNumberController controller;

    @Override
    public void setController(DrawNumberController observer) {
        this.controller=observer;
    }

    @Override
    public void start() {
        System.out.println("Let us start!");
    }

    @Override
    public void result(DrawResult res) {
        switch (res) {
            case YOURS_HIGH, YOURS_LOW -> {
                System.out.println(res.getDescription());
                return;
            }
            case YOU_WON -> System.out.println(res.getDescription()+" Let's start a new game");
            case YOU_LOST -> System.out.println(res.getDescription()+" Lest's start a new game");
            default -> throw new IllegalStateException("Unknown game state");
        }
        controller.resetGame();
    }
    
}
