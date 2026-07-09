package com.drewniany.crystalline.event;

import com.drewniany.crystalline.Crystalline;
import com.drewniany.crystalline.item.custom.GemstoneDrill;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.HitResult;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.event.level.block.BreakBlockEvent;

import java.util.ArrayList;
import java.util.List;

@EventBusSubscriber(modid = Crystalline.MOD_ID)
public class DrillMiningEvents {
    // stops the event from firing itself over and over as we break the extra blocks
    private static boolean isBreaking = false;

    @SubscribeEvent
    public static void onBlockBreak(BreakBlockEvent event) {
        if (isBreaking) return;

        Player player = event.getPlayer();
        Level level = (Level) event.getLevel();
        if (level.isClientSide()) return;   // event now fires on BOTH sides — only act on server

        ItemStack tool = player.getMainHandItem();
        if (!(tool.getItem() instanceof GemstoneDrill)) return;

        // hold shift to mine just one block
        if (player.isShiftKeyDown()) return;

        BlockPos origin = event.getPos();

        // which face is the player looking at? that decides the plane of the 3x3
        HitResult hit = player.pick(10.0, 0.0f, false);
        if (hit.getType() != HitResult.Type.BLOCK) return;
        Direction face = ((BlockHitResult) hit).getDirection();

        isBreaking = true;
        for (BlockPos pos : get3x3(origin, face)) {
            if (pos.equals(origin)) continue; // vanilla already breaks the center
            BlockState state = level.getBlockState(pos);
            if (state.getDestroySpeed(level, pos) < 0) continue;   // skip bedrock/unbreakable
            if (!tool.isCorrectToolForDrops(state)) continue;      // only what the pickaxe can mine
            if (player instanceof ServerPlayer sp) {
                sp.gameMode.destroyBlock(pos); // drops items, damages tool, awards xp
            }
        }
        isBreaking = false;
    }

    // build the 3x3 square on the plane facing the player
    private static List<BlockPos> get3x3(BlockPos origin, Direction face) {
        List<BlockPos> positions = new ArrayList<>();
        switch (face.getAxis()) {
            case Y -> { // mining floor or ceiling
                for (int x = -1; x <= 1; x++)
                    for (int z = -1; z <= 1; z++)
                        positions.add(origin.offset(x, 0, z));
            }
            case X -> { // mining an east/west wall
                for (int y = -1; y <= 1; y++)
                    for (int z = -1; z <= 1; z++)
                        positions.add(origin.offset(0, y, z));
            }
            case Z -> { // mining a north/south wall
                for (int x = -1; x <= 1; x++)
                    for (int y = -1; y <= 1; y++)
                        positions.add(origin.offset(x, y, 0));
            }
        }
        return positions;
    }
}