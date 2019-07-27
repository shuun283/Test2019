package rin.lesson7Algorithm.trieTree;

import java.lang.module.FindException;
import java.util.ArrayList;
import java.util.List;

public class RunTrieTree {

	public static void main(String[] args) {
		List<Word> wordList = new ArrayList<>();
		Word word1 = new Word("link", "the description of link...");
		wordList.add(word1);
		Word word2 = new Word("lin", "the description of lin");
		wordList.add(word2);
		Word word3 = new Word("in", "the description of in");
		wordList.add(word3);
		Word word4 = new Word("music", "the description of music");
		wordList.add(word4);
		Word word5 = new Word("math", "the description of math");
		wordList.add(word5);
		Word word6 = new Word("sport", "the description of sport");
		wordList.add(word6);

		Dictionary dictionary = new Dictionary();
		for (Word word : wordList) {
			Node node = dictionary.findAndCreateNode(word.getVocabulary(), dictionary.getRoot(), 1);
			node.setWord(word);
		}

		String strWord = "lin";
		Word targetWord = dictionary.findWord(strWord, dictionary.getRoot());
		if (targetWord == null) {
			System.out.println("not found!");
		} else {
			System.out.println(targetWord.getDescription());
		}

	}

}
