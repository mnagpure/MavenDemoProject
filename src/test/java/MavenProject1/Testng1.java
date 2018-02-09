package MavenProject1;

import org.testng.Assert;
import org.testng.annotations.Test;

public class Testng1 {
	@Test
	public void add()
	{
		int a=10,b=20;
		System.out.println("Add");
		Assert.assertEquals(30, a+b);
	}
	
	@Test
	public void sub()
	{
		int a=10,b=20;
		System.out.println("Sub");
		Assert.assertEquals(10, b-a);
	}
	@Test
	public void sub1()
	{
		int a=10,b=20;
		System.out.println("Sub");
		Assert.assertEquals(10, b-a);
	}
}
