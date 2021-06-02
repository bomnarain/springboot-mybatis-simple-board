package kr.co.ggoom.sample.configuration.exception;

import kr.co.ggoom.sample.configuration.http.BaseResponseCode;

public class BaseException extends AbstractBaseException {

	private static final long serialVersionUID = 1L;
	
	public BaseException() {
	}
	
	public BaseException(BaseResponseCode responseCode ) {
		this.responseCode = responseCode;
	}
	
	public BaseException(BaseResponseCode responseCode, String[] args ) {
		this.responseCode = responseCode;
		this.args = args;
	}	

}
