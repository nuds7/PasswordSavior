import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;


public class TextFileReader {
	public ArrayList<String> pwdStrings = new ArrayList<String>();
	
	public TextFileReader(String file) throws IOException{
		BufferedReader br = new BufferedReader(new FileReader(file));
		String line;
		
		while ((line = br.readLine()) != null) {
		   System.out.println(line);
		   pwdStrings.add(line);
		}
		
		splitStringsIntoArray();
		
		br.close();
	}
	public ArrayList splitStringsIntoArray(){
		ArrayList<ArrayList> pArray = new ArrayList<ArrayList>();
		
		for (String p: pwdStrings){
			ArrayList<String> subArray = new ArrayList<String>();
			
			String web = p.substring(0, p.indexOf("|"));
			String usr = p.substring(p.indexOf("|") + 1, p.lastIndexOf("|"));
			String pwd = p.substring(p.lastIndexOf("|")+1);
			
			String vari = "boink";
			
			System.out.println(vari);
			
			subArray.add(web);
			subArray.add(usr);
			subArray.add(pwd);
			
			pArray.add(subArray);
		}
		System.out.println(pArray);
		
		return pArray;
	}
}
