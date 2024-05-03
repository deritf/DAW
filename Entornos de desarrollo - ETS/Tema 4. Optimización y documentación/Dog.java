/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dog;

/**
 *
 * @author Alejandro
 */
public class Dog 
{
    // Instance Variables
    String name, breed, color;
    int age;
 
    // Constructor Declaration of Class
    public Dog(String name,String breed,int 
            age, String color)
    {
        this.name = name;
        this.breed = breed;
        this.age = age;
        this.color = color;
    }
 
    // method 1
    public String GetName()
    {
        return name;
    }
 
    // method 2
    public String GetBreed()
    {
        return breed;
    }
 
    // method 3
    public int GetAge()
    {
        return age;
    }
 
    // method 4
    public String GetColor()
    {
        return color;
    }
 
    @Override
    public String toString()
    {
        return("Hi my name is "+this.GetName()+
               ".\nMy breed,age and color are "+
               this.GetBreed()+","+this.GetAge()+
               ","+ this.GetColor());
    }
 
    public static void main(String[] args)
    {
        Dog tuffy = new Dog("tuffy","papillon", 5, "white");
        System.out.println(tuffy.toString());
    }
}