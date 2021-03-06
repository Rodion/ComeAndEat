package com.comeandeat.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import org.hibernate.annotations.GenericGenerator;
import org.javamoney.moneta.Money;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@NoArgsConstructor
@ToString
@EqualsAndHashCode
public class MenuItem {
	@Id
	@GeneratedValue(generator = "UUID")
	@GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
	@Column(name = "id", updatable = false, nullable = false)
	private @Getter String id;

	@ManyToOne
	@JoinColumn(name = "food_provider_id")
	private @Getter @Setter FoodProvider foodProvider;
	private @Getter @Setter String description;
	@Column(columnDefinition = "BLOB")
	private @Getter @Setter Money price;

	@OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinColumn(name = "menu_item_id", foreignKey = @ForeignKey(name = "AdditionsForMenuItem"))
	private @Getter @Setter List<Addition> additionsList;

}
