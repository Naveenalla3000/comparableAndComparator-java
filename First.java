package comparableAndComparator;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;



class Emp1 implements Comparable<Emp1> {
    int id;
    String name;
    double salary;

    public Emp1(int id, String name, double salary) {
        this.id = id;
        this.name = name;
        this.salary = salary;
    }

    @Override
    public String toString() {
        return "emp [id=" + id + ", name=" + name + ", salary=" + salary + "]";
    }

    @Override
    public int compareTo(Emp1 s){
        if(s.id > id)return -1;
        else if(s.id < id)return 1;
        else return 0;
        
        // ascending order
        //return Integer.compare(s.id, id);
        // descending order
        //return Integer.compare(id, s.id);
    }

}

class Emp2   {
    int id;
    String name;
    double salary;

    public Emp2(int id, String name, double salary) {
        this.id = id;
        this.name = name;
        this.salary = salary;
    }

    @Override
    public String toString() {
        return "emp [id=" + id + ", name=" + name + ", salary=" + salary + "]";
    }

}

class IdBasedSorting implements Comparator<Emp2>{
    @Override
    public int compare(Emp2 s1, Emp2 s2) {
        if(s1.id > s2.id)return 1;
        else if(s1.id < s2.id)return -1;
        else return 0;
    }
}
class SalaryBasedSorting implements Comparator<Emp2>{
    @Override
    public int compare(Emp2 s1, Emp2 s2) {
       return Double.compare(s1.salary, s2.salary);
    }
}

public class First {
    public static void main(String[] args) {
        List<Emp1> empList1 = new ArrayList<>();
        empList1.add(new Emp1(1, "A", 1000));
        empList1.add(new Emp1(2, "D", 4000));
        empList1.add(new Emp1(4, "B", 2000));
        empList1.add(new Emp1(3, "C", 3000));
        Collections.sort(empList1);
        for (Emp1 e : empList1) {
            System.out.println(e);
        }
        System.out.println("=============###=====================");
        List<Emp2> empList2 = new ArrayList<>();
        empList2.add(new Emp2(1, "A", 1000));
        empList2.add(new Emp2(2, "D", 4000));
        empList2.add(new Emp2(4, "B", 2000));
        empList2.add(new Emp2(3, "C", 3000));
        Collections.sort(empList2, new IdBasedSorting());
        for (Emp2 e : empList2) {
            System.out.println(e);
        }
        System.out.println("=====================================");
        Collections.sort(empList2, new SalaryBasedSorting());
        for (Emp2 e : empList2) {
            System.out.println(e);
        }
    }
}
