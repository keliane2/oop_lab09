package it.unibo.mvc;

import java.io.File;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.net.URL;

import it.unibo.mvc.api.DrawNumberController;
import it.unibo.mvc.api.DrawNumberView;
import it.unibo.mvc.controller.DrawNumberControllerImpl;
import it.unibo.mvc.model.DrawNumberImpl;

/**
 * Application entry-point.
 */
public final class LaunchApp {

    private LaunchApp() {
    }

    /**
     * Runs the application.
     *
     * @param args ignored
     * @throws ClassNotFoundException    if the fetches class does not exist
     * @throws NoSuchMethodException     if the 0-ary constructor do not exist
     * @throws InvocationTargetException if the constructor throws exceptions
     * @throws InstantiationException    if the constructor throws exceptions
     * @throws IllegalAccessException    in case of reflection issues
     * @throws IllegalArgumentException  in case of reflection issues
     */
    public static void main(final String... args) {
        final var model = new DrawNumberImpl();
        final DrawNumberController app = new DrawNumberControllerImpl(model);
        /*
         * app.addView(new DrawNumberSwingView());
         * app.addView(new DrawNumberSwingView());
         * app.addView(new DrawNumberOutputView());
         */

        ClassLoader loader = DrawNumberView.class.getClassLoader();
        URL url = loader.getResource("it/unibo/mvc");

        String directoryPath = url.getPath();
        File directory = new File(directoryPath);

        for (File file : directory.listFiles()) {
            if (file.isDirectory()) {
                File subDirectory = new File(file.getAbsolutePath());
                for (final File subDirFile : subDirectory.listFiles()) {
                    try {
                        for (Class<?> interfaccia : Class.forName("it.unibo.mvc." + subDirectory.getName() + "."+ (String) subDirFile.getName().subSequence(0,subDirFile.getName().length() - 6),true, loader).getInterfaces()) {
                            if (interfaccia.getSimpleName().equalsIgnoreCase("DrawNumberView")) {
                                Constructor<?>[] constr = Class.forName("it.unibo.mvc." + subDirectory.getName() + "."+ (String) subDirFile.getName().subSequence(0,subDirFile.getName().length() - 6),true, loader).getConstructors();
                                try {
                                    app.addView((DrawNumberView) constr[0].newInstance());
                                    app.addView((DrawNumberView) constr[0].newInstance());
                                    app.addView((DrawNumberView) constr[0].newInstance());
                                } catch (InstantiationException e) {
                                    e.printStackTrace();
                                } catch (IllegalAccessException e) {
                                    e.printStackTrace();
                                } catch (IllegalArgumentException e) {
                                    e.printStackTrace();
                                } catch (InvocationTargetException e) {
                                    e.printStackTrace();
                                }
                            }
                        }
                    } catch (ClassNotFoundException e) {
                        e.printStackTrace();
                    } catch (SecurityException e) {
                        e.printStackTrace();
                    }
                }
            } else {
                try {
                    for (Class<?> interfaccia : Class.forName("it.unibo.mvc." + (String) file.getName().subSequence(0, file.getName().length() - 6), true, loader).getInterfaces()) {
                        if (interfaccia.getSimpleName().equalsIgnoreCase("DrawNumberView")) {
                            Constructor<?>[] constr = Class.forName("it.unibo.mvc." + (String) file.getName().subSequence(0,file.getName().length() - 6), true, loader).getConstructors();
                            try {
                                app.addView((DrawNumberView) constr[0].newInstance());
                                app.addView((DrawNumberView) constr[0].newInstance());
                                app.addView((DrawNumberView) constr[0].newInstance());
                            } catch (InstantiationException e) {
                                e.printStackTrace();
                            } catch (IllegalAccessException e) {
                                e.printStackTrace();
                            } catch (IllegalArgumentException e) {
                                e.printStackTrace();
                            } catch (InvocationTargetException e) {
                                e.printStackTrace();
                            }
                        }
                    }
                } catch (ClassNotFoundException e) {
                    e.printStackTrace();
                } catch (SecurityException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
