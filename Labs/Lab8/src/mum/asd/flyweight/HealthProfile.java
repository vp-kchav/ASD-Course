package mum.asd.flyweight;

public class HealthProfile {
	private String profile;
	
	public HealthProfile(String p) {
		profile = p;
	}
	
	@Override
	public String toString() {
		return profile;
	}
}
