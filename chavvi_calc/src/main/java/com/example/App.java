package com.example;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


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
        String RegisterACommand = "a";
        String RegisterBCommand = "B";
        String AddCommand = "+";
        String SubCommand = "-";
        String DivCommand = "/";
        String MultCommand = "*";
        String ClearCommand = "c";
        String QuitCommand = "q";
        Scanner in = new Scanner(System.in);
        Boolean quit= false;
        double A = 0.0;
        double B = 0.0;
        while(quit==false){
            drawMenu( A, B);
            String userInputString = in.nextLine();
            if( isCommand( userInputString, RegisterACommand))
            {
                A = getRegisterValue( "a", in);
            }
            else if( isCommand( userInputString, RegisterBCommand))
            {
                B = getRegisterValue( "b", in);
            }
            else if( isCommand( userInputString, AddCommand))
            {
                calAdd(A, B);
            }
            else if( isCommand( userInputString, SubCommand))
            {
                calSub(A, B);
            }                                    
            else if( isCommand( userInputString, DivCommand))
            {
                calDiv(A, B);
            }
            else if( isCommand( userInputString, MultCommand))
            {
                calMul(A, B);
            }
            else if( isCommand( userInputString, ClearCommand))
            {
                A = 0;
                B = 0;
                System.out.println( "User Selected Clear ");
            }
            else if( isCommand( userInputString, QuitCommand))
            {
                System.out.println( "User Selected Quit ");
                quit = true;
            }
            else{
                drawErrorScreen(userInputString);
            }   
        }
        in.close();
        return;
    }

    public static double getRegisterValue(String RegName, Scanner in)
    {
        double registerValue = 0;
        boolean isValueValid = false;

        String regexFloatingPoint = "[+-]?[0-9]+(\\.[0-9]+)?([Ee][+-]?[0-9]+)?";    // googled regular expression for a floating point number

        while(isValueValid == false)
        {
            System.out.println( "Please Enter a value for Register: " + RegName);
            String userInputString = in.nextLine();
            if(containsNumberRegEx(userInputString, regexFloatingPoint))
            {
                registerValue = Double.parseDouble(userInputString);
                isValueValid = true;
            }   
            else
            {
                System.out.println( "The value entered ( " + userInputString + " ) for register: " + RegName + " is not a valid int, float or double");
            }
        }
        return registerValue;
    }

    public static boolean containsNumberRegEx(String userInputString, String regex){   
        Pattern p = Pattern.compile(regex);    
        Matcher m = p.matcher(userInputString);
        boolean patternMatched = false;
        if(m.find() && m.group().equals(userInputString))
        {
            System.out.println(userInputString + " is a valid float number");
            patternMatched = true;
        }
        else
        {
            System.out.println(userInputString + " is not a valid float number");
        }
        
     
        return patternMatched;
    }

    public static void calAdd(double A, double B)
    {
        String operation = "+";
        double C = A + B;
        displayResult( A, B, C, operation);
        return;
    }

    public static void calSub(double A, double B)
    {
        String operation = "-";
        double C = A - B;
        displayResult( A, B, C, operation);     
        return;
    }

    public static void calDiv(double A, double B)
    {
        if(B != 0){
            String operation = "/";
            double C = A / B;
            displayResult( A, B, C, operation);
        }
        else
        {
            System.out.println( "Divide by zero error" );
        }
        return;
    }

    public static void calMul(double A, double B)
    {
        String operation = "*";
        double C = A * B;
        displayResult( A, B, C, operation);
        return;
    }

    public static void displayResult( double A, double B, double C, String operation)
    {
        String displayA = String.format("%.3f", A);
        String displayB = String.format("%.3f", B);
        String displayC = String.format("%.3f", C);
        System.out.println( "" );
        System.out.println( "Result\t" +  displayA + " " + operation + " " + displayB + " = " + displayC ); 
        System.out.println( "" );
        return;
    }

    public static void drawErrorScreen( String inputString)
    {
        System.out.println( "" );
        System.out.println( "Could not parse input string " + inputString + " as data or command" );
        System.out.println( "" );
        return;
    }

    public static boolean isCommand( String inputString, String CommandString)
    {
       String capInputString = inputString.toUpperCase();
       String capCommandString = CommandString.toUpperCase();
       if(capInputString.equals(capCommandString))
            return true;
        return false;
    }



    public static void drawMenu( double A, double B)
    {
        String displayA = String.format("%.3f", A);
        String displayB = String.format("%.3f", B);
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
