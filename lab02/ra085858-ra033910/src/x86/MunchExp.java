package x86;

import assem.Instr;
import temp.Temp;
import tree.BINOP;
import tree.CALL;
import tree.CONST;
import tree.ESEQ;
import tree.Exp;
import tree.MEM;
import tree.NAME;
import tree.TEMP;
import util.List;

/**
 * Classe utilizada para munch das expressoes
 */
public class MunchExp 
{
	//Mesma instancia de Frame e List da classe x86.Codegen
	public static Frame frame;
	public static List<Instr> list = null;

	/**
	 * Funcao auxiliar para armazenar as instrucoes geradas ao decorrer dos Munch
	 * @param instr
	 */
	public static void append(Instr instr)
	{
		assert (list != null);
		list.append(instr);
	}
	
	/**
	 * Funcao inicial de munch para essa classe, que analisa qual a instancia da expressao e chama a funcao relacionada
	 * @param Exp exp
	 * @return Temp
	 */
	public static Temp munchExp(Exp exp)
	{
		if(exp instanceof tree.BINOP) 		{ return munchBinop((tree.BINOP) exp); }
		if(exp instanceof tree.CALL) 		{ return munchCall((tree.CALL) exp); }
		if(exp instanceof tree.ESEQ) 		{ return munchEseq((tree.ESEQ) exp); }
		if(exp instanceof tree.MEM) 		{ return munchMem((tree.MEM) exp); }
		if(exp instanceof tree.NAME) 		{ return munchName((tree.NAME) exp); }
		if(exp instanceof tree.TEMP) 		{ return munchTemp((tree.TEMP) exp); }
		if(exp instanceof tree.CONST)		{ return munchConst((tree.CONST) exp); }
		return null; // Se chegou aqui significa que não casou com nenhuma expressão e portanto dará erro
	}
	
	/**
	 * Agrega constantes pegando seu valor diretamente
	 * @param CONST exp
	 * @return Temp
	 */
	private static Temp munchConst(CONST exp)
	{
		Temp t = new Temp();
		append(new assem.OPER("mov `d0, " + exp.getValue(), new List<Temp>(t), null));
		return t;
	}

	/**
	 * Agrega temporarios pegando a variavel temp diretamente
	 * @param TEMP exp
	 * @return Temp
	 */
	private static Temp munchTemp(TEMP exp)
	{
		return exp.getTemp();
	}

	/**
	 * Agrega nomes pegando o label e retornando a string
	 * @param NAME exp
	 * @return Temp
	 */
	private static Temp munchName(NAME exp)
	{
		Temp t = new Temp();
		append(new assem.OPER("mov `d0, " + exp.getLabel().toString(), new List<Temp>(t), null));
		return t;
	}

	/**
	 * Agrega expressoes de memoria como se fosse um load
	 * @param MEM exp
	 * @return Temp
	 */
	private static Temp munchMem(MEM exp)
	{
		Temp t1 = new Temp();
		Temp t2 = munchExp(exp.getExpression());
		append(new assem.OPER("mov `d0, [`s0]", new List<Temp>(t1), new List<Temp>(t2)));
		return t1;
	}

	/**
	 * Agrega expressoes sequenciais de statement e expression dando munch primeiro na statement e depois na expression
	 * @param ESEQ exp
	 * @return Temp
	 */
	private static Temp munchEseq(ESEQ exp)
	{
		MunchStm.munchStm(exp.getStatement());
		return munchExp(exp.getExpression());
	}

	/**
	 * Agrega expressao de Call, empilhando os argumentos, chamando a funcao, desempilhando os argumentos e retornando o resultado da funcao
	 * @param CALL exp
	 * @return Temp
	 */
	private static Temp munchCall(CALL exp)
	{
		int nArgs = exp.getArguments().size();

		// Empilha os argumentos de trás pra frente
		for(int i = nArgs - 1; i >= 0; i--)
		{
			append(new assem.OPER("push `s0", null, new List<Temp>(munchExp(exp.getArguments().get(i)))));
		}

		// Se funcao for um NAME direto, chama, senão avalia a expressao
		if(exp.getCallable() instanceof tree.NAME)
		{
			append(new assem.OPER("call " + ((tree.NAME) exp.getCallable()).getLabel(), frame.calleeDefs(), null));
		}
		else
		{
			append(new assem.OPER("call `s0", frame.calleeDefs(), new List<Temp>(munchExp(exp.getCallable()))));
		}

		// Desempilha os argumentos se existir
		if(nArgs > 0)
		{
			append(new assem.OPER("add esp, " + nArgs * frame.wordsize(), new List<Temp>(frame.SP()), new List<Temp>(frame.SP())));
		}

		// Obtem retorno
		Temp ret = new Temp();
		append(new assem.MOVE(ret, frame.RV()));
		return ret;
	}

	/**
	 * Agrega expressoes binarias (+, -, *, /, LSHIFT, RSHIFT, AND, OR, ARSHIFT, XOR), avaliando as expressoes e realizando as operacoes
	 * retornando o resultado no final
	 * @param BINOP exp
	 * @return Temp
	 */
	private static Temp munchBinop(BINOP exp)
	{
		Exp left = exp.getLeft();
		Exp right = exp.getRight();
		Temp temp = new Temp();
		
		//Se for multiplicacao ou divisao, joga o temp como eax
		if(exp.getOperation()==BINOP.DIV || exp.getOperation()==BINOP.TIMES)
		{
			temp = Frame.eax;
		}
		
		//Recupera a string da arquitetura x86 referente ao inteiro da operacao binaria
		String operation = ConstantMaps.getBinop(exp.getOperation());
		//Guarda primeira expressao
		append(new assem.MOVE(temp, munchExp(left)));
		
		if(exp.getRight() instanceof CONST)
		{
			append(new assem.OPER(operation + " `d0, " + ((CONST)exp.getRight()).getValue(), new List<Temp>(temp), new List<Temp>(temp)));
		}
		else
		{
			append(new assem.OPER(operation + " `d0, `u0", new List<Temp>(temp), new List<Temp>(munchExp(right),temp)));
		}
		
		//E no final recupera ele de volta
		if(exp.getOperation()==BINOP.DIV || exp.getOperation()==BINOP.TIMES)
		{
			temp = new Temp();
			append(new assem.MOVE(temp, Frame.eax));
		}
		return temp;
	}
}
