package CourseWork;

import java.util.ArrayList;
import java.util.List;

public class LexicalAnalyzer {

    private TokenName defineToken(String string) {
        TokenName tokenName;
        switch (string) {
            case "def":
                tokenName = TokenName.KEYWORD_DEF;
                break;
            case "if":
                tokenName = TokenName.KEYWORD_IF;
                break;
            case "elif":
                tokenName = TokenName.KEYWORD_ELIF;
                break;
            case "else":
                tokenName = TokenName.KEYWORD_ELSE;
                break;

            case "return":
                tokenName = TokenName.KEYWORD_RETURN;
                break;

            case "True":
            case "False":
                tokenName = TokenName.BOOL;
                break;

            case "and":
                tokenName = TokenName.AND;
                break;

            case "or":
                tokenName = TokenName.OR;
                break;

            default:
                if (Character.isLetter(string.charAt(0))) {
                    tokenName = TokenName.IDENTIFIER;
                    for (int i = 1; i < string.length(); i++) {
                        if (string.contains(".")) {
                            System.out.println("Lexical error: Identifier can't contain any '.'");
                            return null;
                        }
                    }
                } else {
                    int counter = 0;
                    tokenName = TokenName.NUMBER;

                    for (int i = 1; i < string.length(); i++) {
                        if (Character.isLetter(string.charAt(i))) {
                            System.out.println("Lexical error: Invalid input token: '" + string + "'");
                            return null;
                        } else if(string.charAt(i) == '.'){
                            counter++;
                            if (counter >= 2){
                                System.out.println("Lexical error: Invalid floating point number: too many '.'");
                                return null;
                            }
                        }
                    }
                    if(string.charAt(string.length() - 1) == '.'){
                        System.out.println("Lexical error: Invalid floating point number: can't end with '.");
                        return null;
                    }
                }
        }

        return tokenName;
    }

    private String getAtom(String str, int i) {
        int j = i;
        for (; j < str.length(); ) {
            if (Character.isLetter(str.charAt(j)) || Character.isDigit(str.charAt(j)) || str.charAt(j) == '.') {
                j++;
            } else {

                return str.substring(i, j);
            }
        }

        return str.substring(i, j);
    }

    public List<Token> getListOfTokens(String input) {
        List<Token> listOfTokens = new ArrayList<>();

        for (int i = 0; i < input.length(); i++) {
            switch (input.charAt(i)) {
                case '\n':
                    listOfTokens.add(new Token(TokenName.NEW_LINE, "\n"));
                    break;
                case '\t':
                    listOfTokens.add(new Token(TokenName.TAB, "\t"));
                    break;
                case '=':
                    if (input.charAt(i + 1) == '=') {
                        listOfTokens.add(new Token(TokenName.EQUAL, "=="));
                        i ++;
                    } else {
                        listOfTokens.add(new Token(TokenName.ASSIGN, "="));
                    }
                    break;
                case '[':
                    listOfTokens.add(new Token(TokenName.LEFT_BRACKET, "["));
                    break;
                case ']':
                    listOfTokens.add(new Token(TokenName.RIGHT_BRACKET, "]"));
                    break;
                case '(':
                    listOfTokens.add(new Token(TokenName.LEFT_PARENTHESIS, "("));
                    break;
                case ')':
                    listOfTokens.add(new Token(TokenName.RIGHT_PARENTHESIS, ")"));
                    break;
                case '{':
                    listOfTokens.add(new Token(TokenName.LEFT_BRACE, "{"));
                    break;
                case '}':
                    listOfTokens.add(new Token(TokenName.RIGHT_BRACE, "}"));
                    break;
                case ',':
                    listOfTokens.add(new Token(TokenName.COMMA, ","));
                    break;
                case ':':
                    listOfTokens.add(new Token(TokenName.COLON, ":"));
                    break;
                case ';':
                    listOfTokens.add(new Token(TokenName.SEMICOLON, ";"));
                    break;
                case '+':
                    listOfTokens.add(new Token(TokenName.PLUS, "+"));
                    break;
                case '-':
                    listOfTokens.add(new Token(TokenName.MINUS, "-"));
                    break;
                case '*':
                    listOfTokens.add(new Token(TokenName.STAR, "*"));
                    break;
                case '/':
                    listOfTokens.add(new Token(TokenName.SLASH, "/"));
                    break;
                case '>':
                    if (input.charAt(i + 1) == '=') {
                        listOfTokens.add(new Token(TokenName.MORE_EQUAL, ">="));
                        i ++;
                    } else {
                        listOfTokens.add(new Token(TokenName.MORE, ">"));
                    }
                    break;
                case '<':
                    if (input.charAt(i + 1) == '=') {
                        listOfTokens.add(new Token(TokenName.LESS_EQUAL, "<="));
                        i ++;
                    } else {
                        listOfTokens.add(new Token(TokenName.LESS, "<"));
                    }
                    break;

                default:
                    if (input.charAt(i) == ' ') {
                        continue;
                    } else if (Character.isLetter(input.charAt(i)) || Character.isDigit(input.charAt(i))
                            || input.charAt(i) == '.') {
                        final String atom = getAtom(input, i);
                        i += atom.length() - 1;
                        final TokenName definedToken = defineToken(atom);
                        if(definedToken == null){
                            return null;
                        }
                        listOfTokens.add(new Token(definedToken, atom));
                    } else {
                        System.out.println("Lexical error: Unexpected input character");
                        return null;
                    }
                    break;
            }
        }

        return listOfTokens;
    }
}


