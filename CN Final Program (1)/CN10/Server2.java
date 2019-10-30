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
public class Server_nt2 {
public static void main(String args[]){


    Socket s=null;
    ServerSocket ss2=null;
    System.out.println("Server Listening......");
    try{
        ss2 = new ServerSocket(4445); 

    }
    catch(IOException e){
    e.printStackTrace();
    System.out.println("Server error");

    }

    while(true){
        try{
            s= ss2.accept();
            System.out.println("connection Established");
            ServerThread st=new ServerThread(s);
            st.start();

        }

    catch(Exception e){
        e.printStackTrace();
        System.out.println("Connection Error");

    }
    }

}

}

class ServerThread extends Thread{  

    String line=null;
    BufferedReader  is = null;
    PrintWriter os=null;
    Socket s=null;

    public ServerThread(Socket s){
        this.s=s;
    }

    public void run() {
    try{
        is= new BufferedReader(new InputStreamReader(s.getInputStream()));
        os=new PrintWriter(s.getOutputStream());

    }catch(IOException e){
        System.out.println("IO error in server thread");
    }

    try {
        line=is.readLine();
        while(line.compareTo("QUIT")!=0){

            os.println(line);
            os.flush();
            System.out.println("Response to Client  :  "+line);
            line=is.readLine();
        }   
    } catch (IOException e) {

        line=this.getName(); //reused String line for getting thread name
        System.out.println("IO Error/ Client "+line+" terminated abruptly");
    }
    catch(NullPointerException e){
        line=this.getName(); //reused String line for getting thread name
        System.out.println("Client "+line+" Closed");
    }

    finally{    
    try{
        System.out.println("Connection Closing..");
        if (is!=null){
            is.close(); 
            System.out.println(" Socket Input Stream Closed");
        }

        if(os!=null){
            os.close();
            System.out.println("Socket Out Closed");
        }
        if (s!=null){
        s.close();
        System.out.println("Socket Closed");
        }

        }
    catch(IOException ie){
        System.out.println("Socket Close Error");
    }
    }//end finally
    }
}

//*************************output*****************
/*
gescoe@gescoe-OptiPlex-3020:~$ cd Documents
gescoe@gescoe-OptiPlex-3020:~/Documents$ cd TEA84
gescoe@gescoe-OptiPlex-3020:~/Documents/TEA84$ javac Server_nt2.java
gescoe@gescoe-OptiPlex-3020:~/Documents/TEA84$ java Server_nt2
Server Listening......
connection Established
Response to Client  :  hi
hi
Response to Client  :  are u complete your assignment
yes
Response to Client  :  yes
Do you complete your Program?
Response to Client  :  do you write a assignment?
Response to Client  :  yes
Response to Client  :  ok
connection Established
Response to Client  :  Hiiii
connection Established
Response to Client  :  How are you?
Response to Client  :  bye
*/



