package com.app.predictor.utils;


/**
 * The Interface Constants.
 */
public interface Constants {
	
	/** The Constant SUNDAY. */
	public final static int SUNDAY = 1;

	/**
	 * Value of the {@link #DAY_OF_WEEK} field indicating
	 * Monday.
	 */
	public final static int MONDAY = 2;

	/**
	 * Value of the {@link #DAY_OF_WEEK} field indicating
	 * Tuesday.
	 */
	public final static int TUESDAY = 3;

	/**
	 * Value of the {@link #DAY_OF_WEEK} field indicating
	 * Wednesday.
	 */
	public final static int WEDNESDAY = 4;

	/**
	 * Value of the {@link #DAY_OF_WEEK} field indicating
	 * Thursday.
	 */
	public final static int THURSDAY = 5;

	/**
	 * Value of the {@link #DAY_OF_WEEK} field indicating
	 * Friday.
	 */
	public final static int FRIDAY = 6;

	/**
	 * Value of the {@link #DAY_OF_WEEK} field indicating
	 * Saturday.
	 */
	public final static int SATURDAY = 7;
	
	/** The Constant RANGE_MINUTES. */
	public final static int RANGE_MINUTES = 150;
	
	/** The Constant RANGE_MINUTES_NIGHT. */
	public final static int RANGE_MINUTES_NIGHT = 210;
	
	/** The Constant RANGE_MINUTES_INI. */
	public final static int RANGE_MINUTES_INI = 0;
	
	/** The Constant HOUR_MIDDLE_DAY. */
	public final static String HOUR_MIDDLE_DAY = "12:00";
	
	/** The Constant MESSAGE_PREDICTOR_ALERT. */
	public final static String MESSAGE_PREDICTOR_ALERT = "Atencion el vehiculo no puede circular porque se encuentra dentro del horario de pico y placa";
	
	/** The Constant MESSAGE_PREDICTOR_DEFAULT. */
	public final static String MESSAGE_PREDICTOR_DEFAULT = "El vehiculo puede circular libremente sin restriccion";
	
	public final static String MESSAGE_PREDICTOR_OUT_DAY = "Fecha seleccionada es fin de semana, no aplica pico y placa";
	

}
