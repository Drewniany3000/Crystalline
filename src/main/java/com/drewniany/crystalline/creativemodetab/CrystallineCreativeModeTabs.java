package com.drewniany.crystalline.creativemodetab;

import com.drewniany.crystalline.Crystalline;
import com.drewniany.crystalline.blocks.CrystallineBlocks;
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


    public static final Supplier<CreativeModeTab> CRYSTALLINE_ITEMS_TAB = CREATIVE_TABS.register("crystalline_tab",
            () -> CreativeModeTab.builder().icon(() -> new ItemStack(CrystallineItems.FLAWLESS_RUBY.get()))
                    .title(Component.translatable("creativemodetab.crystalline_tab"))
                    .displayItems((itemDisplayParameters, output) -> {
                        output.accept(CrystallineItems.ROUGH_RUBY);
                        output.accept(CrystallineItems.FLAWED_RUBY);
                        output.accept(CrystallineItems.FINE_RUBY);
                        output.accept(CrystallineItems.RUBY);
                        output.accept(CrystallineItems.FLAWLESS_RUBY);
                        output.accept(CrystallineItems.PERFECT_RUBY);
                        output.accept(CrystallineItems.GEMSTONE_DRILL);
                        output.accept(CrystallineBlocks.RUBY_BLOCK);
                        output.accept(CrystallineBlocks.RUBY_BLOCK_X2);
                        output.accept(CrystallineBlocks.RUBY_BLOCK_X3);
                        output.accept(CrystallineBlocks.RUBY_BLOCK_X4);
                        output.accept(CrystallineBlocks.RUBY_BLOCK_X5);
                        output.accept(CrystallineBlocks.RUBY_BLOCK_X6);
                        output.accept(CrystallineBlocks.RUBY_ORE);
                    })

                    .build());

    public static void register(IEventBus eventBus) {
        CREATIVE_TABS.register(eventBus);
    }
}
