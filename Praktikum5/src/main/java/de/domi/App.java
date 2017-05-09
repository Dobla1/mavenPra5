package de.domi;

import java.io.*;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        System.out.println( "Bitte Zeichenkette eingeben!!" );
        try{
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String eingabe = in.readLine().toUpperCase();
        System.out.println(eingabe);
        }catch(IOException e){
        	System.out.println(e.getMessage());
        }
    }
}
