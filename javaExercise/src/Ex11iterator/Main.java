package Ex11iterator;

public class Main {

	public static void main(String[] args) {
		// TODO 自動生成されたメソッド・スタブ
		BookShelf bookShelf = new BookShelf(4);
		bookShelf.appendBook(new Book("Around the world in 80 Days"));
		bookShelf.appendBook(new Book("Bible of Programming"));
		bookShelf.appendBook(new Book("Cinderalla in New York"));
		bookShelf.appendBook(new Book("Daddy-Long-Arms"));

		Iterator it = bookShelf.iterator();
		while(it.hasNext()) {
			Book book = (Book)it.next();
			System.out.println( "" + book.getName() );
		}
	}

}
