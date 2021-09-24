package com.frankmoley.lil.designpatternsapp.adapter;

public class MoroOrange implements Orange {
    @Override
    public String getVariety() {
        return "Moro Blood Orange";
    }

    @Override
    public void eat() {
        System.out.println("Moro Orange enjoyed");
    }

    @Override
    public void peel() {
        System.out.println("Moro Orange peeled");
    }

    @Override
    public void juice() {
        System.out.println("Moro Orange juiced");
    }
}
