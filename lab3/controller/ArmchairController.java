package controller;

import model.Armchair;

public class ArmchairController
{
    static public Armchair createNewArmchair(String title, String description, String type)
    {
        return new Armchair(title, description, type);
    }
}
