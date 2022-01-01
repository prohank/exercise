package test;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.Serializable;

public class SerializationTest {
    public static void main(String[] args) {
        try {
            SerializeA a = new SerializeA();
//            a.setField1("1");
//            a.setField2("2");
//            a.setField3("3");
//            FileOutputStream fos = new FileOutputStream("serTest");
//            ObjectOutputStream oos = new ObjectOutputStream(fos);
//            oos.writeObject(a);

            FileInputStream fis = new FileInputStream("serTest");
            ObjectInputStream ois = new ObjectInputStream(fis);
            SerializeA b = (SerializeA) ois.readObject();
            System.out.println("B: " + b);
        } catch (IOException  e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

    }


}

class SerializeA implements Serializable {


    private static final long serialVersionUID = -8785823515515510022L; //Serialized with 3 objects


//    private static final long serialVersionUID = -3576103601682749379L; //Serialized with 2 fields

    private String field1;
    private String field2;
    private String field3;


    public String getField3() {
        return field3;
    }

    public void setField3(String field3) {
        this.field3 = field3;
    }


    public String getField1() {
        return field1;
    }

    public void setField1(String field1) {
        this.field1 = field1;
    }

    public String getField2() {
        return field2;
    }

    public void setField2(String field2) {
        this.field2 = field2;
    }

    @Override
    public String toString() {
        return "test.SerializeA{" +
                "field1='" + field1 + '\'' +
                ", field2='" + field2 + '\'' +
                ", field3='" + field3 + '\'' +
                '}';
    }
}
