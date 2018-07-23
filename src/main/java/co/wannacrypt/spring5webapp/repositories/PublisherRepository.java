package co.wannacrypt.spring5webapp.repositories;

import co.wannacrypt.spring5webapp.model.Publisher;
import org.springframework.data.repository.CrudRepository;

public interface PublisherRepository extends CrudRepository<Publisher, Long> {
}
