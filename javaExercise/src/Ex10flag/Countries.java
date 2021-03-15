package Ex10flag;

import java.util.Random;

import javafx.scene.image.Image;
import javafx.scene.paint.ImagePattern;

public class Countries {

	/** 国旗の幅 */
	public static final double WIDTH = 207.0;
	/** 国旗の高さ */
	public static final double HEIGHT = 138.0;

	/** 国旗の数の上限 */
	private final int FLAG_MAX = 16;
	/** 解答の番号 */
	private int answerNumber;
	/** 当該国旗のイメージ */
	private ImagePattern imagePattern;

	public int getAnswerNumber() {
		return answerNumber;
	}
	public ImagePattern getImagePattern() {
		return imagePattern;
	}

	Countries(){
		Random rand = new Random();
		answerNumber = rand.nextInt(FLAG_MAX) + 1;		//1...16 の範囲の数をセット
		String flagFileName = String.format("Ex10flag/Data/flag%03d.png", answerNumber);
		imagePattern = new ImagePattern(new Image(flagFileName,WIDTH,HEIGHT,true,false));
	}
}
