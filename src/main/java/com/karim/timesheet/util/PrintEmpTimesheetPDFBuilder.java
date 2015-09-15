/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.karim.timesheet.util;

import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Document;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import com.karim.timesheet.model.Book;
import com.karim.timesheet.model.Timesheet;
import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author karim
 */
public class PrintEmpTimesheetPDFBuilder extends AbstractITextPdfView {
 
    @Override
    protected void buildPdfDocument(Map<String, Object> model, Document doc,
            PdfWriter writer, HttpServletRequest request, HttpServletResponse response)
            throws Exception {
        // get data model which is passed by the Spring container
        Timesheet timesheet = (Timesheet) model.get("timesheet");
                 
//        doc.add(new Paragraph("Recommended books for Spring framework"));
        doc.addAuthor("ddddddd");
       // _____________________________________ TABLE TITLE __________________________________//
       //_______________________________________________________________________________________//
        
        PdfPTable tableTitle = new PdfPTable(1);
        tableTitle.setWidthPercentage(100.0f);
        tableTitle.setSpacingBefore(3);
//        tableTitle.set;
         
        PdfPCell cellTitle=new PdfPCell(new Paragraph("Employee Name: "+timesheet.getEmployee().getName()+"     "
                + "             Period Ending :"+timesheet.getPeriodEndingDate()));
        cellTitle.setHorizontalAlignment(Element.ALIGN_CENTER);
        cellTitle.setColspan(9);
        cellTitle.setBorder(0);
        tableTitle.addCell(cellTitle);
        
        // _____________________________________ TABLE CONTENT __________________________________//
        //_______________________________________________________________________________________//
        
        PdfPTable table = new PdfPTable(9);
        table.setWidthPercentage(100.0f);
        table.setSpacingBefore(3);
         
        // define font for table header row
        Font font = FontFactory.getFont(FontFactory.HELVETICA);
        font.setColor(BaseColor.WHITE);

         
        // define table header cell
        PdfPCell cell = new PdfPCell();
        cell.setBackgroundColor(BaseColor.BLUE);
        cell.setPadding(3);
         
        // write table header
        cell.setPhrase(new Phrase("Dept", font));
        cell.setHorizontalAlignment(Element.ALIGN_CENTER);
        table.addCell(cell);
         
        cell.setPhrase(new Phrase("Mo", font));
        cell.setHorizontalAlignment(Element.ALIGN_CENTER);
        table.addCell(cell);
 
        cell.setPhrase(new Phrase("Tue", font));
        cell.setHorizontalAlignment(Element.ALIGN_CENTER);
        table.addCell(cell);
         
        cell.setPhrase(new Phrase("Wed", font));
        cell.setHorizontalAlignment(Element.ALIGN_CENTER);
        table.addCell(cell);
         
        cell.setPhrase(new Phrase("Th", font));
        cell.setHorizontalAlignment(Element.ALIGN_CENTER);
        table.addCell(cell);
        
        cell.setPhrase(new Phrase("Fri", font));
        cell.setHorizontalAlignment(Element.ALIGN_CENTER);
        table.addCell(cell);
        
        cell.setPhrase(new Phrase("Sa", font));
        cell.setHorizontalAlignment(Element.ALIGN_CENTER);
        table.addCell(cell);
         
        cell.setPhrase(new Phrase("Su", font));
        cell.setHorizontalAlignment(Element.ALIGN_CENTER);
        table.addCell(cell);
        
        cell.setPhrase(new Phrase("Total", font));
        cell.setHorizontalAlignment(Element.ALIGN_CENTER);
        cell.setColspan(5);
        table.addCell(cell);
        
        table.addCell(timesheet.getDepartment().getName());
        table.addCell(String.valueOf(timesheet.getHoursMon()));
        table.addCell(String.valueOf(timesheet.getHoursTue()));
        table.addCell(String.valueOf(timesheet.getHoursWed()));
        table.addCell(String.valueOf(timesheet.getHoursThu()));
        table.addCell(String.valueOf(timesheet.getHoursFri()));
        table.addCell(String.valueOf(timesheet.getHoursSat()));
        table.addCell(String.valueOf(timesheet.getHoursSun()));
        table.addCell(String.valueOf(timesheet.getTotalHours()));
         
        
        doc.add(tableTitle);
        doc.add(table);
         
    }
}