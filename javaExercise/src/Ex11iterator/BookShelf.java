package Ex11iterator;

public class BookShelf implements Aggregate {

	private Book[] books;
	private int last = 0;

	public BookShelf(int maxsize) {
		// TODO 自動生成されたコンストラクター・スタブ
		this.books = new Book[maxsize];
	}

	public Book getBookAt(int index) {
		return books[index];
	}

	public void appendBook(Book book) {
		this.books[last] = book;
		last++;
	}

	public int getLength() {
		return last;
	}
	@Override
	public Iterator iterator() {
		// TODO 自動生成されたメソッド・スタブ
		return new BookShelfIterator(this);
	}

}
