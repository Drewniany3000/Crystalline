package com.drewniany.crystalline.datagen;

import com.drewniany.crystalline.Crystalline;
import com.drewniany.crystalline.blocks.CrystallineBlocks;
import com.drewniany.crystalline.item.CrystallineItems;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.RecipeCategory;
import net.minecraft.data.recipes.RecipeOutput;
import net.minecraft.data.recipes.RecipeProvider;

import java.util.concurrent.CompletableFuture;

public class CrystallineRecipeProvider extends RecipeProvider {
    public CrystallineRecipeProvider(HolderLookup.Provider registries, RecipeOutput output) {
        super(registries, output);
    }


    public static class Runner extends RecipeProvider.Runner {
        public Runner(PackOutput packOutput, CompletableFuture<HolderLookup.Provider> registries) {
            super(packOutput, registries);
        }

        @Override
        protected RecipeProvider createRecipeProvider(HolderLookup.Provider registries, RecipeOutput output) {
            return new CrystallineRecipeProvider(registries, output);
        }

        @Override
        public String getName() {
            return "Crystalline Recipes";
        }
    }

    @Override
    protected void buildRecipes() {

        shaped(RecipeCategory.BUILDING_BLOCKS, CrystallineBlocks.RUBY_BLOCK.get())
                .pattern("AAA")
                .pattern("AAA")
                .pattern("AAA")
                .define('A', CrystallineItems.ROUGH_RUBY.get())
                .unlockedBy(getHasName(CrystallineItems.ROUGH_RUBY.get()), has(CrystallineItems.ROUGH_RUBY.get()))
                .group("Ruby Recipes")
                .save(output);

        shapeless(RecipeCategory.MISC, CrystallineItems.ROUGH_RUBY.get(), 9)
                .requires(CrystallineBlocks.RUBY_BLOCK)
                .unlockedBy(getHasName(CrystallineBlocks.RUBY_BLOCK.get()), has(CrystallineItems.ROUGH_RUBY.get()))
                .group("Ruby Recipes")
                .save(output);


    }
}
