//Client
package onlyfun.caterpillar.chat;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import onlyfun.caterpillar.chat.ox1.MyMonitor;
import java.io.*;
import java.net.*;

public class ox2 extends JFrame {
	
	private Socket socket;
    private BufferedReader serverReader;
    private PrintStream serverWriter,btnox;
    //private String addr="127.0.0.1";
    private int port =9989;
	
    //serverAddr,serverPort
	public void connectToServer(String serverAddr, int serverPort) throws IOException {
		InetAddress serverInetAddr = InetAddress.getByName(serverAddr); 
		socket = new Socket(serverInetAddr, serverPort);
		
		serverReader = new BufferedReader(
                new InputStreamReader(socket.getInputStream()));
    	serverWriter = new PrintStream(socket.getOutputStream());
    	
    	//
    	btnox = new PrintStream(socket.getOutputStream());
    	//
	}
	
    public String getServerMessage() throws IOException {
    	
    	
    	return serverReader.readLine();
    	
    }
    
    public void sendMessageToServer(String message) {
    	
    	serverWriter.println(message);
    }
    
public void sendoxToServer(String ox) {
    	
    	btnox.println(ox);
    }
    
    public void closeConnection() {
    	try {
            socket.close();
    	}
    	catch(IOException e) {
    		
    	}    	
    }
	//
    private Container container;
    private JTextField serverAddrTextField;
    private JButton connectToServerBtn;
    
    MyMonitor mm = new MyMonitor();

    

    
	public ox2() {
	    super("OOXX Client");
	    setUpUIComponent();
	    setUpEventListener();
	    setVisible(true);
	}
	JButton b1,b2,b3,b4,b5,b6,b7,b8,b9;
	JLabel NL;
	JTextField name,server;
	Panel p1=new Panel();
	

	
	private void setUpUIComponent() {
		
		setSize(225, 450);//600,400
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		container = getContentPane();
		JPanel panel = new JPanel();
		
		
		
		panel.setBorder(BorderFactory.createTitledBorder("OOXX"));
        panel.setLayout(new FlowLayout(FlowLayout.CENTER));
        
        panel.add(new JLabel("Server Address"));
        panel.add(serverAddrTextField = new JTextField(10));
        serverAddrTextField.setText(null);
        panel.add(connectToServerBtn = new JButton("call you"));
 
        p1.setSize(280, 280);
        p1.setLocation(0, 0);
        //

        b1=new JButton("");
    	b1.setSize(45, 45);
    	b1.setLocation(50, 110);
    	
    	b2=new JButton("");
    	b2.setSize(45, 45);
    	b2.setLocation(50, 165);
    	
    	b3=new JButton("");
    	b3.setSize(45, 45);
    	b3.setLocation(50, 220);
    	
    	b4=new JButton("");
    	b4.setSize(45, 45);
    	b4.setLocation(105, 110);
    	
    	b5=new JButton("");
    	b5.setSize(45, 45);
    	b5.setLocation(105, 165);
    	
    	b6=new JButton("");
    	b6.setSize(45, 45);
    	b6.setLocation(105, 220);
    	 	
    	b7=new JButton("");
    	b7.setSize(45, 45);
    	b7.setLocation(160, 110);
    	
    	b8=new JButton("");
    	b8.setSize(45, 45);
    	b8.setLocation(160, 165);
    	
    	b9=new JButton("");
    	b9.setSize(45, 45);
    	b9.setLocation(160, 220);
    	 	
    	p1.add(b1);
    	p1.add(b2);
    	p1.add(b3);
    	p1.add(b4);
    	p1.add(b5);
    	p1.add(b6);
    	p1.add(b7);
    	p1.add(b8);
    	p1.add(b9);
    	
    	b1.addActionListener(mm);
    	b2.addActionListener(mm);
    	b3.addActionListener(mm);
    	b4.addActionListener(mm);
    	b5.addActionListener(mm);
    	b6.addActionListener(mm);
    	b7.addActionListener(mm);
    	b8.addActionListener(mm);
    	b9.addActionListener(mm);
 	
    	p1.setLayout(null);
    	p1.setVisible(true);
    	p1.setEnabled(false);
    	panel.add(p1);
        //    
        container.add(panel);
    }
	
	private void setUpEventListener() {
		connectToServerBtn.addActionListener(
                new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                    	//connectToServerBtn.setEnabled(false);
                		
                        new Thread(new Runnable(){
                            public void run() {
                            	try {
                            		if(!(serverAddrTextField.getText().isEmpty())){
                            		connectToServer(serverAddrTextField.getText(),port);
                          	      JOptionPane.showMessageDialog(null, "有人連線囉!");
                          	      connectToServerBtn.setEnabled(false);
                          	      serverAddrTextField.setEditable(false);
                          	      p1.setEnabled(true);
                          	        
                          	        String serverMessage;
                          	        while((serverMessage = getServerMessage()) != null) {
                          	        	
                          	        	switch(Integer.parseInt(serverMessage))
                          	        	{
                          	        	case 1:
                          	        		b1.setText("O");
                          	        		b1.setEnabled(false);
                          	        		break;
                          	        	case 2:
                          	        		b2.setText("O");
                          	        		b2.setEnabled(false);
                          	        		break;
                          	        	case 3:
                          	        		b3.setText("O");
                          	        		b3.setEnabled(false);
                          	        		break;
                          	        	case 4:
                          	        		b4.setText("O");
                          	        		b4.setEnabled(false);
                          	        		break;
                          	        	case 5:
                          	        		b5.setText("O");
                          	        		b5.setEnabled(false);
                          	        		break;
                          	        	case 6:
                          	        		b6.setText("O");
                          	        		b6.setEnabled(false);
                          	        		break;
                          	        	case 7:
                          	        		b7.setText("O");
                          	        		b7.setEnabled(false);
                          	        		break;
                          	        	case 8:
                          	        		b8.setText("O");
                          	        		b8.setEnabled(false);
                          	        		break;
                          	        	case 9:
                          	        		b9.setText("O");
                          	        		b9.setEnabled(false);
                          	        		break;
                          	        	case 10:
                          	        		JOptionPane.showMessageDialog(null, "You Lose!");
                          	        		p1.setVisible(false);
                          	        		break;
                          	        		default:
                          	        			System.out.println("----");
                          	        	}
                        	        		
                          	        	p1.setEnabled(true);
                          	        }
                            			}
                            		else{JOptionPane.showMessageDialog(null, "ip位址不得空址!連線中斷");
                            		closeConnection();}
                            		}
                            	catch(IOException ex) {
                            		closeConnection();
                            		JOptionPane.showMessageDialog(null, "see you..",
                                            "info", JOptionPane.INFORMATION_MESSAGE);
                            		connectToServerBtn.setEnabled(true);
                            	}
                            }
                        }).start();
                    }
                }
            );
	}
	
	public static void main(String[] args) {
		
		
		new ox2();
	}
	
	
	public class MyMonitor implements ActionListener {
	    public void actionPerformed(ActionEvent e) {
	    	
	    	
	    	if(b1==e.getSource()){
	    		b1.setText("X");
	    		b1.setEnabled(false);   		
	    		sendoxToServer("1");
	    	}
	    	
	    	if(b2==e.getSource()){
	    		b2.setText("X");
	    		b2.setEnabled(false);	  		
	    		sendoxToServer("2");
	    	}
	    	
	    	if(b3==e.getSource()){
	    		b3.setText("X");
	    		b3.setEnabled(false);
	    		sendoxToServer("3");
	    	}
	    	
	    	if(b4==e.getSource()){
	    		b4.setText("X");
	    		b4.setEnabled(false);
	    		sendoxToServer("4");
	    	}
	    	
	    	if(b5==e.getSource()){
	    		b5.setText("X");
	    		b5.setEnabled(false);
	    		sendoxToServer("5");
	    	}
	    	
	    	if(b6==e.getSource()){
	    		b6.setText("X");
	    		b6.setEnabled(false);
	    		sendoxToServer("6");
	    	}
	    	
	    	if(b7==e.getSource()){
	    		b7.setText("X");
	    		b7.setEnabled(false);
	    		sendoxToServer("7");
	    	}
	    	
	    	if(b8==e.getSource()){
	    		b8.setText("X");
	    		b8.setEnabled(false);
	    		sendoxToServer("8");
	    	}
	    	
	    	if(b9==e.getSource()){
	    		b9.setText("X");
	    		b9.setEnabled(false);
	    		sendoxToServer("9");
	    	}
	    	p1.setEnabled(false);
	    	win();
	    	    	   	
	    }
	}
	
	
	//
    public void win(){
    	if(b1.getText()=="X" && b2.getText()=="X"&&b3.getText()=="X")
    	{sendoxToServer("10");
    		JOptionPane.showMessageDialog(null, "You Win!");
    	p1.setVisible(false);
    	
    	}
    	
    	if(b4.getText()=="X" && b5.getText()=="X"&&b6.getText()=="X")
    	{sendoxToServer("10");
    		JOptionPane.showMessageDialog(null, "You Win!");
    	p1.setVisible(false);
    	}
    	
    	if(b7.getText()=="X" && b8.getText()=="X"&&b9.getText()=="X")
    	{sendoxToServer("10");
    		JOptionPane.showMessageDialog(null, "You Win!");
    	p1.setVisible(false);
    	}
    	
    	if(b1.getText()=="X" && b4.getText()=="X"&&b7.getText()=="X")
    	{sendoxToServer("10");
    		JOptionPane.showMessageDialog(null, "You Win!");
    	p1.setVisible(false);
    	}
    	
    	if(b2.getText()=="X" && b5.getText()=="X"&&b8.getText()=="X")
    	{sendoxToServer("10");
    		JOptionPane.showMessageDialog(null, "You Win!");
    	p1.setVisible(false);
    	}
    	
    	if(b3.getText()=="X" && b6.getText()=="X"&&b9.getText()=="X")
    	{sendoxToServer("10");
    		JOptionPane.showMessageDialog(null, "You Win!");
    	p1.setVisible(false);
    	}
    	
    	if(b1.getText()=="X" && b5.getText()=="X"&&b9.getText()=="X")
    	{sendoxToServer("10");
    		JOptionPane.showMessageDialog(null, "You Win!");
    	p1.setVisible(false);
    	}
    	
    	if(b3.getText()=="X" && b5.getText()=="X"&&b7.getText()=="X")
    	{sendoxToServer("10");
    		JOptionPane.showMessageDialog(null, "You Win!");
    	p1.setVisible(false);
    	}
    }
    //

}

