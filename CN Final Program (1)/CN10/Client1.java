/*---------------------------------------------------------------
Assignment No:10
Write a program using TCP sockets for wired network to implement 
a. Peer to Peer Chat 
Demonstrate the packets captured traces using Wireshark Packet Analyzer Tool for peer to
peer mode.
Name:Vedant Nandkumar Joshi
Roll No.:51
Batch:TEA-3
---------------------------------------------------------------*/

import java.net.*;
import java.io.*;

public class Client1{
	public static void main(String args[])throws Exception{  
	                   
	                   Socket s=new Socket("localhost",3344);                   	                          
	                   DataInputStream din=new DataInputStream(s.getInputStream());  
		DataOutputStream dout=new DataOutputStream(s.getOutputStream());  
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));  
		  
		String str="",str2="";  
		while(!str.equals("stop")){  
		str=br.readLine();  
		dout.writeUTF(str);  
		dout.flush();  
		str2=din.readUTF();  
		System.out.println("Server says: "+str2);  
		}  
	  
		dout.close();  
		din.close();
		s.close();  
	}}


//******************OUTPUT*********************

/*gescoe@gescoe-OptiPlex-3020:~/Documents/TEA76$ javac Server1.java
gescoe@gescoe-OptiPlex-3020:~/Documents/TEA76$ java Server1
Client says: hi
hii
Client says: how r u
fine
Client says: hii
*/
//***********************************************
