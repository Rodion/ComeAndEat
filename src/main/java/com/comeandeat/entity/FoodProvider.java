package com.comeandeat.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

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
public class FoodProvider {
	@Id
	@GeneratedValue(generator = "UUID")
	@GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
	@Column(name = "id", updatable = false, nullable = false)
	private @Getter @Setter String id;
	private @Getter @Setter String foodProviderName;
	private @Getter @Setter String address; // (for the purpose of this exercise, a city name only)
	private @Getter @Setter String contactName;
	private @Getter @Setter String contactNumber;
	private @Getter @Setter String workingHours;
	@Column(columnDefinition = "BLOB")
	private @Getter @Setter Money deliveryPrice;

	// OneToMany(mappedBy = "id")
	// private List<MenuItem> menuItems;

}
