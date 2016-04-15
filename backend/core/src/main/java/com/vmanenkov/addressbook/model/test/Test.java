package com.vmanenkov.addressbook.model.test;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "test")
public class Test {

	@Id
	@GeneratedValue
	@Column(name = "id")
	private Integer id;

	@NotNull
	@Column(name = "description")
	private String description;

	public Test(Integer id, String description) {
		super();
		this.id = id;
		this.description = description;
	}

	public Test() {
		super();
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Test [id=");
		builder.append(id);
		builder.append(", description=");
		builder.append(description);
		builder.append("]");
		return builder.toString();
	}

}
