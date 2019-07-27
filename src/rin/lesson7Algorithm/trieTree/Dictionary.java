package rin.lesson7Algorithm.trieTree;

import rin.lesson7Algorithm.trieTree.Node;
import rin.lesson7Algorithm.trieTree.Word;

public class Dictionary {

	private Node root = new Node();

	public Dictionary() {
	}

	public Node getRoot() {
		return root;
	}

	public Word findWord(final String strWord, final Node parentNode) {
		Node node = findNode(strWord, parentNode, 1);
		if (node != null) {
			return node.getWord();
		}
		return null;
	}

	public Node findNode(final String strWord, final Node parentNode, int curDeep) {
		Node[] childrenNotes = parentNode.getChildNodes();
		// String keyWord = strWord.substring(0, curDeep);
		int idx = strWord.charAt(curDeep - 1) - 'a';
		if (childrenNotes != null && childrenNotes[idx] != null) {
			int deep = strWord.length();
			if (deep == curDeep) {
				return childrenNotes[idx];
			} else {
				findNode(strWord, childrenNotes[idx], ++curDeep);
			}
		}
		return null;
	}

	public Node findAndCreateNode(final String strWord, final Node parentNode, int curDeep) {
		Node[] childrenNotes = parentNode.getChildNodes();
		int deep = strWord.length();
		char curChar = strWord.charAt(curDeep - 1);
		int idx = curChar - 'a';
		if (childrenNotes == null) {
			// TODO
			// なし
		}
		if (childrenNotes[idx] == null) {
			childrenNotes[idx] = new Node(curChar);
		}
		if (deep == curDeep) {
			return childrenNotes[idx];
		} else {
			findAndCreateNode(strWord, childrenNotes[idx], ++curDeep);
		}
		return null;
	}

}
