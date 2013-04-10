

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

import org.antlr.v4.runtime.ANTLRFileStream;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.RecognitionException;
import org.antlr.v4.runtime.TokenStream;

public class NPLReader {
	public static void main(String[] args) throws RecognitionException, IOException {
		String outString;

		String inputFile = "arquivos/exemplo.npl";
		String outputFile = "output/jornal.html";
		if(args.length==2)
		{
			inputFile = args[0];
			outputFile = args[1];
		}
		
		CharStream charStream = new ANTLRFileStream(inputFile);
		NPLLexer lexer = new NPLLexer(charStream); 
		TokenStream tokenStream = new CommonTokenStream(lexer); 
		NPLParser parser = new NPLParser(tokenStream); 
		outString = parser.run().result; 

		try 
		{
			FileWriter fstream = new FileWriter(outputFile);
			BufferedWriter out = new BufferedWriter(fstream);
			out.write(outString);
			out.close();
			System.out.println("Arquivo Gerado com Sucesso!");
		} 
		catch (Exception e) 
		{
//			System.err.println("Writing File Error: " + e.getMessage());
			e.printStackTrace();
		}
	}

}
