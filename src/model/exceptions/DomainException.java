package model.exceptions;

public class DomainException extends Exception { // ou RuntimeException

	private static final long serialVersionUID = 1L; 
	
	public DomainException(String msg) {
		super(msg);
	}

}
