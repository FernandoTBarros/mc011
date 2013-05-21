package x86;

import java.util.HashMap;

import tree.BINOP;
import tree.CJUMP;

public class ConstantMaps
{
	private static HashMap<Integer, String> mapCjump = new HashMap<Integer,String>();
	private static HashMap<Integer, String> mapBinop = new HashMap<Integer,String>();
	
	static
	{
		mapCjump.put(CJUMP.EQ, "je");
		mapCjump.put(CJUMP.NE, "jne");
		mapCjump.put(CJUMP.GE, "jge");
		mapCjump.put(CJUMP.GT, "jg");
		mapCjump.put(CJUMP.LE, "jle");
		mapCjump.put(CJUMP.LT, "jl");
		mapCjump.put(CJUMP.UGE, "jae");
		mapCjump.put(CJUMP.UGT, "ja");
		mapCjump.put(CJUMP.ULE, "jbe");
		mapCjump.put(CJUMP.ULT, "jb");
		
		mapBinop.put(BINOP.AND, "and");
		mapBinop.put(BINOP.ARSHIFT, "sar");
		mapBinop.put(BINOP.DIV, "idiv");
		mapBinop.put(BINOP.LSHIFT, "shl");
		mapBinop.put(BINOP.MINUS, "sub");
		mapBinop.put(BINOP.OR, "or");
		mapBinop.put(BINOP.PLUS, "add");
		mapBinop.put(BINOP.RSHIFT, "shr");
		mapBinop.put(BINOP.TIMES, "imul");
		mapBinop.put(BINOP.XOR, "xor");
	}
	
	public static String getCjump(int cjumpCode)
	{
		return mapCjump.get(cjumpCode);
	}
	
	public static String getBinop(int binopOp)
	{
		return mapBinop.get(binopOp);
	}
}
