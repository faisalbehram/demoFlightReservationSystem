package com.studentdal.app.util;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;

import org.springframework.stereotype.Component;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import com.studentdal.app.entites.Reservation;

@Component
public class PDFGenerator{
	
	public void generateIternaryReservation(Reservation reservation,String filepath)
	{	
		
	// generate pdf 
	Document document  = new Document();
	try {
		PdfWriter.getInstance(document, new FileOutputStream(filepath));
		
		document.open();
		
		document.add(generateTable(reservation));
		
		
		document.close();
		
		
	} catch (FileNotFoundException | DocumentException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	}

	// add table and cells to pdf
	private PdfPTable generateTable(Reservation reservation) {
		PdfPTable pdfPTable = new PdfPTable(2);
		
		PdfPCell cell;
		
		cell = new PdfPCell(new Phrase("Flight Iternary"));
		cell.setColspan(2);
		pdfPTable.addCell(cell);
		
		cell = new PdfPCell(new Phrase("Flight Details"));
		cell.setColspan(2);
		pdfPTable.addCell(cell);


		
		pdfPTable.addCell("Departure CIty");
		pdfPTable.addCell(reservation.getFlight().getDepartureCity());
		
		pdfPTable.addCell("Arrival CIty");
		pdfPTable.addCell(reservation.getFlight().getArrivalCity());
		
		pdfPTable.addCell("Flight  Number");
		pdfPTable.addCell(reservation.getFlight().getFlightNumber());
		
		pdfPTable.addCell("Date of Departure");
		pdfPTable.addCell(reservation.getFlight().getDateOfDeparture().toString());
		
		pdfPTable.addCell("Esitmated Departure Time");
		pdfPTable.addCell(reservation.getFlight().getEstimatedDepartureTime().toString());
		
		
		// passsenger Details
		cell = new PdfPCell(new Phrase("Passenger Details"));
		cell.setColspan(2);
		pdfPTable.addCell(cell);
		
		pdfPTable.addCell("FirstName");
		pdfPTable.addCell(reservation.getPassenger().getFirstName());
		
		pdfPTable.addCell("lastName");
		pdfPTable.addCell(reservation.getPassenger().getLastName());
		
		pdfPTable.addCell("Email");
		pdfPTable.addCell(reservation.getPassenger().getEmail());
		
		pdfPTable.addCell("Phone Number");
		pdfPTable.addCell(reservation.getPassenger().getPhone());
		
		return pdfPTable;
	}

}
