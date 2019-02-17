package es.salesianos.model;

import org.springframework.stereotype.Component;

@Component
public class Film extends BaseEntity{

	private String title;
	private Integer codDirector;
	
	public Integer getCodDirector() {
		return codDirector;
	}
	public void setCodDirector(Integer codDirector) {
		this.codDirector = codDirector;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
}

