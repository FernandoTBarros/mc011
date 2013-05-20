package x86;

import temp.Label;
import temp.Temp;
import tree.BINOP;
import tree.CALL;
import tree.CONST;
import tree.ESEQ;
import tree.Exp;
import tree.MEM;
import tree.NAME;
import tree.Stm;
import tree.TEMP;
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

	private void append(Instr instr)
	{
		assert (list != null);
		list.append(instr);
	}

	public List<Instr> codegen(List<Stm> body)
	{
		list = new List<Instr>();

		for(int i = 0; i < body.size(); i++)
		{
			munchStm(body.get(i));
		}

		for(int i = 0; i < body.size(); i++)
		{
			new tree.PrintIR(System.err).printStatement(body.get(i));
		}
		return list;
	}

	//@formatter:off
	private void munchStm(Stm stm)
	{
		if(stm instanceof tree.CJUMP) 		{ munchCjump((tree.CJUMP) stm); }
		else if(stm instanceof tree.EXPSTM) { munchExpstm((tree.EXPSTM) stm); }
		else if(stm instanceof tree.JUMP) 	{ munchJump((tree.JUMP) stm); }
		else if(stm instanceof tree.LABEL) 	{ munchLabel((tree.LABEL) stm); }
		else if(stm instanceof tree.MOVE) 	{ munchMove((tree.MOVE) stm); }
		else if(stm instanceof tree.SEQ) 	{ munchSeq((tree.SEQ) stm); }
	}

	private Temp munchExp(Exp exp)
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

	/** Expressions */
	//@formatter:on
	private Temp munchConst(CONST exp)
	{
		Temp t = new Temp();
		append(new assem.OPER("mov `d0, " + exp.getValue(), new List<Temp>(t), null));
		return t;
	}

	private Temp munchTemp(TEMP exp)
	{
		return exp.getTemp();
	}

	private Temp munchName(NAME exp)
	{
		Temp t = new Temp();
		append(new assem.OPER("mov `d0, " + exp.getLabel().toString(), new List<Temp>(t), null));
		return t;
	}

	private Temp munchMem(MEM exp)
	{
		Temp t1 = new Temp();
		Temp t2 = munchExp(exp.getExpression());
		append(new assem.OPER("mov `d0, [`s0]", new List<Temp>(t1), new List<Temp>(t2)));
		return t1;
	}

	private Temp munchEseq(ESEQ exp)
	{
		munchStm(exp.getStatement());
        return munchExp(exp.getExpression());
	}

	private Temp munchCall(CALL exp)
	{
		// TODO Auto-generated method stub
		return null;
	}

	private Temp munchBinop(BINOP exp)
	{
		// TODO Auto-generated method stub
		return null;
	}

	
	/** Statements */
	private void munchSeq(tree.SEQ stm)
	{
		munchStm(stm.getLeft());
		munchStm(stm.getRight());
	}

	private void munchMove(tree.MOVE stm)
	{
		if(stm.getDestination() instanceof TEMP)
		{
			append(new assem.MOVE(munchExp(stm.getDestination()), munchExp(stm.getSource())));
		}
		else if(stm.getDestination() instanceof MEM)
		{
			//TODO STORE
//			munchMove((MEM) stm.getDestination(), stm.getSource());
		}
		else 
		{
			throw new Error("MOVE Não reconhecido! dst:" + stm.getDestination() + " | src: " + stm.getSource());
		}
	}

	private void munchLabel(tree.LABEL stm)
	{
		append(new assem.LABEL(stm.getLabel().toString() + ":", stm.getLabel()));
	}

	private void munchJump(tree.JUMP stm)
	{
        if(stm.getExpression() instanceof tree.NAME)
        {
        	Label label = ((tree.NAME)stm.getExpression()).getLabel();
        	append(new assem.OPER("jmp `j0", new List<Label>(label)));
        }
        else
        {
        	Temp t = munchExp(stm.getExpression());
        	append(new assem.OPER("jmp `s0", null, new List<Temp>(t,null), stm.getTargets()));
        }
	}

	private void munchCjump(tree.CJUMP stm)
	{
		Temp leftTemp = munchExp(stm.getLeft());
	    Temp rightTemp = munchExp(stm.getRight());

	    append(new assem.OPER("cmp `s0, `s1", null, new List<Temp>(leftTemp, new List<Temp>(rightTemp))));

	    String x86Instr = CjumpMap.get(stm.getOperation());
	    if (x86Instr == null) 
	    { throw new Error("CJUMP operacao invalida: " + stm.getOperation()); }

	    append(new assem.OPER(x86Instr + " `j0", new List<Label>(stm.getLabelTrue(), new List<Label>(stm.getLabelFalse()))));
	}

	private void munchExpstm(tree.EXPSTM stm)
	{
		munchExp(stm.getExpression());
	}
}
