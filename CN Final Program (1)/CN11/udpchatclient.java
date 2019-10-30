/********************	Assignment No.11******************
Write a program using UDP sockets for wired network to implement
a. peer to peer
Name:Vedant Nandkumar Joshi
Roll No.:51
Batch:TEA-3
**********************************************/
//client
import java.io.*;
import java.net.*;
public class udpchatclient
{
 public static void main(String args[]) throws IOException
 {
	 String message = null;
	 DatagramSocket cs = null; 
	cs = new DatagramSocket();  
	byte[] receiveData = new byte[512];   
	 byte[] sendData  = new byte[512]; 
	 BufferedReader br = new BufferedReader(new InputStreamReader(System.in));  
	 System.out.println(" UDP Client socket is created and waiting for server");
		
     InetAddress IPAddress = InetAddress.getByName("localhost"); 
  
	 int port = 9001;
		  
	 while(true)
	 {
		System.out.println("Client Says:");
						
		message = br.readLine();	
			 
		sendData = message.getBytes(); 
		  
		DatagramPacket sendPacket = new DatagramPacket(sendData, sendData.length, IPAddress,port); 
  
		cs.send(sendPacket);  
  
		DatagramPacket receivePacket =new DatagramPacket(receiveData, receiveData.length); 
  
		cs.receive(receivePacket); 
  
		message = new String(receivePacket.getData(), 0, receivePacket.getLength());  //myoperation = istream.readUTF();

		System.out.println("Server Says: "+message);
		}	 
	}
}

/*
gescoe@gescoe-OptiPlex-3020:~/Desktop/cn_prints$ javac udpchatclient.java
gescoe@gescoe-OptiPlex-3020:~/Desktop/cn_prints$ java udpchatclient
 UDP Client socket is created and waiting for server
Client Says:
hi   
Server Says: hi
Client Says:
how are you?
Server Says: fine thank you
Client Says:
good to see you
*/





