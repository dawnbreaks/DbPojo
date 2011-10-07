package com.blogspot.ostas.dbpojo.utils;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.File;
import java.util.HashMap;
import java.util.Map;

public class SqlToJavaTypesMap implements SqlTypesConversionHelper {
    private String conversionFileDef;
    private Map<String, GeneratedTypeDescriptor> typesMap;

    public String getConversionFileDef() {
        return conversionFileDef;
    }

    public void setConversionFileDef(String conversionFileDef) {
        this.conversionFileDef = conversionFileDef;
        readXml();
    }
    public SqlToJavaTypesMap()
    {
        typesMap = new HashMap<String, GeneratedTypeDescriptor>();
    }
    private void readXml()
    {
 try {
    final File fXmlFile = new File(conversionFileDef);
    DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
    DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
    Document doc = dBuilder.parse(fXmlFile);
    doc.getDocumentElement().normalize();


    NodeList nList = doc.getElementsByTagName("type");
    System.out.println("Root element :" + doc.getDocumentElement().getNodeName()+" node list length: "+nList.getLength());

     GeneratedTypeDescriptor typeDescriptor;
     for (int temp = 0; temp < nList.getLength(); temp++) {
       Node nNode = nList.item(temp);
       if (nNode.getNodeType() == Node.ELEMENT_NODE) {
          Element eElement = (Element) nNode;
           typeDescriptor = new GeneratedTypeDescriptor();
           typeDescriptor.setTypeName(eElement.getAttribute("to"));
           typeDescriptor.setImportString(eElement.getAttribute("import"));
           typesMap.put(eElement.getAttribute("db"),typeDescriptor);
        }
    }

  } catch (Exception e) {
    e.printStackTrace();
  }
}

    @Override
    public String sqlTypeToJavaType(String sqlType) {
        if(typesMap.containsKey(sqlType)){
            return typesMap.get(sqlType).getTypeName();
        }
        else{
            //return "do_not_supported_"+sqlType;
            return "String";
        }
    }

    @Override
    public String importStringForSqlType(String sqlType) {
        if(typesMap.containsKey(sqlType)){
            return typesMap.get(sqlType).getImportString();
        }
        else{
            return null;
        }
    }
}
