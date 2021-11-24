/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lexicalanalysis;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public enum Token {

    //Operators
    TK_MINUS("-"),
    TK_PLUS("\\+"),
    TK_MUL("\\*"),
    TK_DIV("[^/]/[^/]"),
    TK_LESS("<"),
    TK_LEG("<="),
    TK_GT(">"),
    TK_GEQ(">="),
    TK_EQ("=="),
    TK_ASSIGN("="),
    //operator("\\[+-*]"),
    // TK_Increment("+{2}"),
    //TK_Decrement("-{2}"),

    //() ;
    TK_OPEN("\\("),
    TK_CLOSE("\\)"),
    TK_SEMI(";"),
    //Keywords
    TK_KEY_DEFINE("define"),
    TK_KEY_IF("if"),
    TK_KEY_THEN("then"),
    TK_KEY_ELSE("else"),
    TK_KEY_ENDIF("endif"),
    TK_KEY_WAHILE("while"),
    TK_KEY_DO("do"),
    TK_KEY_ENDWAHILE("endwhile"),
    TK_KEY_PRINT("print"),
    TK_KEY_NEWLINE("newline"),
    TK_KEY_READ("read"),
    //Integers
    INTEGER("\\d+"),
    //Identifers
    IDENTIFIER("\\w+"),
    //String
    STRING("\"[^\"]+\""),
    //WhiteSpace
    WHITESPACE(" "),
    //New Line
    //NEWLINE("\\r"),
    NEWLINE("\\n"),
    //NEWLINE3("\\t"),
    
    //Comments
    COMMENT("(//.*$)|(/\\\\*.*?\\\\*/)");

    // TK_COMMA (","), 
    // TK_NOT ("~"), 
    //TK_AND ("&"), 
    //TK_OR ("\\|"),  
    //OPEN_BRACKET ("\\{"),
    //CLOSE_BRACKET ("\\}")
    private final Pattern pattern;

    Token(String regex) {
        pattern = Pattern.compile("^" + regex);
    }
    
    int endOfMatch(String s) {
       // System.out.println(s);
        Matcher m = pattern.matcher(s);

        if (m.find()) {
            return m.end();
        }
        return -1;
    }
}
