package com.drewniany.crystalline.datagen;

import com.drewniany.crystalline.Crystalline;
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

    }
}

