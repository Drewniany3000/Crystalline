package com.drewniany.crystalline.datagen;

import com.drewniany.crystalline.Crystalline;
import com.drewniany.crystalline.blocks.CrystallineBlocks;
import com.drewniany.crystalline.item.CrystallineItems;
import net.minecraft.client.data.models.BlockModelGenerators;
import net.minecraft.client.data.models.ItemModelGenerators;
import net.minecraft.client.data.models.ModelProvider;
import net.minecraft.client.data.models.model.ModelTemplates;
import net.minecraft.data.PackOutput;

public class CrystallineModelProvider extends ModelProvider {

    public CrystallineModelProvider(PackOutput output) {
        super(output, Crystalline.MOD_ID);
    }


    @Override
    protected void registerModels(BlockModelGenerators blockModels, ItemModelGenerators itemModels) {
        itemModels.generateFlatItem(CrystallineItems.PERFECT_RUBY.get(), ModelTemplates.FLAT_ITEM);
        itemModels.generateFlatItem(CrystallineItems.FLAWLESS_RUBY.get(), ModelTemplates.FLAT_ITEM);
        itemModels.generateFlatItem(CrystallineItems.RUBY.get(), ModelTemplates.FLAT_ITEM);
        itemModels.generateFlatItem(CrystallineItems.FINE_RUBY.get(), ModelTemplates.FLAT_ITEM);
        itemModels.generateFlatItem(CrystallineItems.FLAWED_RUBY.get(), ModelTemplates.FLAT_ITEM);
        itemModels.generateFlatItem(CrystallineItems.ROUGH_RUBY.get(), ModelTemplates.FLAT_ITEM);






        // BLOCKS
        blockModels.createTrivialCube(CrystallineBlocks.RUBY_BLOCK.get());
        blockModels.createTrivialCube(CrystallineBlocks.RUBY_BLOCK_X2.get());
        blockModels.createTrivialCube(CrystallineBlocks.RUBY_BLOCK_X3.get());
        blockModels.createTrivialCube(CrystallineBlocks.RUBY_BLOCK_X4.get());
        blockModels.createTrivialCube(CrystallineBlocks.RUBY_BLOCK_X5.get());
        blockModels.createTrivialCube(CrystallineBlocks.RUBY_BLOCK_X6.get());
        blockModels.createTrivialCube(CrystallineBlocks.RUBY_ORE.get());


    }
}

