package lexicalanalysis;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public enum Token {

    //Operators
    TK_MINUS("-"),
    TK_PLUS("\\+[^\\+]"),
    TK_MUL("\\*"),
    TK_DIV("[^\\*\\/]{0}/[^\\*\\/]"),
    TK_LESS("<[^=]"),
    TK_LEG("<="),
    TK_GT(">[^=]"),
    TK_GEQ(">="),
    TK_EQ("=="),
    TK_ASSIGN("="),
    TK_DECREMENT("[^-]--[^-]"),
    TK_INCREMENT("\\+\\+"),

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
    INTEGER("\\d+[^\\w+]"),
    
    //Identifers
    //IDENTIFIER("[^d]{0}(?:\\b[_a-zA-Z]|\\B\\$)[_$a-zA-Z0-9]*+"),
    IDENTIFIER_Error("\\d+\\w+"),
    IDENTIFIER("\\w+"),
    
    //"   U+0022 QUOTATION MARK
    //“   U+201C LEFT DOUBLE QUOTATION MARK
    //”   U+201D RIGHT DOUBLE QUOTATION MARK
    STRING(".*\"([^\"]+)\".*"),
    STRING1(".*\\“([^\\“]+)\\“.*"),
    
    //WhiteSpace
    WHITESPACE(" "),
    
    //New Line
    NEWLINE("\\n"),
    
    COMMENT("(/\\*.*?\\*/)"),
    COMMENT2("//.*"),
    ;
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
