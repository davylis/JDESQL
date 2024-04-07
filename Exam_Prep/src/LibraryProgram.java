import java.util.ArrayList;
import java.util.Scanner;

public class LibraryProgram {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		ArrayList<Book> books = new ArrayList<Book>();
		String title = "";
		String genre = "";
		int page = 0;
		while (true) {
			System.out.print("Enter title: ");
			title = input.nextLine();
			if (title.equalsIgnoreCase("quit")) {
				break;
			}
			System.out.print("Enter genre: ");
			genre = input.nextLine();
			System.out.print("Enter page count: ");
			page = Integer.parseInt(input.nextLine());
			System.out.println();

			Book bookExample = new Book(title, genre, page);
			books.add(bookExample);
		}
		System.out.println();
		System.out.println("---List Books---");
		System.out.print("Enter genre: ");
		String askGenre = input.nextLine();
		int sum = 0;
		int max = 0;
		String maxTitle = "";
		String output = "";
		for(Book b:books) {
			if(askGenre.equalsIgnoreCase(b.getGenre())) {
				if(b.getPageCount() > max) {
					maxTitle = b.getTitle();
				}
				sum+=b.getPageCount();
				output+=b.toString()+"\n";
			}
		}
		System.out.print("\n" + askGenre.toUpperCase() + " NOVELS (Total: " + sum + " pages)\n");
		System.out.println(output);
		System.out.println("The novel with the most pages in the " + askGenre + " genre is " + maxTitle);
		input.close();
	}

}
