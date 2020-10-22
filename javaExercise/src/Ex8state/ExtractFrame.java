package Ex8state;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class ExtractFrame implements Context {

	/** Tokens */
	public final static int beginBlock = 1001;
	public final static int endBlock    = 1002;
	public final static int oneLine      = 1003;
	public final static int newLine     = (int)'\n';
	public final static int dQuote      = (int)'"';

	/** 現在の状態 */
	private State state;

	public ExtractFrame() {
		this.state = NormalState.getInstance();
	}

	@Override
	public void changeState(State state) {
		// TODO 自動生成されたメソッド・スタブ
		this.state = state;
	}

	@Override
	public int getToken(BufferedReader br)  throws IOException {
		// TODO 自動生成されたメソッド・スタブ
		int c1 = br.read();
		if( c1 == -1 )		return -1;
		if( (char)c1 == '"' ) {
			return dQuote;
		}
		br.mark(1);
		int c2 = br.read();
		if( (char)c1 == '/' && (char)c2 == '*' )		return beginBlock;
		if( (char)c1 == '*' && (char)c2 == '/' ) 	return endBlock;
		if( (char)c1 == '/' && (char)c2 == '/' ) 	return oneLine;
		if( (char)c1 == '\r' && (char)c2 == '\n') 	return newLine;
		br.reset();
		return c1;
	}

	@Override
	public void extractor(BufferedReader br) throws IOException {
		int token;
		while((token = getToken(br)) != -1 ) {
			if(token == beginBlock || token == endBlock) {
				(InBlockState.getInstance()).execute(this, state, token);
			}else if(token == oneLine) {
				(InOnelineState.getInstance()).execute(this, state, token);
			}else if(token == newLine) {
				(InNewlineState.getInstance()).execute(this, state, token);
			}else if(token == dQuote) {
				(InStringState.getInstance()).execute(this, state, token);
			}else {
				(NormalState.getInstance()).execute(this, state, token);
			}
		}
	}

	@Override
	public void controlMain(String filename) throws IOException {
		// TODO 自動生成されたメソッド・スタブ
		File f = new File(filename);
		if(!f.exists()) {
			System.out.println("Sorry. " + filename + " is no exist.");
			return;
		}
		FileReader fr = new FileReader(f);
		BufferedReader br = new BufferedReader(fr);
		extractor(br);
		br.close();
	}
}
