package java.briup.basic;


import org.w3c.dom.Document;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.File;

/**
 * Created by ZH on 2015/11/19.
 */
public class Convert {
    /** DOM解析 */
    public static void main(String args[]){
        long lasting = System.currentTimeMillis();
        System.out.println("-------------------------Dom解析--------------------------");
        try {
            File f = new File("E:/a.xml");
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document doc = builder.parse(f);
            NodeList nl = doc.getElementsByTagName("VALUE");
            for(int i=0;i<nl.getLength();i++){
                System.out.println("车牌号码:"+doc.getElementsByTagName("NO").item(i).getFirstChild().getNodeValue());
                System.out.println("车主地址:"+doc.getElementsByTagName("ADDR").item(i).getFirstChild().getNodeValue());
            }
        }catch(Exception e){
            e.printStackTrace();
        }


        System.out.println("-------------------------SAX解析--------------------------");

    }
}
