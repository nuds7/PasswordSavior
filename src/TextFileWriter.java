import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;


public class TextFileWriter {
	public TextFileWriter(String file, String web, String usr, String pwd){
		
		try {
		    PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter(file, true)));
		    out.println(web+"|"+usr+"|"+pwd);
		    out.close();
		} catch (IOException e) {
		    // oops
		}
		
	}
}
