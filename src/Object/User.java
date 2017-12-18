package Object;

/**
 * equals方法覆写
 *
 * @author kevin
 * @create 2017-12-19 0:25
 **/
public class User {

    private String uid;
    private String name;
    private int age;

    public User(String uid, String name, int age) {
        this.uid = uid;
        this.name = name;
        this.age = age;
    }

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public boolean equals(Object o) {
        if(o == null || !(o instanceof User)) return false;
        if(((User) o).getUid() == this.getUid()) return true;
        return false;
    }

    @Override
    public int hashCode() {
        int result = uid != null ? uid.hashCode() : 0;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + age;// result << 5 - result = 31 * result
        return result;
    }
}
