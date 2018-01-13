package CourseWork;

enum PieceName {
    Comma, ParenthesesOpen, ParenthesesClose,
    Plus, Minus, Star, Slash,
    Greater, GreaterOrEquals,
    Less, LessOrEquals,
    Equals, And, Or,
    Bool, Number,
    FunctionBool, FunctionNumber, FunctionEnd;

    public static PieceName getOperatorResultType(PieceName name) {
        switch (name) {
            case Plus:
            case Minus:
            case Star:
            case Slash:
                return PieceName.Number;

            case Greater:
            case GreaterOrEquals:
            case Less:
            case LessOrEquals:
            case Equals:
            case And:
            case Or:
                return PieceName.Bool;

            default:
                System.out.println("Internal error(shouldn't have called this method with such argument)");
                return null;
        }
    }
}
