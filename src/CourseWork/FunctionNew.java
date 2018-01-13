package CourseWork;

import java.util.ArrayList;
import java.util.List;

public class FunctionNew extends Node {

    public String name;
    public List<Argument> listOfArguments = new ArrayList<>();

    public FunctionNew(String name, List<Argument> listOfArguments) {
        super(NodeName.FUNCTION_NEW);
        this.name = name;
        this.listOfArguments = listOfArguments;
    }
}
