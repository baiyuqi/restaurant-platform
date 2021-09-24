package com.dy.food.account.repository.dao;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "RECEPT_ADDRESS")
@Builder
public class ReceptAddress {
	@Id
	@GeneratedValue(generator = "uuid")
	@GenericGenerator(name = "uuid", strategy = "uuid2")
	String id;
	String accept_name;
	String mobile;
	String province;
	String area;
	String city;
	int sex;

	String street;
	boolean inner;
	long lat;
	String doorNumber;
	boolean isDefault;

	String poiname;
}
