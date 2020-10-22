package Ex8state;

public class InStringState implements State {

	private static InStringState singleton = new InStringState();
	private InStringState() {}
	public   static State getInstance() { return singleton; }

	@Override
	public void execute(Context context, State state, int c) {
		// TODO 自動生成されたメソッド・スタブ
	 	if( state == InBlockState.getInstance() || state == InOnelineState.getInstance() ) {
	 		System.out.print((char)c);
	 	}else {
	 		if( state == InStringState.getInstance() )
	 			context.changeState(NormalState.getInstance());
	 		else
	 			context.changeState(InStringState.getInstance());
	 	}

	}

}
