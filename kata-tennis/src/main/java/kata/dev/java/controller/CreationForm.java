package kata.dev.java.controller;



import org.hibernate.validator.constraints.NotEmpty;

public class CreationForm {
	
	@NotEmpty
	private String id;

	public String getId() {
		return id;
	}

	public void setId(final String id) {
		this.id = id;
	}	
	
	
	
}
