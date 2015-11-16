package org.Assignment.BankOfChange;

import java.util.HashMap;
import java.util.Map;
public class ChangeTellerMachine {
	Map<Integer, Integer> notes = new HashMap<Integer, Integer>();
	Map<Integer, Integer> dispatchedNotes = new HashMap<Integer, Integer>();

	public void bankerAddsMoneyToMachine(int x, int y) {
		notes.put(x, y);
	}

	public boolean checkInvalidNoteFromCustomer(int note) throws Exception {
		if (note <= 10) {
			// showError("Not available for such Low Value");
		}
		return false;
	}

	public boolean checkValidNoteFromCustomer(int note) throws Exception {
		return (note > 10);
	}

	private void showError(String string) throws Exception {
		throw new Exception(string);
	}

	public Map<Integer, Integer> dispatch(int note) throws Exception {
		int n = note;
		dispatchedNotes = (Map<Integer, Integer>) noteCalculator(n);
		if (notes.containsKey(n)) {
			int newcount = (notes.get(n) + 1);
			notes.replace(n, newcount);
		}
		return dispatchedNotes;
	}
	private Map<Integer, Integer> noteCalculator(int n) throws Exception {
		if (n == 1000 && checkifNotesAvailable()) {
			if (notes.containsKey(n)) {
				notes.replace(500, notes.get(500) - 1);
				notes.replace(100, notes.get(100) - 4);
				notes.replace(50, notes.get(50) - 1);
				notes.replace(10, notes.get(10) - 5);
			}
			dispatchedNotes.put(500, 1);
			dispatchedNotes.put(100, 4);
			dispatchedNotes.put(50, 1);
			dispatchedNotes.put(10, 5);
			return dispatchedNotes;
		}
		if (n == 500 && checkifNotesAvailable()) {
			if (notes.containsKey(n)) {
				notes.replace(100, notes.get(100) - 4);
				notes.replace(50, notes.get(50) - 1);
				notes.replace(10, notes.get(10) - 5);
			}
			dispatchedNotes.put(100, 4);
			dispatchedNotes.put(50, 1);
			dispatchedNotes.put(10, 5);
		}
		if (n == 100 && checkifNotesAvailable()) {
			if (notes.containsKey(n)) {
				notes.replace(50, notes.get(50) - 1);
				notes.replace(10, notes.get(10) - 5);
			}
			dispatchedNotes.put(50, 1);
			dispatchedNotes.put(10, 5);
		}
		if (n == 50 && checkifNotesAvailable()) {
			if (notes.containsKey(n)) {
				notes.replace(10, (notes.get(10) - 5));
			}
			dispatchedNotes.put(10, 5);
		}
		// System.out.println(dispatchedNotes);
		return dispatchedNotes;
	}
	public boolean checkifNotesAvailable() throws Exception {
		if (notes.containsValue(0)) {
			showError("Sufficient Notes not available for this transactions.");
			return false;
		} else
			return true;
	}
	public int getNotesCount(int n) {
		return (notes.get(n));
	}
}