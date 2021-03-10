package Ex9command.drawer;

import Ex9command.command.MacroCommand;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public class DrawCanvas extends Canvas  implements Drawable {

	//描画色
	private Color color = Color.RED;

	//描画時の点の半径
	private int radius = 6;

	//コマンドの履歴
	private MacroCommand history;

	//Constructor
	public DrawCanvas(int width, int height, MacroCommand history) {
		setWidth(width);
		setHeight(height);
		//setSize(width, height);
		//setBackground(Color.WHITE);
		this.history = history;
	}

	//履歴全体を再描画
	public void paint(GraphicsContext g) {
		history.execute();
	}

	//描画
	@Override
	public void draw(int x, int y) {
		// TODO 自動生成されたメソッド・スタブ
		GraphicsContext g = getGraphicsContext2D();
		g.setFill(color);
		g.fillOval(x - radius, y - radius, radius * 2, radius * 2);
	}

}
