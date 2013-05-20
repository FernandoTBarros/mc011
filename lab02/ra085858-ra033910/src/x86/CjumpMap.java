package x86;

import java.util.HashMap;

import tree.CJUMP;

public class CjumpMap
{
	private static HashMap<Integer, String> mapCjump = new HashMap<Integer,String>();
	
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
	}
	
	public static String get(int cjumpCode)
	{
		return mapCjump.get(cjumpCode);
	}
}
