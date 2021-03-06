package org.alice.bookshop.service.admin.manage;

import org.alice.bookshop.model.Publisher;
import org.alice.bookshop.repository.PublisherJpa;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

@Service("amPublisherService")
public class PublisherService {

	@Autowired
	public PublisherJpa publisherJpa;

	public Page<Publisher> getPublishers(int p, int psize) {
		return publisherJpa.findByDeleted(false, PageRequest.of(p - 1, psize));
	}

	private boolean isPublisherExit(Publisher publisher) {
		Publisher isExit = publisherJpa.findByName(publisher.getName());
		return (isExit != null);
	}

	public String add(Publisher publisher) {
		if (isPublisherExit(publisher)) {
			return "Publisher " + publisher.getName() + " already exit!";
		} else {
			publisherJpa.save(publisher);
			return "Add publisher " + publisher.getName() + " successed";
		}
	}

	public String edit(Publisher publisher) {
		Publisher originPublisher = publisherJpa.getOne(publisher.getId());
		if (isPublisherExit(publisher) && !originPublisher.getName().equals(publisher.getName())) {
			return "Publisher's name should not be same with another!";
		} else {
			publisherJpa.save(publisher);
			return "Edit publisher id = " + publisher.getId() + " successed";
		}
	}

}
