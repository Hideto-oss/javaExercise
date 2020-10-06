public class Ex1NumberDisplay {

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
	//---------------- とりあえず 1 から 100 まで半角数字で出力
	//---------------- 3 の倍数か 3 の数字が含まれていたら *** を出力
	public void go(){
		for(int i=0; i<100; i++){
			if( ((i+1) % 3) == 0 || isThere3(i+1) ){
				System.out.print("*** ");
				System.out.println(i+1);
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
