package com.drewniany.crystalline;

import com.drewniany.crystalline.creativemodetab.CrystallineCreativeModeTabs;
import com.drewniany.crystalline.item.CrystallineItems;
import com.drewniany.crystalline.item.CrystallineItems;
import org.slf4j.Logger;

import com.mojang.logging.LogUtils;

import net.minecraft.world.item.CreativeModeTabs;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.Mod;
import net.neoforged.fml.config.ModConfig;
import net.neoforged.fml.ModContainer;
import net.neoforged.fml.event.lifecycle.FMLCommonSetupEvent;
import net.neoforged.neoforge.common.NeoForge;
import net.neoforged.neoforge.event.BuildCreativeModeTabContentsEvent;
import net.neoforged.neoforge.event.server.ServerStartingEvent;


@Mod(com.drewniany.crystalline.Crystalline.MOD_ID)
public class Crystalline {

    public static final String MOD_ID = "crystalline";

    public static final Logger LOGGER = LogUtils.getLogger();



    public Crystalline(IEventBus modEventBus, ModContainer modContainer) {

        modEventBus.addListener(this::commonSetup);

        CrystallineItems.register(modEventBus);

        CrystallineCreativeModeTabs.register(modEventBus);



        NeoForge.EVENT_BUS.register(this);


        modEventBus.addListener(this::addCreative);

        modContainer.registerConfig(ModConfig.Type.COMMON, com.drewniany.crystalline.Config.SPEC);
    }

    private void commonSetup(FMLCommonSetupEvent event) {

    }

    private void addCreative(BuildCreativeModeTabContentsEvent event) {
        if(event.getTabKey() == CreativeModeTabs.INGREDIENTS) {
            event.accept(CrystallineItems.PERFECT_RUBY);
            event.accept(CrystallineItems.FLAWLESS_RUBY);
            event.accept(CrystallineItems.RUBY);
        }
    }

    @SubscribeEvent
    public void onServerStarting(ServerStartingEvent event) {

    }
}
