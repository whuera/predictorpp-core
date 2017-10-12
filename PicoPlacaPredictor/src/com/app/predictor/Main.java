package com.app.predictor;

import java.io.IOException;
import java.util.Calendar;
import javax.xml.parsers.ParserConfigurationException;
import org.xml.sax.SAXException;
import com.app.predictor.model.PicoPlacaForm;
import com.app.predictor.service.ServicePredictorPicoPlaca;


/**
 * The Class Main.
 */
public class Main {


	/**
	 * The main method.
	 *
	 * @param args the arguments
	 * @throws ParserConfigurationException the parser configuration exception
	 * @throws SAXException the SAX exception
	 * @throws IOException Signals that an I/O exception has occurred.
	 */
	public static void main(String[] args) throws ParserConfigurationException, SAXException, IOException{
		System.out.println("Test");
		Calendar dateInput = Calendar.getInstance();
		System.out.println(dateInput.toString());
		ServicePredictorPicoPlaca bussinesRule = new ServicePredictorPicoPlaca();
		PicoPlacaForm picoPlacaForm = new PicoPlacaForm();
		picoPlacaForm.setDateQuestion(dateInput);
		picoPlacaForm.setNumber("PCD4007");
		picoPlacaForm.setParamTime("16:59");
		System.out.println(bussinesRule.dayEnabled(picoPlacaForm));
	}

}
