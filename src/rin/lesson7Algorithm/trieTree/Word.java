package rin.lesson7Algorithm.trieTree;

import java.beans.JavaBean;

//@JavaBean
public class Word {

	// アルファベットキー
	private char key;
	// 語彙
	private String vocabulary;
	// 説明文
	private String description;

	public Word(String word, String description) {
		this.key = word.charAt(word.length() - 1);
		this.vocabulary = word;
		this.description = description;
	}

	public char getKey() {
		return key;
	}

	public String getVocabulary() {
		return vocabulary;
	}

	public String getDescription() {
		return description;
	}

}
