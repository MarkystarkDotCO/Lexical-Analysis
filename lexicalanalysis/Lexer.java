/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lexicalanalysis;

/**
 *
 * @author MethanonKaeokrachang
 */
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;
import java.util.stream.Stream;

public class Lexer {
    //store charactors 1 line
    private StringBuilder input = new StringBuilder();
 
    //
    private Token token;
    private String lexema;
    private boolean exausthed = false;
    private String errorMessage = "";
    private Set<Character> blankChars = new HashSet<Character>();

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

    public void moveAhead() {
        if (exausthed) {
            return;
        }

        if (input.length() == 0) {
            exausthed = true;
            return;
        }

        //removeWhiteSpaces();

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

    public Token currentToken() {
        return token;
    }

    public String currentLexema() {
        if(lexema.equals("\n")){
            token=null;
        return "";
        }
        if(lexema.equals(" ")){
        token=null;
        return "";
        }
        return lexema;
    }

    public boolean isSuccessful() {
        return errorMessage.isEmpty();
    }

    public String errorMessage() {
        return errorMessage;
    }

    public boolean isExausthed() {
        return exausthed;
    }
}