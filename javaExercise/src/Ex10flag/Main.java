package Ex10flag;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

public class Main extends Application {

	BorderPane root;

	//国旗の幅
	private double WIDTH = 207.0;
	//国旗の高さ
	private double HEIGHT = 138.0;

	@Override
	public void start(Stage pstage) throws Exception {
		// TODO 自動生成されたメソッド・スタブ
		Button decideButton = new Button("決定");
		decideButton.setOnAction((event)->{
		});

		Pane flagBase = new Pane();
		flagBase.setPrefSize(WIDTH, HEIGHT);
		makeFlag(flagBase);
		root = new BorderPane();
		root.setTop(flagBase);
		root.setBottom(decideButton);
		Scene scene = new Scene(root);
		pstage.setScene(scene);
		pstage.setTitle("Which country is this Flag?");
		pstage.sizeToScene();
		pstage.show();
	}

	void makeFlag(Pane base) {
		//本来のイメージの縦横比にする方法が解らない
		ImagePattern ip = new ImagePattern(new Image("Ex10flag/Data/flag001.png",WIDTH,HEIGHT,true,false));
		//System.out.println("width  is [" + ip.getWidth() + "]");
		//System.out.println("height is [" + ip.getHeight() + "]");
		Rectangle rect = new Rectangle(WIDTH * ip.getWidth() ,HEIGHT * ip.getHeight(), ip );
		//rect.setFill(ip);
		base.getChildren().addAll(rect);
	}
	public static void main(String[] args) {
		// TODO 自動生成されたメソッド・スタブ
		launch(args);
	}

}
