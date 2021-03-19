package Ex11iterator;

public class BookShelfIterator implements Iterator {

	private BookShelf bookShelf;
	private int index;

	public BookShelfIterator(BookShelf bookShelf) {
		// TODO 自動生成されたコンストラクター・スタブ
		this.bookShelf = bookShelf;
		this.index = 0;
	}

	@Override
	public boolean hasNext() {
		// TODO 自動生成されたメソッド・スタブ
		if(index < bookShelf.getLength()) {
			return true;
		}else {
			return false;
		}
	}

	@Override
	public Object next() {
		// TODO 自動生成されたメソッド・スタブ
		Book book = bookShelf.getBookAt(index);
		index++;
		return book;
	}

}
