package com.mouritech.feigndemo.feignclientexample.errors;
import feign.Response;
import feign.codec.ErrorDecoder;

public class AppFeignErrorDecoder implements ErrorDecoder{
	
	private final ErrorDecoder defaultErrorDecoder = new Default();

	@Override
	public Exception decode(String methodKey, Response response) {
		if(response.status() >=400 && response.status() <= 499) {
			throw new ProductNotFoundException("Product Not Found");
		}
		return defaultErrorDecoder.decode(methodKey, response);
	}

}