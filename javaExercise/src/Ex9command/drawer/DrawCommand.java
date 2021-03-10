package Ex9command.drawer;

import Ex9command.command.Command;


public class DrawCommand implements Command {

	//描画対象
	protected Drawable drawable;

	//描画位置
	private double x;
	private double y;

	//Constructor
	public DrawCommand(Drawable drawable, double x, double y) {
		this.drawable = drawable;
		this.x  = x;
		this.y  = y;
	}

	//実行
	@Override
	public void execute() {
		// TODO 自動生成されたメソッド・スタブ
		drawable.draw((int)x, (int)y);
	}

}
