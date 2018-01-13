package CourseWork;

public class FunctionEnd extends Node {

    public String name;
    public int amountOfArguments;

    public FunctionEnd(String name, int amountOfArguments) {
        super(NodeName.FUNCTION_END);
        this.name = name;
        this.amountOfArguments = amountOfArguments;
    }
}
