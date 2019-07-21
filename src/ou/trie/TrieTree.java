package ou.trie;

public class TrieTree {

	private Node root;

	public TrieTree() {
		this.root = new Node();
	}

	boolean addWord(String word, String description) {
		Node node = root;
		for (int i = 0; i < word.length(); i++) {
			char c = word.charAt(i);
			Node n = findChildNode(node, c);
			if (n == null) {
				n = new Node();
				n.setData(c);
				node.getChildren().add(n);
			}
			node = n;
		}
		node.setDescription(description);
		return true;
	}

	String searchWord(String word) {
		Node node = root;
		for (int i = 0; i < word.length(); i++) {
			// isExist;return false;
			char c = word.charAt(i);
			Node temp = findChildNode(node, c);
			if (temp == null) {
				return "not find.";
			}
			node = temp;
		}
		return node.getDescription();
	}

	private Node findChildNode(Node node2, char data) {
		for (Node node : node2.getChildren()) {
			if (node.getData() == data) {
				return node;
			}
		}
		return null;
	}

}
