package array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Demo1 {

    public static void main(String[] args) {
        // Create a map with an object of MyClass
        Map<String, Object> map = new HashMap<>();
        MyClass dummy = new MyClass();
        List<Att> attList = new ArrayList<Att>();
        Att att = new Att();
        att.setKey("key");
        att.setValue("val");
        attList.add(att);
        dummy.setElements(attList);
        
        map.put("key1", dummy);
        map.put("key2", attList);

        // Retrieve an object from the map
        Object obj = map.get("key1");

        // Check if the object is an instance of MyClass
        if (obj instanceof MyClass) {
        	
            MyClass myClassObject = (MyClass) obj;
            List<Att> elements = myClassObject.getElements();
            
            System.out.println("Elements: " + elements);
        } else {
            System.out.println("Object is not an instance of MyClass.");
        }
        
        List<Att> attList1 = new ArrayList<Att>();
        Object obj1 = map.get("key2");
		 if (obj1 instanceof Att) {
		        	
            Att myClassObject = (Att) obj1;
            
            System.out.println("Elements: " + myClassObject);
        } else {
            System.out.println("Object is not an instance of MyClass.");
        }
    }
}


class MyClass {
    private List<Att> elements;

	public List<Att> getElements() {
		return elements;
	}

	public void setElements(List<Att> elements) {
		this.elements = elements;
	}
}

class Att {
	
    private String key;
    private String value;
    
	public String getKey() {
		return key;
	}
	public void setKey(String key) {
		this.key = key;
	}
	public String getValue() {
		return value;
	}
	public void setValue(String value) {
		this.value = value;
	}

   
}
