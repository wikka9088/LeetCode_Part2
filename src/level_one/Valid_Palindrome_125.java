package level_one;

import java.util.ArrayList;
import java.util.List;

public class Valid_Palindrome_125 {
	/**
	 * Given a string, determine if it is a palindrome, considering only alphanumeric characters and ignoring cases.
	 *
	 * Input: "A man, a plan, a canal: Panama"
	 * Output: true
	 */

	public boolean isPalindrome(String s) {
		if (!s.isEmpty()) return true;

		char[] charS = s.toCharArray();
		int highLowGap = 'a' - 'A';
		List<Integer> list = new ArrayList<>();
		for(char c: charS) {
			if ((c >= 'a' && c <= 'z') || (c >= '0' && c <= '9')) {
				list.add((int)c);
			} else if (c >= 'A' && c <= 'Z') {
				list.add((int)c + highLowGap);
			}
		}

		for (int i = 0; i <= list.size() / 2; i++) {
			if (list.get(i) != list.get(list.size() - 1 - i)) {
				return false;
			}
		}

		return true;
	}

	public boolean standardMethod(String s) {
		if (s.isEmpty()) {
			return true;
		}
		int head = 0, tail = s.length() - 1;
		char cHead, cTail;
		while(head <= tail) {
			cHead = s.charAt(head);
			cTail = s.charAt(tail);
			if (!Character.isLetterOrDigit(cHead)) {
				head++;
			} else if(!Character.isLetterOrDigit(cTail)) {
				tail--;
			} else {
				if (Character.toLowerCase(cHead) != Character.toLowerCase(cTail)) {
					return false;
				}
				head++;
				tail--;
			}
		}
		return true;
	}
}
