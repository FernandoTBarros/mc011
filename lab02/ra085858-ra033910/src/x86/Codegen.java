package x86;

import tree.Stm;
import util.List;
import assem.Instr;

public class Codegen
{
	private Frame frame;
	private List<Instr> list = null;

	public Codegen(Frame f)
	{
		frame = f;
	}

	/**
	 * Funcao auxiliar para armazenar as instrucoes geradas ao decorrer dos Munch
	 * @param instr
	 */
	public void append(Instr instr)
	{
		assert (list != null);
		list.append(instr);
	}

	public List<Instr> codegen(List<Stm> body)
	{
		list = new List<Instr>();

		//Seta a instancia de list criada nas duas classes auxiliares, para ter uma lista apenas para toda execucao
		MunchStm.list = list;
		MunchExp.list = list;

		//Seta instancia de frame na classe MunchExp que sera usada na funcao munchCall e munchBinop
		MunchExp.frame = frame;
		
		//Percorre a arvore de statements fazendo o munch pra cada caso
		for(int i = 0; i < body.size(); i++)
		{
			MunchStm.munchStm(body.get(i));
		}
		
		//Retorna a lista de instrucoes gerada durante a execucao
		return list;
	}

}
