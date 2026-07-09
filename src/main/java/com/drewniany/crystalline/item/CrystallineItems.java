package com.drewniany.crystalline.item;

import com.drewniany.crystalline.Crystalline;
import com.drewniany.crystalline.item.custom.GemstoneDrill;
import net.minecraft.core.component.DataComponents;
import net.minecraft.world.item.Item;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;

public class CrystallineItems {
    public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(Crystalline.MOD_ID);

    public static final DeferredItem<Item> PERFECT_RUBY = ITEMS.registerItem("perfect_ruby",
            properties -> new Item(properties.component(DataComponents.ENCHANTMENT_GLINT_OVERRIDE, true)));
    public static final DeferredItem<Item> FLAWLESS_RUBY = ITEMS.registerSimpleItem("flawless_ruby");
    public static final DeferredItem<Item> RUBY = ITEMS.registerSimpleItem("ruby");
    public static final DeferredItem<Item> FINE_RUBY = ITEMS.registerSimpleItem("fine_ruby");
    public static final DeferredItem<Item> FLAWED_RUBY = ITEMS.registerSimpleItem("flawed_ruby");
    public static final DeferredItem<Item> ROUGH_RUBY = ITEMS.registerSimpleItem("rough_ruby");

    public static final DeferredItem<GemstoneDrill> GEMSTONE_DRILL = ITEMS.registerItem("gemstone_drill",
            properties -> new GemstoneDrill(properties.pickaxe(GemstoneDrill.GEMSTONE, 1f, -2.8f)));


    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}

