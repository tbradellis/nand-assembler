package assembler;

import java.util.HashMap;
import java.util.Map;

public class SystemTable {
	
	//symbol table guts will be a hash map
	private Map<String, Integer> sysTable;

	//constructor for system table
	public SystemTable() {
		
		sysTable = new HashMap<String, Integer>();
		sysTable.put("SP",   0);
		sysTable.put("LCL",  1);
		sysTable.put("ARG",  2);
		sysTable.put("THIS", 3);
		sysTable.put("THAT", 4);
		sysTable.put("R0",   0);
		sysTable.put("R1",   1);
		sysTable.put("R2",   2);
		sysTable.put("R3",   3);
		sysTable.put("R4",   4);
		sysTable.put("R5",   5);
		sysTable.put("R6",   6);
		sysTable.put("R7",   7);
		sysTable.put("R8",   8);
		sysTable.put("R9",   9);
		sysTable.put("R10", 10);
		sysTable.put("R11", 11);
		sysTable.put("R12", 12);
		sysTable.put("R13", 13);
		sysTable.put("R14", 14);
		sysTable.put("SCREEN", 16384);
		sysTable.put("KBD", 24576);
		
	}
	
	public void addEntry(String k, int v) {	
		sysTable.put(k, v);		
	}

	public boolean contains(String k) {		
		return sysTable.containsKey(k);		
	}
	
	public int getAddress(String k) {		
		return sysTable.get(k);		
	}
	
	
}
