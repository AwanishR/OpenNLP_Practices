import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;


public class NoteFileReader  {
	public String [] getNotes(){
		
	//public static void main (String args[]){
		String s[]=new String [25000];
		try {
		FileReader fr = new FileReader ("D:\\Awanish\\NLP\\data\\sample2.txt");
		BufferedReader br = new BufferedReader (fr);
		FileWriter fw  = new FileWriter ("D:\\Awanish\\NLP\\data\\out.txt");
		BufferedWriter bw = new BufferedWriter (fw);
		
		boolean eof = false;
		
		int i =0;
		while (!eof)
		{
			s[i] = br.readLine();
			if (s[i]!=null)
			{
				//System.out.println(s[i]);
				i++;
			}
			else
			{
				eof = true;
			}
		}
		br.close();
		bw.write("*****Total number of notes:"+i+"**************");
		//System.out.println("*****Total number of notes:"+i+"**************");
		bw.close();
		fr.close();
		fw.close();
	}
		catch (FileNotFoundException f)
		{
			f.printStackTrace();
		}
	catch (IOException e)
		{
			e.printStackTrace();
		}
	
		//return null;
		return s;
}
}
