package org.Assignment.BankOfChange;
import java.util.HashMap;
import java.util.Map;
public class Amount {
	HashMap<Integer, Integer> notes = new HashMap<Integer, Integer>();
	public void BankerAddsMoneyToMachine() {
		Amount am = new Amount();
		am.addMoney();
	}
	public void addMoney() {

		notes.put(10, 100);
		notes.put(50, 50);
		notes.put(100, 25);
		notes.put(500, 20);
		notes.put(1000, 10);
	}

	public void AcceptNoteFromCustomer(int note) throws Exception {
		if (note < 10) {
			showError("Maximum possible denomination value is 1000 Rs.");
			//	System.out.println("We do not have Change available for this currency note");
		} else {
			dispatch(note);
		}
	}
	private void showError(String string) throws Exception {
		        throw new Exception(string);
	}
	private void dispatch(int note) {
		int n = note;
		if (notes.containsKey(n))
		{
			noteCalculator(n);
			int newcount = (notes.get(n) + 1);
			notes.replace(n, newcount);
		}
	}
	private Map<Integer,Integer> noteCalculator(int n) {
		Map<Integer, Integer> dispatchedNotes = new HashMap<Integer, Integer>();

		if (n == 1000) {
			notes.replace(500, notes.get(500) - 1);
			notes.replace(100, notes.get(100) - 4);
			notes.replace(50, notes.get(50) - 1);
			notes.replace(10, notes.get(10) - 5);
			dispatchedNotes.put(500, 1);
			dispatchedNotes.put(100, 4);
			dispatchedNotes.put(50, 1);
			dispatchedNotes.put(10, 5);
		}
		if (n == 500) {
			notes.replace(100, notes.get(100) - 4);
			notes.replace(50, notes.get(50) - 1);
			notes.replace(10, notes.get(10) - 5);
			dispatchedNotes.put(500, 1);
			dispatchedNotes.put(100, 4);
			dispatchedNotes.put(50, 1);
			dispatchedNotes.put(10, 5);
		}
		if (n == 100) {
			notes.replace(50, notes.get(50) - 1);
			notes.replace(10, notes.get(10) - 5);
			dispatchedNotes.put(500, 1);
			dispatchedNotes.put(100, 4);
			dispatchedNotes.put(50, 1);
			dispatchedNotes.put(10, 5);
		}
		if (n == 50) {
			notes.replace(10, notes.get(10) - 5);
			dispatchedNotes.put(500, 1);
			dispatchedNotes.put(100, 4);
			dispatchedNotes.put(50, 1);
			dispatchedNotes.put(10, 5);
		}
		return dispatchedNotes;
	}
}
