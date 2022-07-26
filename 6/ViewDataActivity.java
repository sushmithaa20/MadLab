package com.example.parsing;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import org.json.JSONObject;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.w3c.dom.Text;

import java.io.InputStream;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

public class ViewDataActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_data);

        Bundle bundle = getIntent().getExtras();
        String dataType = bundle.getString("datatype");
        TextView xmlContent = findViewById(R.id.xmlContent);
        TextView jsonContent = findViewById(R.id.jsonContent);

        if(dataType.equals("xml")){
            jsonContent.setText("");
            try{
                InputStream is = getAssets().open("weather.xml");

                DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
                DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
                Document doc = dBuilder.parse(is);

                Element element = (Element) doc.getDocumentElement();
                element.normalize();

                NodeList nList = doc.getElementsByTagName("weather");
                for(int i=0;i<nList.getLength();i++){
                    Node node = nList.item(i);
                    if(node.getNodeType() == Node.ELEMENT_NODE) {
                        Element element2 = (Element) node;
                        xmlContent.setText(xmlContent.getText()+"\nCity Name: "+getValue("cityname",element2)+"\n");
                        xmlContent.setText(xmlContent.getText()+"Latitude: "+getValue("latitude",element2)+"\n");
                        xmlContent.setText(xmlContent.getText()+"Longitude: "+getValue("longitude",element2)+"\n");
                        xmlContent.setText(xmlContent.getText()+"Temperature: "+getValue("temperature",element2)+"\n");
                        xmlContent.setText(xmlContent.getText()+"Humidity: "+getValue("humidity",element2)+"\n");

                    }
                }
            }catch (Exception e){
                e.printStackTrace();
            }
        }
        else if(dataType.equals("json")){
            xmlContent.setText("");
            try{
                InputStream is = getAssets().open("weather.json");
                byte[] data = new byte[is.available()];
                is.read(data);
                String jsonString = new String(data);
                JSONObject jsonObject = new JSONObject(jsonString);
                JSONObject weather = jsonObject.getJSONObject("weather");
                jsonContent.setText(jsonContent.getText()+"City Name: "+weather.getString("cityname")+"\n");
                jsonContent.append("Latitude: "+weather.getString("latitude")+"\n");
                jsonContent.append("Longitude: "+weather.getString("longitude")+"\n");
                jsonContent.append("Temperature: "+weather.getString("temperature")+"\n");
                jsonContent.setText(jsonContent.getText()+"Humidity: "+weather.getString("humidity")+"\n");

            }catch(Exception e){
                e.printStackTrace();
            }
        }


    }

    private String getValue(String tag, Element element2) {
        NodeList nodeList = element2.getElementsByTagName(tag).item(0).getChildNodes();
        Node node = nodeList.item(0);
        return node.getNodeValue();
    }
}
