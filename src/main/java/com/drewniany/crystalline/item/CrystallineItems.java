package com.drewniany.crystalline.item;

import com.drewniany.crystalline.Crystalline;
import com.drewniany.crystalline.Crystalline;
import net.minecraft.world.item.Item;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;

public class CrystallineItems {
    public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(Crystalline.MOD_ID);

    public static final DeferredItem<Item> PERFECT_RUBY = ITEMS.registerSimpleItem("perfect_ruby");
    public static final DeferredItem<Item> FLAWLESS_RUBY = ITEMS.registerSimpleItem("flawless_ruby");
    public static final DeferredItem<Item> RUBY = ITEMS.registerSimpleItem("ruby");


    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}

