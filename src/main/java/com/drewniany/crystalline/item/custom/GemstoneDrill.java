package com.drewniany.crystalline.item.custom;

import net.minecraft.tags.BlockTags;
import net.minecraft.tags.ItemTags;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ToolMaterial;

public class GemstoneDrill extends Item {
    public GemstoneDrill(Properties properties) {
        super(properties);
    }

    public static final ToolMaterial GEMSTONE = new ToolMaterial(
            BlockTags.INCORRECT_FOR_NETHERITE_TOOL, // blocks it CANNOT properly mine
            3000,                                   // durability
            12.0F,                                  // mining speed
            5.0F,                                   // attack damage bonus
            18,                                     // enchantability
            ItemTags.NETHERITE_TOOL_MATERIALS       // what repairs it
    );
}
