package ou.trie;

import java.util.ArrayList;

public class Node {

	private char data;
	private String word;// word
	private String description;
	private ArrayList<Node> children;

	public Node() {
	}

	public Node(char data, String description) {
		this.data = data;
		this.description = description;
	}

	public char getData() {
		return data;
	}

	public void setData(char data) {
		this.data = data;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public ArrayList<Node> getChildren() {
		if (this.children == null) {
			this.children = new ArrayList<Node>();
		}
		return this.children;
	}

	public Node[] getNodes() {
		// TODO Auto-generated method stub
		return null;
	}

}
