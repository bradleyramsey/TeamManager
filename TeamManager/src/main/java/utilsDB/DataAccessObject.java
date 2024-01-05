package utilsDB;

import java.sql.Connection;

public abstract class DataAccessObject <T extends DataTransferObject>{
	protected final Connection connection;
	protected final static String PLAYER_SEQUENCE = "";
	public DataAccessObject(Connection connection) {
		super();
		this.connection = connection;
	}
	
	public abstract T findById(long id);
	public abstract T update(T dto);
	public abstract T insert(T dto);
	public abstract void delete(long id);
}
