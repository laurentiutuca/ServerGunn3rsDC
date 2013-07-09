package com.gunn3rs.servercliinterface;

import java.util.Scanner;

public interface IServerCLI {
	
	public String readCommand(Scanner sc);
	public boolean solveCommand(String comm);

}
