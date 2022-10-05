package com.example;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )throws Exception
    {
        Socket s=new Socket("localhost",3000);
        PrintWriter pr=new PrintWriter(s.getOutputStream());
      
        BufferedReader tastiera =new BufferedReader(new InputStreamReader(System.in));
        System.out.println("inserisci il messaggio"); 
        String stringaUtente =tastiera.readLine();
        
        pr.println(stringaUtente);
        pr.flush();

        BufferedReader inputStream =new BufferedReader(new InputStreamReader(s.getInputStream()));
        String str =inputStream.readLine();
        System.out.println("Server :" +str);
        s.close();
    }
}
