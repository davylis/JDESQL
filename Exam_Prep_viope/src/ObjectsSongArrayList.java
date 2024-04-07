import java.util.ArrayList;
import java.util.Scanner;

public class ObjectsSongArrayList {
	private String englishWord;
	private String finnishWord;

	public ObjectsSongArrayList(String englishWord, String finnishWord) {
		this.englishWord = englishWord;
		this.finnishWord = finnishWord;
	}

	public String getEng() {
		return this.englishWord;
	}

	public String getFin() {
		return this.finnishWord;
	}

	public void setFin(String fin) {
		this.finnishWord = fin;
	}

	public void setEng(String eng) {
		this.englishWord = eng;
	}

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		ArrayList<ObjectsSongArrayList> words = new ArrayList<ObjectsSongArrayList>();
		String eng = "";
		String finn = "";
		while (true) {
			System.out.print("Enter an English word: ");
			eng = scanner.nextLine();
			if (eng.equalsIgnoreCase("ok")) {
				break;
			}
			System.out.print("Enter an Finnish word: ");
			finn = scanner.nextLine();
			ObjectsSongArrayList wordpair = new ObjectsSongArrayList(eng, finn);
			words.add(wordpair);
		}

		while (true) {
			System.out.print("Enter an English word: ");
			eng = scanner.nextLine();
			if (eng.equalsIgnoreCase("quit")) {
				break;
			}
			for (ObjectsSongArrayList s : words) {
				if (eng.equals(s.getEng())) {
					System.out.println(s.getFin());
				}
			}
		}

	}

}
