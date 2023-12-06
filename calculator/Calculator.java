package calculator;

import java.util.*;

public class Calculator {
    private final State state;
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
                state.setCurrentValue(input);
                state.pushToStack();
                System.out.println(state.getStack());
            } catch (NumberFormatException e) {
                // Assume it's an operator if we can't parse the input to a double.
                if (operators.containsKey(input)) {
                    operators.get(input).execute();
                    System.out.println(state.getStack());
                } else {
                    System.out.println("Error: Invalid operator.");
                }
            }

        } while(true);
    }
}
