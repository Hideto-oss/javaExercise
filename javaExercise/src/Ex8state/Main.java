package Ex8state;

import java.io.IOException;

public class Main {

	public static void main(String[] args) {
		// TODO 自動生成されたメソッド・スタブ
		//処理を書く (ご自由に作成して下さい)
		//System.out.println("Not yet. Sorry.");

		ExtractFrame ef = new ExtractFrame();

		String file = "C_sample.txt";
		try {
			ef.controlMain(file);
		}catch (IOException e) {
			e.printStackTrace();
		}
	}
}
