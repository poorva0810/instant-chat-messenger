/* package codechef; // don't place package name! */

import java.util.*;
import java.lang.*;
import java.io.*;

/* Name of the class has to be "Main" only if the class is public. */
public class server extends JFrame 
{
	public static void main (String[] args) throws java.lang.Exception
	{
	private JTextField usertext;
	private JTextArea chatwindow;
	private objectoutputstream output;
	private objectinputstream input;
	private serversocket server;
	private socket connection;
	
	
	public server(){
	    super("poorvas instnt messenger");
	    usertext = new JTextField();
	    usertext.seteditable(false);
	    usertext.addactionlistener();
	    new actionlistener(){
	        public  void actionperformed(actionevent event){
	            sendmessage(event.getactioncommand());
	            usertext.settext("");
	        }
	    }
	  
	};
	add(usertext, borderlayout.north);
	chatwindow = new JTextArea();
	add(new Jscrollpane(chatwindow));
	setsize(300,150);
	setvisible(true);
	}
	
	public void startrunning(){
	    try{
	        server = new serversocket(6789, 100);
	        while(true){
	            try{
	                waitforconnection();
	                setupstreams();
	                whilechatting();
	           
	        }catch(EOfexception eofexception){
	            showmessage("\n server ended the connection");
	           
	        }finally{
	            closecrap();
	        }
	}catch(IOexception ioexception){
	    ioexception.printstacktrace();
	}
}

private void waitforconnection() throws ioexception{
    showmessage("waiting for someone to connect...\n");
    connection = server.accept();
    showmessage("now connected to"+connection.getinetaddress().gethostname());
}

private void setupstreams() throws ioexception{
    output = new objectoutputstream(connection.getoutputstream());
    output.flush();
    input = new objectinputstream(connection.getinputstream());
    showmessage("\n streams are now setup \n");
}


private void whilechatting() throws ioexception{
    string message = "you r now connected";
    sendmessage(message);
    abletotype(true);
    do{
        try{
            message = (string) input.readobject();
            showmessage("\n" + message);
        }catch(ClassNotFoundException ClassNotFoundException){
            showmessage("\n idk user");
        }
        }
        
    }while(!message.equals("client - end"));
    
    }
    
    private void closecrap(){
        showmessage("\n closing connection \n");
        abletotype(false);
        try{
            output.close();
            input.close();
            connection.close();
        }
    }
    
    private void sendmessage(string message){
        try{
            output.writeobject("server - " + message);
            output.flush();
            showmessage("\nserver - "+ message);
            
        }catch(IOexceptionexception ioexception){
            chatwindow.append("\n err i cant send message");
        }
        
    }
    
    private void showmessage(final string text){
        swingutilities.invokelater(
            new Runnable(){
                public void run(){
                    chatwindow.append(text);
                }
            }
    );
}

private void abletotype(final boolean tof){
    swingutilities.invokelater(
            new Runnable(){
                public void run(){
                    usertext.seteditable(tof);
}
            }
        }catch(IOexceptionexception ioexception){
            ioexception.printstacktrace();
        }
        }
    }
}
}

}
