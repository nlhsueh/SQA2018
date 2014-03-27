//Server
package onlyfun.caterpillar.chat;

import java.awt.*;

import javax.swing.*;

import java.awt.event.*;
import javax.swing.*;
import java.io.*;
import java.net.*;

public class ox1 extends JFrame {
	
	private int serverPort;
    private ServerSocket serverSocket;
    private BufferedReader clientReader;
    private PrintStream clientWriter,btnox;
    private int port =9989;
    Thread ta=new Runner3();
    
	

    
    public void SimpleChatServer(int serverPort) {
        this.serverPort = serverPort;
    }
    
    public String waitForClient() throws IOException {
    	serverSocket = new ServerSocket(serverPort);
    	Socket clientSocket = serverSocket.accept();
    	
    	clientReader = new BufferedReader(
                new InputStreamReader(clientSocket.getInputStream()));
    	clientWriter = new PrintStream(clientSocket.getOutputStream());
    	//
    	btnox = new PrintStream(clientSocket.getOutputStream());
    	//
    	return clientSocket.getInetAddress().getHostName();
    }
    
    public String getClientMessage() throws IOException {
    	return clientReader.readLine();
    }
    
    public void sendMessageToClient(String message) {
    	clientWriter.println(message);
    }
    //
    public void sendoxToClient(String ox) {
    	btnox.println(ox);
    }
    // 
    public void closeConnection() {
    	try {
            serverSocket.close();
    	}
    	catch(IOException e) {
    		
    	}
    }
	//
    private Container container;
    
    private JButton waitForClientBtn;
    
    MyMonitor mm = new MyMonitor();
    
	public ox1() {
	    super("OOXX Server");
	    setUpUIComponent();
	    setUpEventListener();
	    setVisible(true);
	}
	JButton b1,b2,b3,b4,b5,b6,b7,b8,b9;
	Panel p1=new Panel();
	
	private void setUpUIComponent() {
		setSize(225, 450);
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		container = getContentPane();
		JPanel panel = new JPanel();
		
		
		
		
		panel.setBorder(BorderFactory.createTitledBorder("OOXX"));
        panel.setLayout(new FlowLayout(FlowLayout.CENTER));
        
        panel.add(waitForClientBtn = new JButton("wait for you"));

        
        p1.setSize(280, 280);
        p1.setLocation(0, 0);
        
      
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
		waitForClientBtn.addActionListener(
                new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                    	
                    	//waitForClientBtn.setEnabled(false);
                    	JOptionPane.showMessageDialog(null, "等待玩家!");
                    	SimpleChatServer(port);
	
                		ta.start();                		
                		
                        new Thread(new Runnable(){
                         

							private Component jpane;

							public void run() {
                            	try {
                          	    waitForClient();

                          	        JOptionPane.showMessageDialog(null, "有人連線囉!");
                          	        waitForClientBtn.setEnabled(false);
                          	        p1.setEnabled(true);
                          	        ta.stop();
 
                          	        String clientMessage;
                          	        while((clientMessage = getClientMessage()) != null) {
                          	        	
                          	        	//
                          	        	switch(Integer.parseInt(clientMessage))
                          	        	{
                          	        	case 1:
                          	        		b1.setText("X");
                          	        		b1.setEnabled(false);
                          	        		break;
                          	        	case 2:
                          	        		b2.setText("X");
                          	        		b2.setEnabled(false);
                          	        		break;
                          	        	case 3:
                          	        		b3.setText("X");
                          	        		b3.setEnabled(false);
                          	        		break;
                          	        	case 4:
                          	        		b4.setText("X");
                          	        		b4.setEnabled(false);
                          	        		break;
                          	        	case 5:
                          	        		b5.setText("X");
                          	        		b5.setEnabled(false);
                          	        		break;
                          	        	case 6:
                          	        		b6.setText("X");
                          	        		b6.setEnabled(false);
                          	        		break;
                          	        	case 7:
                          	        		b7.setText("X");
                          	        		b7.setEnabled(false);
                          	        		break;
                          	        	case 8:
                          	        		b8.setText("X");
                          	        		b8.setEnabled(false);
                          	        		break;
                          	        	case 9:
                          	        		b9.setText("X");
                          	        		b9.setEnabled(false);
                          	        		break;
                          	        	case 10:
                          	        		JOptionPane.showMessageDialog(null, "You Lose!");
                          	        		p1.setVisible(false);
                          	        		break;
                          	        		default:
                          	        			
                          	        	}
                          	        	//
                          	        	p1.setEnabled(true);
                          	        	
                          	        }
                            	}
                            	catch(IOException ex) {
                            		closeConnection();
                            		JOptionPane.showMessageDialog(null, "see you..",
                                            "info", JOptionPane.INFORMATION_MESSAGE);
                            		waitForClientBtn.setEnabled(true);
                            		
                            	}
                            }
                        }).start();
                    }
                }
            );
	}
	
	public static void main(String[] args) {
		new ox1();
	}
	
	class Runner3 extends Thread {
		public void run() {
			
			for(int i=0; i<=30; i++) {	
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				if(i==30)
				{
					JOptionPane.showMessageDialog(null, "超過 "+i+" 秒自動斷線");
					System.exit(0);}
			}			
		}
	}
	
	public class MyMonitor implements ActionListener {
	    public void actionPerformed(ActionEvent e) {

	    	
	    	if(b1==e.getSource()){
	    		b1.setText("O");
	    		b1.setEnabled(false);
	        	sendoxToClient("1");      	
	    	}
	    	
	    	if(b2==e.getSource()){
	    		b2.setText("O");
	    		b2.setEnabled(false);
	    		sendoxToClient("2");	
	    	}
	    	
	    	if(b3==e.getSource()){
	    		b3.setText("O");
	    		b3.setEnabled(false);
	    		sendoxToClient("3");	
	    	}
	    	
	    	if(b4==e.getSource()){
	    		b4.setText("O");
	    		b4.setEnabled(false);
	    		sendoxToClient("4");
	    	}
	    	
	    	if(b5==e.getSource()){
	    		b5.setText("O");
	    		b5.setEnabled(false);
	    		sendoxToClient("5");
	    	}
	    	
	    	if(b6==e.getSource()){
	    		b6.setText("O");
	    		b6.setEnabled(false);
	    		sendoxToClient("6");
	    	}
	    	
	    	if(b7==e.getSource()){
	    		b7.setText("O");
	    		b7.setEnabled(false);
	    		sendoxToClient("7");
	    	}
	    	
	    	if(b8==e.getSource()){
	    		b8.setText("O");
	    		b8.setEnabled(false);
	    		sendoxToClient("8");
	    	}
	    	
	    	if(b9==e.getSource()){
	    		b9.setText("O");
	    		b9.setEnabled(false);
	    		sendoxToClient("9");
	    	}	    	
	    	p1.setEnabled(false);
	    	win(); 	    	   	
	    }
	}
	
	//
    public void win(){
    	if(b1.getText()=="O" && b2.getText()=="O"&&b3.getText()=="O")
    	{sendoxToClient("10");
    		JOptionPane.showMessageDialog(null, "You Win!");
    		b1.setText(null);
    	p1.setVisible(false);
    	}
    	
    	if(b4.getText()=="O" && b5.getText()=="O"&&b6.getText()=="O")
    	{sendoxToClient("10");
    		JOptionPane.showMessageDialog(null, "You Win!");
    	p1.setVisible(false);
    	}
    	
    	if(b7.getText()=="O" && b8.getText()=="O"&&b9.getText()=="O")
    	{sendoxToClient("10");
    		JOptionPane.showMessageDialog(null, "You Win!");
    	p1.setVisible(false);
    	}
    	
    	if(b1.getText()=="O" && b4.getText()=="O"&&b7.getText()=="O")
    	{sendoxToClient("10");
    		JOptionPane.showMessageDialog(null, "You Win!");
    	p1.setVisible(false);
    	}
    	
    	if(b2.getText()=="O" && b5.getText()=="O"&&b8.getText()=="O")
    	{sendoxToClient("10");
    		JOptionPane.showMessageDialog(null, "You Win!");
    	p1.setVisible(false);
    	}
    	
    	if(b3.getText()=="O" && b6.getText()=="O"&&b9.getText()=="O")
    	{sendoxToClient("10");
    		JOptionPane.showMessageDialog(null, "You Win!");
    	p1.setVisible(false);
    	}
    	
    	if(b1.getText()=="O" && b5.getText()=="O"&&b9.getText()=="O")
    	{sendoxToClient("10");
    		JOptionPane.showMessageDialog(null, "You Win!");
    	p1.setVisible(false);
    	}
    	
    	if(b3.getText()=="O" && b5.getText()=="O"&&b7.getText()=="O")
    	{sendoxToClient("10");
    		JOptionPane.showMessageDialog(null, "You Win!");
    	p1.setVisible(false);
    	}
    }
    //


	
}
