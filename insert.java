import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.StringTokenizer;


public class insert
{
	static class Node {
		int value;
		int subnodes = 0;
		BigInteger permut;
		Node[] children = new Node[2];
		Node(int num) {this.value = num;}
	}
	
	Node root; /* dummy node, left child points to the actual root */

	/**
	 * Add number to an existing tree.
	 * @param child index of the child to be added (0 or 1).
	 */
	void addNumber(int num, Node parent, int child) {
		while (parent.children[child] != null) {
			parent = parent.children[child];
			child = (num < parent.value) ? 0 : 1;
		}
		parent.children[child] = new Node(num);
	}

	/** Compute the number of subnodes and possible permutations. */
	void compute(Node n) {
		BigInteger[] perms = new BigInteger[2];
		int[] cnts = new int[2];
		for (int i = 0; i < 2; ++i) {
			Node chld = n.children[i];
			if (chld == null) {
				perms[i] = BigInteger.ONE;
				cnts[i] = 0;
			} else {
				compute(chld);
				perms[i] = chld.permut;
				cnts[i] = chld.subnodes;
			}
		}
		n.subnodes = cnts[0] + cnts[1] + 1;
		n.permut = perms[0].multiply(perms[1]).multiply(
				comb(cnts[0]+cnts[1], cnts[0]));
	}
	
	/** Number of combinations (n,k) */
	BigInteger comb(int n, int k) {
		if (k > n/2) k = n-k;
		return multiply(n-k, n).divide(multiply(0, k));
	}

	/** Product of all numbers between (min+1) and (max) */
	BigInteger multiply(int min, int max) {
		BigInteger x = BigInteger.ONE;
		for (int i = min; ++i <= max; ) {
			x = x.multiply(BigInteger.valueOf(i));
		}
		return x;
	}

	/** Go through the given trees */
	void run() throws Exception {
		for (;;) {
			int num = nextInt();
			if (num == 0) break;
			root = new Node(0);
			while (num-- > 0) {
				addNumber(nextInt(), root, 0);
			}
			compute(root);
			System.out.println(root.permut);
		}
	}


	StringTokenizer st = new StringTokenizer("");
	BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	public static void main(String[] args) throws Exception {
		new insert().run();
	}
	String nextToken() throws Exception {
		while (!st.hasMoreTokens()) st = new StringTokenizer(input.readLine());
		return st.nextToken();
	}
	int nextInt() throws Exception {
		return Integer.parseInt(nextToken());
	}
}
