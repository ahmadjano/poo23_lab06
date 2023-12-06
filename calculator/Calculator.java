package calculator;

import java.util.*;

/**
 * Calculator class represents a simple CLI calculator with basic arithmetic operations.
 */
public class Calculator {
    protected final State state;
    private final Map<String, Operator> operators;

    /**
     * Calculator constructor initializes the calculator with default operators.
     */
    public Calculator() {
        this.state = new State();
        this.operators = new HashMap<>();

        // Initialize supported operators
        this.operators.put("+", new Addition(state));
        this.operators.put("-", new Subtraction(state));
        this.operators.put("/", new Division(state));
        this.operators.put("*", new Multiplication(state));
        this.operators.put("exp2", new Power(state, 2));
        this.operators.put("sqrt", new SquareRoot(state));
        this.operators.put("reciprocal", new Reciprocal(state));
        this.operators.put("clear", new Clear(state));
    }

    /**
     * Run method starts the calculator's interactive session.
     * It takes user input for numbers and operators until the user types 'exit'.
     */
    public void Run() {
        List<String> operatorsList = new ArrayList<>(operators.keySet());
        Collections.sort(operatorsList);

        System.out.println("Type 'exit' to close the calculator.");
        System.out.format("Valid operators: %s\n", String.join(", ", operatorsList));

        Scanner scanner = new Scanner(System.in);
        String input;

        do {
            System.out.print("> ");
            input = scanner.next();

            if (input.equals("exit")) {
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
                    System.out.println(ex.getMessage());
                }
            }

        } while (true);
    }

    /**
     * Submit value to the calculator.
     *
     * @param input - User input value.
     */
    protected void submitValue(String input) {
        state.updateStatus(State.CalculatorState.INPUT);
        this.state.setCurrentValue(input);
        this.state.pushToStack();
    }

    /**
     * Execute operation based on user input.
     *
     * @param input - User input operator.
     * @throws IllegalArgumentException if the input operator is invalid.
     */
    protected void executeOperation(String input) throws IllegalArgumentException {
        if (operators.containsKey(input)) {
            String value = state.popFromStack();
            operators.get(input).execute();

            if (state.getStatus() == State.CalculatorState.ERROR) {
                String errorMessage = state.getCurrentValue();
                // Undo the pop.
                state.setCurrentValue(value);
                state.pushToStack();
                throw new IllegalArgumentException(errorMessage);
            }

            if (!input.equals("clear")) {
                state.pushToStack();
            }
        } else {
            throw new IllegalArgumentException("Invalid operator: " + input);
        }
    }
}
