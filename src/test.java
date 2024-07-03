/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author huzai
 */
import java.util.Observable;
import java.util.Observer;

// Model (Observable)
class Model extends Observable {
    private int data1;
    private String data2;

    public int getData1() {
        return data1;
    }

    public void setData1(int newData1) {
        this.data1 = newData1;
        setChanged(); // Mark the model as changed
        notifyObservers(); // Notify observers without passing data
    }

    public String getData2() {
        return data2;
    }

    public void setData2(String newData2) {
        this.data2 = newData2;
        setChanged(); // Mark the model as changed
        notifyObservers(); // Notify observers without passing data
    }
}

// View (Observer)
class View implements Observer {
    @Override
    public void update(Observable o, Object arg) {
        if (o instanceof Model) {
            Model model = (Model) o;
            int newData1 = model.getData1();
            String newData2 = model.getData2();
            System.out.println("View received updated data: " + newData1 + ", " + newData2);
        }
    }
}

// Main class
public class test {
    public static void main(String[] args) {
        Model model = new Model();
        View view = new View();

        // Register the view as an observer of the model
        model.addObserver(view);

        // Simulate a change in the model's data
        model.setData1(10);
        model.setData2("Hello");
    }
}
