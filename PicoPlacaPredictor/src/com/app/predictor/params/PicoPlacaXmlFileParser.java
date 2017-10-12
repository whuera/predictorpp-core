package com.app.predictor.params;

import java.util.ArrayList;
import java.util.List;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import com.app.predictor.model.PicoPlacaParam;


/**
 * The Class PicoPlacaXmlFileParser.
 */
public class PicoPlacaXmlFileParser extends DefaultHandler {
	
	/** The pico placa param. */
	PicoPlacaParam picoPlacaParam = new PicoPlacaParam();
	
	/** The list pico placa param. */
	private List<PicoPlacaParam> listPicoPlacaParam = new ArrayList<>();
	
	/** The bname. */
	boolean bname = false;
	
	/** The bpicoini. */
	boolean bpicoini = false;
	
	/** The bpicofin. */
	boolean bpicofin = false;
	
	/** The bmorninghourini. */
	boolean bmorninghourini = false;
	
	/** The bmorninghourfin. */
	boolean bmorninghourfin = false;
	
	/** The bafternoonhourini. */
	boolean bafternoonhourini = false;
	
	/** The bafternoonhourfin. */
	boolean bafternoonhourfin = false;
	
	/**
	 * Gets the list pico placa param.
	 *
	 * @return the list pico placa param
	 */
	public List<PicoPlacaParam> getListPicoPlacaParam() {
		return listPicoPlacaParam;
	}


	/**
	 * Sets the list pico placa param.
	 *
	 * @param listPicoPlacaParam the new list pico placa param
	 */
	public void setListPicoPlacaParam(List<PicoPlacaParam> listPicoPlacaParam) {

	}

	/** The data. */
	String data = null;

	/* (non-Javadoc)
	 * @see org.xml.sax.helpers.DefaultHandler#characters(char[], int, int)
	 */
	@Override
	public void characters(char[] ch, int start, int length) throws SAXException {
		data = new String(ch, start, length).trim();
		
		if (bname) {

			picoPlacaParam.setName(data);
			bname = false;
		} 
		if (bpicoini) {

			picoPlacaParam.setPicoini(data);
			bpicoini = false;
		} 
		if (bpicofin) {
			picoPlacaParam.setPicofin(data);
			bpicofin = false;
		}
		
		if(bmorninghourini){
			picoPlacaParam.setMorninghourini(data);
			bmorninghourini = false;
		}
		
		if(bmorninghourfin){
			picoPlacaParam.setMorninghourfin(data);
			bmorninghourfin = false;
		}
		if(bafternoonhourini){
			picoPlacaParam.setAfternoonhourini(data);
			bafternoonhourini = false;
		}
		if(bafternoonhourfin){
			picoPlacaParam.setAfternoonhourfin(data);
			bafternoonhourfin = false;
		}

	}


	/* (non-Javadoc)
	 * @see org.xml.sax.helpers.DefaultHandler#startElement(java.lang.String, java.lang.String, java.lang.String, org.xml.sax.Attributes)
	 */
	@Override
	public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
		

		if(qName.equalsIgnoreCase("dia")){
			picoPlacaParam = new PicoPlacaParam();
		}
		if (qName.equalsIgnoreCase("name")) {
			bname = true;
		} if (qName.equalsIgnoreCase("picoini")) {
			bpicoini = true;
		} if (qName.equalsIgnoreCase("picofin")) {
			bpicofin = true;
		} if (qName.equalsIgnoreCase("morninghourini")){
			bmorninghourini = true;
		} if(qName.equalsIgnoreCase("morninghourfin")){
			bmorninghourfin = true;
		}if (qName.equalsIgnoreCase("afternoonhourini")){
			bafternoonhourini = true;
		}if(qName.equalsIgnoreCase("afternoonhourfin")){
			bafternoonhourfin = true;
		}

	}
	
	 /* (non-Javadoc)
 	 * @see org.xml.sax.helpers.DefaultHandler#endElement(java.lang.String, java.lang.String, java.lang.String)
 	 */
 	@Override
	    public void endElement(String uri, String localName, String qName) throws SAXException {

	        if (qName.equalsIgnoreCase("dia")) {

	        	listPicoPlacaParam.add(picoPlacaParam);
	        }
	    }

	/* (non-Javadoc)
	 * @see org.xml.sax.helpers.DefaultHandler#endDocument()
	 */
	@Override
	public void endDocument() throws SAXException {
		//System.out.println(picoPlacaParam);
	}

}
