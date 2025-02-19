package com.fossil.fossil.block.entity;

import com.fossil.fossil.block.custom_blocks.SarcophagusBlock;
import com.fossil.fossil.entity.ModEntities;
import com.fossil.fossil.entity.monster.AnuBoss;
import net.minecraft.core.BlockPos;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.ServerLevelAccessor;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;

public class SarcophagusBlockEntity extends BlockEntity {
    public static final int STATE_LOCKED = 0;
    public static final int STATE_UNLOCKED = 1;
    public static final int STATE_OPENING = 2;
    public static final int STATE_CLOSING = 3;
    private int state;
    private int doorTimer;

    public SarcophagusBlockEntity(BlockPos blockPos, BlockState blockState) {
        super(ModBlockEntities.SARCOPHAGUS.get(), blockPos, blockState);
    }

    private static void tick(Level level, BlockPos pos, BlockState state, SarcophagusBlockEntity blockEntity) {
        if (blockEntity.state != STATE_CLOSING) {
            if (blockEntity.doorTimer > 0) {
                blockEntity.doorTimer++;
            }
            if (blockEntity.doorTimer >= 91) {
                blockEntity.state = STATE_CLOSING;
                if (!level.isClientSide) {
                    AnuBoss anuBoss = ModEntities.ANU_BOSS.get().create(level);
                    anuBoss.finalizeSpawn((ServerLevelAccessor) level, level.getCurrentDifficultyAt(pos), MobSpawnType.NATURAL, null, null);
                    BlockPos anuPos = pos.offset(state.getValue(SarcophagusBlock.FACING).getNormal());
                    anuBoss.moveTo(anuPos.getX() + 0.5, anuPos.getY() + 0.1, anuPos.getZ() + 0.5, 0, 0);
                    Player player = level.getNearestPlayer(pos.getX(), pos.getY(), pos.getZ(), 100, false);
                    player.displayClientMessage(AnuBoss.getRandomGreeting(level.random), false);
                    level.addFreshEntity(anuBoss);
                }
            }
        } else {
            if (blockEntity.doorTimer > 0) {
                blockEntity.doorTimer--;
            }
            if (blockEntity.doorTimer == 0) {
                blockEntity.state = STATE_LOCKED;
            }
        }
    }

    public static void serverTick(Level level, BlockPos pos, BlockState state, SarcophagusBlockEntity blockEntity) {
        tick(level, pos, state, blockEntity);
    }

    public static void clientTick(Level level, BlockPos pos, BlockState state, SarcophagusBlockEntity blockEntity) {
        tick(level, pos, state, blockEntity);
    }

    public void setState(int state) {
        this.state = state;
    }

    public void setDoorTimer(int doorTimer) {
        this.doorTimer = doorTimer;
    }

    public int getState() {
        return state;
    }

    public int getDoorTimer() {
        return doorTimer;
    }
}
