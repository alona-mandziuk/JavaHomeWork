package com.pb.mandziuk.hw6;

import java.lang.reflect.Constructor;
import java.util.Arrays;

public class VetClinic {
    public static void main(String[] args) throws Exception {

        Animal animal[] = new Animal[3];
        animal[0] = new Cat();
        animal[1] = new Dog();
        animal[2] = new Horse();

        Veterinarian vet = new Veterinarian();
        Class clazz = vet.getClass();
        //  System.out.println(clazz.getName());
        // System.out.println(Arrays.toString(clazz.getMethods()));

        Class vetClazz = Class.forName("com.pb.mandziuk.hw6.Veterinarian");
        Constructor constr = vetClazz.getConstructor(new Class[]{});
        Object obj = constr.newInstance();
        if (obj instanceof Veterinarian) {
            ((Veterinarian) obj).treatAnimal(animal[0]);
            // for (Animal c: animal) {(vet.treatAnimal(c));}

            //  vet.treatAnimal(animal[0]);

        }
        System.out.println("---------------");
        animal[1].sleep();


    }
}