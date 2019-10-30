/*----------------------------------------------------------------
Assignment No:10
Write a program using TCP sockets for wired network to implement 
a. Peer to Peer Chat 
Demonstrate the packets captured traces using Wireshark Packet Analyzer Tool for peer to
peer mode.
Name:Vedant Nandkumar Joshi
Roll No.:51
Batch:TEA-3
----------------------------------------------------------------*/

import java.net.*;
import java.io.*;

public class Server1{
	public static void main(String args[])throws Exception{
	ServerSocket ss=new ServerSocket(3344);
	Socket s=ss.accept();
	DataInputStream din=new DataInputStream(s.getInputStream()); 
	DataOutputStream dout=new DataOutputStream(s.getOutputStream());
	BufferedReader br=new BufferedReader (new InputStreamReader(System.in));
	String str="",str2="";
	while(!str.equals("stop")) {
	str= din.readUTF();
	System.out.println("Client says: "+str);
	str2=br.readLine();
	dout.writeUTF(str2);
	dout.flush();
 }
	din.close();
	dout.close();
	s.close();
	ss.close();
 }}
 
 
 //*****************OUTPUT*******************
/* 
gescoe@gescoe-OptiPlex-3020:~/Documents/TEA84$ javac Client1.java
gescoe@gescoe-OptiPlex-3020:~/Documents/TEA84$ java Client1
hi
Server says: hii
how r u
Server says: fine
*/
//****************************************************


 




