package org.sambasoft.model;
import java.io.Serializable;


public class Transacts implements Serializable {

	private static final long serialVersionUID = 1L;
	private long id;
	private String description;
	private String natureze;
	private String signal;

	public static long getSerialVersionUID() {
		return serialVersionUID;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getNatureze() {
		return natureze;
	}

	public void setNatureze(String natureze) {
		this.natureze = natureze;
	}

	public String getSignal() {
		return signal;
	}

	public void setSignal(String signal) {
		this.signal = signal;
	}
}
