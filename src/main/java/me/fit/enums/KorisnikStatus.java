package me.fit.enums;

public enum KorisnikStatus {

	
    EXISTS("Student vec postoji");
	
	private String label;

	private KorisnikStatus(String label) {
		this.label = label;
	}

	public String getLabel() {
		return label;
	}

	public void setLabel(String label) {
		this.label = label;
	}
}
