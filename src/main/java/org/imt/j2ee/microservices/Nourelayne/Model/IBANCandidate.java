package org.imt.j2ee.microservices.Nourelayne.Model;


public class IBANCandidate {
	
	private int id;
	private String ibanNumber;

	private Boolean valide;
	
    public IBANCandidate() {
		
	}
	
	public IBANCandidate(String ibanNumber) {
		super();
		this.ibanNumber = ibanNumber;
	}
	
	public IBANCandidate(int id, String ibanNumber) {
		super();
		this.ibanNumber = ibanNumber;
		this.id=id;
	}
	
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}

	public Boolean getValide() {
		return valide;
	}

	public void setValide(Boolean valide) {
		this.valide = valide;
	}

	public String getIbanNumber() {
		return ibanNumber;
	}
	
	public void setIbanNumber(String ibanNumber) {
		this.ibanNumber = ibanNumber;
	}
}
