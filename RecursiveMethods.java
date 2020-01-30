import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
 * Requirement:
 * You are required to implement all methods recursively.
 * You receive a zero if there is any occurrence of a loop (e.g., for, while).  
 * See under doc/index.html for the API of methods.
 * This lab requires definitions of recursive helper methods. 
 * You may review the recording of parts of Lecture 14 (October 28): 
 * 		https://youtu.be/J2CB3QHinQU 
 */
public class RecursiveMethods {
	/**
	 * Return an array storing the first n numbers in an arithmetic sequence, with
	 * initial term 'start' and common difference 'diff'. You can assume that n is
	 * non-negative (larger than or equal to 0). e.g., arithmeticArray(2, 3, 5)
	 * returns an array {2, 5, 8, 11, 14}.
	 * 
	 * @param start the first term in an arithmetic sequence
	 * @param diff  the common difference between terms in an arithmetic sequence
	 * @param n     the first n numbers in an arithmetic sequence
	 * @return an array representing the first n numbers in the specified arithmetic
	 *         sequence
	 * 
	 *         <b>You are forbidden to use the arithmeticList method below to solve
	 *         this problem.</b>
	 * 
	 */
	public int[] arithmeticArray(int start, int diff, int n) {
		int[] result = new int[n];
		if (n == 0) {
			return result;
		}
		result[0] = start;
		this.arithmeticArrayHelper(0, diff, result);
		return result;
	}

	/**
	 * This is a recursive helper method expected to be used by arithmeticArray.
	 * 
	 * @param i    position in `seq` to be assigned to
	 * @param diff common difference of the arithmetics sequence
	 * @param seq  a partially filled arithmetic sequence
	 * 
	 *             Each recursive call to this helper method stores at index `i` of
	 *             the resulting arithmetic sequence `seq`, which is assumed to have
	 *             been partially filled at indices 0, 1, ..., i - 1.
	 */
	void arithmeticArrayHelper(int i, int diff, int[] seq) {
		// if its last element we simply return. or if its 0, 1 elements only, return.
		if (i >= seq.length) {
			return;
		} else if (i == 0) {
			arithmeticArrayHelper(i + 1, diff, seq);
			return;
		}
		// add an new element to sequence and recur call arithmeticArrayHelper with i+1.
		else {
			seq[i] = seq[i - 1] + diff;
			arithmeticArrayHelper(i + 1, diff, seq);
			return;
		}

	}

	/**
	 * Return a list storing the first n numbers in an arithmetic sequence, with
	 * initial term 'start' and common difference 'diff'. You can assume that n is
	 * non-negative (larger than or equal to 0). e.g., arithmeticList(2, 3, 5)
	 * returns a list {2, 5, 8, 11, 14}.
	 * 
	 * @param start the first term in an arithmetic sequence
	 * @param diff  the common difference between terms in an arithmetic sequence
	 * @param n     the first n numbers in an arithmetic sequence
	 * @return a list representing the first n numbers in the specified arithmetic
	 *         sequence
	 * 
	 *         <b>You are forbidden to use the arithmeticArray method above to solve
	 *         this problem.</b>
	 * 
	 *         Requirement: You are required to implement all methods recursively.
	 *         You receive a zero if there is any occurrence of a loop (e.g., for,
	 *         while).
	 */
	public List<Integer> arithmeticList(int start, int diff, int n) {
		List<Integer> result = new ArrayList<Integer>();
		if (n == 0) {
			return result;
		}
		result.add(start);
		this.arithmeticListHelper(1, diff, result, n);
		return result;
	}

	/**
	 * This is a recursive helper method expected to be used by arithmeticList.
	 * 
	 * @param i    position in `seq` to be assigned to
	 * @param diff common difference of the arithmetics sequence
	 * @param seq  a partially filled arithmetic sequence
	 * @param n    size of the arithmetic sequence to be built eventually
	 * 
	 *             Each recursive call to this helper method stores at index `i` of
	 *             the resulting arithmetic sequence `seq`, which is assumed to have
	 *             been partially filled at indices 0, 1, ..., i - 1.
	 */
	void arithmeticListHelper(int i, int diff, List<Integer> seq, int n) {
		if (i >= n) {
			return;
		}

		else {
			// add element seq[i] + diff to index i + 1.
			seq.add(seq.get(i - 1) + diff);
			arithmeticListHelper(i + 1, diff, seq, n);
			return;
		}
	}

	/**
	 * Return whether or not an array represents the first n numbers of an
	 * arithmetic sequence. An arithmetic sequence has a common difference between
	 * every two adjacent terms. The array may or may not be empty. e.g.,
	 * isArithmeticArray({1, 3, 5, 8, 10}) returns false and isArithmeticArray({1,
	 * 3, 5, 7, 9}) returns true (because the common difference is 2).
	 * 
	 * @param a an array
	 * @return true if input array a represents an arithmetic sequence; false
	 *         otherwise.
	 * 
	 *         <b>You are forbidden to use the isArithmeticList method below to
	 *         solve this problem.</b>
	 * 
	 *         Requirement: You are required to implement all methods recursively.
	 *         You receive a zero if there is any occurrence of a loop (e.g., for,
	 *         while).
	 */
	public boolean isArithmeticArray(int[] a) {
		// if the length is 0 or 1 then by it is a sequence, return true.
		if (a.length <= 1) {
			return true;
		}
		int difference = a[1] - a[0];
		return isArithmeticArrayHelper(0, difference, a);
	}

	/**
	 * This is a recursive helper method expected to be used by isArithmeticArray.
	 * 
	 * @param i    position in `seq`, starting from which the remaining sub-sequence
	 *             is an arithmetic sequence
	 * @param diff common difference of the arithmetics sequence
	 * @param a    an array which may or may not be an arithmetic sequence
	 * @return whether or not the sub-sequence of `a` with indices i - 1, i, i + 1,
	 *         ..., a.length - 1 is an arithmetic sequence
	 * 
	 *         Each recursive call to this helper method considers if elements of
	 *         `a` at indices `i - 1` and `i` make two valid adjacent elements in
	 *         the arithmetic sequence, i.e., their difference is equal to the
	 *         common difference `diff`. Also, it considers if the remaining
	 *         sub-sequence (indices i + 1, i + 2, ..., a.length - 1) is an
	 *         arithmetic sequence with common difference `diff`.
	 */
	boolean isArithmeticArrayHelper(int i, int diff, int[] a) {
		// first element + (3*4) which is the last element if it == last element in "a".
		if (a.length - 2 == i) {
			return a[a.length - 1] == ((a.length - 1) * diff) + a[0];
		}
		// return recur call && the current element difference.
		else {
			return isArithmeticArrayHelper(i + 1, diff, a) && a[i + 1] == (a[i] + diff);
		}
	}

	/**
	 * Return whether or not a list represents the first n numbers of an arithmetic
	 * sequence. An arithmetic sequence has a common difference between every two
	 * adjacent terms. The list may or may not be empty. e.g., isArithmeticList({1,
	 * 3, 5, 8, 10}) returns false and isArithmeticList({1, 3, 5, 7, 9}) returns
	 * true (because the common difference is 2).
	 * 
	 * @param l a list
	 * @return true if input list l represents an arithmetic sequence; false
	 *         otherwise.
	 * 
	 *         <b>You are forbidden to use the isArithmeticArray method above to
	 *         solve this problem.</b>
	 * 
	 *         Requirement: You are required to implement all methods recursively.
	 *         You receive a zero if there is any occurrence of a loop (e.g., for,
	 *         while).
	 */
	public boolean isArithmeticList(List<Integer> l) {
		boolean result = true;
		if (l.size() > 2) {
			int difference = l.get(1) - l.get(0);
			result = this.isArithmeticListHelper(0, difference, l);
		}
		/*
		 * if the if doesn't execute means we have 0, 1 elements which means they always
		 * have arithmetic pattern.
		 */
		return result;
	}

	/**
	 * This is a recursive helper method expected to be used by isArithmeticList.
	 * 
	 * @param i    position in `seq`, starting from which the remaining sub-sequence
	 *             is an arithmetic sequence
	 * @param diff common difference of the arithmetics sequence
	 * @param l    a list which may or may not be an arithmetic sequence
	 * @return whether or not the sub-sequence of `l` with indices i - 1, i, i + 1,
	 *         ..., l.size() - 1 is an arithmetic sequence
	 * 
	 *         Each recursive call to this helper method considers if elements of
	 *         `l` at indices `i - 1` and `i` make two valid adjacent elements in
	 *         the arithmetic sequence, i.e., their difference is equal to the
	 *         common difference `diff`. Also, it considers if the remaining
	 *         sub-sequence (indices i + 1, i + 2, ..., l.size() - 1) is an
	 *         arithmetic sequence with common difference `diff`.
	 */
	boolean isArithmeticListHelper(int i, int diff, List<Integer> l) {
		if (l.size() - 1 <= i) {
			// see if the last element is infact (l[0] + (diff*(l.size() - 1)))
			return l.get(l.size() - 1) == ((l.size() - 1) * diff) + l.get(0);
		} else {

			return ((l.get(i) + diff) == l.get(i + 1)) && isArithmeticListHelper(i + 1, diff, l);
		}
	}

	/**
	 * Given a sorted input array a, return a sorted array of size a.length + 1,
	 * consisting of all elements of array a and integer i.
	 * 
	 * @param a an array that is sorted in a non-descending order
	 * @param i an integer
	 * @return a sorted array of size a.length + 1, consisting of all elements of
	 *         array a and integer i. e.g., insertIntoSortedArray({1, 2, 4, 5}, 3)
	 *         returns a sorted array {1, 2, 3, 4, 5}.
	 * 
	 *         <b>You are forbidden to use the insertIntoSortedList method below to
	 *         solve this problem.</b>
	 * 
	 *         Requirement: You are required to implement all methods recursively.
	 *         You receive a zero if there is any occurrence of a loop (e.g., for,
	 *         while).
	 */
	public int[] insertIntoSortedArray(int[] a, int i) {
		int[] result = Arrays.copyOf(a, a.length + 1);
		if (result.length < 1) {
			return result;
		}
		result = insertIntoSortedArrayHelper(result, i, 0);
		return result;
	}

	private int[] insertIntoSortedArrayHelper(int[] result, int i, int index) {
		if (result.length - 1 <= index) {
			result[index] = i;
			return result;
		} else if (i <= result[index]) {
			int tmp = result[index];
			result[index] = i;
			i = tmp;
			return insertIntoSortedArrayHelper(result, i, index + 1);
		} else {
			return insertIntoSortedArrayHelper(result, i, index + 1);

		}

	}

	/**
	 * Given a sorted input list, return a sorted list of size list.size() + 1,
	 * consisting of all elements of the input list and integer i.
	 * 
	 * @param list a list that is sorted in a non-descending order
	 * @param i    an integer
	 * @return a sorted list of size list.size() + 1, consisting of all elements of
	 *         the input list and integer i. e.g., insertIntoSortedList({1, 2, 4,
	 *         5}, 3) returns a sorted list {1, 2, 3, 4, 5}.
	 * 
	 *         <b>You are forbidden to use the insertIntoSortedArray method above to
	 *         solve this problem.</b>
	 * 
	 *         Requirement: You are required to implement all methods recursively.
	 *         You receive a zero if there is any occurrence of a loop (e.g., for,
	 *         while).
	 */
	public List<Integer> insertIntoSortedList(List<Integer> list, int i) {
		List<Integer> result = new ArrayList<Integer>();
		result.addAll(list);
		int index = result.size() - 1;
		if (result.size() < 2) {
			result.add(i);
			return result;
		}
		this.insertIntoSortedListHelper(result, i, index);
		return result;
	}

	public void insertIntoSortedListHelper(List<Integer> list, int i, int index) {
		if (index < 0) {
			return;
		} else if (list.get(0) >= i) {
			list.add(0, i);
		} else if (list.get(index) <= i) {
			list.add(index + 1, i);
			return;
		} else {
			insertIntoSortedListHelper(list, i, index - 1);
			return;
		}

	}

	public List<Integer> reverseListHelper(int i, List<Integer> list) {
		if (i >= list.size()) {
			return list;
		} else {
			list.add(i, list.get(list.size() - 1));
			list.remove(list.size() - 1);
			return reverseListHelper(i + 1, list);
		}
	}

}
