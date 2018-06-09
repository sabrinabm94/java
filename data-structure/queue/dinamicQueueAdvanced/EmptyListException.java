public class EmptyListException extends NullPointerException{
	public EmptyListException(){
		super();
	}
	public EmptyListException(String error){
		super(error);
	}
}
