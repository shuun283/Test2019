package ou.trie;

public class TrieTree {

	private Node root;

	public TrieTree() {
		this.root = new Node();
	}

	boolean addWord(String word, String description) {
		Node node = root;
		for (int i = 1; i <= word.length(); i++) {
			// isExist;return false;
			String nodeData = word.substring(0, i);
			Node n = node.findChildNode(nodeData);
			n.setParent(node);
			n.setData(nodeData);
			node.getChildren().add(n);
			node = n;
		}
		node.setDescription(description);
		return true;
	}

	String searchWord(String word) {
		Node node = root;
		for (int i = 1; i <= word.length(); i++) {
			// isExist;return false;
			String nodeData = word.substring(0, i);
			Node temp = node.findChildNode(nodeData);
			if (temp == null) {
				return "not find.";
			}
			node = temp;
		}
		return node.getDescription();
	}

}
