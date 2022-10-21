package models;

import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Component;
import org.springframework.web.context.WebApplicationContext;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Component

public class MockBookService {
    private List<Book> list;

    private static Long nextId = 4L;  //od tej zmiennej będziemy dodawać o jeden


    public MockBookService() {
        list = new ArrayList<>();
        list.add(new Book(1L, "9788324631766", "Thiniking in Java", "Bruce Eckel", "Helion", "programming"));
        list.add(new Book(2L, "9788324627738", "Rusz glowa Java.", "Sierra Kathy, Bates Bert", "Helion", "programming"));
        list.add(new Book(3L, "9780130819338", "Java 2. Podstawy", "Cay Horstmann, Gary Cornell", "Helion", "programming"));
    }

    public List<Book> getList() {
        return list;
    }

    public void setList(List<Book> list) {
        this.list = list;
    }

    public Optional<Book> findBooksById(Long id){
//        for(Book book : list){
//            if(book.getId() == id){
//                return Optional.of(book);
//            }
//        }
        return list.stream()
                .filter(s -> s.getId().equals(id))
                .findAny();
    }

    public void addBook(Book book){
        book.setId(nextId++);
        list.add(book);
    }

    public void removeBook(Long id){
        list.removeIf(book -> (book.getId() == id));
    }

    public void updateBook(Book book) {
//        for(Book bookEdit : list){
//            if(bookEdit.getId().equals(id)){
//                int index = list.indexOf(bookEdit);
//                book.setId(bookEdit.getId());
//                list.set(index,book);
//            }
//        }
        Long id = book.getId();
        list.set(Math.toIntExact(id) -1, book);
    }


}
