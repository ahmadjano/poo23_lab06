package calculator;

import javax.naming.OperationNotSupportedException;
import java.util.*;

public class Calculator {
    protected final State state;
    private final Map<String, Operator> operators;

    public Calculator() {
        this.state = new State();
        this.operators = new HashMap<>();

        this.operators.put("+", new Addition(state));
        this.operators.put("-", new Subtraction(state));
        this.operators.put("/", new Division(state));
        this.operators.put("*", new Multiplication(state));
        this.operators.put("exp2", new Power(state, 2));
        this.operators.put("sqrt", new SquareRoot(state));
        this.operators.put("reciprocal", new Reciprocal(state));
        this.operators.put("clear", new Clear(state));
    }

    public void Run() {
        List<String> operatorsList = new ArrayList<>(operators.keySet());
        Collections.sort(operatorsList);

        System.out.println("Type 'exit' to close the calculator.");
        System.out.format("Valid operators: %s\n", String.join(", " , String.join(", ", operatorsList)));

        Scanner scanner = new Scanner(System.in);
        String input;

        do {
            System.out.print("> ");
            input = scanner.next();

            if (input.equals("exit")){
                break;
            }

            try {
                Double.parseDouble(input);
                submitValue(input);
                System.out.println(state.getStack());
            } catch (NumberFormatException e) {
                // Assume it's an operator if we can't parse the input to a double.
                try {
                    executeOperation(input);
                    System.out.println(state.getStack());
                } catch (IllegalArgumentException ex) {
                    System.out.println("Error: Invalid operator.");
                }
            }

        } while(true);
    }

    protected void submitValue(String input) {
        this.state.setCurrentValue(input);
        this.state.pushToStack();
    }

    protected void executeOperation(String input) throws IllegalArgumentException {
        if (operators.containsKey(input)) {
            state.popFromStack();
            operators.get(input).execute();
            if (!input.equals("clear")){
                state.pushToStack();
            }
        } else {
            throw new IllegalArgumentException("Invalid operator: " + input);
        }

    }
}
