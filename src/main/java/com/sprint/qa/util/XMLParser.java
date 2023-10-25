//package com.sprint.qa.util;
//
//import com.sprint.qa.helper.LoggerHelper;
//import org.apache.log4j.Logger;
//import org.w3c.dom.Document;
//import org.w3c.dom.Node;
//import org.w3c.dom.NodeList;
//import org.xml.sax.SAXException;
//
//import javax.xml.parsers.DocumentBuilder;
//import javax.xml.parsers.DocumentBuilderFactory;
//import javax.xml.parsers.ParserConfigurationException;
//import javax.xml.xpath.XPath;
//import javax.xml.xpath.XPathConstants;
//import javax.xml.xpath.XPathExpressionException;
//import javax.xml.xpath.XPathFactory;
//import java.io.File;
//import java.io.IOException;
//
//public class XMLParser {
//
//    public File xml_file;
//    Logger log = LoggerHelper.getLogger(LoggerHelper.class);
//    public DocumentBuilderFactory dbf;
//    public DocumentBuilder db;
//    public Document doc;
//    public NodeList items_list;
//
//    public XMLParser(String file) throws ParserConfigurationException, IOException, SAXException {
//        xml_file = new File(file);
//        dbf = DocumentBuilderFactory.newInstance();
//        db=dbf.newDocumentBuilder();
//        doc= db.parse(xml_file);
//        doc.getDocumentElement().normalize();
//    }
//
//    public NodeList get_nodelist(String tagname){
//        return doc.getElementsByTagName(tagname);
//    }
//
//    public NodeList get_childnodes(String nodename){
//        return doc.getElementsByTagName(nodename).item(0).getChildNodes();
//    }
//
//    public Node get_parent_node(String tagname){
//        return doc.getDocumentElement().getElementsByTagName(tagname).item(0).getParentNode();
//    }
//
//    public void set_element_text(String parent_node,String tagname,String text){
//        items_list= get_childnodes("purchaseOrderIdentifier");
//        for(int i=0;i<items_list.getLength();i++){
//            if(items_list.item(i).getNodeName().equalsIgnoreCase(tagname)){
//                items_list.item(i).setTextContent(text);
//            }
//        }
//    }
//
//    public void set_element_text(Node nd,String text){
//        nd.setTextContent(text);
//    }
//
//    public Node find_node_xpath_xml(String xpath) throws XPathExpressionException {
//        XPath xph= XPathFactory.newInstance().newXPath();
//        return (Node) xph.compile(xpath).evaluate(doc, XPathConstants.NODE);
//    }
//
//    public NodeList find_nodelist_xpath_xml(String xpath) throws XPathExpressionException {
//        XPath xph= XPathFactory.newInstance().newXPath();
//        return (NodeList) xph.compile(xpath).evaluate(doc, XPathConstants.NODESET);
//    }
//}
