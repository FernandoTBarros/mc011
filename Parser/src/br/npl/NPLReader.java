package br.npl;

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

		CharStream charStream = new ANTLRFileStream("arquivos/exemplo.npl");
		NPLLexer lexer = new NPLLexer(charStream); 
		TokenStream tokenStream = new CommonTokenStream(lexer); 
		NPLParser parser = new NPLParser(tokenStream); 
		outString = parser.run().result; 

		try 
		{
			FileWriter fstream = new FileWriter("output/jornal.html");
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
