package com.example;
import java.util.Scanner;

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
            String userInputString= in.nextLine();
            quit = true;
        }
        in.close();

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
    }
    public static void hLine(){
        System.out.println( "--------------------------------------------" );
    }
}
