package home;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

@Data
@Entity
@Table(name = "mydb.books")
public class Book implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "name")
    private String name;
    @Column(name = "author")
    private String author_name;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "")
    private Author author;

    public Book(String name, String author) {
        this.name = name;
        this.author_name = author;
    }

    public Book() {
    }

    public Author getAuthor(){
        return this.author;
    }

}
