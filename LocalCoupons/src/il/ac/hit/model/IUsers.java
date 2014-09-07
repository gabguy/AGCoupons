package il.ac.hit.model;

public interface IUsers {
	
	/**
	 * 
	 * @param username
	 * @param password
	 * @param businessName
	 * @return
	 */
	public boolean addUser(String username, String password, String businessName);
	
	/**
	 * 
	 * @param username
	 * @return
	 */
	public User getUser(String username);
	
	/**
	 * 
	 * @param username
	 * @return
	 */
	public boolean removeUser(String username);
	
	/**
	 * 
	 * @param username
	 * @param password
	 * @param businessName
	 * @return
	 */
	public boolean updateUser(String username, String password, String businessName);

}
