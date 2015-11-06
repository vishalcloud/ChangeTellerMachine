package org.Assignment.BankOfChange;

import static org.junit.Assert.*;

import java.util.HashMap;
import java.util.Map;

import org.junit.Assert;
import org.junit.Test;

public class TestAmount {

	@Test
	public void Testaddmoney() {
		Amount am = new Amount();
		am.addMoney();



	}

	@Test
	public void TestnoteCalculator() throws Exception
	{	Amount am = new Amount();
	int n = 0;
	am.noteCalculator(n);
		Map<Integer, Integer> dispatchedNotes = new HashMap<Integer, Integer>();

	
		Assert.assertEquals ("{10,10}" , am.noteCalculator(100));
	}
	
	@Test
	public void testAcceptNoteFromCustomer() throws Exception
	{
		Amount am = new Amount();
		Assert.assertEquals("Not available for suchh Low Value",am.AcceptNoteFromCustomer(10));
	}
	
}
