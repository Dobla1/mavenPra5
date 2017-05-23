/*
 * @packages 
 * @author Dominik Blankenhorn
 * @version 1.0
 */
package de.domi;

import java.io.*;

/**
 * Praktikum5
 */
public class App 
{
    public static void main( String[] args )
    {
        System.out.println( "Bitte Zeichenkette eingeben!!" );
        try{
        //Einlesen des Strings
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String eingabe = in.readLine().toUpperCase();
        System.out.println(eingabe);
        System.out.println("das wars");
        }catch(IOException e){
        	System.out.println(e.getMessage());
        }
    }
}
