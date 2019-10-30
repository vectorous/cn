/******************Assignment No.11**********************
Write a program using UDP sockets for wired network to implement
b. Multiuser Chat
Name:Vedant Nandkumar Joshi
Roll No.:51
Batch:TEA-3
****************************************************/

import java.net.*;
import java.nio.charset.StandardCharsets;
import java.io.*;  

public class Client {
 
	public static void main(String args[])throws Exception{  
		DatagramSocket datagramSocket = new DatagramSocket(84);

		byte[] buffer;
		InetAddress receiverAddress = InetAddress.getLocalHost();
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		String str="",str2="";  
		while(!str.equals("stop")){  
			str=br.readLine();  
			buffer = str.getBytes();
			DatagramPacket packet = new DatagramPacket(
			        buffer, buffer.length, receiverAddress, 85);
			datagramSocket.send(packet);


			byte[] buffer1 = new byte[10];
			DatagramPacket packet1 = new DatagramPacket(buffer1, buffer1.length);

			datagramSocket.receive(packet1);
			buffer1 = packet1.getData();
			String str1 = new String(buffer1, StandardCharsets.UTF_8);
			System.out.println("Server says: "+str1);

		}  

	}}

/*

gescoe@ubuntu:~/Desktop$  javac udpchatclient.java
gescoe@ubuntu:~/Desktop$ java udpchatclient
UDP Client socket is created and waiting for server
Client Says:
hi
Server Says: hello client 
Client Says:
how are you server
Server Says: i am fine 
Client Says:
ok bye
Server Says: bye
Client Says:
Quit
Server Says: Quit


*/
