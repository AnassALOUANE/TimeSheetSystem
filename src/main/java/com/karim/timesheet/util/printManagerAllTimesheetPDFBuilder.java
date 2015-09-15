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
import com.karim.timesheet.model.Timesheet;
import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author karim
 */
public class printManagerAllTimesheetPDFBuilder extends AbstractITextPdfView {
 
    @Override
    protected void buildPdfDocument(Map<String, Object> model, Document doc,
            PdfWriter writer, HttpServletRequest request, HttpServletResponse response)
            throws Exception {
        // get data model which is passed by the Spring container
        List<Timesheet> timesheets = (List<Timesheet>) model.get("timesheets");
                 
//        doc.add(new Paragraph("Recommended books for Spring framework"));
        doc.addAuthor("karim DAHDOUH");
       // _____________________________________ TABLE TITLE __________________________________//
       //_______________________________________________________________________________________//
        
//        PdfPTable tableTitle = new PdfPTable(1);
//        tableTitle.setWidthPercentage(100.0f);
//        tableTitle.setSpacingBefore(3);
////        tableTitle.set;
//         
//        PdfPCell cellTitle=new PdfPCell(new Paragraph("Employee Name: "+timesheet.getEmployee().getName()+"     "
//                + "             Period Ending :"+timesheet.getPeriodEndingDate()));
//        cellTitle.setHorizontalAlignment(Element.ALIGN_CENTER);
//        cellTitle.setColspan(9);
//        cellTitle.setBorder(0);
//        tableTitle.addCell(cellTitle);
        
        // _____________________________________ TABLE CONTENT __________________________________//
        //_______________________________________________________________________________________//
        
        PdfPTable table = new PdfPTable(5);
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
        cell.setPhrase(new Phrase("Periode Ending", font));
        cell.setHorizontalAlignment(Element.ALIGN_CENTER);
        table.addCell(cell);
         
        cell.setPhrase(new Phrase("Id", font));
        cell.setHorizontalAlignment(Element.ALIGN_CENTER);
        table.addCell(cell);
 
        cell.setPhrase(new Phrase("Employee", font));
        cell.setHorizontalAlignment(Element.ALIGN_CENTER);
        table.addCell(cell);
         
         
        cell.setPhrase(new Phrase("TotalHours", font));
        cell.setHorizontalAlignment(Element.ALIGN_CENTER);
        table.addCell(cell);
        
        
        
        cell.setPhrase(new Phrase("Depr", font));
        cell.setHorizontalAlignment(Element.ALIGN_CENTER);
        cell.setColspan(5);
        table.addCell(cell);
        for(Timesheet timesheet : timesheets){
            table.addCell(String.valueOf(timesheet.getPeriodEndingDate()));
            table.addCell(String.valueOf(timesheet.getId_timesheet()));
            table.addCell(String.valueOf(timesheet.getEmployee().getName()));
            table.addCell(String.valueOf(timesheet.getTotalHours()));
            table.addCell(String.valueOf(timesheet.getDepartment().getName()));
        
       } 
        doc.add(table);
         
    }
}