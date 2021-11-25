package lexicalanalysis;

import java.util.HashMap;

public class LexicalAnalysis {

    public static void main(String[] args) {
        HashMap<String, String> map = new HashMap<String, String>();
        //################################################################
        Lexer lexer = new Lexer("C:\\Users\\MethanonKaeokrachang\\LexicalAnalysis\\src\\lexicalanalysis\\Input.txt");

        while (!lexer.isExausthed()) {
            // System.out.printf("%-18s :  %s \n",lexer.currentLexema() , lexer.currentToken());
            //System.out.printf("%s %s\n" , lexer.currentToken(),lexer.currentLexema());

            String strLexema = lexer.currentLexema();
            Token strToken = lexer.currentToken();

            if (!strToken.toString().equals("COMMENT")) {
                //System.out.println(strToken.toString()+" "+strLexema);
                if (!strToken.toString().equals("NEWLINE")) {
                    if (!strToken.toString().equals("WHITESPACE")) {
                        if (strToken.toString().equals("IDENTIFIER_Error")) {
                            //add
                            //symbolTable.add(strLexema);
                            System.out.println(" Unexpexted Symbol : " + strLexema);
                            return;
                        }
                        if (strToken.toString().equals("IDENTIFIER")) {
                            //add
                            //symbolTable.add(strLexema);
                            if (map.get(strLexema) == null) {
                                map.put(strLexema, strLexema);
                                System.out.println(strToken.toString() + " : " + strLexema);
                            } else if (map.get(strLexema).equals(strLexema)) {
                                System.out.println("INTEGER already in symbol table : " + strLexema);
                            }

                        } else {
                            System.out.println(checkOperators(strToken.toString()) + " : " + lexer.currentLexema());
                            //System.out.printf("%s %s\n", lexer.currentToken(), lexer.currentLexema());
                        }

                    }
                }
            }

            lexer.moveAhead();
        }

        //mean isn't error 
        if (lexer.isSuccessful()) {
        } else {
            System.out.println(lexer.errorMessage());
        }
    }

    public static String checkOperators(String st) {
        String[] tkOperators = {
            "TK_MINUS",
            "TK_PLUS",
            "TK_MUL",
            "TK_DIV",
            "TK_LESS",
            "TK_LEG",
            "TK_GT",
            "TK_GEQ",
            "TK_EQ",
            "TK_ASSIGN",
            "TK_INCREMENT",
            "TK_DECREMENT",};

        String[] tkKeywords = {
            "TK_KEY_DEFINE",
            "TK_KEY_IF",
            "TK_KEY_THEN",
            "TK_KEY_ELSE",
            "TK_KEY_ENDIF",
            "TK_KEY_WAHILE",
            "TK_KEY_DO",
            "TK_KEY_ENDWAHILE",
            "TK_KEY_PRINT",
            "TK_KEY_NEWLINE",
            "TK_KEY_READ",};
        String[] tkStrings = {
            "STRING",
            "STRING1",};

        String strOperator = "opertor";
        String strKeyword = "keyword";
        String strString = "string";
        for (int i = 0; i < tkOperators.length; i++) {
            if (tkOperators[i].equals(st)) {
                return strOperator;
            }
        }
        for (int i = 0; i < tkKeywords.length; i++) {
            if (tkKeywords[i].equals(st)) {
                return strKeyword;
            }
        }
        for (int i = 0; i < tkStrings.length; i++) {
            if (tkStrings[i].equals(st)) {
                return strString;
            }
        }

        return st;
    }

}
