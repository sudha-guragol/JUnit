package in.ashokit.dao;

public class UserDaoImpl implements UserDao{

	public String findNameById(Integer id) {
		System.out.println("FindNameById() called");
		return "John";
	}

	public String findEmailById(Integer id) {
		System.out.println("fineEmailById() called");
		return "john123@gmail.com";
	}

}
