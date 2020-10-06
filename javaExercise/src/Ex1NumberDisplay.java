public class Ex1NumberDisplay {

	/** 漢数字で数字を出力(親..制御) */
	private void kanji_println(int n){
		kanji_print(n);
		System.out.println("");
	}
	/** 漢数字で数字を出力(子..再帰で上位の数から出力) */
	private void kanji_print(int n){
		if( n == 0 )	return;
		kanji_print(n / 10);
		switch(n % 10){
		    case 0: System.out.print("〇"); break;
		    case 1: System.out.print("一"); break;
		    case 2: System.out.print("二"); break;
		    case 3: System.out.print("三"); break;
		    case 4: System.out.print("四"); break;
		    case 5: System.out.print("五"); break;
		    case 6: System.out.print("六"); break;
		    case 7: System.out.print("七"); break;
		    case 8: System.out.print("八"); break;
		    case 9: System.out.print("九"); break;
		}
	}
	/** 10進数字 n に 3 が含まれていれば true */
	private boolean isThere3(int n) {
		while(n > 0){
			if( (n % 10) == 3) {
				return true;
			}else{
				n /= 10;
			}
		}
		return false;
	}
	/** 1 から 100 まで判定を行い仕様通りにで出力 */
	public void go(){
		for(int i=0; i<100; i++){
			if( ((i+1) % 3) == 0 || isThere3(i+1) ){
				kanji_println(i+1);
			}else{
				System.out.println(i+1);
			}
		}
	}

	//課題 1.（世界のナベアツ）
	public static void main(String[] args) {
		// TODO 自動生成されたメソッド・スタブ
		Ex1NumberDisplay nd = new Ex1NumberDisplay();
		nd.go();
	}

}
