package dev.f04c.pokedex;

import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import dev.f04c.pokedex.model.Pokemon;

public class PokemonDetailActivity extends AppCompatActivity {

    private static final Pokemon[] pokemonList = {
            new Pokemon(1, "Bulbasaur", "Bulbasaur can be seen napping in bright sunlight...", R.drawable.bulbasaur),
            new Pokemon(2, "Ivysaur", "There is a bud on this Pokémon’s back...", R.drawable.ivysaur),
            new Pokemon(3, "Venusaur", "There is a large flower on this Pokémon’s back...", R.drawable.venusaur)
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pokemon_detail);

        // Retrieve data from the intent
        int id = getIntent().getIntExtra("POKEMON_ID", -1);

        // Find views
        TextView nameTextView = findViewById(R.id.pokemon_name_detail);
        TextView descriptionTextView = findViewById(R.id.pokemon_description_detail);
        ImageView imageView = findViewById(R.id.pokemon_image_detail);
        Button backButton = findViewById(R.id.back_button); // Add a button to go back

        // Fetch the Pokémon details based on ID
        Pokemon pokemon = getPokemonById(id);

        if (pokemon != null) {
            // Set the data
            nameTextView.setText(pokemon.getName());
            descriptionTextView.setText(pokemon.getDescription());
            imageView.setImageResource(pokemon.getImageResource());
        } else {
            // Handle the case where the Pokémon is not found
            nameTextView.setText("Unknown");
            descriptionTextView.setText("Details not available.");
        }

        // Set up the back button to finish the activity and return to the previous one
        backButton.setOnClickListener(v -> finish());
    }

    // Method to fetch Pokémon details by ID
    private Pokemon getPokemonById(int id) {
        for (Pokemon pokemon : pokemonList) {
            if (pokemon.getId() == id) {
                return pokemon;
            }
        }
        return null;
    }
}
