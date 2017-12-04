package assembler;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/*
 * Encapsulate access to the input code.  Reads an assembly language command, parses it, and provides
 * convenient access to the command's components (fields and symbols).
 * Removes all white space and comments.
 * 
 * 
 */


public class Parser {
	
	
	private Scanner scanner;
	private String current = "D=M+1";
	//change this to ENUM data type!! 
	public static commandType comType;


	public String dest;
	public String comp;
	public String jump;
	
	
	public Parser(File file) throws FileNotFoundException {			
		setScanner(new Scanner(file));
		
		//when, where, and how should I close the file		
	}
	
	public Boolean hasMareCommands() {	// check to see if there is a new line
		return (getScanner().hasNextLine());
	}
	
	
	public String advance() {
		return current = getScanner().nextLine();
	}

	
	// check to see if the current instruction is an Address, Command, or Label -returns a string for nominal distinction
	//Just finished conversiont o ENUM...you need to update everything else now.
	
	public commandType commandType() {
		if(current.substring(0,1).equals("@") && Character.isDigit(current.charAt(1))) {
			return assembler.Parser.commandType.A_COMMAND;
		} else if (current.substring(0,1).equals("@")) {
			return comType.L_COMMAND;
		}
		return comType.C_COMMAND;
	}
	
	//call if it's an A_COMMAND
	//returns the string representation of the binary value
	public String address(String aCmnd) {
		String intString = aCmnd.substring(1, aCmnd.length());
		Integer myInt = Integer.parseInt(intString);
		String biString = Integer.toBinaryString(myInt);
		//subtracting from the 16 bits in order to concatenate the leading zeroes for the address instruction
		// only goes to the 15th
		// return concatenates the opcode 0
		int count = 15 - biString.length();
		for(int i=0; i< count; i++ ) {
			biString = "0" + biString;
		}
		return "0" + biString;
	}
	// Dest instruction will be called for both jump and compute
	// use if contains (; || =) before executing
	// do not execute if it is an instruction that just computes, i.e 1
	
	public String dest() {
		if(current.contains("=")) {
			return dest = current.substring(0, current.indexOf("="));
		} else {
			return dest = "NULL";
		}
	}
	
	//returns everything to the right of the equal sign (compute instruction
	//used in conjunction with dest
	//Will need check to see if the current instruction is a pure compute instruction (vs jump)
	
	public String comp() {
		if(current.contains("=")) {
			return comp = current.substring(current.indexOf("=") + 1, current.length());
		}else if (current.contains(";")){
			return comp = current.substring(0, current.indexOf(";"));
		}
		return "NULL";
	}
	
	//use to get the jmp instruction 
	//will need to check if the instruction contains a jump instruction before calling this method
	//i.e. if contains ";"
	
	public String jump() {
		if(!current.contains(";")) {
			return jump = "NULL";
		} else {
			return jump = current.substring(current.lastIndexOf(";") + 1).trim();
		}
	}
	
	//Standard "getter" to se what the current instruction is
	public enum commandType {
		A_COMMAND,C_COMMAND,L_COMMAND
	}
	public String getCurrent() {
		return current;
	}
	
	//used during testing to set various instructions and test parsing
	public String setCurrent(String asm) {
		return current = asm;
		
	}
	

	public Scanner getScanner() {
		return scanner;
	}

	public void setScanner(Scanner scanner) {
		this.scanner = scanner;
	}

	
}
