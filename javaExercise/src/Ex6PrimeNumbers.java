import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Ex6PrimeNumbers {

	/** エラトステネスのふるい
	 * 0～9999 の boolean[] で添え字が素数であれば true
	 * そうでなければ false をセットして返す  */
	private boolean[] sieve() {

		boolean[] array = new boolean[10000];
		int i,j;
		for(i = 0; i < array.length; i++) {
			array[i] = true;
		}
		array[0] = false;		//0 は素数ではない
		array[1] = false;		//1 も素数ではない
		for(i = 2; i < array.length; i++) {
			if(array[i]) {
				j = i * 2;
				while(j < array.length) {
					array[j] = false;
					j = j + i;
				}
			}
		}
		return array;
	}

	/** 引数 n を素因数分解してその素数を小さい方から
	 * 配列にセットして返す */
	public List<Integer> getPrimeFactors(int n, boolean[] primelist){

		List<Integer> list = new ArrayList<>();
		for(int i = 2; i < primelist.length; i++) {
			if(primelist[i]) {
				while((n % i) == 0) {
					list.add(i);
					n = n / i;
				}
			}
			if( n == 1 )	break;
		}
		return list;
	}

	/** 引数 n を素因数分解した結果を表示する */
	public void resultPrint(int n, List<Integer> factors) {
		if( factors.size() == 1) {
			System.out.println( n + " は素数です。");
		}else {
			for(Iterator it = factors.iterator(); it.hasNext();) {
				System.out.print(it.next());
				if(!it.hasNext())		break;
				System.out.print(" * ");
			}
			System.out.println();
		}
	}

	//チェックするため暫定で作成
	public void checkMethods() {
		boolean[] primeList = sieve();
		for(int i = 0; i < primeList.length; i++) {
			System.out.println( i + " is " + primeList[i]);
		}
	}

	public void go(){
		//処理を書く
		//System.out.println("Not yet. Sorry.");
		//checkMethods();
		boolean[] primeList = sieve();
		int[]  ns = { 2, 7, 13, 1111, 298, 10, 20, 24, 6144, 256, 5555, 7777, 8888, 9999, 997};
		for(int i = 0; i < ns.length; i++) {
			List<Integer> f = getPrimeFactors(ns[i], primeList);
			resultPrint(ns[i], f);
		}
	}

	public static void main(String[] args) {
		// TODO 自動生成されたメソッド・スタブ
		Ex6PrimeNumbers pn = new Ex6PrimeNumbers();
		pn.go();
	}

}