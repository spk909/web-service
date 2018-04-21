package fr.school.exception;

public class TechnicalBusinessException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
		
	private Throwable exception;
	
	public TechnicalBusinessException(Throwable exception){
		this.exception = exception;
	}

	public Throwable getException() {
		return exception;
	}

	public void setException(Throwable exception) {
		this.exception = exception;
	}
	
	
}
