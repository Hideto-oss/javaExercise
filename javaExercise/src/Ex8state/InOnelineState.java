package Ex8state;

public class InOnelineState implements State {

	private static InOnelineState singleton = new InOnelineState();
	private InOnelineState() {}
	public   static State getInstance() { return singleton; }

	@Override
	public void execute(Context context, State state, int c) {
		// TODO 自動生成されたメソッド・スタブ
		if( state == NormalState.getInstance() ) {
			context.changeState(InOnelineState.getInstance());
		}else if( state == InBlockState.getInstance() || state == InOnelineState.getInstance() ) {
			System.out.print("//");
		}
	}

}
