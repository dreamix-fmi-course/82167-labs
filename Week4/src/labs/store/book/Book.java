package labs.store.book;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Objects;
import java.util.UUID;

public record Book(UUID ISBN,
                   String tittle,
                   String author,
                   BigDecimal price,
                   String publisher,
                   LocalDate publishedYear) {

    public Book {
        Objects.requireNonNull(ISBN);
        Objects.requireNonNull(tittle);
        Objects.requireNonNull(author);
        Objects.requireNonNull(price);
        Objects.requireNonNull(publisher);
        Objects.requireNonNull(publishedYear);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Book book = (Book) o;
        return ISBN.equals(book.ISBN);
    }

    @Override
    public int hashCode() {
        return Objects.hash(ISBN);
    }
}
