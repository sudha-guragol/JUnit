package in.ashokit.service;

import in.ashokit.dao.UserDao;

public class Userservice {

	//mock obj will be there in this dao variable when service methiod i called
	private UserDao dao;
	
	public Userservice() {
		// TODO Auto-generated constructor stub
	}
	
	//constructor injection
	public Userservice(UserDao dao)
	{
		this.dao=dao;
	}
	
	public String getNameByUserId(Integer id)
	{
		//below line will talk to mock dao rather than the real dao
		//dao obj holding mockdao obj(talking to dummy dao method)
		String name = dao.findNameById(id);
		return name;
	}
	
	public String getEmailById(Integer id)
	{
		//service method will talk to dummy dao method
		String email = dao.findEmailById(id);
		return email;
	}
	
	public void doProcess()
	{
		System.out.println("doProcess() method started");
		pushMsgToKafkaTopic("msg");
		System.out.println("doprocess() method endeds");
	}

	private void pushMsgToKafkaTopic(String string) {
System.out.println("pushing mes to kafka");		
	}
	
	public String doWork(String msg)
	{
		String formattedMsg=formatMsg(msg);
		return formattedMsg;
	}

	//by creating spy object we need to call private method
	private String formatMsg(String msg) {
		return msg.toUpperCase();
	}
	
}
