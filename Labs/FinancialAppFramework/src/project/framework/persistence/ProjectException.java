
package project.framework.persistence;

public class ProjectException extends Exception {
    public ProjectException(String msg){
        super(msg);
    }
    public ProjectException(Exception e){
        super(e);
    }
	private static final long serialVersionUID = 3258144448058015026L;
}
