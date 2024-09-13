package dev.f04c.pokedex.model;

public class Pokemon {
    private int id;
    private String name;
    private String description;
    private int imageResource;

    // Constructor
    public Pokemon(int id, String name, String description, int imageResource) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.imageResource = imageResource;
    }

    // Getter for the Pokémon name
    public String getName() {
        return name;
    }

    // Getter for the Pokémon description
    public String getDescription() {
        return description;
    }

    // Getter for the Pokémon image resource
    public int getImageResource() {
        return imageResource;
    }

    public int getId() {
        return id;
    }

}
