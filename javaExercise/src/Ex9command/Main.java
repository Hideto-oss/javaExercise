package Ex9command;

import Ex9command.command.Command;
import Ex9command.command.MacroCommand;
import Ex9command.drawer.DrawCanvas;
import Ex9command.drawer.DrawCommand;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;


public class Main extends Application {

	//幅
	private int WIDTH = 400;
	//高さ
	private int HEIGHT = 400;
	//描画履歴
	private MacroCommand history = new MacroCommand();
	//描画領域
	DrawCanvas canvas = new DrawCanvas(WIDTH, HEIGHT, history);

	@Override
	public void start(Stage pstage) {

		canvas.setOnMouseDragged((MouseEvent e) -> {
			Command cmd = new DrawCommand(canvas, e.getX(), e.getY() );
			history.append(cmd);
			cmd.execute();
		});

		Button clearButton = new Button("clear");
		clearButton.setOnAction((event)->{
			history.clear();
			canvasClear();
		});

		BorderPane root = new BorderPane();
		root.setTop(clearButton);
		root.setBottom(canvas);
		canvasClear();
		Scene scene = new Scene(root);
		pstage.setScene(scene);
		pstage.setTitle("Command Pattern Sample");
		pstage.sizeToScene();
		pstage.show();
	}

	private void canvasClear() {
		GraphicsContext g = canvas.getGraphicsContext2D();
		g.setFill(Color.WHITE);
		g.fillRect(0, 0,  WIDTH,  HEIGHT);
	}


	public static void main(String[] args) {
		// TODO 自動生成されたメソッド・スタブ
		launch(args);
	}

}
