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
public class LexicalAnalysis {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Lexer lexer = new Lexer("C:\\Users\\MethanonKaeokrachang\\LexicalAnalysis\\src\\lexicalanalysis\\Input.txt");
        //System.out.println("Lexical Analysis");
        //System.out.println("-----------------");
        while (!lexer.isExausthed()) {
            //System.out.printf("%-18s :  %s \n",lexer.currentLexema() , lexer.currentToken());
            System.out.printf("%s %s\n" , lexer.currentToken(),lexer.currentLexema());
            lexer.moveAhead();
        }
        
        //mean isn't error 
        if (lexer.isSuccessful()) {
            //System.out.println("Ok! :D");
        } else {
            System.out.println(lexer.errorMessage());
        }
    }
    
}
