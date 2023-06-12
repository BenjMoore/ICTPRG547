package Scripts;

public class Connection {
/*
    private void send() {
        try {
            //streamOut.writeUTF(txtWord1.getText());
            streamOut.flush();
            //txtWord1.setText("");
        } catch (IOException ioe) {
            println("Sending error: " + ioe.getMessage());
            close();
        }
    }

    public void handle(String msg) {
        if (msg.equals(".bye")) {
            println("Good bye. Press EXIT button to exit ...");
            close();
        } else {
            println(msg);


        }
    }

    public void open() {
        try {
            streamOut = new DataOutputStream(socket.getOutputStream());
            //client = new ChatClientThread1(this, socket);
        } catch (IOException ioe) {
            println("Error opening output stream: " + ioe);
        }
    }

    public void close() {
        try {
            if (streamOut != null) {
                streamOut.close();
            }
            if (socket != null) {
                socket.close();
            }
        } catch (IOException ioe) {
            println("Error closing ...");
        }
        client.close();
        client.stop();
    }

    void println(String msg) {
        //display.appendText(msg + "\n");
        txtLinkedList.setText(msg);
    }

    public void getParameters() {
//        serverName = getParameter("host");
//        serverPort = Integer.parseInt(getParameter("port"));

        serverName = "localhost";
        serverPort = 4444;
    }

    public void connect(String serverName, int serverPort) {
        println("Establishing connection. Please wait ...");
        try {
            socket = new Socket(serverName, serverPort);
            println("Connected: " + socket);
            open();
        } catch (UnknownHostException uhe) {
            println("Host unknown: " + uhe.getMessage());
        } catch (IOException ioe) {
            println("Unexpected exception: " + ioe.getMessage());
        }
    }

    private void send() {
        try {
            streamOut.writeUTF(txtWord1.getText());
            streamOut.flush();
            txtWord1.setText("");
        } catch (IOException ioe) {
            println("Sending error: " + ioe.getMessage());
            close();
        }
    }

    public void handle(String msg) {
        if (msg.equals(".bye")) {
            println("Good bye. Press EXIT button to exit ...");
            close();
        } else {
            System.out.println("Handle: " + msg);
            println(msg);
        }
    }

    public void open() {
        try {
            streamOut = new DataOutputStream(socket.getOutputStream());
            client2 = new ChatClientThread2(this, socket);
        } catch (IOException ioe) {
            println("Error opening output stream: " + ioe);
        }
    }

    public void close() {
        try {
            if (streamOut != null) {
                streamOut.close();
            }
            if (socket != null) {
                socket.close();
            }
        } catch (IOException ioe) {
        }
        client.close();
        client.stop();
    }

    void println(String msg) {
        //display.appendText(msg + "\n");
        lblMessage.setText(msg);
    }

}
*/
}
