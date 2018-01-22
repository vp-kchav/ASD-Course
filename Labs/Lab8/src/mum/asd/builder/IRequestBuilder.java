package mum.asd.builder;

public interface IRequestBuilder {
	public void buildRequest(String reqContent,String resContent);
	public void buildCustomer();
	public void buildAgent();
	public Request getRequest();
}
