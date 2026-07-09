package com.drewniany.crystalline;

import com.drewniany.crystalline.datagen.CrystallineBlockLootTableProvider;
import com.drewniany.crystalline.datagen.CrystallineBlockTagsProvider;
import com.drewniany.crystalline.datagen.CrystallineModelProvider;
import com.drewniany.crystalline.datagen.CrystallineRecipeProvider;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.PackOutput;
import net.minecraft.data.loot.LootTableProvider;
import net.minecraft.world.level.storage.loot.LootContext;
import net.minecraft.world.level.storage.loot.parameters.LootContextParamSets;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.data.event.GatherDataEvent;

import java.util.Collections;
import java.util.List;

@EventBusSubscriber(modid = com.drewniany.crystalline.Crystalline.MOD_ID)
public class CrystallineDataGen {
    @SubscribeEvent
    public static void gatherClientData(GatherDataEvent.Client event) {
        DataGenerator generator = event.getGenerator();
        PackOutput packOutput = generator.getPackOutput();
        var lookupProvider = event.getLookupProvider();

        generator.addProvider(true, new CrystallineModelProvider(packOutput));
        generator.addProvider(true, new CrystallineBlockTagsProvider(packOutput, lookupProvider));
        generator.addProvider(true, new LootTableProvider(packOutput, Collections.emptySet(),
                List.of(new LootTableProvider.SubProviderEntry(CrystallineBlockLootTableProvider::new, LootContextParamSets.BLOCK)), lookupProvider));
        generator.addProvider(true, new CrystallineRecipeProvider.Runner(packOutput, lookupProvider));
    }
}
