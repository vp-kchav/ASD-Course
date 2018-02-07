
package project.framework.persistence;

public class DatabaseException extends ProjectException {
 	static final String message = "A database error has occurred.";
    public DatabaseException(String msg){
        super((msg == null)? message : msg);
    }
    public DatabaseException(Exception e){
        super(e);
    }
	private static final long serialVersionUID = 3258128038058015026L;	
}
