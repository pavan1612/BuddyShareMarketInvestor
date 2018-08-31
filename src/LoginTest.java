import static org.junit.Assert.*;

import org.junit.*;
import Register.*
;public class LoginTest {

	LoginBean bean= new LoginBean();
	User user1=new User();
	@Before  
    public void setUp() throws Exception {  
		user1.setUemail("abc");
		user1.setUname("abc");
		user1.setUpass("abc");
		bean.setEmail("abc");
		bean.setPassword("abc");
    } 
	@Test
	public void test() {
		RegisterDao reg=new RegisterDao();
		assertEquals(1,reg.register(user1));
		
		LoginDao d= new LoginDao();
		assertEquals(true,d.validate(bean));  
	
	}

}
