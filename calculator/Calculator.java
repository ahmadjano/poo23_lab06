package calculator;

import java.util.Scanner;

public class Calculator {
    private State state;

    public Calculator() {
        this.state = new State();
    }

    public void Run() {
        Scanner scanner = new Scanner(System.in);
        String input;

        do {
            System.out.print("> ");
            input = scanner.next();

            System.out.println("OK");
        } while(!input.equals("exit"));
    }
}
