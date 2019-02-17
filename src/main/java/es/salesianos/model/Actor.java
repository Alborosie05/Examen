package es.salesianos.model;

import org.springframework.stereotype.Component;

@Component
public class Actor extends Director{

	private Integer year;

	public Integer getYear() {
		return year;
	}
	public void setYear(Integer year) {
		this.year = year;
	}

}

