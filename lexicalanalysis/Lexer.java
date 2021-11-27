package lexicalanalysis;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Scanner;

public class Lexer {
    //store string of charactors
    private StringBuilder input = new StringBuilder();
    
    private Token token;
    private String lexema;
    private boolean exausthed = false;
    private String errorMessage = "";

    //Lexer Read Input.txt
    public Lexer(String filePath) {
        
        //Input line by line in st list
       
        //############################
        try {
            FileInputStream fis = new FileInputStream(filePath);
            Scanner sc = new Scanner(fis);    
            while (sc.hasNextLine()) {
                input.append(sc.nextLine());
                input.append("\n");
            }
            sc.close();     //closes the scanner  
        } catch (IOException e) {
            e.printStackTrace();
        }
        //####################################
        moveAhead();
    }
//
    public void moveAhead() {
        if (exausthed) {
            return;
        }
        
        if (input.length() == 0) {
            exausthed = true;
            return;
        }


        if (findNextToken()) {
            return;
        }

        exausthed = true;

        if (input.length() > 0) {
            errorMessage = "Unexpected symbol: '" + input.charAt(0) + "'";
        }
    }

    

    private boolean findNextToken() {
        int i=0;
        for (Token t : Token.values()) {
            int end = t.endOfMatch(input.toString());
            //System.out.println(input.toString());

            if (end != -1) {
                //get token
                token = t;
                
                //รับ char 1 ตัว
                lexema = input.substring(0, end);
                input.delete(0, end);
                i++;
                return true;
            }
        }

        return false;
    }

    // get token type
    public Token currentToken() {
        return token;
    }

    // get lexema
    public String currentLexema() {
        if(lexema.equals("\n")){
        return "";
        }
        if(lexema.equals(" ")){
        return "";
        }
        return lexema;
    }

    // get message when success
    public boolean isSuccessful() {
        return errorMessage.isEmpty();
    }

    // get message when not found token
    public String errorMessage() {
        return errorMessage;
    }

    // check end of file
    public boolean isExausthed() {
        return exausthed;
    }
}