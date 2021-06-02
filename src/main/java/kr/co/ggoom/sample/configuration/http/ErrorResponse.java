package kr.co.ggoom.sample.configuration.http;

import java.util.List;

public class ErrorResponse {
    public ErrorResponse(String message, List<String> details) {
        super();
        this.message = message;
        this.details = details;
    }
  
    @SuppressWarnings("unused")
	private String message;
    @SuppressWarnings("unused")
	private List<String> details;
}
