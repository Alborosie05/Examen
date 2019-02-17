package es.salesianos.model;

import org.springframework.stereotype.Component;

@Component
public class Director extends BaseEntity{
	
	private String name;

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
}

