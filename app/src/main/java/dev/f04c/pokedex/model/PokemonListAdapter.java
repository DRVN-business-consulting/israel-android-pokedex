package dev.f04c.pokedex.model;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import dev.f04c.pokedex.PokemonDetailActivity;
import dev.f04c.pokedex.R;

public class PokemonListAdapter extends RecyclerView.Adapter<PokemonListAdapter.PokemonViewHolder> {

    private List<Pokemon> pokemonList;
    private Context context;

    public PokemonListAdapter(Context context, List<Pokemon> pokemonList) {
        this.context = context;
        this.pokemonList = pokemonList;
    }

    @NonNull
    @Override
    public PokemonViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.pokemon_item, parent, false);
        return new PokemonViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull PokemonViewHolder holder, int position) {
        Pokemon pokemon = pokemonList.get(position);
        holder.pokemonName.setText(pokemon.getName());
        holder.pokemonDescription.setText(pokemon.getDescription());
        holder.pokemonImage.setImageResource(pokemon.getImageResource());

        holder.itemView.setOnClickListener(v -> {
            Intent intent = new Intent(v.getContext(), PokemonDetailActivity.class);
            intent.putExtra("POKEMON_ID", pokemon.getId());
            v.getContext().startActivity(intent);
        });
    }

    @Override
    public int getItemCount() {
        return pokemonList.size();
    }

    static class PokemonViewHolder extends RecyclerView.ViewHolder {

        TextView pokemonName;
        TextView pokemonDescription;
        ImageView pokemonImage;

        PokemonViewHolder(@NonNull View itemView) {
            super(itemView);
            pokemonName = itemView.findViewById(R.id.pokemon_name);
            pokemonDescription = itemView.findViewById(R.id.pokemon_description);
            pokemonImage = itemView.findViewById(R.id.pokemon_image);
        }
    }
}
