package mum.asd.builder;

import java.util.UUID;


public class RequestBuilder implements IRequestBuilder {

	Request request;
	
	@Override
	public void buildRequest(String reqContent,String resContent) {
		request.setReqId(UUID.randomUUID().toString());
		request.setReqContent(reqContent);
		request.setRespContent(resContent);
		
	}

	@Override
	public void buildCustomer() {
		// TODO Auto-generated method stub

	}

	@Override
	public void buildAgent() {
		// TODO Auto-generated method stub

	}

	@Override
	public Request getRequest() {
		return request;
	}

}
