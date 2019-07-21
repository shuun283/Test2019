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
        for (char c : word.toCharArray()) {
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
