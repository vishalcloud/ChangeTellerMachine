package org.Assignment.BankOfChange;

import java.util.HashMap;
import java.util.Map;

import org.junit.Assert;
import org.junit.Test;

public class TestChangeTellerMachine {
	ChangeTellerMachine am = new ChangeTellerMachine();

	
	@Test
	public void bankerShouldAddValidDenominations() {
		am.bankerAddsMoneyToMachine(10, 100);
		am.bankerAddsMoneyToMachine(50, 50);
		am.bankerAddsMoneyToMachine(100, 25);
		am.bankerAddsMoneyToMachine(500, 20);
		am.bankerAddsMoneyToMachine(1000, 10);

		Assert.assertEquals(10, am.getNotesCount(1000));
		Assert.assertEquals(20, am.getNotesCount(500));
		Assert.assertEquals(25, am.getNotesCount(100));
		Assert.assertEquals(50, am.getNotesCount(50));
		Assert.assertEquals(100, am.getNotesCount(10));

		Assert.assertFalse(am.notes.containsKey(20));
		Assert.assertFalse(am.notes.containsKey(5));
		Assert.assertFalse(am.notes.containsKey(1));
		Assert.assertFalse("Invalid Note! Try with another denomination", am.notes.containsKey(2));
	}
		@Test
		public void testcheckInvalidNoteFromCustomer() throws Exception {
		//	Amount am = new Amount();
			Assert.assertFalse(am.checkInvalidNoteFromCustomer(1));
			Assert.assertFalse(am.checkInvalidNoteFromCustomer(10));
			Assert.assertFalse(am.checkInvalidNoteFromCustomer(20));
			Assert.assertFalse(am.checkInvalidNoteFromCustomer(5));
		}
		@Test
		public void testcheckValidNoteFromCustomer() throws Exception{
			ChangeTellerMachine am = new ChangeTellerMachine();
			Assert.assertTrue(am.checkValidNoteFromCustomer(50));
			Assert.assertTrue(am.checkValidNoteFromCustomer(100));
			Assert.assertTrue(am.checkValidNoteFromCustomer(500));
			Assert.assertTrue(am.checkValidNoteFromCustomer(1000));
		}
	@Test
	public void testIfCorrectChangeIsDispatched() throws Exception {
		Map<Integer, Integer> dispatchedNotes = new HashMap<Integer, Integer>();
		//Amount am = new Amount();
		dispatchedNotes=am.dispatch(50);
		Assert.assertEquals((Integer)5,(Integer)dispatchedNotes.get(10));
		dispatchedNotes=am.dispatch(100);
		Assert.assertEquals((Integer)1,(Integer)dispatchedNotes.get(50));
		Assert.assertEquals((Integer)5,(Integer)dispatchedNotes.get(10));
		dispatchedNotes=am.dispatch(500);
		Assert.assertEquals((Integer)4,(Integer)dispatchedNotes.get(100));
		Assert.assertEquals((Integer)1,(Integer)dispatchedNotes.get(50));
		Assert.assertEquals((Integer)5,(Integer)dispatchedNotes.get(10));
		dispatchedNotes=am.dispatch(1000);
		Assert.assertEquals((Integer)1,(Integer)dispatchedNotes.get(500));
		Assert.assertEquals((Integer)4,(Integer)dispatchedNotes.get(100));
		Assert.assertEquals((Integer)1,(Integer)dispatchedNotes.get(50));
		Assert.assertEquals((Integer)5,(Integer)dispatchedNotes.get(10));
	}
	
	@Test
	public void TestIfNotesAreOOS() throws Exception {
		//Amount am = new Amount();
		Assert.assertTrue(am.checkifNotesAvailable());
		am.notes.replace(50, 0);
		Assert.assertTrue(am.checkifNotesAvailable());
		System.out.println(am.notes);
	}
	}
	
