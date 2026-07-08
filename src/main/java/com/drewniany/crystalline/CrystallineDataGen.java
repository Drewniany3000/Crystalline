package com.drewniany.crystalline;

import com.drewniany.crystalline.datagen.CrystallineBlockTagsProvider;
import com.drewniany.crystalline.datagen.CrystallineModelProvider;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.PackOutput;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.data.event.GatherDataEvent;

@EventBusSubscriber(modid = com.drewniany.crystalline.Crystalline.MOD_ID)
public class CrystallineDataGen {
    @SubscribeEvent
    public static void gatherClientData(GatherDataEvent.Client event) {
        DataGenerator generator = event.getGenerator();
        PackOutput packOutput = generator.getPackOutput();
        var lookupProvider = event.getLookupProvider();

        generator.addProvider(true, new CrystallineModelProvider(packOutput));
        generator.addProvider(true, new CrystallineBlockTagsProvider(packOutput, lookupProvider));
    }
}
