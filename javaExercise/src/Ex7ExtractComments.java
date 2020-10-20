import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class Ex7ExtractComments {

	/** 状態を表す enum (Mode) */
	public enum Mode{
		Normal, InBlockComment, InOnelineComment, InString
	};

	/** トークンを示す enum (Token) */
	public enum Token{

		BeginBlock((int)1001),
		EndBlock((int)1002),
		OneLine((int)1003),
		NewLine((int)'\n'),
		DQuote((int)'"');

		private int value;
		Token(int value){
			this.value = value;
		}
		public int getValue() {
			return this.value;
		}
	};

	//チェックするため暫定で作成
	public void checkMethods(BufferedReader br) throws IOException {
		for(Token tok: Token.values()) {
			System.out.println( "[" + tok.ordinal() + "] "
					+ tok.name() + " (" + tok.getValue() + ")" );
		}
		int data;
		while( (data = br.read()) != -1 ) {
			System.out.print((char)data);
		}
	}

	/** トークンを得る */
	public int getToken(BufferedReader br) throws IOException {
		int c1 = br.read();
		if( c1 == -1 )		return -1;
		if( (char)c1 == '"' ) {
			return Token.DQuote.getValue();
		}
		//if( (char)c1 == '\n' ) {
		//	return Token.NewLine.getValue();
		//}
		br.mark(1);
		int c2 = br.read();
		if( (char)c1 == '/' && (char)c2 == '*' ) {
			return Token.BeginBlock.getValue();
		}
		if( (char)c1 == '*' && (char)c2 == '/' ) {
			return Token.EndBlock.getValue();
		}
		if( (char)c1 == '/' && (char)c2 == '/' ) {
			return Token.OneLine.getValue();
		}
		if( (char)c1 == '\r' && (char)c2 == '\n') {
			return Token.NewLine.getValue();
		}
		br.reset();
		return c1;
	}

	/** コメント抽出処理を行う */
	public void extractor(BufferedReader br) throws IOException {
		int token;
		Mode mode = Mode.Normal;

		while((token = getToken(br)) != -1 ) {

			if(token == Token.BeginBlock.getValue()) {
					if( mode == Mode.Normal) {
						mode = Mode.InBlockComment;
					}else if( mode == Mode.InBlockComment || mode == Mode.InOnelineComment ) {
						System.out.print("/*");
					}
					//InString の場合は何もしない
			}
			else if(token == Token.EndBlock.getValue()) {
					if( mode == Mode.InBlockComment ) {
						System.out.println();
						mode = Mode.Normal;
					}else if( mode == Mode.InOnelineComment ) {
						System.out.print("*/");
					}
			}
			else if(token == Token.OneLine.getValue()) {
					if( mode == Mode.Normal ) {
						mode = Mode.InOnelineComment;
					}else if( mode == Mode.InBlockComment || mode == Mode.InOnelineComment ) {
						System.out.print("//");
					}
			}
			else if(token == Token.NewLine.getValue()) {
					if( mode == Mode.InBlockComment ) {
						System.out.println();
					}else if( mode == Mode.InOnelineComment ) {
						System.out.println();
						mode = Mode.Normal;
					}
			}
			else if(token == Token.DQuote.getValue()) {
			 	if( mode == Mode.InBlockComment || mode == Mode.InOnelineComment ) {
			 		System.out.print('"');
			 	}else {
			 		if( mode == Mode.InString )		mode = Mode.Normal;
			 		else												mode = Mode.InString;
			 	}
			}
			else {
				 	if( mode == Mode.InBlockComment || mode == Mode.InOnelineComment ) {
				 		System.out.print((char)token);
				 	}
			}
		}
	}

	public void go(){
		//処理を書く
		//System.out.println("Not yet. Sorry.");
		String file = "C_sample.txt";
		try {
			File f = new File(file);
			if(!f.exists()) {
				System.out.println("Sorry. " + file + " is no exist.");
				return;
			}
			FileReader fr = new FileReader(f);
			BufferedReader br = new BufferedReader(fr);
			//checkMethods(br);			//単に出力
			extractor(br);
			br.close();
		}catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		// TODO 自動生成されたメソッド・スタブ
		Ex7ExtractComments ec = new Ex7ExtractComments();
		ec.go();
	}
}
