package IO;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.awt.event.MouseListener;
import java.awt.event.MouseEvent;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import java.io.IOException;

public class SecondaryScreen extends JFrame implements ActionListener, MouseListener{
    private Socket socket = null;
    private DataInputStream console = null;
    private DataOutputStream streamOut = null;
    private String serverName = "localhost";
    private int serverPort = 4444;
    private IO.ChatClientThread2 client = null;
    String msgtobesent = "";
    ArrayList<Object[]> al2 = new ArrayList();


    public static void main(String[] args)throws IOException {new SecondaryScreen();}
    public void connect(String serverName, int serverPort) throws InterruptedException { try
        {
            this.socket = new Socket(serverName, serverPort);

        }
        catch (UnknownHostException uhe)
        {
            System.out.println("Host unknown: " + uhe.getMessage());
            socket.wait(1000);

        }
        catch (IOException ioe)
        {
            System.out.println("Unexpected exception: " + ioe.getMessage());

        }
    }
    private void send() {
        try {

            msgtobesent = "Correct";
            streamOut.writeUTF(msgtobesent);
            streamOut.flush();
        } catch (IOException ioe) {
            println("Sending error: " + ioe.getMessage());
            close();
        }
    }

    public void handle(String msg) {
        if (msg.equals(".bye")) {
            println("Good bye. Press EXIT button to exit ...");
            close();
        } else
        {
           /* topicBox.getText() + ": "
                    + subtopicBox.getText() + ": " + questionBox.getText() + ": " + aBox.getText() + bBox.getText() + ": "
                    + cBox.getText() + ": " + dBox.getText() + ": " + eBox.getText();*/
            String temp[] = msg.split(": ");

            topicBox.setText(temp[0]);
            subtopicBox.setText(temp[1]);
            questionBox.setText(temp[2]);
            aBox.setText(temp[3]);
            bBox.setText(temp[4]);
            cBox.setText(temp[5]);
            dBox.setText(temp[6]);
            eBox.setText(temp[7]);

            System.out.println("Handle: " + msg);
            println(msg);
        }
    }


    public void HandleIncoming() throws IOException {

        String RecivedString = "";
        BufferedReader br = new BufferedReader(new FileReader(RecivedString));
        String str = br.readLine();
        int i = 0;
        String line = "";

        while ((line = br.readLine()) != null)
        {
            String[] breaker = line.split(": ");
            topicBox.setText(breaker[1]);
            subtopicBox.setText(breaker[2]);
            questionBox.setText(breaker[3]);
            aBox.setText(breaker[4]);
            bBox.setText(breaker[5]);
            cBox.setText(breaker[6]);
            dBox.setText(breaker[7]);
            eBox.setText(breaker[8]);

            String ArrayLength = Integer.toString(breaker.length);;

           // if(  5)
          //  {

          //  }
        }
        br.close();
    }

    public void open() {
        try {
            streamOut = new DataOutputStream(socket.getOutputStream());
            client = new ChatClientThread2(this, socket);
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
        lblNetworkMessage.setText(msg);
    }


    public void getParameters()
    {
//        serverName = getParameter("host");
//        serverPort = Integer.parseInt(getParameter("port"));

        serverName = "localhost";
        serverPort = 4444;
    }

    SpringLayout myLayout = new SpringLayout();

    JLabel txtTitle
            ,txtTopic,txtA,txtQN
            ,txtQnA,txtQnB,txtQnC
            ,txtQnD,txtQnE
            ,txtSubtopic,txtStaffName,txtCorrectAns,lblNetworkMessage,txtNetworkSentMSG;

    JButton btnSubmit,btnExit,btnConnect;
    // Declare Text Fields
    JTextField searchBox, topicBox,
            answerBox,aBox,bBox,
            cBox,dBox,eBox, txtOne,subtopicBox,StaffName,CorrectAnswer;

    JTextArea questionBox;

    ArrayList<Object[]> al = new ArrayList();

    public SecondaryScreen() throws IOException
    {
        //initialise main screen
        setSize(500, 500);
        setLocation(0, 0);
        AddWindowListenerToForm();
        setLayout(myLayout);
        setResizable(false);
        //new BubbleSort(al);

        setTitle("Perfect Policys Quiz | Quiz Screen |");
        // Setup UI
        SetupButtons();
        SetupTextfields();
        SetupJlabels();
        setVisible(true);
        System.out.println("Initial size of al: ");
}

    private void SetupButtons()
    {
    btnSubmit = UIComponentLibrary.CreateJButton("Submit",150,20,10,425,this,this,myLayout);
    btnExit = UIComponentLibrary.CreateJButton("Exit",150,20,300,425,this,this,myLayout);
    btnConnect = UIComponentLibrary.CreateJButton("Connect",150,20,10,10,this,this,myLayout);
    }
    private void SetupTextfields()
    {
        topicBox = UIComponentLibrary.CreateAJTextField(35,70,90,this,myLayout);
        subtopicBox = UIComponentLibrary.CreateAJTextField(35,70,120,this,myLayout);
        questionBox = UIComponentLibrary.CreateAJTextArea(2,35,70,150,this,myLayout);
        aBox = UIComponentLibrary.CreateAJTextField(35,70,210,this,myLayout);
        bBox = UIComponentLibrary.CreateAJTextField(35,70,240,this,myLayout);
        cBox = UIComponentLibrary.CreateAJTextField(35,70,270,this,myLayout);
        dBox = UIComponentLibrary.CreateAJTextField(35,70,300,this,myLayout);
        eBox = UIComponentLibrary.CreateAJTextField(35,70,330,this,myLayout);
        StaffName = UIComponentLibrary.CreateAJTextField(35,70,60,this,myLayout);
        CorrectAnswer = UIComponentLibrary.CreateAJTextField(15,110,400,this,myLayout);
        Border border = BorderFactory.createLineBorder(Color.black, 1);
        questionBox.setBorder(border);
        topicBox.setBorder(border);
        subtopicBox.setBorder(border);
        aBox.setBorder(border);
        bBox.setBorder(border);
        cBox.setBorder(border);
        dBox.setBorder(border);
        eBox.setBorder(border);
        StaffName.setBorder(border);

    }
    private void SetupJlabels()
    {
        txtTitle = UIComponentLibrary.CreateAJLabel("Perfect Policy's", 190,10,this,myLayout);
        txtTopic = UIComponentLibrary.CreateAJLabel("Topic:", 10,90,this, myLayout);
        txtSubtopic = UIComponentLibrary.CreateAJLabel("Subtopic",10,120,this,myLayout);
        txtQN = UIComponentLibrary.CreateAJLabel("Q# :", 10,170,this, myLayout);
        txtA = UIComponentLibrary.CreateAJLabel("Options", 235,190,this, myLayout);
        txtQnA = UIComponentLibrary.CreateAJLabel("A:", 10,210,this, myLayout);
        txtQnB = UIComponentLibrary.CreateAJLabel("B:", 10,240,this, myLayout);
        txtQnC = UIComponentLibrary.CreateAJLabel("C:", 10,270,this, myLayout);
        txtQnD = UIComponentLibrary.CreateAJLabel("D:", 10,300,this, myLayout);
        txtQnE = UIComponentLibrary.CreateAJLabel("E:", 10,330,this, myLayout);
        txtStaffName = UIComponentLibrary.CreateAJLabel("Staff Name",5,60,this, myLayout);
        txtCorrectAns = UIComponentLibrary.CreateAJLabel("Correct Answer:",10,400,this,myLayout);
        lblNetworkMessage = UIComponentLibrary.CreateAJLabel("Message: ",10,375,this,myLayout);
        txtA.setOpaque(true);
        txtTitle.setOpaque(true);
        txtA.setBackground(Color.cyan);
        txtTitle.setBackground(Color.cyan);
        txtTitle.setFont(new Font("Calbri",Font.PLAIN,18));

    }
    private void DisplayText(int index)
    {

    }
    // action listner add
    private void AddWindowListenerToForm()
    {
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent windowEvent) {
                super.windowClosing(windowEvent);
                System.exit(0);
            }
        });
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btnExit) {
            System.exit(0);
        }

        if (e.getSource() == btnConnect) {
            try {
                connect("localhost", 4444);
                lblNetworkMessage.setText("Connected");
            } catch (InterruptedException interruptedException) {
                interruptedException.printStackTrace();
            }
        }
    }
    @Override
    public void mouseClicked(MouseEvent e) {

    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }
}

