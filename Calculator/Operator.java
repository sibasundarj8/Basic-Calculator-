package Calculator;

public enum Operator {
    ADD, SUBTRACT, MULTIPLY, DIVIDE, REMINDER;

    public <T extends Number> float apply(T a, T b){
        return switch (this){
            case ADD -> a.intValue() + b.intValue();
            case SUBTRACT -> a.intValue() - b.intValue();
            case MULTIPLY -> a.intValue() * b.intValue();
            case DIVIDE -> (float) a.intValue() / b.intValue();
            case REMINDER -> a.intValue() % b.intValue();
        };
    }
}