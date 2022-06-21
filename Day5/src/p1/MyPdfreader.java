package p1;

import java.io.File;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.text.PDFTextStripper;

public class MyPdfreader {

	public static void main(String[] args) {
		
		try {
			
			String rootPath = "C:\\Users\\dani_\\Downloads\\Mid Term 17-Jun-22-20220617\\CoreJavaTest-main\\CaseStudy_CoreJava\\";
			String fileName = "Order.csv";
			
			File f = new File(rootPath+fileName);
			PDDocument myPdf = PDDocument.load(f);
			
			PDFTextStripper pdfReader = new PDFTextStripper();
			String wholePdfDoc = pdfReader.getText(myPdf);
			System.out.println(wholePdfDoc);
			
			myPdf.close();
		
		} catch (Exception e) {
			System.out.println(e);
		}

	}

}
