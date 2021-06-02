package kr.co.ggoom.sample.configuration.exception;

import kr.co.ggoom.sample.configuration.http.BaseResponseCode;

public abstract class AbstractBaseException extends RuntimeException {
	
	private static final long serialVersionUID = 1L;
	
	protected BaseResponseCode responseCode;
	protected Object[] args;
	
	public AbstractBaseException() {
		
	}
	
	public AbstractBaseException(BaseResponseCode responseCode) {
		this.responseCode = responseCode;
		
	}
	
	public BaseResponseCode getResponseCode() {
		return responseCode;
	}
	
	public Object[] getArgs() {
		return args;
	}

}
