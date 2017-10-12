package com.app.predictor.service;

import java.io.IOException;

import javax.xml.parsers.ParserConfigurationException;

import org.xml.sax.SAXException;

import com.app.predictor.businessrule.BussinesRule;
import com.app.predictor.model.PicoPlacaForm;


/**
 * The Class ServicePredictorPicoPlaca.
 */
public class ServicePredictorPicoPlaca implements IPredictorPicoPlaca {
	
	/** The bussines rule. */
	BussinesRule bussinesRule = new BussinesRule();		
	
	/* (non-Javadoc)
	 * @see com.app.predictor.service.IPredictorPicoPlaca#getCalculateHours(java.lang.String, java.lang.String, java.lang.String)
	 */
	@Override
	public String getCalculateHours(String hourClient, String hourRange, String hourRangeFinish) {
		return bussinesRule.getCalculateHours(hourClient, hourRange, hourRangeFinish);
	}

	/* (non-Javadoc)
	 * @see com.app.predictor.service.IPredictorPicoPlaca#dayEnabled(com.app.predictor.model.PicoPlacaForm)
	 */
	@Override
	public String dayEnabled(PicoPlacaForm picoPlacaForm)
			throws ParserConfigurationException, SAXException, IOException {
		return bussinesRule.dayEnabled(picoPlacaForm);
	}

}
