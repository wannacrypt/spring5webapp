package co.wannacrypt.spring5webapp.repositories;

import co.wannacrypt.spring5webapp.model.Book;
import org.springframework.data.repository.CrudRepository;

public interface BookRepository extends CrudRepository<Book, Long> {
}
