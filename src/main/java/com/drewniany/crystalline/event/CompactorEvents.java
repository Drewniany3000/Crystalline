package com.drewniany.crystalline.event;

import com.drewniany.crystalline.Crystalline;
import com.drewniany.crystalline.blocks.CrystallineBlocks;
import com.drewniany.crystalline.item.CrystallineItems;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.event.tick.PlayerTickEvent;

public class CompactorEvents {

    // how many of a lower tier make one of the next tier
    private static final int PER_STEP = 9;

    @EventBusSubscriber(modid = Crystalline.MOD_ID)
    public static class Handler {

        @SubscribeEvent
        public static void onPlayerTick(PlayerTickEvent.Post event) {
            Player player = event.getEntity();
            if (player.level().isClientSide()) return;      // server-side only
            if (player.tickCount % 10 != 0) return;         // run twice a second, not every tick

            Inventory inv = player.getInventory();
            if (!hasCompactor(inv)) return;

            // the compaction chain, from lowest tier to highest.
            // each row: {what you have, what 9 of them become}
            Item[][] chain = {
                    { CrystallineItems.ROUGH_RUBY.get(),      CrystallineBlocks.RUBY_BLOCK.get().asItem() },
                    { CrystallineBlocks.RUBY_BLOCK.get().asItem(),    CrystallineBlocks.RUBY_BLOCK_X2.get().asItem() },
                    { CrystallineBlocks.RUBY_BLOCK_X2.get().asItem(), CrystallineBlocks.RUBY_BLOCK_X3.get().asItem() },
                    { CrystallineBlocks.RUBY_BLOCK_X3.get().asItem(), CrystallineBlocks.RUBY_BLOCK_X4.get().asItem() },
                    { CrystallineBlocks.RUBY_BLOCK_X4.get().asItem(), CrystallineBlocks.RUBY_BLOCK_X5.get().asItem() },
                    { CrystallineBlocks.RUBY_BLOCK_X5.get().asItem(), CrystallineBlocks.RUBY_BLOCK_X6.get().asItem() },
            };

            for (Item[] step : chain) {
                compact(player, inv, step[0], step[1]);
            }
        }

        private static void compact(Player player, Inventory inv, Item source, Item result) {
            int groups = countItem(inv, source) / PER_STEP;
            if (groups <= 0) return;

            removeItems(inv, source, groups * PER_STEP);

            ItemStack out = new ItemStack(result, groups);
            inv.add(out);                       // add reduces out's count as it fits items
            if (!out.isEmpty()) {
                player.drop(out, false);        // no room left -> drop the leftovers
            }
        }

        private static boolean hasCompactor(Inventory inv) {
            Item compactor = CrystallineItems.COMPACTOR.get();
            for (int i = 0; i < inv.getContainerSize(); i++) {
                if (inv.getItem(i).getItem() == compactor) return true;
            }
            return false;
        }

        private static int countItem(Inventory inv, Item item) {
            int total = 0;
            for (int i = 0; i < inv.getContainerSize(); i++) {
                ItemStack stack = inv.getItem(i);
                if (stack.getItem() == item) total += stack.getCount();
            }
            return total;
        }

        private static void removeItems(Inventory inv, Item item, int amount) {
            for (int i = 0; i < inv.getContainerSize() && amount > 0; i++) {
                ItemStack stack = inv.getItem(i);
                if (stack.getItem() == item) {
                    int take = Math.min(amount, stack.getCount());
                    stack.shrink(take);
                    amount -= take;
                }
            }
        }
    }
}
