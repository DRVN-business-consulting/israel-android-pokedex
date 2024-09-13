package dev.f04c.pokedex;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import dev.f04c.pokedex.model.Pokemon;
import dev.f04c.pokedex.model.PokemonListAdapter;

public class PokemonList extends AppCompatActivity {

    private RecyclerView recyclerView;
    private PokemonListAdapter adapter;
    private List<Pokemon> pokemonList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pokemon_list);

        // Initialize RecyclerView and Adapter
        recyclerView = findViewById(R.id.recycler_view);
        pokemonList = new ArrayList<>();
        adapter = new PokemonListAdapter(this, pokemonList);

        // Set LayoutManager
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        // Set Adapter
        recyclerView.setAdapter(adapter);

        // Populate data
        populatePokemonList();
    }

    private void populatePokemonList() {
        // Example data
        // Example data with IDs
        pokemonList.add(new Pokemon(1, "Bulbasaur", "Bulbasaur can be seen napping in bright sunlight...", R.drawable.bulbasaur));
        pokemonList.add(new Pokemon(2, "Ivysaur", "There is a bud on this Pokémon’s back...", R.drawable.ivysaur));
        pokemonList.add(new Pokemon(3, "Venusaur", "There is a large flower on this Pokémon’s back...", R.drawable.venusaur));

        // Notify the adapter that the data has changed
        adapter.notifyDataSetChanged();
    }
}
