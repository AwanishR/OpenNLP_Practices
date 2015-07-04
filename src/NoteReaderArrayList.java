import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

//import java.util.Iterator;
public class NoteReaderArrayList {

	public ArrayList<String> getNotes() {

		// public static void main (String args[]){
		ArrayList<String> notes = new ArrayList<String>();
		try {
			FileReader fr = new FileReader(
					"input\\sample2.txt");
			BufferedReader br = new BufferedReader(fr);
			FileWriter fw = new FileWriter("output\\out.txt");
			BufferedWriter bw = new BufferedWriter(fw);
			String s;
			boolean eof = false;

			int i = 0;
			while (!eof) {
				s = br.readLine();
				if (s != null) {
					// System.out.println(s[i]);
					notes.add(s);
					i++;
				} else {
					eof = true;
				}
			}
			/*
			 * Iterator <String> it = notes.iterator(); while(it.hasNext()) {
			 * System.out.println(it.next()); }
			 */
			br.close();
			bw.write("*****Total number of notes:" + i + "**************");
			// System.out.println("*****Total number of notes:"+i+"**************");
			bw.close();
			fr.close();
			fw.close();
		} catch (FileNotFoundException f) {
			f.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

		// return null;
		return notes;
	}

}
