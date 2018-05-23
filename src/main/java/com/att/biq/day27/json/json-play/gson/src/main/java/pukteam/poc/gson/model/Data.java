package pukteam.poc.gson.model;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Data {

    private int x;
    private double y;
    private String z;
    private List<String> l;
    private Nested nested;
    private Gender gender;
    private Set<Nested> setOfNested;

    public Data(int x, double y, String z, List<String> l, Gender gender) {
        this.x = x;
        this.y = y;
        this.z = z;
        this.l = l;
        this.gender = gender;
        nested = new Nested(3, "nested");
        setOfNested = Stream.iterate(0, t -> t + 1).limit(l.size()).map(i -> new Nested(i, "nested" + i)).collect(Collectors.toSet());
    }

    @Override
    public String toString() {
        return "Data{" +
                "x=" + x +
                ", y=" + y +
                ", z='" + z + '\'' +
                ", l=" + l +
                ", nested=" + nested +
                ", gender=" + gender +
                ", setOfNested=" + setOfNested +
                '}';
    }
}
