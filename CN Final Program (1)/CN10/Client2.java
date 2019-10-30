/*---------------------------------------------------------------
Assignment No:10
Write a program using TCP sockets for wired network to implement 
b. Multiuser Chat 
Demonstrate the packets captured traces using Wireshark Packet Analyzer Tool for peer to
peer mode.
Name:Vedant Nandkumar Joshi
Roll No.:51
Batch:TEA-3
---------------------------------------------------------------*/

import java.io.*;
import java.net.*;

public class Client_nt {

public static void main(String args[]) throws IOException{

    InetAddress address=InetAddress.getLocalHost();
    Socket s1=new Socket("192.168.3.34", 4445); // You can use static final constant PORT_NUM
    String line=null;
    BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
    BufferedReader is=new BufferedReader(new InputStreamReader(s1.getInputStream()));
    PrintWriter os=new PrintWriter(s1.getOutputStream());     
    System.out.println("Client Address : "+address);
    System.out.println("Enter Data to echo Server ( Enter QUIT to end):");

    String response=null;
    try{
	line=br.readLine();

        while(line.compareTo("QUIT")!=0)
	    {
                os.println(line);
                os.flush();
                response=is.readLine();
                System.out.println("Server Response : "+response);
                line=br.readLine();

            }

      }
    catch(IOException e){
        e.printStackTrace();
    System.out.println("Socket read Error");
    }
    finally{

        is.close();os.close();br.close();s1.close();
                System.out.println("Connection Closed");

    }

}
}


/*****************************************************************************
gescoe@gescoe-OptiPlex-3020:~$ cd Desktop
gescoe@gescoe-OptiPlex-3020:~/Desktop$ javac Client_nt.java
gescoe@gescoe-OptiPlex-3020:~/Desktop$ java client_nt
Error: Could not find or load main class client_nt
gescoe@gescoe-OptiPlex-3020:~/Desktop$ javac Client_nt.java
gescoe@gescoe-OptiPlex-3020:~/Desktop$ java Client_nt
Client Address : gescoe-OptiPlex-3020/127.0.1.1
Enter Data to echo Server ( Enter QUIT to end):
hi
Server Response : hi
are u complete your assignment
Server Response : are u complete your assignment
yes
Server Response : yes
do you write a assignment?         
Server Response : do you write a assignment?
yes
Server Response : yes
ok
Server Response : ok

********************************************************************************/
