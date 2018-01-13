package CourseWork;

public class Token {

    TokenName tokenName;
    String tokenValue;


    public Token(TokenName tokenName, String tokenValue) {
        this.tokenName = tokenName;
        this.tokenValue = tokenValue;
    }

    @Override
    public String toString() {
        if (tokenValue == "\n") {
            return "\\n" + " :: " + tokenName.name();
        } else if (tokenValue == "\t") {
            return "\\t" + " :: " + tokenName.name();
        } else {
            return tokenValue + " :: " + tokenName.name();
        }
    }

    public TokenName getTokenName() {
        return tokenName;
    }

    public String getTokenValue() {
        return tokenValue;
    }
}
