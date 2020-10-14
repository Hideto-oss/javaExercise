
public class Ex5toBase36toBase62 {

	/** ある桁の数値を 36進数あるいは 62進数の文字にして返す */
	private char toRadix62(char num) {
		if(num < 10) {
			return (char)(num + '0');
		}else if(num < 36){
			return (char)(num - 10 + 'a');
		}else {
			return (char)(num - 36 + 'A');
		}
	}

	/** 10進数 n と基数(36 or 62)を渡して、36あるいは62進数を文字列で返す */
	public String convert( long n,  int radix ) {

		StringBuffer sb = new StringBuffer();
		long column = 1L;
		long temp = n;
		while((int)(temp/(long)radix) > 0) {		//最大桁を求める
			temp /= (long)radix;
			column *= (long)radix;
		}
		while(column > 0L) {
			char c = toRadix62((char)(n/column));
			sb.append(c);
			n %= column;
			column /= (long)radix;
		}
		return sb.toString();
	}

	public void go(){
		//処理を書く
		//System.out.println("Not yet. Sorry.");
		Ex3Base36 b36 = new Ex3Base36();
		Ex4Base62 b62 = new Ex4Base62();

		long n1 = 10L;
		System.out.println( n1 + " is " + convert(n1,36) + "(36進) and " + convert(n1,62) + "(62進)");
		// 10 is a(36進) and a(62進)
		long n2 = 36L;
		System.out.println( n2 + " is " + convert(n2,36) + "(36進) and " + convert(n2,62) + "(62進)");
		// 36 is 10(36進) and A(62進)
		long n3 = 62L;
		System.out.println( n3 + " is " + convert(n3,36) + "(36進) and " + convert(n3,62) + "(62進)");
		// 62 is 1q(36進) and 10(62進)
		long n4 = 1000L;
		System.out.println( n4 + " is " + convert(n4,36) + "(36進) and " + convert(n4,62) + "(62進)");
		// 1000 is rs(36進) and g8(62進)
		long n5 = 60466176L;
		System.out.println( n5 + " is " + convert(n5,36) + "(36進) and " + convert(n5,62) + "(62進)");
		// 60466176 is 100000(36進) and 45I0U(62進)
		long n6 = 99999999L;
		System.out.println( n6 + " is " + convert(n6,36) + "(36進) and " + convert(n6,62) + "(62進)");
		// 99999999 is 1njchr(36進) and 6LAzd(62進)

		long n7 = b36.to10Base("1234");
		System.out.println( n7 + " is " + convert(n7,36) + "(36進) and " + convert(n7,62) + "(62進)");
		// 49360 is 1234(36進) and cQ8(62進)
		long n8 = b62.to10Base("1234");
		System.out.println( n8 + " is " + convert(n8,36) + "(36進) and " + convert(n8,62) + "(62進)");
		// 246206 is 59z2(36進) and 1234(62進)
	}

	public static void main(String[] args) {
		// TODO 自動生成されたメソッド・スタブ
		Ex5toBase36toBase62 conv = new Ex5toBase36toBase62();
		conv.go();
	}

}
