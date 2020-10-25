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
	 * Atributo startDate (fecha inicial)
	 */
	private String startDate;
	
	/**
	 * Atributo endDate (fecha final)
	 */
	private String endDate;
	
	/**
	 * Atributo startHour
	 */
	private String startHour;
	
	/**
	 * Atributo endHour
	 */
	private String endHour;
	
	/**
	 * Constructor
	 */
	public Accidente (String id, String severity, String startDate, String endDate, String startHour, String endHour) {
		this.id = id;
		this.severity = severity;
		this.startDate = startDate;
		this.endDate = endDate;
		this.startHour = startHour;
		this.endHour = endHour;
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
	public String getStartDate() {
		return startDate;
	}
	
	/**
	 * Retorna el atributo endTime
	 */
	public String getEndDate() {
		return endDate;
	}
	
	/**
	 * Retorna el atributo startHour
	 */
	public String getStartHour() {
		return startHour;
	}
	
	/**
	 * Retorna el atributo endHour
	 */
	
	public String getEndHour() {
		return endHour;
	}

	

	
}