package fx.leyu.spring.cache;

import java.util.Objects;

public class User {
    private String name;
    private String nation;

    public User(String name, String nation) {
        this.name = name;
        this.nation = nation;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNation() {
        return nation;
    }

    public void setNation(String nation) {
        this.nation = nation;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        User user = (User) o;
        return Objects.equals(name, user.name) &&
                Objects.equals(nation, user.nation);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, nation);
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", nation='" + nation + '\'' +
                '}';
    }
}
