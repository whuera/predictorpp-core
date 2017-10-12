package com.app.predictor.service;

import java.io.IOException;

import javax.xml.parsers.ParserConfigurationException;

import org.xml.sax.SAXException;

import com.app.predictor.model.PicoPlacaForm;

public interface IPredictorPicoPlaca {
	public  String getCalculateHours(String hourClient, String hourRange, String hourRangeFinish);
	public String dayEnabled(PicoPlacaForm picoPlacaForm) throws ParserConfigurationException, SAXException, IOException;

}
