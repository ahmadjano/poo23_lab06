package calculator;

public class MemoryStore extends Operator{
    public MemoryStore(State state) {
        super(state);
    }

    @Override
    void execute() {
        this.state.storeValue();
    }
}
