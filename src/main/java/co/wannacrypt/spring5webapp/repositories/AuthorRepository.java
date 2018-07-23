package co.wannacrypt.spring5webapp.repositories;

import co.wannacrypt.spring5webapp.model.Author;
import org.springframework.data.repository.CrudRepository;

public interface AuthorRepository extends CrudRepository<Author, Long> {

}
