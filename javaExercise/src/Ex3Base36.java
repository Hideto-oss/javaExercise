
public class Ex3Base36 {

	/** 文字列が数字あるいはアルファベットであるかどうかをチェック */
	private boolean isOk(String numstr) {
		for(int i = 0; i < numstr.length(); i++ ) {
			char c = numstr.charAt(i);
			if( !( Character.isDigit(c) ||
					Character.isUpperCase(c) ||
					Character.isLowerCase(c))   ) {
				return false;
			}
		}
		return true;
	}

	/** 文字列中のアルファベットを大文字にして返す */
	private String toUpperCaseString(String numstr) {
		StringBuffer sb = new StringBuffer();
		for(int i = 0; i < numstr.length(); i++ ) {
			char c = numstr.charAt(i);
			if( Character.isLowerCase(c) ) {
				sb.append(Character.toUpperCase(c));
			} else {
				sb.append(c);
			}
		}
		return sb.toString();
	}

	/** 36進数の文字を10進数の値に計算して long にして返す */
	private long radix36to10(char c) {
		long ret;
		if(Character.isDigit(c)) {
			ret = (long)(c - '0');
		}else {
			ret = (long)(c -'A') + 10L;
		}
		return ret;
	}

	/** 36進数(4桁まで)を計算して long にして返す */
	public long to10Base(String numstr) {
		if( !isOk(numstr) ) {
			System.out.println("Cannot calcuration. Exist invalid character.");
			System.exit(1);
		}
		String upper = toUpperCaseString(numstr);
		long factor = 1L;
		long answer = 0L;
		for(int i = upper.length() - 1; i >= 0; i--) {
				long colnum = radix36to10(upper.charAt(i));
				answer += colnum * factor;
				factor *= 36L;
		}
		return answer;
	}
	//チェックするため暫定で作成
	private void checkMethods() {
		String s1 = "1234567890ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
		System.out.println(isOk(s1));			//true
		String s2 = "1234!567890";
		System.out.println(isOk(s2));			//false
		String s3 = "ABCDEFG&HIJ";
		System.out.println(isOk(s2));			//false
		String s4 = "zyxwv#utsrqpo";
		System.out.println(isOk(s2));			//false
		String s5 = "012345ABCDEF";
		System.out.println(toUpperCaseString(s5));			//012345ABCDEF
		String s6 = "123abcDEFghi4";
		System.out.println(toUpperCaseString(s6));			//123ABCDEFGHI4
		String s7 = "xyz987OPQstu";
		System.out.println(toUpperCaseString(s7));			//XYZ987OPQSTU
		System.out.println(toUpperCaseString(s1));
					//1234567890ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz
	}

	public void go(){
		//処理を書く
		//System.out.println("Not yet. Sorry.");
		//checkMethods();
		String s1 = "1";
		System.out.println("36Base (" + s1 + ") is [" + to10Base(s1) + "].");	//1
		String s2 = "10";
		System.out.println("36Base (" + s2 + ") is [" + to10Base(s2) + "].");	//36
		String s3 = "100";
		System.out.println("36Base (" + s3 + ") is [" + to10Base(s3) + "].");	//1296
		String s4 = "1000";
		System.out.println("36Base (" + s4 + ") is [" + to10Base(s4) + "].");	//46656
		String s5 = "1234";
		System.out.println("36Base (" + s5 + ") is [" + to10Base(s5) + "].");	//49360
		String s6 = "000z";
		System.out.println("36Base (" + s6 + ") is [" + to10Base(s6) + "].");	//35
		String s7 = "1ekf";
		System.out.println("36Base (" + s7 + ") is [" + to10Base(s7) + "].");	//65535
		String s8 = "zzzz";
		System.out.println("36Base (" + s8 + ") is [" + to10Base(s8) + "].");	//1679615
		String s9 = "ZZZZ";
		System.out.println("36Base (" + s9 + ") is [" + to10Base(s9) + "].");	//1679615
		String s0 = "12&3";
		System.out.println("36Base (" + s0 + ") is [" + to10Base(s0) + "].");	//Error Happend!
	}

	public static void main(String[] args) {
		// TODO 自動生成されたメソッド・スタブ
		Ex3Base36 b36 = new Ex3Base36();
		b36.go();
	}

}
