package lang.myInterface;

import javax.print.attribute.standard.Destination;

/**
 * 局部内部类
 * @author kevin
 * @date 2018/01/04
 * @Modified By:
 */
public class Parcel4 {

    public Comparable destination(String s) {
        class PDestination implements Comparable {
            private String label;

            private PDestination(String whereTo) {
                label = whereTo;
            }

            public String readLabel() {
                return label;
            }

            @Override
            public int compareTo(Object o) {
                return 0;
            }
        }
        return new PDestination(s);
    }

    public static void main(String[] args) {
        Parcel4 p = new Parcel4();
        Comparable d = p.destination("Tasmania");
    }
} 