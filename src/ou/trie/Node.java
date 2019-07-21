package ou.trie;

import java.util.ArrayList;

public class Node {

	private String data;

	private String description;
	private Node parent;
	private ArrayList<Node> children;

	public Node() {
	}

	public Node(String data, String description) {
		this.data = this.parent.data + data;
		this.description = description;
	}

	public String getData() {
		return data;
	}

	public void setData(String data) {
		this.data = data;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public void setParent(Node parent) {
		this.parent = parent;
	}

	public ArrayList<Node> getChildren() {
		if (this.children == null) {
			this.children = new ArrayList<Node>();
		}
		return this.children;
	}

	public Node findChildNode(String data) {
		for (Node node : children) {
			if (node.data.equals(data)) {
				return node;
			}
		}
		return new Node();
	}

}
