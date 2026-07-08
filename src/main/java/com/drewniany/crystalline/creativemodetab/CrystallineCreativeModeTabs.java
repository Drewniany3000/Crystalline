package com.drewniany.crystalline.creativemodetab;

import com.drewniany.crystalline.Crystalline;
import com.drewniany.crystalline.item.CrystallineItems;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.function.Supplier;

public class CrystallineCreativeModeTabs {
    public static final DeferredRegister<CreativeModeTab> CREATIVE_TABS =
            DeferredRegister.create(Registries.CREATIVE_MODE_TAB, Crystalline.MOD_ID);


    public static final Supplier<CreativeModeTab> CRYSTALLINE_ITEMS_TAB = CREATIVE_TABS.register("crystalline_items_tab",
            () -> CreativeModeTab.builder().icon(() -> new ItemStack(CrystallineItems.FLAWLESS_RUBY.get()))
                    .title(Component.translatable("creativemodetab.crystalline_items_tab"))

                    .build());

    public static void register(IEventBus eventBus) {
        CREATIVE_TABS.register(eventBus);
    }
}
