package com.drewniany.crystalline.datagen;

import com.drewniany.crystalline.blocks.CrystallineBlocks;
import com.drewniany.crystalline.item.CrystallineItems;
import net.minecraft.core.Holder;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.loot.BlockLootSubProvider;
import net.minecraft.data.loot.LootTableProvider;
import net.minecraft.world.flag.FeatureFlagSet;
import net.minecraft.world.flag.FeatureFlags;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.item.enchantment.Enchantments;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.storage.loot.LootTable;
import net.minecraft.world.level.storage.loot.entries.LootItem;
import net.minecraft.world.level.storage.loot.entries.LootPoolEntryContainer;
import net.minecraft.world.level.storage.loot.functions.ApplyBonusCount;
import net.minecraft.world.level.storage.loot.functions.SetItemCountFunction;
import net.minecraft.world.level.storage.loot.providers.number.UniformGenerator;

import java.util.Set;

public class CrystallineBlockLootTableProvider extends BlockLootSubProvider {
    public CrystallineBlockLootTableProvider(HolderLookup.Provider registries) {
        super(Set.of(), FeatureFlags.REGISTRY.allFlags(), registries);
    }

    @Override
    protected void generate() {
        dropSelf(CrystallineBlocks.RUBY_BLOCK.get());
        dropSelf(CrystallineBlocks.RUBY_BLOCK_X2.get());
        dropSelf(CrystallineBlocks.RUBY_BLOCK_X3.get());
        dropSelf(CrystallineBlocks.RUBY_BLOCK_X4.get());
        dropSelf(CrystallineBlocks.RUBY_BLOCK_X5.get());
        dropSelf(CrystallineBlocks.RUBY_BLOCK_X6.get());

        add(CrystallineBlocks.RUBY_ORE.get(), createMultipleOreDrops(CrystallineBlocks.RUBY_ORE.get(), CrystallineItems.ROUGH_RUBY.get(), 1, 30));
    }




    protected LootTable.Builder createMultipleOreDrops(Block block, Item item, float minDrops, float maxDrops) {
        HolderLookup.RegistryLookup<Enchantment> enchantments = this.registries.lookupOrThrow(Registries.ENCHANTMENT);
        return this.createSilkTouchDispatchTable(
                block,
                (LootPoolEntryContainer.Builder<?>)this.applyExplosionDecay(
                        block,
                        LootItem.lootTableItem(item)
                                .apply(SetItemCountFunction.setCount(UniformGenerator.between(minDrops, maxDrops)))
                                .apply(ApplyBonusCount.addOreBonusCount(enchantments.getOrThrow(Enchantments.FORTUNE)))
                )
        );
    }

    @Override
    protected Iterable<Block> getKnownBlocks() {
        return CrystallineBlocks.BLOCKS.getEntries().stream().map(Holder::value)::iterator;
    }
}
