package test.rivky.veig;

import java.util.Objects;

public class School {
    private String id;
    private String name;

    public School(String id, String name) {
        this.id = id;
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "School{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                '}'
                ;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
//        if (o == null || getClass() != o.getClass()) return false;
        School school = (School) o;
        return Objects.equals(id, school.id) && Objects.equals(name, school.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id,name);
    }
}
