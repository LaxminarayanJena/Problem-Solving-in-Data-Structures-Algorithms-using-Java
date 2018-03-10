public class StringTree {

	class Node {
		String value;
		int count;
		Node lChild;
		Node rChild;
	};

	Node root = null;
	// Other Methods.

	public void print() {
		print(root);
	}

	public void print(Node curr)/* pre order */
	{
		if (curr != null) {
			System.out.print(" value is ::" + curr.value);
			System.out.println(" count is :: " + curr.count);
			print(curr.lChild);
			print(curr.rChild);
		}
	}

	public void insert(String value) {
		root = insert(value, root);
	}

	Node insert(String value, Node curr) {
		int compare;
		if (curr == null) {
			curr = new Node();
			curr.value = value;
			curr.lChild = curr.rChild = null;
			curr.count = 1;
		} else {
			compare = curr.value.compareTo(value);
			if (compare == 0)
				curr.count++;
			else if (compare == 1)
				curr.lChild = insert(value, curr.lChild);
			else
				curr.rChild = insert(value, curr.rChild);
		}
		return curr;
	}

	void freeTree() {
		root = null;
	}

	boolean find(String value) {
		boolean ret = find(root, value);
		System.out.println("Find " + value + " Return " + ret);
		return ret;
	}

	boolean find(Node curr, String value) {
		int compare;
		if (curr == null)
			return false;
		compare = curr.value.compareTo(value);
		if (compare == 0)
			return true;
		else {
			if (compare == 1)
				return find(curr.lChild, value);
			else
				return find(curr.rChild, value);
		}
	}

	int frequency(String value) {
		return frequency(root, value);

	}

	int frequency(Node curr, String value) {
		int compare;
		if (curr == null)
			return 0;

		compare = curr.value.compareTo(value);
		if (compare == 0)
			return curr.count;
		else {
			if (compare > 0)
				return frequency(curr.lChild, value);
			else
				return frequency(curr.rChild, value);
		}
	}

	public static void main(String[] args) {
		StringTree tt = new StringTree();
		tt.insert("banana");
		tt.insert("apple");
		tt.insert("mango");
		tt.insert("banana");
		tt.insert("apple");
		tt.insert("mango");
		System.out.println("\nSearch results for apple, banana, grapes and mango :\n");
		tt.find("apple");
		tt.find("banana");
		tt.find("banan");
		tt.find("applkhjkhkj");
		tt.find("grapes");
		tt.find("mango");

		tt.print();
		System.out.println("frequency returned :: " + tt.frequency("apple"));
		System.out.println("frequency returned :: " + tt.frequency("banana"));
		System.out.println("frequency returned :: " + tt.frequency("mango"));
		System.out.println("frequency returned :: " + tt.frequency("hemant"));

	}

}
