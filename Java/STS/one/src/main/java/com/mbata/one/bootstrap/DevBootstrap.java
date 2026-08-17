package com.mbata.one.bootstrap;

import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import com.mbata.one.Author;
import com.mbata.one.Book;
import com.mbata.one.Publisher;
import com.mbata.one.repositories.AuthorRepository;
import com.mbata.one.repositories.BookRepository;
import com.mbata.one.repositories.PublisherRepository;

@Component
public class DevBootstrap implements ApplicationListener<ContextRefreshedEvent>{
	
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
		Publisher publisher = new Publisher();
		publisher.setName("foo");
		
		publisherRepository.save(publisher);		
		
		// Shaka
		Author shaka = new Author("Shaka", "Zulu");
		Book aaa = new Book("Domain Driven Design", "1234", publisher);
		shaka.getBooks().add(aaa);
		aaa.getAuthors().add(shaka);
		
		authorRepository.save(shaka);
		bookRepository.save(aaa);	
	
		
		// Lwanda
		Author lwanda = new Author("Lwanda", "Magere");
		Book aapp = new Book("Architectural Patterns", "112244", publisher);
		lwanda.getBooks().add(aapp);
		//aapp.getAuthors().add(lwanda);
		
		authorRepository.save(lwanda);
		bookRepository.save(aapp);
	}

}
