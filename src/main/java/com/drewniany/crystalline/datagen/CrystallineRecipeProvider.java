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


        shaped(RecipeCategory.BUILDING_BLOCKS, CrystallineBlocks.RUBY_BLOCK_X2.get())
                .pattern("AAA")
                .pattern("AAA")
                .pattern("AAA")
                .define('A', CrystallineItems.FLAWED_RUBY.get())
                .unlockedBy(getHasName(CrystallineItems.FLAWED_RUBY.get()), has(CrystallineItems.FLAWED_RUBY.get()))
                .group("Ruby Recipes")
                .save(output);

        shapeless(RecipeCategory.MISC, CrystallineItems.FLAWED_RUBY.get(), 9)
                .requires(CrystallineBlocks.RUBY_BLOCK_X2)
                .unlockedBy(getHasName(CrystallineBlocks.RUBY_BLOCK_X2.get()), has(CrystallineItems.FLAWED_RUBY.get()))
                .group("Ruby Recipes")
                .save(output);

        shaped(RecipeCategory.BUILDING_BLOCKS, CrystallineBlocks.RUBY_BLOCK_X2.get())
                .pattern("AAA")
                .pattern("AAA")
                .pattern("AAA")
                .define('A', CrystallineBlocks.RUBY_BLOCK.get())
                .unlockedBy(getHasName(CrystallineBlocks.RUBY_BLOCK.get()), has(CrystallineBlocks.RUBY_BLOCK.get()))
                .group("Ruby Recipes")
                .save(output, "crystalline:x_to_x2");


        shaped(RecipeCategory.BUILDING_BLOCKS, CrystallineBlocks.RUBY_BLOCK_X3.get())
                .pattern("AAA")
                .pattern("AAA")
                .pattern("AAA")
                .define('A', CrystallineItems.FINE_RUBY.get())
                .unlockedBy(getHasName(CrystallineItems.FINE_RUBY.get()), has(CrystallineItems.FINE_RUBY.get()))
                .group("Ruby Recipes")
                .save(output);

        shapeless(RecipeCategory.MISC, CrystallineItems.FINE_RUBY.get(), 9)
                .requires(CrystallineBlocks.RUBY_BLOCK_X3)
                .unlockedBy(getHasName(CrystallineBlocks.RUBY_BLOCK_X3.get()), has(CrystallineItems.FINE_RUBY.get()))
                .group("Ruby Recipes")
                .save(output);

        shaped(RecipeCategory.BUILDING_BLOCKS, CrystallineBlocks.RUBY_BLOCK_X3.get())
                .pattern("AAA")
                .pattern("AAA")
                .pattern("AAA")
                .define('A', CrystallineBlocks.RUBY_BLOCK_X2.get())
                .unlockedBy(getHasName(CrystallineBlocks.RUBY_BLOCK_X2.get()), has(CrystallineBlocks.RUBY_BLOCK_X2.get()))
                .group("Ruby Recipes")
                .save(output, "crystalline:x2_to_x3");


        shaped(RecipeCategory.BUILDING_BLOCKS, CrystallineBlocks.RUBY_BLOCK_X4.get())
                .pattern("AAA")
                .pattern("AAA")
                .pattern("AAA")
                .define('A', CrystallineItems.RUBY.get())
                .unlockedBy(getHasName(CrystallineItems.RUBY.get()), has(CrystallineItems.RUBY.get()))
                .group("Ruby Recipes")
                .save(output);

        shapeless(RecipeCategory.MISC, CrystallineItems.RUBY.get(), 9)
                .requires(CrystallineBlocks.RUBY_BLOCK_X4)
                .unlockedBy(getHasName(CrystallineBlocks.RUBY_BLOCK_X4.get()), has(CrystallineItems.RUBY.get()))
                .group("Ruby Recipes")
                .save(output);

        shaped(RecipeCategory.BUILDING_BLOCKS, CrystallineBlocks.RUBY_BLOCK_X4.get())
                .pattern("AAA")
                .pattern("AAA")
                .pattern("AAA")
                .define('A', CrystallineBlocks.RUBY_BLOCK_X3.get())
                .unlockedBy(getHasName(CrystallineBlocks.RUBY_BLOCK_X3.get()), has(CrystallineBlocks.RUBY_BLOCK_X3.get()))
                .group("Ruby Recipes")
                .save(output, "crystalline:x3_to_x4");

        shaped(RecipeCategory.BUILDING_BLOCKS, CrystallineBlocks.RUBY_BLOCK_X5.get())
                .pattern("AAA")
                .pattern("AAA")
                .pattern("AAA")
                .define('A', CrystallineItems.FLAWLESS_RUBY.get())
                .unlockedBy(getHasName(CrystallineItems.FLAWLESS_RUBY.get()), has(CrystallineItems.FLAWLESS_RUBY.get()))
                .group("Ruby Recipes")
                .save(output);

        shapeless(RecipeCategory.MISC, CrystallineItems.FLAWLESS_RUBY.get(), 9)
                .requires(CrystallineBlocks.RUBY_BLOCK_X5)
                .unlockedBy(getHasName(CrystallineBlocks.RUBY_BLOCK_X5.get()), has(CrystallineItems.FLAWLESS_RUBY.get()))
                .group("Ruby Recipes")
                .save(output);

        shaped(RecipeCategory.BUILDING_BLOCKS, CrystallineBlocks.RUBY_BLOCK_X5.get())
                .pattern("AAA")
                .pattern("AAA")
                .pattern("AAA")
                .define('A', CrystallineBlocks.RUBY_BLOCK_X4.get())
                .unlockedBy(getHasName(CrystallineBlocks.RUBY_BLOCK_X4.get()), has(CrystallineBlocks.RUBY_BLOCK_X4.get()))
                .group("Ruby Recipes")
                .save(output, "crystalline:x4_to_x5");

        shaped(RecipeCategory.BUILDING_BLOCKS, CrystallineBlocks.RUBY_BLOCK_X6.get())
                .pattern("AAA")
                .pattern("AAA")
                .pattern("AAA")
                .define('A', CrystallineItems.PERFECT_RUBY.get())
                .unlockedBy(getHasName(CrystallineItems.PERFECT_RUBY.get()), has(CrystallineItems.PERFECT_RUBY.get()))
                .group("Ruby Recipes")
                .save(output);

        shapeless(RecipeCategory.MISC, CrystallineItems.PERFECT_RUBY.get(), 9)
                .requires(CrystallineBlocks.RUBY_BLOCK_X6)
                .unlockedBy(getHasName(CrystallineBlocks.RUBY_BLOCK_X6.get()), has(CrystallineItems.PERFECT_RUBY.get()))
                .group("Ruby Recipes")
                .save(output);

        shaped(RecipeCategory.BUILDING_BLOCKS, CrystallineBlocks.RUBY_BLOCK_X6.get())
                .pattern("AAA")
                .pattern("AAA")
                .pattern("AAA")
                .define('A', CrystallineBlocks.RUBY_BLOCK_X5.get())
                .unlockedBy(getHasName(CrystallineBlocks.RUBY_BLOCK_X5.get()), has(CrystallineBlocks.RUBY_BLOCK_X5.get()))
                .group("Ruby Recipes")
                .save(output, "crystalline:x5_to_x6");








    }
}
