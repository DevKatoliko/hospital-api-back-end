package exceptions;

public class HospitalNotFoundException extends RuntimeException{

	private static final long serialVersionUID = 1L;

	public HospitalNotFoundException(String msg) {
		super(msg);
	}
	
	public HospitalNotFoundException(String msg, Throwable cause) {
		super(msg, cause);
	}
}
