package interfaces;
import java.sql.SQLException;
import java.util.Collection;

import exception.UserNotFoundException;
import exception.UserNullException;

public interface UserModelI<T> {
	
	public T doRetrieveByKey(String nick) throws SQLException, UserNotFoundException;
	
	public Collection<T> doRetrieveAll(String order) throws SQLException;
	
	public void doSave(T user) throws SQLException, UserNullException;
	



}
