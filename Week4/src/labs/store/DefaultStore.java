package labs.store;

import labs.store.book.Book;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.UUID;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class DefaultStore implements Store {

    private static final String NULL_ARG_ERROR = "%s cannot be null.";

    private final Map<UUID, Book> books = new HashMap<>();

    @Override
    public boolean add(Book book) {
        Objects.requireNonNull(book, String.format(NULL_ARG_ERROR, "book"));
        books.put(book.ISBN(), book);
        return true;
    }

    @Override
    public void remove(Book book) {
        Objects.requireNonNull(book, String.format(NULL_ARG_ERROR, "book"));
        books.remove(book.ISBN());
    }

    @Override
    public List<Book> getAllBooksByAuthor(String author) {
        Objects.requireNonNull(author, String.format(NULL_ARG_ERROR, "author"));

        return getAllBooksFilterBy(book -> book.author().equals(author));
    }

    @Override
    public List<Book> getAllBooksPublishedAfter(LocalDate from) {
        Objects.requireNonNull(from, String.format(NULL_ARG_ERROR, "from"));

        return getAllBooksFilterBy(book -> book.publishedYear().isAfter(from));
    }

    @Override
    public List<Book> getAllBooksBetween(LocalDate from, LocalDate to) {
        Objects.requireNonNull(from, String.format(NULL_ARG_ERROR, "from"));
        Objects.requireNonNull(to, String.format(NULL_ARG_ERROR, "to"));

        return getAllBooksFilterBy(book -> book.publishedYear().isBefore(to) && book.publishedYear().isAfter(from));
    }

    @Override
    public void clear() {
        books.clear();
    }

    @Override
    public Map<String, List<Book>> getAllBooksGroupByAuthor() {
        return books.values().stream()
            .collect(Collectors.groupingBy(Book::author));
    }

    @Override
    public Map<String, List<Book>> getAllBooksGroupByPublisher() {
        return books.values().stream()
            .collect(Collectors.groupingBy(Book::publisher));
    }

    @Override
    public List<Book> getAllBooksFilterBy(Predicate<Book> bookPredicate) {
        Objects.requireNonNull(bookPredicate, String.format(NULL_ARG_ERROR, "bookPredicate"));

        return books.values().stream()
            .filter(bookPredicate)
            .toList();
    }
}
