package Quiz;

import IO.mainScreen;

import java.io.IOException;

// Third party library
// apache.string.utills
// download link (download binarys [.gz])
// apache licence
// search for how to install apache library
// examples of use

public class Main implements IApp {
    public static void main(String[] args)throws IOException
    {
        IApp app = new Main();
        ShutdownInterceptor shutdownInterceptor = new ShutdownInterceptor(app);
        Runtime.getRuntime().addShutdownHook(shutdownInterceptor);
        app.start();
        new mainScreen();
    }

    public void start() {

    try {
            System.out.println("Sleeping for 5 seconds before shutting down");
            Thread.sleep(5000);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public void shutDown() {
        // Do a graceful shutdown here
        System.out.println("Shutdown is called");
    }

}
