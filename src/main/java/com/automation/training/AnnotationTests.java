package com.automation.training;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class AnnotationTests {
	
	@Test(groups = {"grupo1"})
	public void testEqualsIgnoreCase() {
		String a = "hOla MuNDO";
		String b = "hola mundo";
		Assert.assertTrue(a.equalsIgnoreCase(b));
	}
	
	@Parameters({ "string1", "string2" })
	@Test(groups = {"grupo1" , "grupo2"})
	public void testConcact(String a, String b) {
		String resultado = a + b;
		Assert.assertEquals(resultado, "I love test automation");
	}

	@Test (groups = {"grupo2"})
	public void testCount() {
		String a = "I love";
		Assert.assertEquals(a.length(), 6);
	}
}
