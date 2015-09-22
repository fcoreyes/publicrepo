package cl.tagprinter.server.queue;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class TagPrintJob {

	private String type;
	private String requestor;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getRequestor() {
		return requestor;
	}

	public void setRequestor(String requestor) {
		this.requestor = requestor;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

}
