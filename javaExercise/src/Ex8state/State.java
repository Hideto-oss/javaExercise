package Ex8state;

public interface State {

	void execute(Context context, State state, int c);
}
