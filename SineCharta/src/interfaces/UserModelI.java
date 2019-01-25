package interfaces;
import java.sql.SQLException;
import java.util.Collection;

public interface UserModelI<T> {
	
	public T doRetrieveByKey(String nick) throws SQLException;
	
	public Collection<T> doRetrieveAll(String order) throws SQLException;
	
	public void doSave(T user) throws SQLException;
	



}
