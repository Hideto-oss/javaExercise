package Ex10flag;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

public class Main extends Application {

	BorderPane root;
	Pane flagBase;
	private Countries cFlag;

	private final static String[] items = {
			"国名を選択して下さい",			//000
			"アフガニスタン",					//001
			"アルバニア",							//002
			"アルジェリア",						//003
			"アンドラ公国",						//004
			"アンゴラ共和国",					//005
			"南極大陸(Antarctica)",			//006
			"アンティグア・バーブーダ",		//007
			"アルゼンチン",						//008
			"アルメニア",							//009
			"アルバ",								//010
			"オーストラリア",					//011
			"オーストリア",						//012
			"アゼルバイジャン",					//013
			"バハマ",								//014
			"バーレーン",							//015
			"バングラデシュ"						//016
	};

	@Override
	public void start(Stage pstage) throws Exception {

		// TODO 自動生成されたメソッド・スタブ
		flagBase = new Pane();
		flagBase.setPrefSize(Countries.WIDTH, Countries.HEIGHT);
		makeFlag(flagBase);

		ComboBox<String> flagCombo = new ComboBox<String>();
		for(int i=0; i<items.length; i++) {
			flagCombo.getItems().add(i,items[i]);
		}
		flagCombo.setValue(flagCombo.getItems().get(0));

		Button decideButton = new Button("決定");
		decideButton.setOnAction((event)->{
			int selectNum = flagCombo.getSelectionModel().getSelectedIndex();
			if(selectNum == 0 || selectNum == -1) {
				System.out.println("コンボボックスで国名を選択して下さい。");
			}else {
				if(selectNum == cFlag.getAnswerNumber() ) {
					System.out.println("正解です！");
				}else {
					System.out.println("不正解です...");
					System.out.println("正解は「" + items[cFlag.getAnswerNumber()] + "」でした。");
				}
			}
		});

		Button nextButton = new Button("次の問題へ");
		nextButton.setOnAction((event)->{
			makeFlag(flagBase);
		});

		root = new BorderPane();
		root.setTop(flagBase);
		root.setLeft(flagCombo);
		root.setCenter(decideButton);
		root.setRight(nextButton);
		//root.setBottom(decideButton);
		Scene scene = new Scene(root);
		pstage.setScene(scene);
		pstage.setTitle("Which country is this Flag?");
		pstage.sizeToScene();
		pstage.show();
	}

	void makeFlag(Pane base) {
		cFlag = new Countries();
		ImagePattern ip = cFlag.getImagePattern();
		System.out.println("answer is [" + cFlag.getAnswerNumber() + "]");
		Rectangle rect = new Rectangle(Countries.WIDTH * ip.getWidth() ,Countries.HEIGHT * ip.getHeight(), ip );
		base.getChildren().clear();
		base.getChildren().addAll(rect);
	}
	public static void main(String[] args) {
		// TODO 自動生成されたメソッド・スタブ
		launch(args);
	}

}
