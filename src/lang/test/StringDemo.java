package lang.test;

/**
 * String类方法自实现
 *
 * @author kevin
 * @date 2017/12/20
 * @Modified By:
 **/
public class StringDemo {

    private String value;

    public StringDemo(){

    }

    public StringDemo(String value){
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    /**
     * 获取索引处的字符
     * @param value
     * @param index
     * @return
     */
    public char myCharAt(int index){
        if(index < 0 || index > value.length() - 1){
            throw new ArrayIndexOutOfBoundsException();
        }
        return toCharArray()[index];
    }



    /**
     * 将String转换为char[]
     * @param value
     * @return
     */
    public char[] toCharArray(){
        if(value.length() < 0){
            throw new ArrayIndexOutOfBoundsException(value.length() + 1);
        }
        char[] val = new char[value.length()];
        for (int i = 0; i < value.length(); i++) {
            val[i] = value.charAt(i);
        }
        return val;
    }

    @Override
    public String toString() {
        return "StringDemo{" + "value='" + value + '\'' + '}';
    }
}
