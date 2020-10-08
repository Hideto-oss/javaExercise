public class Ex2BigNumCalc {

	/** 桁数の上限を定義 */
	private final int DIGIT_LIMIT = 25;

	/** 文字列の数字を受け取り数値、にして char 配列で返す */
	private char[] toCharArray( String numstr) {

		char[] ret = new char[DIGIT_LIMIT];
		// zero clear
		for(int i=0; i<DIGIT_LIMIT; i++) {
			ret[i] = 0;
		}
		//右詰めで格納するためスタートポジションを計算
		int length = numstr.length();
		int start_pos = DIGIT_LIMIT - length;

		//スタートポジションから末尾まで数値をセット
		for(int i=0; i<length; i++) {
			try {
				ret[start_pos + i] = (char)Integer.parseInt( numstr.substring(i,i+1) );
			} catch(NumberFormatException e) {
				e.printStackTrace();
			}
		}
		return ret;
	}

	/** char 配列の数値を表示する(マイナスも考慮) */
	private void printBigNumber( char[] numAry, boolean isMinus) {
		boolean start_zero = false;
		if(isMinus) {
			System.out.print("-");
		}
		for(int i = 0; i < DIGIT_LIMIT; i++ ) {
			if( i == 0 && numAry[i] == 0 ) {
				start_zero = true;
				continue;
			}
			if( start_zero && numAry[i] == 0 ) {
				continue;
			}
			if( start_zero && numAry[i] != 0 ) {
				start_zero = false;
			}
			System.out.print( (int)numAry[i] );
		}
		System.out.println("");
	}

	//チェックするため暫定で作成
	private void checkMethods() {
		String test1 = "12345678901230";
		String test2 = "02345678900230";
		String test3 = "00345678900030";
		String test4 = "00045678900030";
		String test5 = "1234567890123456789012345";
		printBigNumber( toCharArray(test1), false );
		printBigNumber( toCharArray(test2), false );
		printBigNumber( toCharArray(test3), true  );
		printBigNumber( toCharArray(test4), true  );
		printBigNumber( toCharArray(test5), false );
	}
	public void go(){
		//ここに処理を書く（メソッドなどは自由に追加の事）
		System.out.println("Not Yet");	//Dummy
		checkMethods();
	}

	//課題 2.（巨大数の和と差）
	public static void main(String[] args) {
		// TODO 自動生成されたメソッド・スタブ
		Ex2BigNumCalc bnc = new Ex2BigNumCalc();
		bnc.go();

	}

}
