package ch10_java_lang_package.Object_;

public class Object_toString {
		public static void main(String[] args) {
			
			Book book1 = new Book(200, "개미");
			
			System.out.println(book1);
			System.out.println(book1.toString());
		}
	}

class Book{
	
	int bookNumber;
	String bookTitle;
	
	public Book(int bookNumber, String bookTitle) {
		this.bookNumber = bookNumber;
		this.bookTitle = bookTitle;
	}
	
	// source를 이용하여 자동 생성.
	@Override
	public String toString() {
		return "Book [bookNumber=" + bookNumber + ", bookTitle=" + bookTitle + "]";
	}
}
