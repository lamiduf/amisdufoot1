package gdes.lamiduf.exception;

public class LamidufException extends Exception {


	public LamidufException(String message) {
		super(message);
	}

	public LamidufException(Throwable cause) {
		super(cause);
	}

	public LamidufException(String message, Throwable cause) {
		super(message, cause);
	}

}
