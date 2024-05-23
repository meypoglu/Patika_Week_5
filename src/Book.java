public class Book implements Comparable<Book>{
    private String name, author;
    private int pageNum, publishDate;

    public String getName() {
        return name;
    }

    public String getAuthor() {
        return author;
    }

    public int getPageNum() {
        return pageNum;
    }

    public int getPublishDate() {
        return publishDate;
    }

    public Book(String name, int pageNum, String author, int publishDate) {
        this.name = name;
        this.author = author;
        this.pageNum = pageNum;
        this.publishDate = publishDate;
    }

    @Override
    public int compareTo(Book o) {
        return -o.name.compareTo(this.name);
    }
}
