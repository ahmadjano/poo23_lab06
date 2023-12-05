package calculator;

public class Division extends Operator{
    public Division(State state) {
        super(state);
    }

    // /!\ DUPLICATE CODE ACROSS ALL DOUBLE OPERANDS OPERATIONS (ADD, SUB, MULT, DIV)
    // NEEDS CHANGE
    @Override
    void execute() {
        double n1,n2;
        n1 = Double.parseDouble(this.state.popFromStack());
        n2 = Double.parseDouble(this.state.popFromStack());
        double result = n1 / n2;
        String resultString = (int) result - result == 0.0
                ? Integer.toString((int) result)
                : Double.toString(result);
        this.state.pushToStack(resultString);    }
}
