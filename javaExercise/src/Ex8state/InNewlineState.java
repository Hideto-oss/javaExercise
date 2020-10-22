package Ex8state;

public class InNewlineState implements State {

	private static InNewlineState singleton = new InNewlineState();
	private InNewlineState() {}
	public   static State getInstance() { return singleton; }

	@Override
	public void execute(Context context, State state, int c) {
		// TODO 自動生成されたメソッド・スタブ
		if( state == InBlockState.getInstance() ) {
			System.out.println();
		}else if( state == InOnelineState.getInstance() ) {
			System.out.println();
			context.changeState(NormalState.getInstance());
		}
	}

}
