class Book {
    String title, author;

    Book(String title, String author) {
        this.title = title;
        this.author = author;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null || getClass() != obj.getClass())
            return false;
        Book b = (Book) obj;
        return title.equals(b.title) && author.equals(b.author);
    }
}

public class Library {
    public static void main(String[] args) {
        Book b1 = new Book("Java", "James");
        Book b2 = new Book("Java", "James");
        System.out.println(b1 == b2);
        System.out.println(b1.equals(b2));
    }
}
