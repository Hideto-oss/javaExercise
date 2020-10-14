
public class Ex4Base62 {

	/** 文字列が数字あるいはアルファベットであるかどうかをチェック */
	private boolean isDigitAlpha(String numstr) {
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

	/** 62進数の文字を10進数の値に計算して long にして返す */
	private long radix62to10(char c) {
		long ret;
		if(Character.isDigit(c)) {
			ret = (long)(c - '0');
		}else {
			if(Character.isLowerCase(c)) {
				ret = (long)(c -'a') + 10L;
			}else {
				ret = (long)(c -'A') + 36L;
			}
		}
		return ret;
	}

	/** 62進数(4桁まで)を計算して long にして返す */
	public long to10Base(String numstr) {
		if( !isDigitAlpha(numstr) ) {
			System.out.println("Cannot calcuration. Exist invalid character.");
			System.exit(1);
		}
		long factor = 1L;
		long answer = 0L;
		for(int i = numstr.length() - 1; i >= 0; i--) {
				long colnum = radix62to10(numstr.charAt(i));
				answer += colnum * factor;
				factor *= 62L;
		}
		return answer;
	}

	public void go(){
		//処理を書く
		//System.out.println("Not yet. Sorry.");
		String s1 = "1";
		System.out.println("62Base (" + s1 + ") is [" + to10Base(s1) + "].");	//1
		String s2 = "10";
		System.out.println("62Base (" + s2 + ") is [" + to10Base(s2) + "].");	//62
		String s3 = "100";
		System.out.println("62Base (" + s3 + ") is [" + to10Base(s3) + "].");	//3844
		String s4 = "1000";
		System.out.println("62Base (" + s4 + ") is [" + to10Base(s4) + "].");	//238328
		String s5 = "1234";
		System.out.println("62Base (" + s5 + ") is [" + to10Base(s5) + "].");	//246206
		String s6 = "000z";
		System.out.println("62Base (" + s6 + ") is [" + to10Base(s6) + "].");	//35
		String s7 = "000Z";
		System.out.println("62Base (" + s7 + ") is [" + to10Base(s7) + "].");	//61
		String s8 = "zzzz";
		System.out.println("62Base (" + s8 + ") is [" + to10Base(s8) + "].");	//8478225
		String s9 = "ZZZZ";
		System.out.println("62Base (" + s9 + ") is [" + to10Base(s9) + "].");	//14776335
	}
	public static void main(String[] args) {
		// TODO 自動生成されたメソッド・スタブ
		Ex4Base62 b62 = new Ex4Base62();
		b62.go();
	}

}
