package com.fossil.fossil.block.custom_blocks;

import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.BonemealableBlock;
import net.minecraft.world.level.block.BushBlock;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;

import java.util.Random;

public class ShortFlowerBlock extends BushBlock implements BonemealableBlock {
    private final VoxelShape shape;

    public ShortFlowerBlock(Properties properties, VoxelShape shape) {
        super(properties);
        this.shape = shape;
    }

    @Override
    public VoxelShape getShape(BlockState state, BlockGetter level, BlockPos pos, CollisionContext context) {
        Vec3 vec3 = state.getOffset(level, pos);
        return shape.move(vec3.x, vec3.y, vec3.z);
    }

    @Override
    public BlockBehaviour.OffsetType getOffsetType() {
        return BlockBehaviour.OffsetType.XZ;
    }

    @Override
    public boolean isValidBonemealTarget(BlockGetter level, BlockPos pos, BlockState state, boolean isClient) {
        return true;
    }

    @Override
    public boolean isBonemealSuccess(Level level, Random random, BlockPos pos, BlockState state) {
        return true;
    }

    @Override
    public void performBonemeal(ServerLevel level, Random random, BlockPos pos, BlockState state) {
        int maxTries = random.nextInt(3);
        int tries = 0;
        int timeout = 0;
        while (tries < maxTries && timeout < 101) {
            timeout++;
            BlockPos tryPos = pos.offset(random.nextInt(10) - 4, random.nextInt(8) - 4, random.nextInt(10) - 4);
            if (level.isEmptyBlock(tryPos.above()) && canSurvive(state, level, tryPos.above())) {
                tries++;
                level.setBlock(tryPos.above(), state.getBlock().defaultBlockState(), 3);
            }
        }
        level.setBlock(pos, state.getBlock().defaultBlockState(), 3);
    }
}
