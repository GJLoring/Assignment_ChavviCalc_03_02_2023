package com.example;
import java.util.Scanner;

import javax.lang.model.util.ElementScanner14;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        calc();
    }

    public static void calc()
    {
        Scanner in = new Scanner(System.in);
        Boolean quit= false;
        double A = 0.0;
        double B = 0.0;
        double C = 0.0;
        while(quit==false){
            drawMenu( A, B, C);
            String userInputString = in.nextLine();
            if( isCommandRegisterA(userInputString))
            {
                System.out.println( "Enter value for A: ");
                String aString = in.nextLine();
            }
            else if(isCommandRegisterB(userInputString))
            {
                System.out.println( "Enter value for B: ");
                String bString = in.nextLine();
            }
            else if(isCommandAdd(userInputString))
            {
                System.out.println( "User Selected Add ");
            }
            else if(isCommandSubtract(userInputString))
            {
                System.out.println( "User Selected Subtract ");            
            }                                    
            else if(isCommandDivide(userInputString))
            {
                System.out.println( "User Selected Divide ");
            }
            else if(isCommandMultiply(userInputString))
            {
                System.out.println( "User Selected Multiply ");
            }
            else if(isCommandClear(userInputString))
            {
                A = 0;
                B = 0;
                System.out.println( "User Selected Clear ");
            }
            else if(isCommandQuit(userInputString))
            {
                System.out.println( "User Selected Quit ");
                quit = true;
            }
            else{
                drawErrorScreen(userInputString);
            }
            
        }
        in.close();

    }

    public static void drawErrorScreen( String inputString)
    {
        System.out.println( "Could not parse input string " + inputString + " as data or command" );
        return;
    }

    public static boolean isCommandRegisterA( String inputString)
    {
        if(inputString.equals(new String("a")))
            return true;
        return false;
    }

    public static boolean isCommandRegisterB( String inputString)
    {
        if(inputString.equals(new String("b")))
            return true;
        return false;
    }

    public static boolean isCommandAdd( String inputString)
    {
        if(inputString.equals(new String("+")))
            return true;
        return false;
    }

    public static boolean isCommandSubtract( String inputString)
    {
        if(inputString.equals(new String("-")))
            return true;
        return false;
    }

    public static boolean isCommandDivide( String inputString)
    {
        if(inputString.equals(new String("/")))
            return true;
        return false;
    }

    public static boolean isCommandMultiply( String inputString)
    {
        if(inputString.equals(new String("*")))
            return true;
        return false;
    }

    public static boolean isCommandClear( String inputString)
    {
        if(inputString.equals(new String("c")))
            return true;
        return false;
    }


    public static boolean isCommandQuit( String inputString)
    {
        if(inputString.equals(new String("q")))
            return true;
        return false;
    }


    public static boolean isData( String inputString)
    {
        return true;
    }


    public static void drawMenu( double A, double B, double C)
    {
        String displayA = String.format("%.3f", A);
        String displayB = String.format("%.3f", B);
        String displayC = String.format("%.3f", C);
        hLine();
        System.out.println( "Chavvi Calc" );
        hLine();
        System.out.println( "A = " + displayA + "\tB = " + displayB );
        hLine();
        System.out.println( "a\tEnter value for A" );
        System.out.println( "b\tEnter value for b" );
        System.out.println( "+\tAdd" );
        System.out.println( "-\tSubtract" );
        System.out.println( "*\tMultiply" );
        System.out.println( "/\tDivide" );
        System.out.println( "c\tClear" );
        System.out.println( "q\tQuit" );
        hLine();
        System.out.println( "Enter a command: " );
        return;
    }
    public static void hLine(){
        System.out.println( "--------------------------------------------" );
        return;
    }
}
