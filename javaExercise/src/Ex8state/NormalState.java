package Ex8state;

public class NormalState implements State {

	private static NormalState singleton = new NormalState();
	private NormalState() {}
	public   static State getInstance() { return singleton; }

	@Override
	public void execute(Context context, State state,int c) {
		// TODO 自動生成されたメソッド・スタブ

	 	if( state == InBlockState.getInstance() || state == InOnelineState.getInstance() ) {
	 		System.out.print((char)c);
	 	}

	}

}
