package com.drewniany.crystalline.datagen;

import com.drewniany.crystalline.Crystalline;
import com.drewniany.crystalline.blocks.CrystallineBlocks;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.tags.BlockTags;
import net.neoforged.neoforge.common.Tags;
import net.neoforged.neoforge.common.data.BlockTagsProvider;

import java.util.concurrent.CompletableFuture;

public class CrystallineBlockTagsProvider extends BlockTagsProvider {


    public CrystallineBlockTagsProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider) {
        super(output, lookupProvider, Crystalline.MOD_ID);
    }

    @Override
    protected void addTags(HolderLookup.Provider provider) {
        tag(BlockTags.MINEABLE_WITH_PICKAXE)
                .add(CrystallineBlocks.RUBY_ORE.get())
                .add(CrystallineBlocks.RUBY_BLOCK.get())
                .add(CrystallineBlocks.RUBY_BLOCK_X2.get())
                .add(CrystallineBlocks.RUBY_BLOCK_X3.get())
                .add(CrystallineBlocks.RUBY_BLOCK_X4.get())
                .add(CrystallineBlocks.RUBY_BLOCK_X5.get())
                .add(CrystallineBlocks.RUBY_BLOCK_X6.get())
                ;
        tag(Tags.Blocks.NEEDS_NETHERITE_TOOL)
                .add(CrystallineBlocks.RUBY_ORE.get())
                .add(CrystallineBlocks.RUBY_BLOCK.get())
                .add(CrystallineBlocks.RUBY_BLOCK_X2.get())
                .add(CrystallineBlocks.RUBY_BLOCK_X3.get())
                .add(CrystallineBlocks.RUBY_BLOCK_X4.get())
                .add(CrystallineBlocks.RUBY_BLOCK_X5.get())
                .add(CrystallineBlocks.RUBY_BLOCK_X6.get())
                ;

    }
}
