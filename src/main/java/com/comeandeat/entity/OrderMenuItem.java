package com.comeandeat.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import org.hibernate.annotations.GenericGenerator;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@NoArgsConstructor
@ToString
@EqualsAndHashCode
public class OrderMenuItem {
	@Id
	@GeneratedValue(generator = "UUID")
	@GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
	@Column(name = "id", updatable = false, nullable = false)
	private @Getter String id;

	@ManyToOne(fetch = FetchType.LAZY)
	private @Getter @Setter FoodOrder order;
	@ManyToOne(fetch = FetchType.LAZY)
	private @Getter @Setter FoodProvider foodProvider;
	@ManyToOne(fetch = FetchType.LAZY)
	private @Getter @Setter MenuItem menuItem;
	@ManyToOne(fetch = FetchType.LAZY)
	private @Getter @Setter Addition addition;
}
