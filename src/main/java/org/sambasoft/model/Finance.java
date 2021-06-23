package org.sambasoft.model;
import java.io.Serializable;
import java.util.Date;


public class Finance implements Serializable {

	private static final long serialVersionUID = 1L;
	private long id;
	private Transacts type;
	private Date dateFinance;
	private Integer value;
	private String cpf;
	private String card;
	private String hour;
	private String ownerStore;
	private String nameStore;

	public static long getSerialVersionUID() {
		return serialVersionUID;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public Transacts getType() {
		return type;
	}

	public void setType(Transacts type) {
		this.type = type;
	}

	public Date getDateFinance() {
		return dateFinance;
	}

	public void setDateFinance(Date dateFinance) {
		this.dateFinance = dateFinance;
	}

	public Integer getValue() {
		return value;
	}

	public void setValue(Integer value) {
		this.value = value;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getCard() {
		return card;
	}

	public void setCard(String card) {
		this.card = card;
	}

	public String getHour() {
		return hour;
	}

	public void setHour(String hour) {
		this.hour = hour;
	}

	public String getOwnerStore() {
		return ownerStore;
	}

	public void setOwnerStore(String ownerStore) {
		this.ownerStore = ownerStore;
	}

	public String getNameStore() {
		return nameStore;
	}

	public void setNameStore(String nameStore) {
		this.nameStore = nameStore;
	}
}