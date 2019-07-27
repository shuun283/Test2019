package rin.lesson7Algorithm.trieTree;

import rin.lesson7Algorithm.trieTree.Word;

public class Node {

	// アルファベットキー
	private char key;
	// 語彙である場合
	private Word word;
	private Node[] childNodes = new Node[26];

	public Node() {
	}

	public Node(char key) {
		this.key = key;
	}

	public Node(char key, Word word) {
		this.key = key;
		this.word = word;
	}

	public char getKey() {
		return key;
	}

	public void setWord(Word word) {
		this.word = word;
	}

	public Word getWord() {
		return word;
	}

	public Node[] getChildNodes() {
		return childNodes;
	}

}
