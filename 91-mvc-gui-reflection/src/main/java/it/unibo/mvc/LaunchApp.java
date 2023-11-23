package it.unibo.mvc;


import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.InvocationTargetException;
import java.net.URL;

import it.unibo.mvc.api.DrawNumberController;
import it.unibo.mvc.api.DrawNumberView;
import it.unibo.mvc.controller.DrawNumberControllerImpl;
import it.unibo.mvc.model.DrawNumberImpl;
import it.unibo.mvc.view.DrawNumberOutputView;
import it.unibo.mvc.view.DrawNumberSwingView;

/**
 * Application entry-point.
 */
public final class LaunchApp {

    private LaunchApp() { }

    /**
     * Runs the application.
     *
     * @param args ignored
     * @throws ClassNotFoundException if the fetches class does not exist
     * @throws NoSuchMethodException if the 0-ary constructor do not exist
     * @throws InvocationTargetException if the constructor throws exceptions
     * @throws InstantiationException if the constructor throws exceptions
     * @throws IllegalAccessException in case of reflection issues
     * @throws IllegalArgumentException in case of reflection issues
     */
    public static void main(final String... args) {
        final var model = new DrawNumberImpl();
        final DrawNumberController app = new DrawNumberControllerImpl(model);
       /* app.addView(new DrawNumberSwingView());
        app.addView(new DrawNumberSwingView());
        app.addView(new DrawNumberOutputView());*/

        ClassLoader loader = LaunchApp.class.getClassLoader();
        System.out.println(loader.getResource("it/unibo/mvc"));
        URL url=loader.getResource("it/unibo/mvc");

        String file=url.getPath();
        try (
            final BufferedReader r = new BufferedReader (new FileReader ( file ) )
        ) {
            while (r.readLine()!=null) {

                System . out . println (r. readLine () );
                
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        
        /*for (final Class<?extends> element : DrawNumberView.class.getClasses()) {
            System.out.println("in");
            System.out.println(element.toString());
            System.out.println("oki");
            for (Class<?> element1 : element.getInterfaces()) {
                System.out.println(element1.getSimpleName());
                if (element1.getSimpleName()=="DrawNumberView") {
                    System.out.println("ok");
                }
            }
        }
        /*String classPath = System.getProperty()
        //for (Class cl : "bin\main\it\"unibo\mvc") {"
            
        //}
        for (final Class<?> element : DrawNumberView.class.getClasses()) {
            Object constructor= element.getConstructor(element);
            for (int i = 0; i < 3; i++) {
                app.addView(element.));
            }
        }*/
    }
}
