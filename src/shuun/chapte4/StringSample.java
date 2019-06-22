package shuun.chapte4;

public class StringSample {

	public static void main(String[] args) {
		String str1 = "ABCABC";
		String str2 = "あいうえおあいうえお";

		System.out.println(str1.length());
		System.out.println(str2.length());

		System.out.println(str1.charAt(1));
		System.out.println(str2.charAt(1));

		System.out.println(str1.indexOf(2));
		System.out.println(str2.indexOf(2));

		System.out.println(str1.substring(2));
		System.out.println(str2.substring(2));

		System.out.println(str1.replace('A', 'D'));
		System.out.println(str2.replace('あ', 'か'));

		System.out.println(str1.replaceFirst("B", "EE"));
		System.out.println(str2.replaceFirst("い", "きき"));

		System.out.println(str1.replaceAll("C", "CCC"));
		System.out.println(str2.replaceAll("う", "くくく"));

		String str3 = "りんご,レモン,すいか,ぶどう";
		String[] fruits = str3.split(",", 0);
		for (String fruit : fruits) {
			System.out.println(fruit);

		}

		short sh = 100;
		String strsh = String.valueOf(sh);
		System.out.println(strsh);

		int num = 100;
		String strnum = String.valueOf(num);
		System.out.println(strnum);

		long lon = 100;
		String strlon = String.valueOf(lon);
		System.out.println(strlon);

		float fl = 100;
		String strfl = String.valueOf(fl);
		System.out.println(strfl);

		double db = 100;
		String strdb = String.valueOf(db);
		System.out.println(strdb);

		String str4 = "apple";
		String str5 = "";

		boolean bool1 = str4.isEmpty();
		boolean bool2 = str5.isEmpty();

		System.out.println("bool1 : " + bool1);
		System.out.println("bool2 : " + bool2);

		String str6 = " apple ";
		System.out.println(str6);
		String str7 = str6.trim();
		System.out.println(str7);
		
		String str8 = "　apple　";
		System.out.println(str6);
		String str9 = str8.trim();
		System.out.println(str9); 
	}

}
