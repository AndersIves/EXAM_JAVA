package com.JavaTest1.Exam2;

import org.dom4j.Attribute;
import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import java.io.File;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.stream.Stream;

public class XMLdispart {
    private LinkedHashMap<String,String> map = new LinkedHashMap();
    private XMLdispart(){
        SAXReader reader = new SAXReader();
        try {
            Document document = reader.read(new File("configuration.XML"));
            Element bookStore = document.getRootElement();
            // 通过element对象的elementIterator方法获取迭代器
            Iterator it = bookStore.elementIterator();
            // 遍历迭代器，获取根节点中的信息（书籍）
            while (it.hasNext()) {
                Element element = (Element)it.next();
                map.put(element.getName(),element.getStringValue());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    private static XMLdispart xmLdispart = new XMLdispart();
    public static LinkedHashMap<String,String> getInf(){
        return xmLdispart.map;
    }
}
