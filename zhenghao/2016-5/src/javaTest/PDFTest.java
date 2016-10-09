package javaTest;

import com.lowagie.text.*;
import com.lowagie.text.pdf.*;

import java.io.FileOutputStream;

public class PDFTest {
    public static final String  FONT_USE = "STSongStd-Light";
    public static final String UNICODE_BIAN = "UniGB-UCS2-H";

    public static void main(String args[]){
        Document doc = new Document(PageSize.A4);
        try{
            PdfWriter.getInstance(doc,new FileOutputStream("E:/a.pdf"));
            doc.open();
            //标题字体
            BaseFont title = BaseFont.createFont(FONT_USE,UNICODE_BIAN,BaseFont.NOT_EMBEDDED);
            Font titleFont = new Font(title,18,Font.NORMAL);
            //内容字体
            BaseFont content = BaseFont.createFont(FONT_USE,UNICODE_BIAN,BaseFont.NOT_EMBEDDED);
            Font contentFont = new Font(content,9,Font.NORMAL);

            Paragraph titleP = new Paragraph("儿童信息",titleFont);
            titleP.setAlignment(titleP.ALIGN_CENTER);
            doc.add(titleP);

            PdfPTable table = new PdfPTable(4);
            table.setWidthPercentage(100);
            table.addCell(new Paragraph("Children-id",contentFont));
            PdfPCell cell = new PdfPCell(new Paragraph("1002101",contentFont));
            cell.setColspan(3);
            table.addCell(cell);

            //添加第一行
            table.addCell(new Paragraph("Name(CN)",contentFont));
            table.addCell(new Paragraph("郑豪",contentFont));
            table.addCell(new Paragraph("Name(EN)",contentFont));
            table.addCell(new Paragraph("Zheng Hao",contentFont));

            //添加第二行
            table.addCell(new Paragraph("Gender(CN)",contentFont));
            table.addCell(new Paragraph("男",contentFont));
            table.addCell(new Paragraph("Gender(EN)",contentFont));
            table.addCell(new Paragraph("male",contentFont));

            table.addCell(new Paragraph("Note",contentFont));
            cell = new PdfPCell(new Paragraph("儿童资料",contentFont));
            cell.setColspan(3);
            table.addCell(cell);

            doc.add(table);
            doc.newPage();

            doc.close();
        }catch(Exception e){
            e.printStackTrace();
        }

    }
}
