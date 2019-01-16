package interfaces;
import java.sql.SQLException;
import java.util.Collection;

public interface UserModelI<T> {
	
	public T doRetrieveByKey(String username) throws SQLException;
	
	public Collection<T> doRetrieveAll(String order) throws SQLException;
	
	public void doSave(T product) throws SQLException;
	
	public void doUpdate(T product) throws SQLException;
	
	public boolean doDelete(String code) throws SQLException;
	
	public void doUpName(String name) throws SQLException;


}
