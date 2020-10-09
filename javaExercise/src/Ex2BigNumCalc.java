public class Ex2BigNumCalc {

	/** 桁数の上限を定義 */
	private final int DIGIT_LIMIT = 25;

	/** 文字列が数字であるかどうかをチェック */
	private boolean isOk(String numstr) {
		for(int i = 0; i < numstr.length(); i++ ) {
			if( !Character.isDigit( numstr.charAt(i)) ) {
				return false;
			}
		}
		return true;
	}

	/** size の char[] を new し 0 クリアして返す */
	private char[] getZeroCharArray( int size) {
		char[] array;
		array = new char[size];
		// zero clear
		for(int i = 0; i <size; i++) {
			array[i] = 0;
		}
		return array;
	}

	/** 文字列の数字を受け取り、数値にして char 配列で返す */
	private char[] toCharArray( String numstr) {

		char[] ret = getZeroCharArray(DIGIT_LIMIT);

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

	/** n1, n2 の数値を足して、答えを char[] で返す*/
	private char[] plus( String n1, String n2) {
		if( !isOk(n1) || !isOk(n2) ) {
			System.out.println("Cannot calcuration. Not digit.");
			System.exit(1);
		}
		char[] answer = getZeroCharArray(DIGIT_LIMIT + 1);
		char[] n1Array = toCharArray(n1);
		char[] n2Array = toCharArray(n2);
		char  carry = 0;
		for( int i = DIGIT_LIMIT-1; i >= 0; i-- ) {
			answer[i+1] = (char)(n1Array[i] + n2Array[i] + carry);
			carry = (char)((int)answer[i+1] / 10);
			answer[i+1] = (char)((int)answer[i+1] % 10);
		}
		answer[0] = carry;
		return answer;
	}

	/** char 配列の数値を表示する(マイナスも考慮) */
	private void printBigNumber( char[] numAry, boolean isMinus) {

		//--------------------------- ゼロだった場合は 0 を表示し return
		boolean all_zero = true;
		for( int i = 0; i < numAry.length; i++ ) {
			if( numAry[i] != 0 ) {
				all_zero = false;
				break;
			}
		}
		if( all_zero ) {
			System.out.println("0");
			return;
		}

		//--------------------------- それ以外の場合の処理
		boolean start_zero = false;
		if(isMinus) {
			System.out.print("-");
		}
		for(int i = 0; i < numAry.length; i++ ) {
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

		System.out.println(isOk("0123456789"));	//true
		System.out.println(isOk("012A456789"));	//false
		System.out.println(isOk("012BCDEF89"));	//false
		System.out.println(isOk("987654321234567"));	//true
	}

	public void go(){
		//ここに処理を書く（メソッドなどは自由に追加の事）
		System.out.println("Not Yet");	//Dummy
		checkMethods();						//Dalete later
		printBigNumber( plus("123456","987654"), false );		// 1111110
		printBigNumber( plus("1234567890123456789012345",
										"9876543210987654321098765"), false );
									//11111111101111111110111110
		printBigNumber( plus("0","0"), false );		// 0
		printBigNumber( plus("0","A"), false );		// Error!

	}

	//課題 2.（巨大数の和と差）
	public static void main(String[] args) {
		// TODO 自動生成されたメソッド・スタブ
		Ex2BigNumCalc bnc = new Ex2BigNumCalc();
		bnc.go();

	}

}
