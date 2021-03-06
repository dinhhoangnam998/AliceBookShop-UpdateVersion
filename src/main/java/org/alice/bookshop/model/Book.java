package org.alice.bookshop.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.Proxy;
import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Proxy(lazy = false)
@JsonIgnoreProperties({ "width", "height", "totalPage", "coverPrice", "releaseDate", "description", "shortDescription",
		"remainQuantity", "imgURLs", "thumbURLs", "author", "category", "publisher", "salePrice", "deleted", "relateBooks" })
public class Book {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String name;
	private int width;
	private int height;
	private int totalPage;
	private int coverPrice;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@Temporal(TemporalType.DATE)
	private Date releaseDate;
	@Column(columnDefinition = "varchar(2047)")
	private String shortDescription;
	@Column(columnDefinition = "varchar(4195)")
	private String description;
	// derived
	private int remainQuantity;
	private String imgURL;
	@ElementCollection
	private List<String> imgURLs = new ArrayList<>();
	@ElementCollection
	private List<String> thumbURLs = new ArrayList<>();
	private boolean deleted;
	private int salePrice;

	@ManyToOne
	private Author author;
	@ManyToOne
	private Category category;
	@ManyToOne
	private Publisher publisher;
	@ManyToMany
	private List<Book> relateBooks = new ArrayList<>();
}
