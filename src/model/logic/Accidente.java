package model.logic;


public class Accidente  {
	
	/**
	 * Atributo id
	 */
	private String id;
	
	/**
	 * Atributo severity
	 */
	private String severity;
	
	/**
	 * Atributo startTime
	 */
	private String startTime;
	
	/**
	 * Atributo endTime
	 */
	private String endTime;
	
	/**
	 * Constructor
	 */
	public Accidente (String id, String severity, String startTime, String endTime) {
		this.id = id;
		this.severity = severity;
		this.startTime = startTime;
		this.endTime = endTime;
	}
	
	/**
	 * Retorna el atributo id
	 */
	public String getID() {
		return id;
	}
	
	/**
	 * Retorna el atributo severity
	 */
	public String getSeverity() {
		return severity;
	}
	
	/**
	 * Retorna el atributo startTime
	 */
	public String getStartTime() {
		return startTime;
	}
	
	/**
	 * Retorna el atributo endTime
	 */
	public String getEndTime() {
		return endTime;
	}

	
}