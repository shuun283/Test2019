package ou.trie;

public class App {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TrieTree dictionary = new TrieTree();
		// TODO
		dictionary.addWord("to", "【空間】〈ある場所〉へ［に，まで］；〈物〉に付けて；（到達を目ざして）…の方へ；…の側に");
		dictionary.addWord("tea", "紅茶，（ホット）ティー（black tea）；アイスティー（iced tea）；");
		dictionary.addWord("ted", "テッド（◇男子の名；Edward，Theodor，Theodore の愛称）");
		dictionary.addWord("ten", "（数の）１０；１０の記号（◇１０，X など）");
		dictionary.addWord("inn", "((英やや古))（いなかにあり，時に宿泊もできる）居酒屋，パブ；（酒場つきの昔ふうの）宿屋，小さな旅館");
		dictionary.addWord("to", "modify");
		System.out.println(dictionary.searchWord("word"));
		System.out.println(dictionary.searchWord("tea"));
	}

}
