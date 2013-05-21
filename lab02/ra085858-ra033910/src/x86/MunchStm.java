package x86;

import assem.Instr;
import temp.Label;
import temp.Temp;
import tree.MEM;
import tree.Stm;
import tree.TEMP;
import util.List;

/**
 * Classe utilizada para munch dos statements
 */
public class MunchStm 
{
	//Mesma instancia de List da classe x86.Codegen
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
	 * Funcao inicial de munch para essa classe, que analisa qual a instancia do statement e chama a funcao relacionada
	 * @param Stm stm
	 */
	public static void munchStm(Stm stm)
	{
		if(stm instanceof tree.CJUMP) 		{ munchCjump((tree.CJUMP) stm); }
		else if(stm instanceof tree.EXPSTM) { munchExpstm((tree.EXPSTM) stm); }
		else if(stm instanceof tree.JUMP) 	{ munchJump((tree.JUMP) stm); }
		else if(stm instanceof tree.LABEL) 	{ munchLabel((tree.LABEL) stm); }
		else if(stm instanceof tree.MOVE) 	{ munchMove((tree.MOVE) stm); }
		else if(stm instanceof tree.SEQ) 	{ munchSeq((tree.SEQ) stm); }
	}
	/**
	 * Agrega statement de sequencia, agregando o filho esquerdo e depois o direito
	 * @param SEQ stm
	 */
	private static void munchSeq(tree.SEQ stm)
	{
		munchStm(stm.getLeft());
		munchStm(stm.getRight());
	}

	/**
	 * Agrega statement de move, criando uma instrucao de MOVE caso destination for um TEMP, ou se for um MEM, cria como um store
	 * @param MOVE stm
	 */
	private static void munchMove(tree.MOVE stm)
	{
		if(stm.getDestination() instanceof TEMP)
		{
			append(new assem.MOVE(MunchExp.munchExp(stm.getDestination()), MunchExp.munchExp(stm.getSource())));
		}
		else if(stm.getDestination() instanceof MEM)
		{
			append(new assem.OPER("mov [`u0], `u1", null, new List<Temp>(MunchExp.munchExp(((tree.MEM)stm.getDestination()).getExpression()), MunchExp.munchExp(stm.getSource()))));
		}
		else
		{
			throw new Error("MOVE Não reconhecido! dst:" + stm.getDestination() + " | src: " + stm.getSource());
		}
	}

	/**
	 * Agrega statement de Label, criando a instrucao de label no formato do x86: "label: "
	 * @param LABEL stm
	 */
	private static void munchLabel(tree.LABEL stm)
	{
		append(new assem.LABEL(stm.getLabel().toString() + ":", stm.getLabel()));
	}

	/**
	 * Agrega statement de Jump incondicional, analisando se for por label ou por endereco direto
	 * @param JUMP stm
	 */
	private static void munchJump(tree.JUMP stm)
	{
		if(stm.getExpression() instanceof tree.NAME)
		{
			Label label = ((tree.NAME) stm.getExpression()).getLabel();
			append(new assem.OPER("jmp `j0", new List<Label>(label)));
		}
		else
		{
			Temp t = MunchExp.munchExp(stm.getExpression());
			append(new assem.OPER("jmp `s0", null, new List<Temp>(t, null), stm.getTargets()));
		}
	}

	/**
	 * Agrega statement de jump condicional, avaliando as expressoes, fazendo a comparacao e em seguida fazendo o jump de acordo com o resultado da comparacao
	 * @param CJUMP stm
	 */
	private static void munchCjump(tree.CJUMP stm)
	{
		//Avalia expressoes
		Temp leftTemp = MunchExp.munchExp(stm.getLeft());
		Temp rightTemp = MunchExp.munchExp(stm.getRight());

		//Compara
		append(new assem.OPER("cmp `s0, `s1", null, new List<Temp>(leftTemp, new List<Temp>(rightTemp))));

		//Obtem string referente a constante da operacao para o x86
		String x86Instr = ConstantMaps.getCjump(stm.getOperation());
		if(x86Instr == null) { throw new Error("CJUMP operacao invalida: " + stm.getOperation()); }

		//Faz o jump de acordo com o resultado da comparacao
		append(new assem.OPER(x86Instr + " `j0", new List<Label>(stm.getLabelTrue(), new List<Label>(stm.getLabelFalse()))));
	}

	/**
	 * Agrega statement de expressao, apenas avaliando a expressao
	 * @param EXPSTM stm
	 */
	private static void munchExpstm(tree.EXPSTM stm)
	{
		MunchExp.munchExp(stm.getExpression());
	}
}
