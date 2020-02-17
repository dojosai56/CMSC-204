package Lab8Tarek;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.After;
import org.junit.Test;

public class GradebookTester {
private GradeBook grade1;
private GradeBook grade2;

@Before
public void setUp() throws Exception {
	grade1 = new GradeBook(5);
	grade2 = new GradeBook(5);
	
	grade1.addScore(50);
	grade1.addScore(43);
	grade1.addScore(64);
	grade1.addScore(26);
	
	
	grade2.addScore(100);
	grade2.addScore(11);
	grade2.addScore(80);
	grade2.addScore(96);
	
	System.out.println(grade1.toString());
}

@After
public void tearDown() throws Exception {
	grade1 = null;
	grade2 = null;
}

@Test 
public void testAddScore() {
	
	
	assertTrue(grade1.toString().equals("50.0, 43.0, 64.0, 26.0"));
	assertTrue(grade2.toString().equals("100.0, 11.0, 80.0, 96.0"));
	
	assertEquals(50, grade1.getScoreSize(), .001);
	assertEquals(43, grade1.getScoreSize(), .001);
	assertEquals(64, grade1.getScoreSize(), .001);
	assertEquals(26, grade1.getScoreSize(), .001);
	
	assertEquals(100, grade2.getScoreSize(), .001);
	assertEquals(11, grade2.getScoreSize(), .001);
	assertEquals(80, grade2.getScoreSize(), .001);
	assertEquals(96, grade1.getScoreSize(), .001);
}
}
