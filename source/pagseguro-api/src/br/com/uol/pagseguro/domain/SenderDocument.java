package br.com.uol.pagseguro.domain;


public class SenderDocument{

	/** Sender document type */
	private String type;
	
	/** Sender document value*/
	private Long value;

	/**
	 * The constructor
	 */
	public SenderDocument(){
		
	}
	
	/**
	 * The constructor
	 * @param type
	 * @param value
	 */
	public SenderDocument(String type, Long value){
		this.setType(type);
		this.setValue(value);
	}
	
	/**
	 * Gets document type
	 * @return String
	 */
	public String getType() {
		return type;
	}
	
	/**
	 * Sets document type
	 * @param String type
	 */
	public void setType(String type) {
		this.type = type;
	}

	/**
	 * Gets document value
	 * @return Long
	 */
	public Long getValue() {
		return value;
	}

	/**
	 * Sets document value
	 * @param Long value
	 */
	public void setValue(Long value) {
		this.value = value;
	}

	@Override
	public String toString() {
		return "Document [type=" + type + ", value=" + value + "]";
	}
	
}
