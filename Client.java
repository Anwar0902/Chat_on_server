import java.io.*;
import java.net.*;

class Client
{
 Socket s;
 Client(String ip, int port) throws Exception
 {
  //request a connection
  s = new Socket(ip, port);
 }

 static int getInt()
 {
  try
  {
   System.in.skip(System.in.available()); 
   byte arr[] = new byte[20];
   int n = System.in.read(arr);
   String s = new String(arr,0, n-2);
   return Integer.parseInt(s);
  }
  catch(Exception ex)
  {
   return 0; 
  } 
 }//getInt

 static String getString()
 {
  try
  {
   System.in.skip(System.in.available()); 
   byte arr[] = new byte[100];
   int n = System.in.read(arr);
   String s = new String(arr,0, n-2);
   return s;
  }
  catch(Exception ex)
  {
   return "NA"; 
  } 
 }//getString

 static char getChar()
 {
  try
  {
   System.in.skip(System.in.available()); 
   return (char) System.in.read();
  }
  catch(Exception ex)
  {
   return ' '; 
  } 
 }//getChar


 void interact() throws Exception
 {
  DataInputStream din = new DataInputStream(s.getInputStream());
  DataOutputStream dout = new DataOutputStream(s.getOutputStream());

   char ch ;
   int arr[], opt;
   int points = 0;
   String player,player1,player2, s;

   System.out.print("enter ur name:-");
   player1=getString();
   System.out.print("enter ur friend's name:-");
   player2=getString();
   dout.writeUTF(player1);
   dout.writeUTF(player2);

   do
   {

    player = din.readUTF();
    System.out.println(player2+":-"+player + "\n");
    System.out.print(player1+":-");
    player = getString();
    dout.writeUTF(player);

   }while(true);

  /* s = din.readUTF();
   System.out.println(s);   
   s = din.readUTF();
   System.out.println(s);*/

 }//interact
 
 void close() throws Exception
 {
   s.close();
 }
 public static void main(String args[])
 {
  try
  {
   Client c = new Client("127.0.0.1", 9876);
   c.interact();
   c.close();
  } 
  catch(Exception ex)
  {
   System.out.println(ex);
  }
 }
}