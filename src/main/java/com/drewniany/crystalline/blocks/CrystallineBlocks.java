package com.drewniany.crystalline.blocks;

import com.drewniany.crystalline.Crystalline;
import com.drewniany.crystalline.item.CrystallineItems;
import com.mojang.brigadier.exceptions.Dynamic3CommandExceptionType;
import net.minecraft.util.valueproviders.UniformInt;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.DropExperienceBlock;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredBlock;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.function.Function;

public class CrystallineBlocks {
    public static final DeferredRegister.Blocks BLOCKS =
            DeferredRegister.createBlocks(Crystalline.MOD_ID);

    public static final DeferredBlock<Block> RUBY_BLOCK_X6 = registerBlock("ruby_block_x6",
            properties -> new Block(properties.strength(4f).requiresCorrectToolForDrops().sound(SoundType.IRON)));
    public static final DeferredBlock<Block> RUBY_BLOCK_X5 = registerBlock("ruby_block_x5",
            properties -> new Block(properties.strength(4f).requiresCorrectToolForDrops().sound(SoundType.IRON)));
    public static final DeferredBlock<Block> RUBY_BLOCK_X4 = registerBlock("ruby_block_x4",
            properties -> new Block(properties.strength(4f).requiresCorrectToolForDrops().sound(SoundType.IRON)));
    public static final DeferredBlock<Block> RUBY_BLOCK_X3 = registerBlock("ruby_block_x3",
            properties -> new Block(properties.strength(4f).requiresCorrectToolForDrops().sound(SoundType.IRON)));
    public static final DeferredBlock<Block> RUBY_BLOCK_X2 = registerBlock("ruby_block_x2",
            properties -> new Block(properties.strength(4f).requiresCorrectToolForDrops().sound(SoundType.IRON)));
    public static final DeferredBlock<Block> RUBY_BLOCK = registerBlock("ruby_block",
            properties -> new Block(properties.strength(4f).requiresCorrectToolForDrops().sound(SoundType.IRON)));
    public static final DeferredBlock<Block> RUBY_ORE = registerBlock("ruby_ore",
            properties -> new DropExperienceBlock(UniformInt.of(10, 15), properties.strength(4f).requiresCorrectToolForDrops().sound(SoundType.AMETHYST)));



    private static <T extends Block> DeferredBlock<T> registerBlock(String name, Function<BlockBehaviour.Properties, T> function) {
        DeferredBlock<T> toReturn = BLOCKS.registerBlock(name, function);
        registerBlockItem(name, toReturn);
        return toReturn;
    }

    private static <T extends Block> void registerBlockItem(String name, DeferredBlock<T> block) {
        CrystallineItems.ITEMS.registerItem(name,properties -> new BlockItem(block.get(), properties.useBlockDescriptionPrefix()));
    }






    public static void register(IEventBus eventBus) {
        BLOCKS.register(eventBus);
    }

}
