package com.app.predictor.model;


import java.util.Calendar;



// TODO: Auto-generated Javadoc
/**
 * The Class PicoPlacaForm.
 */
public class PicoPlacaForm {

	/** The number. */
	private String number;
	
	/** The date question. */
	private Calendar dateQuestion;
	
	/** The param time. */
	private String paramTime;
	

	/**
	 * Gets the param time.
	 *
	 * @return the param time
	 */
	public String getParamTime() {
		return paramTime;
	}

	/**
	 * Sets the param time.
	 *
	 * @param paramTime the new param time
	 */
	public void setParamTime(String paramTime) {
		this.paramTime = paramTime;
	}

	/**
	 * Gets the number.
	 *
	 * @return the number
	 */
	public String getNumber() {
		return number;
	}

	/**
	 * Sets the number.
	 *
	 * @param number the new number
	 */
	public void setNumber(String number) {
		this.number = number;
	}

	/**
	 * Gets the date question.
	 *
	 * @return the date question
	 */
	public Calendar getDateQuestion() {
		return dateQuestion;
	}

	/**
	 * Sets the date question.
	 *
	 * @param dateQuestion the new date question
	 */
	public void setDateQuestion(Calendar dateQuestion) {
		this.dateQuestion = dateQuestion;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "PicoPlacaForm [number=" + number + ", dateQuestion=" + dateQuestion + ", paramTime=" + paramTime + "]";
	}

	
	
}
