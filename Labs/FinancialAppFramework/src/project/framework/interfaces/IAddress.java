
package project.framework.interfaces;

public interface IAddress {
    public String getStreet();
    public String getEmail();
    public String getCity();
    public String getState();
    public String getZip();
	public Object getFormattedAddress();
    
}
