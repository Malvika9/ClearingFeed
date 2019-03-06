import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashSet;
public class Main {

	static HashSet<String> set=new HashSet<String>();  
	public static void main(String[] args) {
		readFile();
		
	}
	
	public static void readFile() {
		BufferedReader reader;
		
		try {
			reader = new BufferedReader(new FileReader("C:\\Users\\csmal\\Desktop\\Desktop\\SampleFile_TTS.txt"));
			String line = reader.readLine();
			while (line != null) {
				process(line);
				line = reader.readLine();
			}
			reader.close();
		} 
		catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	
	  public static void process(String line) 
	  { 
		  System.out.println(line);   
		  int i=20;
		  while(i!=56)
		  {
			  if(Character.isLetter(line.charAt(i))) 
			  {
				  System.out.println("i is "+ i);
				  ValidateDate(line, i);
				  break;
			  }
			  else
				  i++;
		  }
	  }
	  
	  public static void ValidateDate(String line, int k)
	  {
		  if(line.substring(k-8, k).equalsIgnoreCase(new SimpleDateFormat("ddMMyyyy").format(new Date())))
		  {
			  if(k-8!=12)
				  System.out.println( "Error in Transaction Reference Number");
			  else
			  {
				  if(!set.contains(line.substring(0,k-8)))
				  {
					  set.add(line.substring(0,k-8));
					  System.out.println("RESULT : VALID");
				  }
				  else
					  System.out.println("RESULT : Duplicate Result");
			  }
		  }
		 else
		  {
			  if(k>12)
			  {
				  k=k-1;
				  if(k==12)
					  System.out.println("RESULT : Date is invalid");	
				  ValidateDate(line,k);
			  }
		  }
	  }
}
	  