package calculator;

public class MemoryRecall extends Operator{
    public MemoryRecall(State state) {
        super(state);
    }

    @Override
    void execute() {
        this.state.recallValue();
    }
}
