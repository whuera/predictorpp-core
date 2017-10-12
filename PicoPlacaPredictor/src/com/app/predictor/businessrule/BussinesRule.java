package com.app.predictor.businessrule;

import java.io.File;
import java.io.IOException;
import java.time.LocalTime;
import java.time.temporal.ChronoUnit;
import java.util.Calendar;
import java.util.List;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.xml.sax.SAXException;
import com.app.predictor.model.PicoPlacaForm;
import com.app.predictor.model.PicoPlacaParam;
import com.app.predictor.params.PicoPlacaXmlFileParser;
import com.app.predictor.utils.Constants;

/**
 * The Class BussinesRule.
 */
public class BussinesRule {
	
	private static final Logger logger = LoggerFactory.getLogger(BussinesRule.class);

	/** The Constant PARAMS_FILE_PATH. */
	private static final String PARAMS_FILE_PATH = "Resources/picoplaca.xml";



	/**
	 * Gets the calculate hours.
	 *
	 * @param hourClient the hour client
	 * @param hourRange the hour range
	 * @param hourRangeFinish the hour range finish
	 * @return the calculate hours
	 */
	public  String getCalculateHours(String hourClient, String hourRange, String hourRangeFinish){
		int minutes = 0;
		String messageResponse = Constants.MESSAGE_PREDICTOR_DEFAULT;
		try{
			LocalTime hourEvaluate = null;
			LocalTime hourMiddleDay = LocalTime.parse(Constants.HOUR_MIDDLE_DAY);
			hourEvaluate = LocalTime.parse(hourClient);
			if (hourEvaluate.isBefore(hourMiddleDay)){
				LocalTime hourFinishMorning  = LocalTime.parse(hourRange);				
				minutes = (int) ChronoUnit.MINUTES.between(hourEvaluate, hourFinishMorning);
				messageResponse =  minutes >= Constants.RANGE_MINUTES_INI && minutes <= Constants.RANGE_MINUTES?Constants.MESSAGE_PREDICTOR_ALERT:Constants.MESSAGE_PREDICTOR_DEFAULT;				
			}else{
				LocalTime hourFinishToNight  = LocalTime.parse(hourRangeFinish);
				minutes = (int) ChronoUnit.MINUTES.between(hourEvaluate, hourFinishToNight);
				messageResponse =  minutes >= Constants.RANGE_MINUTES_INI && minutes <= Constants.RANGE_MINUTES_NIGHT?Constants.MESSAGE_PREDICTOR_ALERT:Constants.MESSAGE_PREDICTOR_DEFAULT;
			}
		}catch(Exception ex){		
			logger.error(ex.getMessage());
		}
		return messageResponse;
	}

	/**
	 * Day enabled.
	 *
	 * @param picoPlacaForm the pico placa form
	 * @return the string
	 * @throws ParserConfigurationException the parser configuration exception
	 * @throws SAXException the SAX exception
	 * @throws IOException Signals that an I/O exception has occurred.
	 */
	public String dayEnabled(PicoPlacaForm picoPlacaForm) throws ParserConfigurationException, SAXException, IOException {
		String messageAlert = Constants.MESSAGE_PREDICTOR_DEFAULT;
		PicoPlacaXmlFileParser picoPlacaXmlFileParser = new PicoPlacaXmlFileParser();
		SAXParserFactory saxParserFactory = SAXParserFactory.newInstance();
		SAXParser saxParser = saxParserFactory.newSAXParser();
		if(picoPlacaForm.getDateQuestion().get(Calendar.DAY_OF_WEEK)!= Calendar.SUNDAY && picoPlacaForm.getDateQuestion().get(Calendar.DAY_OF_WEEK)!= Calendar.SATURDAY){				
			saxParser.parse(new File(PARAMS_FILE_PATH), picoPlacaXmlFileParser);
			List<PicoPlacaParam> listPicoPlacaParam = picoPlacaXmlFileParser.getListPicoPlacaParam();			
			for (PicoPlacaParam picoPlacaParam : listPicoPlacaParam) {
				if(picoPlacaParam.getName().equalsIgnoreCase(String.valueOf(picoPlacaForm.getDateQuestion().get(Calendar.DAY_OF_WEEK)))){
					char[] param = picoPlacaForm.getNumber().toCharArray(); 					
					if(picoPlacaParam.getPicoini().equalsIgnoreCase(String.valueOf(param[6]))||picoPlacaParam.getPicofin().equalsIgnoreCase(String.valueOf(param[6])) ){
						messageAlert =	this.getCalculateHours(picoPlacaForm.getParamTime(), picoPlacaParam.getMorninghourfin(), picoPlacaParam.getAfternoonhourfin());
					}
				}
			}
		}else
		{
			messageAlert = Constants.MESSAGE_PREDICTOR_OUT_DAY;
		}
		return messageAlert;
	}

}
