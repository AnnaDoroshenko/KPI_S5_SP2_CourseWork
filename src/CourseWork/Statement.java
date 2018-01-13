package CourseWork;

public class Statement extends Node {
    public final String code;

    public Statement(String code) {
        super(NodeName.STATEMENT);
        this.code = code;
    }
}
