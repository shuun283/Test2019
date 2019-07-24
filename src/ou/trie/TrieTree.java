package ou.trie;

public class TrieTree {

	private Node root = new Node();

	public TrieTree() {
	}

	public Node find(Node parent, String word, int depth) {
		Node[] childs = parent.getNodes();
		int index = word.charAt(depth) - 'a';
		if (childs != null && childs[index] != null) {
			Node node = childs[index];
			if (depth == word.length() - 1) {
				return node;
			} else {
				depth = depth + 1;
				find(node, word, depth);
			}
		}
		return null;
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
