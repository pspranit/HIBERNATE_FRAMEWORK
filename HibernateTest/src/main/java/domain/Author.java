package domain;

import javax.persistence.*;
import java.util.LinkedList;
import java.util.List;

@Entity
@Table(name = "demoauthor")
public class Author {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "author_id")
    private int authorId;
    @Column(name = "author_name")
    private String authorName;

    @ManyToMany(cascade = {CascadeType.PERSIST,CascadeType.MERGE,CascadeType.DETACH,CascadeType.REFRESH})
    @JoinTable(
            name="demoauthorbook",
            joinColumns = @JoinColumn(name="ref_author"),
            inverseJoinColumns = @JoinColumn(name = "ref_book")
    )
    private List<Book> bookList;

    public int getAuthorId() {
        return authorId;
    }

    public void setAuthorId(int authorId) {
        this.authorId = authorId;
    }

    public String getAuthorName() {
        return authorName;
    }

    public void setAuthorName(String authorName) {
        this.authorName = authorName;
    }

    public List<Book> getBookList() {
        return bookList;
    }

    public void setBookList(List<Book> bookList) {
        this.bookList = bookList;
    }

    public void addBooks(Book b1) {

        if(bookList==null)
        {
            bookList=new LinkedList<>();
        }
        bookList.add(b1);
    }
}
