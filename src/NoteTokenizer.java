import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

import opennlp.tools.tokenize.Tokenizer;
import opennlp.tools.tokenize.TokenizerME;
import opennlp.tools.tokenize.TokenizerModel;
import opennlp.tools.util.InvalidFormatException;


public class NoteTokenizer {
	public static void main (String args[])  throws InvalidFormatException,
	IOException 
	{
		InputStream modelIn = new FileInputStream ("D:\\Awanish\\NLP\\Programs\\OpenNLPModels\\en-token.bin");
		try {
			TokenizerModel token = new TokenizerModel (modelIn);
			Tokenizer tokenizer = new TokenizerME (token);
			String tokens []=tokenizer.tokenize("I am a student, what are you?");
			for (String s:tokens)
			{
				System.out.println(s);
			}
		}
		catch (IOException e)
		{
			e.printStackTrace();
		}
	}

}
