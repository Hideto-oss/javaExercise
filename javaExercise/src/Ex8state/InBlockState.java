package Ex8state;

public class InBlockState implements State {

	private static InBlockState singleton = new InBlockState();
	private InBlockState() {}
	public   static State getInstance() { return singleton; }

	@Override
	public void execute(Context context, State state, int c) {
		// TODO 自動生成されたメソッド・スタブ
		if(c == ExtractFrame.beginBlock) {
			if( state == NormalState.getInstance() ) {
				context.changeState(InBlockState.getInstance());
			}else if( state == InBlockState.getInstance() || state == InOnelineState.getInstance() ) {
				System.out.print("/*");
			}
			//InStringState の場合は何もしない
		}
		else if(c == ExtractFrame.endBlock) {
			if( state == InBlockState.getInstance()) {
				System.out.println();
				context.changeState(NormalState.getInstance());;
			}else if( state == InOnelineState.getInstance()) {
				System.out.print("*/");
			}
		}
	}

}
