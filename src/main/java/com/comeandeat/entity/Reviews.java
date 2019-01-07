package com.comeandeat.entity;

import javax.persistence.Cacheable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import org.hibernate.annotations.GenericGenerator;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Cacheable(false)
@NoArgsConstructor
public class Reviews {
	@Id
	@GeneratedValue(generator = "UUID")
	@GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
	@Column(name = "id", updatable = false, nullable = false)
	private @Getter String id;

	@ManyToOne(fetch = FetchType.LAZY)
	private @Getter @Setter FoodProvider foodProvider;
	private @Getter @Setter int rating;
	private @Getter @Setter String reviewText;
}
