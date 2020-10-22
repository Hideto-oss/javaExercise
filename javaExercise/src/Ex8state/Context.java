package Ex8state;

import java.io.BufferedReader;
import java.io.IOException;

public interface Context {

	void changeState(State s);
	int   getToken(BufferedReader br)  throws IOException;
	void extractor(BufferedReader br)  throws IOException;
	void controlMain(String filename)  throws IOException;
}
