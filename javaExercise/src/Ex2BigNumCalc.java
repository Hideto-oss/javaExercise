public class Ex2BigNumCalc {

	/** 桁数の上限を定義 */
	private final int DIGIT_LIMIT = 25;

	/** n1 - n2 の値が負になる場合に true をセット */
	private boolean g_minus = false;

	/** 文字列が数字であるかどうかをチェック */
	private boolean isOk(String numstr) {
		for(int i = 0; i < numstr.length(); i++ ) {
			if( !Character.isDigit( numstr.charAt(i)) ) {
				return false;
			}
		}
		return true;
	}

	/** n1 , n2 の大小関係を調べ n1 < n2 の場合に g_mines に true をセット */
	private void checkBigger(byte[] n1, byte[] n2) {
		g_minus = false;
		for(int i = 0; i < DIGIT_LIMIT; i++ ) {
			if( n1[i] == n2[i] ) {
				continue;
			}else {
				if( n1[i] < n2[i] )	g_minus = true;
				break;
			}
		}
	}

	/** size の byte[] を new し 0 クリアして返す */
	private byte[] getZeroByteArray( int size) {
		byte[] array;
		array = new byte[size];
		// zero clear
		for(int i = 0; i <size; i++) {
			array[i] = 0;
		}
		return array;
	}

	/** 文字列の数字を受け取り、数値にして byte 配列で返す */
	private byte[] toByteArray( String numstr) {

		byte[] ret = getZeroByteArray(DIGIT_LIMIT);

		//右詰めで格納するためスタートポジションを計算
		int length = numstr.length();
		int start_pos = DIGIT_LIMIT - length;

		//スタートポジションから末尾まで数値をセット
		for(int i=0; i<length; i++) {
			try {
				ret[start_pos + i] = (byte)Integer.parseInt( numstr.substring(i,i+1) );
			} catch(NumberFormatException e) {
				e.printStackTrace();
			}
		}
		return ret;
	}

	/** n1, n2 の数値を足して、答えを byte[] で返す */
	private byte[] plus( String n1, String n2) {
		if( !isOk(n1) || !isOk(n2) ) {
			System.out.println("Cannot calcuration. Not digit. (in plus())");
			System.exit(1);
		}
		byte[] answer = getZeroByteArray(DIGIT_LIMIT + 1);
		byte[] n1Array = toByteArray(n1);
		byte[] n2Array = toByteArray(n2);
		byte  carry = 0;
		for( int i = DIGIT_LIMIT-1; i >= 0; i-- ) {
			answer[i+1] = (byte)(n1Array[i] + n2Array[i] + carry);
			carry = (byte)((int)answer[i+1] / 10);
			answer[i+1] = (byte)((int)answer[i+1] % 10);
		}
		answer[0] = carry;
		return answer;
	}

	/** n1 - n2 の値を計算して、答えを byte[] で返す
	   * 負だった場合には g_minus に true がセットされる */
	private byte[] minus( String n1, String n2 ) {

		g_minus = false;		//reset!
		if( !isOk(n1) || !isOk(n2) ) {
			System.out.println("Cannot calcuration. Not digit. (in minus())");
			System.exit(1);
		}
		byte[] answer = getZeroByteArray(DIGIT_LIMIT + 1);
		byte[] n1Array = toByteArray(n1);
		byte[] n2Array = toByteArray(n2);


		checkBigger(n1Array,n2Array);
		byte borrow = 0;
		if(!g_minus) {									// n1 >= n2 の場合
			for(int i = DIGIT_LIMIT - 1; i >= 0; i-- ) {
				answer[i+1] = (byte)(n1Array[i] - n2Array[i] - borrow);
				if((int)answer[i+1] < 0) {
					answer[i+1] = (byte)(answer[i+1] + 10);
					borrow = 1;
				}else {
					borrow = 0;
				}
			}
		}else {											// n1 < n2 の場合
			for(int i = DIGIT_LIMIT - 1; i >= 0; i-- ) {
				answer[i+1] = (byte)(n2Array[i] - n1Array[i] - borrow);
				if((int)answer[i+1] < 0) {
					answer[i+1] = (byte)(answer[i+1] + 10);
					borrow = 1;
				}else {
					borrow = 0;
				}
			}
		}
		answer[0] = borrow;
		return answer;
	}

	/** byte 配列の数値を表示する(マイナスも考慮) */
	private void printBigNumber( byte[] numAry, boolean isMinus) {

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
		printBigNumber( toByteArray(test1), false );
		printBigNumber( toByteArray(test2), false );
		printBigNumber( toByteArray(test3), true  );
		printBigNumber( toByteArray(test4), true  );
		printBigNumber( toByteArray(test5), false );

		System.out.println(isOk("0123456789"));	//true
		System.out.println(isOk("012A456789"));	//false
		System.out.println(isOk("012BCDEF89"));	//false
		System.out.println(isOk("987654321234567"));	//true

		byte[] n1 = toByteArray("22222223444444");
		byte[] n2 = toByteArray("22222222555555");
		checkBigger(n1,n2);
		if( g_minus == false )	System.out.println("OK!");
		else								System.out.println("NG!");
		n2 = toByteArray("22222223444444");
		checkBigger(n1,n2);
		if( g_minus == false )	System.out.println("OK!");
		else								System.out.println("NG!");
		n2 = toByteArray("22222223445444");
		checkBigger(n1,n2);
		if( g_minus == true )	System.out.println("OK!");
		else								System.out.println("NG!");
	}

	public void go(){

		//checkMethods();						//Dalete later

		printBigNumber( plus("123456","987654"), false );		// 1111110
		printBigNumber( plus("1234567890123456789012345",
										"9876543210987654321098765"), false );
									//11111111101111111110111110
		printBigNumber( plus("0","0"), false );		// 0
		//printBigNumber( plus("0","A"), false );		// Error!

		printBigNumber( minus("123456","987654"), g_minus );		// -864198
		printBigNumber( minus("1234567890123456789012345",
										   "9876543210987654321098765"), g_minus );
									//    -8641975320864197532086420
		printBigNumber( minus("0","0"), g_minus );		// 0
		printBigNumber( minus("99999","99999"), g_minus );		// 0
		printBigNumber( minus("99999","88888"), g_minus );		// 11111
		printBigNumber( minus("10000","1"), g_minus );				// 9999
		printBigNumber( minus("0","A"), g_minus );		// Error!

	}

	//課題 2.（巨大数の和と差）
	public static void main(String[] args) {
		// TODO 自動生成されたメソッド・スタブ
		Ex2BigNumCalc bnc = new Ex2BigNumCalc();
		bnc.go();

	}

}
