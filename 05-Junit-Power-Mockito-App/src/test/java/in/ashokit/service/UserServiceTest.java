package in.ashokit.service;

import static org.junit.Assert.assertEquals;
import static org.mockito.Matchers.anyString;

import org.junit.Test;
import org.powermock.api.mockito.PowerMockito;

import in.ashokit.dao.UserDao;
import in.ashokit.dao.UserDaoImpl;

public class UserServiceTest {
//to represent this method as a junit test
	@Test
	public void testGetNameByUerId()
	{
		//for the userDao creating mock obj
	UserDao mockDao=PowerMockito.mock(UserDao.class);
	//defining behavoiour for mock obj(telling mockdao when somebody calls findnamebyId return john
	//mock obj will not talk to db(if somebody calls with 101 as parameter then return john as output
	PowerMockito.when(mockDao.findNameById(100)).thenReturn("John");
	
	
	Userservice service=new Userservice(mockDao);
	//service layer method will be called with mock obj
	String name = service.getNameByUserId(100);
	assertEquals("John", name);
		}
	
	
	@Test
	public void tetGetEmailByUserId()
	{
		UserDao mockDao = PowerMockito.mock(UserDao.class);
		
	/*	calling real daoImpl method
	 * PowerMockito.when(mockDao.findEmailById(101)).thenCallRealMethod();
		or*/
		
		PowerMockito.when(mockDao.findEmailById(101)).thenReturn("john123@gmail.com");
		
		Userservice service=new Userservice(mockDao);
		String email = service.getEmailById(101);
		assertEquals("john123@gmail.com", email);
	}
	
	//if dao method return void use below method(mocking for void method)
	@Test
	public void testDoProcess()
	{
		Userservice mockService = PowerMockito.mock(Userservice.class);
		try
		{
			PowerMockito.doNothing().when(mockService,"pushMsgToKafkaTopic",anyString());
		mockService.doProcess();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	
	
	//performing unit testing for private method
	
	@Test
	public void testDoWorkWithPrivateMethodMock() throws Exception
	{
		Userservice service=new Userservice();
		//for testing private method only mock obj is not sufficient need to create spy
		Userservice spy = PowerMockito.spy(service);
		PowerMockito.doReturn("Test Msg").when(spy,"formatMsg","test msg");
		
		String formattedMsg=service.doWork("test msg");
		assertEquals("TEST MSG", formattedMsg);
		
	}
}
