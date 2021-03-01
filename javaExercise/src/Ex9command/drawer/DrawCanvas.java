package Ex9command.drawer;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;

import Ex9command.command.MacroCommand;

public class DrawCanvas extends Canvas  implements Drawable {

	//描画色
	private Color color = Color.red;

	//描画時の点の半径
	private int radius = 6;

	//コマンドの履歴
	private MacroCommand history;

	//Constructor
	public DrawCanvas(int width, int height, MacroCommand history) {
		setSize(width, height);
		setBackground(Color.white);
		this.history = history;
	}

	//履歴全体を再描画
	public void paint(Graphics g) {
		history.execute();
	}

	//描画
	@Override
	public void draw(int x, int y) {
		// TODO 自動生成されたメソッド・スタブ
		Graphics g = getGraphics();
		g.setColor(color);
		g.fillOval(x - radius, y - radius, radius * 2, radius * 2);
	}

}
