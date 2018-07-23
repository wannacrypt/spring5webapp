package co.wannacrypt.spring5webapp.bootstrap;

import co.wannacrypt.spring5webapp.model.Author;
import co.wannacrypt.spring5webapp.model.Book;
import co.wannacrypt.spring5webapp.model.Publisher;
import co.wannacrypt.spring5webapp.repositories.AuthorRepository;
import co.wannacrypt.spring5webapp.repositories.BookRepository;
import co.wannacrypt.spring5webapp.repositories.PublisherRepository;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

@Component
public class DevBootstrap implements ApplicationListener<ContextRefreshedEvent> {

    private AuthorRepository authorRepository;
    private BookRepository bookRepository;
    private PublisherRepository publisherRepository;

    public DevBootstrap(AuthorRepository authorRepository, BookRepository bookRepository, PublisherRepository publisherRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
        this.publisherRepository = publisherRepository;
    }

    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) {
        initData();
    }

    private void initData() {

        // Eric
        Author eric = new Author("Eric", "Evans");
        Publisher hc = new Publisher("Harper Collins", "Wall street 157");
        Book ddd = new Book("Domain Driven Design", "1234");
        hc.setBook(ddd);
        ddd.setPublisher(hc);
        eric.getBooks().add(ddd);
        ddd.getAuthors().add(eric);

        authorRepository.save(eric);
        publisherRepository.save(hc);
        bookRepository.save(ddd);

        // Rod
        Author rod = new Author("Rod", "Johnson");
        Publisher at = new Publisher("Atamura", "Baitursynova 912A");
        Book noEJB = new Book("J2EE Development without EJB", "1245");
        noEJB.setPublisher(at);
        at.setBook(noEJB);
        rod.getBooks().add(noEJB);

        authorRepository.save(rod);
        publisherRepository.save(at);
        bookRepository.save(noEJB);

    }
}
