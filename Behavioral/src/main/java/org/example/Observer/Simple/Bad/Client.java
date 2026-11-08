package org.example.Observer.Simple.Bad;

import java.util.ArrayList;
import java.util.List;

public class Client {
    public static void main (String [] args){
        DataSource data = new DataSource();
        Sheet2 sheet2 = new Sheet2();
        BarChart barChart1 = new BarChart();
        data.AddDependent(sheet2);
        data.AddDependent(barChart1);

        List<Integer> values = new ArrayList<>(){{
            add(5);
            add(1);
            add(3);
            add(4);
        }};
        // callingn set values, changing state of the data source will trigger both sheet
        data.setValues(new ArrayList<>(){{
            add(5);
        }});
    }
}

class Sheet2{
    private int total;
    public int getTotal(){
        return total;
    }
    public int calculateTotal(List<Integer> values){

        var sum = 0;
        for(var value : values){
            sum += value;
        }
        System.out.println("Calculate Total: " +sum);
        return sum;
    }
}

class BarChart{
    public void Render(List<Integer> values){
        System.out.println("Rendering Bar Chart with new values");
    }
}
class DataSource{
    private List<Integer> values = new ArrayList<Integer>();   // has internal states
    private List<Object> dependents = new ArrayList<Object>(); // observers
    public void setValues(List<Integer> values){
        values = values;
        for (var dependent : dependents){
            if (dependent instanceof Sheet2){
                ((Sheet2) dependent).calculateTotal(values);
            }
            if (dependent instanceof BarChart){
                ((BarChart) dependent).Render(values);
            }
        }
    }
    public void AddDependent(Object dependent){
        dependents.add(dependent);
    }
    public void RemoveDependent(Object dependent){
        dependents.remove(dependent);
    }
}