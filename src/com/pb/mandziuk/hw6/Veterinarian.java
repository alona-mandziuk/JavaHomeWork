package com.pb.mandziuk.hw6;

public class Veterinarian extends Animal {
    Cat c = new Cat();
    Dog d = new Dog();
    Horse h = new Horse();
    String vname = " GoodDoc ";

    public Veterinarian(String name, String food, String location) {
        super(name, food, location);
    }

    public Veterinarian() {
        super(" Cat Pushok ", " milk ", " mother laps");
    }


    //  String vetname = "GoodDoc";

   // public String getVetname() {
     //   return vetname;
    //}

  //  public void setVetname(String vetname) {
    //    this.vetname = vetname;
   // }


    public void treatAnimal (Animal animal){
        System.out.println(vname + "treats animals: ");
        System.out.println(c.getName() + " which came from " + c.getLocation() + ", and likes " + c.getFood()
                + ".");
        System.out.println(d.getName() + " which came from " + d.getLocation() + ", and likes " + d.getFood() + ".");
        System.out.println(h.getName() + " which came from " + h.getLocation() + ", and likes " + h.getFood() + ".");

    }
}
