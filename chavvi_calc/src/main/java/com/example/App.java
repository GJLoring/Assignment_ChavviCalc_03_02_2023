package com.example;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        System.out.println( "Hello World!" );
        double a = 1.0034534535;
        double b = 2.078989;
        double c = 3.00;
        drawMenu( a, b, c);
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
    }
    public static void hLine(){
        System.out.println( "--------------------------------------------" );
    }
}
