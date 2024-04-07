class Book {
	private String title;
	private String genre;
	private int pageCount;

	public Book(String title, String genre, int pageCount) {
		this.title = title;
		this.genre = genre;
		this.pageCount = pageCount;
	}

	public String getTitle() {
		return this.title;
	}

	public String getGenre() {
		return this.genre;
	}

	public int getPageCount() {
		return this.pageCount;
	}

	public String toString() {
		String result = getTitle() + " ( " + getPageCount() + " pages) ";
		return result;
	}
}
