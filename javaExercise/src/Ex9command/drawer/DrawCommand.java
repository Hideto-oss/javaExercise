package Ex9command.drawer;

import java.awt.Point;

import Ex9command.command.Command;


public class DrawCommand implements Command {

	//描画対象
	protected Drawable drawable;

	//描画位置
	private Point position;

	//Constructor
	public DrawCommand(Drawable drawable, Point position) {
		this.drawable = drawable;
		this.position  = position;
	}

	//実行
	@Override
	public void execute() {
		// TODO 自動生成されたメソッド・スタブ
		drawable.draw(position.x, position.y);
	}

}
