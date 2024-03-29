import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
//import java.sql.Date;
import java.util.ArrayList;
import java.util.Date;

import opennlp.tools.sentdetect.SentenceDetectorME;
import opennlp.tools.sentdetect.SentenceModel;
import opennlp.tools.tokenize.Tokenizer;
import opennlp.tools.tokenize.TokenizerME;
import opennlp.tools.tokenize.TokenizerModel;
import opennlp.tools.util.InvalidFormatException;

public class StenceDetector {
	public static void main(String args[]) throws InvalidFormatException,
			IOException {

		NoteReaderArrayList noteRead = new NoteReaderArrayList();
		InputStream modelIn = new FileInputStream("en-sent.bin");
		InputStream modelInToken = new FileInputStream("en-token.bin");
		try {
			FileWriter fw = new FileWriter("output\\finaloutput.txt");
			BufferedWriter bw = new BufferedWriter(fw);
			SentenceModel sentMod = new SentenceModel(modelIn);
			SentenceDetectorME sentDetector = new SentenceDetectorME(sentMod);
			TokenizerModel token = new TokenizerModel(modelInToken);
			Tokenizer tokenizer = new TokenizerME(token);
			// String sent
			// []=sentDetector.sentDetect("Called participant to discuss quitting smoking.  He has been smoking for 35+ years and is not interested at this time in quitting.  He isn't even working on attempting to quit.  He does understand that tobacco and nicotine use has a negative impact on his health, but overall he feels fine.  He works closely with his doctor, so he understands the risks.  His doctor has even stopped asking him about quitting smoking at this point.  I did mention that NRT medication have a $0 copay and gave him the contact number for WellDyne just in case.  He did not welcome a follow up coaching session. ");
			// String sent []= noteRead.getNotes();
			ArrayList<String> notes = noteRead.getNotes();
			bw.write("Total Number of Notes +++++++++" + notes.size());
			int TotalCount = 0, count = 0, totTokenCount = 0;
			Date startTime = new Date();
			long start = System.currentTimeMillis();
			System.out.println("Start Time =>" + startTime);
			System.out.println("Program running .....");
			for (String sentences : notes) {
				if (sentences != null) {
					bw.write("\n\nActual Note is +++++++++\n" + sentences);
					String sent[] = sentDetector.sentDetect(sentences);
					// System.out.println("\nThe actual text is:"+s);
					// System.out.println ("\nDetected sentences are:");
					bw.write("\n\n++++++++Detected sentences are +++++++++++++");
					for (String sentToWrite : sent) {
						bw.write("\n++++++++ sentence is +++++++++++++");
						count++;
						bw.write("\n" + sentToWrite);
						TotalCount++;
						String tokens[] = tokenizer.tokenize(sentToWrite);
						int tCount = 0;
						bw.write("\n\n +++ Tokens Detected from this sentence +++++++\n");
						for (String tokensToWrite : tokens) {
							bw.write("\n" + tokensToWrite);
							tCount++;
							totTokenCount++;
						}
						bw.write("\nTotal Number of tokens detected++++++>>"
								+ tCount);
					}
					bw.write("\nNumber of sentences in this note--->" + count);
					count = 0;
				}
			}
			long end = System.currentTimeMillis();
			Date endTime = new Date();
			bw.write("\n\nTotal Detected Sentences +++++++++++++++"
					+ TotalCount);
			bw.write("\n\nTotal Detected Tokens +++++++++++++++"
					+ totTokenCount);
			System.out.println("Processing Complete!!\nTotal Notes Processed="
					+ notes.size());
			System.out.println("Total Sentences detected=" + TotalCount);
			System.out.println("Total Tokens detected=" + totTokenCount);
			float averageSentence = (float) TotalCount / notes.size();
			float averageToken = (float) totTokenCount / notes.size();
			System.out
					.printf("Average sentence per note = %f", averageSentence);
			System.out.printf("\nAverage token per note = %f\n", averageToken);
			long diffInTime = end - start;
			System.out.println("End Time => " + endTime);
			System.out.println("Total Processing Time=>" + (float) diffInTime
					/ 1000 + " seconds");
			bw.close();
			fw.close();
		} catch (IOException ie) {
			ie.printStackTrace();
		} finally {
			if (modelIn != null)
				try {
					modelIn.close();
				} catch (IOException ie) {
					ie.printStackTrace();
				}
		}

	}

}
