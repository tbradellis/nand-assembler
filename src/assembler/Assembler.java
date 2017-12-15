package assembler;

import java.io.File;
import java.io.FileNotFoundException;
import assembler.Parser.commandType;

public class Assembler {

	public static void main(String[] args) throws FileNotFoundException {
		// TODO Auto-generated method stub
		Code bits = new Code();
		System.out.println("111" + bits.getComp("M+1") + bits.getDest("AMD") + bits.getJump("JGT"));
		
		File myFile = new File("my.hack");
		System.out.println(myFile.toString());
		System.out.println(myFile.toURI());
		Parser myParser = new Parser(myFile);
		//myParser.advance();
		System.out.println(commandType.A_COMMAND);
		while (myParser.hasMareCommands()) {
			myParser.setCurrent(myParser.advance());
			if(myParser.commandType() == commandType.A_COMMAND) {
				System.out.println(myParser.address(myParser.getCurrent()));
			}else if(myParser.commandType() == commandType.C_COMMAND) {
				
				System.out.println("111" + bits.getComp(myParser.comp()) + bits.getDest(myParser.dest()) + bits.getJump(myParser.jump()));
			}
		}
		if(myParser.hasMareCommands()) {
		} else {
			myParser.getScanner().close();
		}
		
		
		System.out.println(myParser.getCurrent() + " ****************************");
		
		//System.out.println(myParser.getCurrent());
	//	System.out.println(myParser.dest());
		//System.out.println(myParser.comp());
		System.out.println(myParser.commandType() + "=1st command");
		System.out.println(myParser.jump() + " jmp");
		
		System.out.println(myParser.setCurrent("AMD=M+1") + "setting 2nd command");
		System.out.println(myParser.dest() + " dest");
		System.out.println(myParser.comp() + " comp");
		myParser.setCurrent("@123");
		// Check to see if A or C instruction (Later L)
		//if A return the numeric value for a "0 + convert to binary
		
		
		System.out.println(myParser.getCurrent() + " 3rd instruction");
		System.out.println(myParser.commandType());
		if(myParser.commandType().equals("A_COMMAND")) {
			System.out.println(myParser.address(myParser.getCurrent()));
		}
		
		myParser.setCurrent("D=M+1");
		System.out.println(myParser.getCurrent() + " 4th instruction");
		//System.out.println(myParser.commandType());
		System.out.println(myParser.commandType());
		if(myParser.commandType().equals("C_COMMAND")) {
		
			System.out.println(myParser.dest());
			System.out.println(myParser.jump());
			System.out.println(myParser.comp());
			System.out.println("111" + bits.getComp(myParser.comp()) + bits.getDest(myParser.dest()) + bits.getJump(myParser.jump()));
			
		}
		myParser.setCurrent("@4566");
		//System.out.println(myParser.commandType());
		if(myParser.commandType().equals("A_COMMAND")) {
			System.out.println(myParser.address(myParser.getCurrent()));
		}
		
		// Parsing seems to work so far. 
		//Try to use them conditionally on a command
		//may still need to break into smaller pieces
		//System.out.println(myParser.dest() + myParser.comp() + myParser.jump());
		
		
		//Need to get 15 bit representation of address value
		
		//Enum is working
		//Parser works for address, compute, dest, jump
		//next up:
		//Create SystemTable Class
		
		// SystemTable class created and ready to use. 
		// next up: create a SystemTable object in main and add logic to read 
		// and update system table
		// final thought - integer value is already handled with Integer.toBinaryString()
		
	}

}
