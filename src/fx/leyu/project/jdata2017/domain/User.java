package fx.leyu.project.jdata2017.domain;

import java.sql.Date;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class User {
    private static final String UNKOWN_AGE = "-1";     // -1
    private static final String YOUNG_AGE = "16-25岁"; // 0
    private static final String MID_1_AGE = "26-35岁"; // 1
    private static final String MID_2_AGE = "36-45岁"; // 2
    private static final String MID_3_AGE = "46-55岁"; // 3
    private static final String OLD_AGE = "56岁以上";  // 4
    private static Map<String, Integer> map = new HashMap<>();
    
    static {
       map.put(UNKOWN_AGE, 0);
       map.put(YOUNG_AGE, 0);
       map.put(MID_1_AGE, 1);
       map.put(MID_2_AGE, 2);
       map.put(MID_3_AGE, 3);
       map.put(OLD_AGE, 4);
    }
    
    private int id;
    private int age;
    private int sex;
    private int userLevel;
    private Date registrationDate;

    public User(Integer id, Integer age, Integer sex, Integer userLevel,
            Date registrationDate) {
        super();
        this.id = id;
        this.age = age;
        this.sex = sex;
        this.userLevel = userLevel;
        this.registrationDate = registrationDate;
    }

    public User(String[] args) {
        if (args == null || args.length != 5) {
            throw new IllegalArgumentException("value is " + Arrays.toString(args));
        }
        id = Integer.parseInt(args[0]);
        age = chengeTheAge(args[1].trim());
        sex = Integer.parseInt(args[2]);
        userLevel = Integer.parseInt(args[3]);
        registrationDate = Date.valueOf(args[4].replaceAll("/", "-"));
    }
    
    private int chengeTheAge(String string) {
        if (map.containsKey(string)) {
            return map.get(string);
        }
        return -1;
    }

    public int getId() {
        return id;
    }
    public int getAge() {
        return age;
    }
    public int getSex() {
        return sex;
    }
    public int getUserLevel() {
        return userLevel;
    }
    public Date getRegistrationDate() {
        return registrationDate;
    }
    public void setId(int id) {
        this.id = id;
    }
    public void setAge(int age) {
        this.age = age;
    }
    public void setSex(int sex) {
        this.sex = sex;
    }
    public void setUserLevel(int userLevel) {
        this.userLevel = userLevel;
    }
    public void setRegistrationDate(Date registrationDate) {
        this.registrationDate = registrationDate;
    }
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + age;
        result = prime * result + id;
        result = prime * result + ((registrationDate == null)
                ? 0
                : registrationDate.hashCode());
        result = prime * result + sex;
        result = prime * result + userLevel;
        return result;
    }
   
    @Override
    public String toString() {
        return "User [id=" + id + ", age=" + age + ", sex=" + sex
                + ", userLevel=" + userLevel + ", registrationDate="
                + registrationDate + "]";
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        User other = (User) obj;
        if (age != other.age)
            return false;
        if (id != other.id)
            return false;
        if (registrationDate == null) {
            if (other.registrationDate != null)
                return false;
        } else if (!registrationDate.equals(other.registrationDate))
            return false;
        if (sex != other.sex)
            return false;
        if (userLevel != other.userLevel)
            return false;
        return true;
    }
}
