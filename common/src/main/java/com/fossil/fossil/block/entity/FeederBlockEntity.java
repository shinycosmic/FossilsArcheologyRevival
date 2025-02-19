package com.fossil.fossil.block.entity;

import com.fossil.fossil.block.custom_blocks.FeederBlock;
import com.fossil.fossil.entity.prehistoric.base.Prehistoric;
import com.fossil.fossil.inventory.FeederMenu;
import com.fossil.fossil.util.Diet;
import com.fossil.fossil.util.FoodMappings;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.NonNullList;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.TranslatableComponent;
import net.minecraft.world.ContainerHelper;
import net.minecraft.world.WorldlyContainer;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.inventory.ContainerData;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.entity.BaseContainerBlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class FeederBlockEntity extends BaseContainerBlockEntity implements WorldlyContainer {
    private static final int[] SLOTS_TOP = new int[]{0, 1};
    private int meat;
    private int plant;
    private int prevMeat;
    private int prevPlant;
    private int ticksExisted;
    protected NonNullList<ItemStack> items = NonNullList.withSize(2, ItemStack.EMPTY);
    private final ContainerData dataAccess = new ContainerData() {

        @Override
        public int get(int index) {
            switch (index) {
                case 0 -> {
                    return meat;
                }
                case 1 -> {
                    return plant;
                }
            }
            return 0;
        }

        @Override
        public void set(int index, int value) {
            switch (index) {
                case 0 -> meat = value;
                case 1 -> plant = value;
            }
        }

        @Override
        public int getCount() {
            return 2;
        }
    };

    public FeederBlockEntity(BlockPos blockPos, BlockState blockState) {
        super(ModBlockEntities.FEEDER.get(), blockPos, blockState);
    }

    public static void serverTick(Level level, BlockPos pos, BlockState state, FeederBlockEntity blockEntity) {
        blockEntity.ticksExisted++;
        blockEntity.prevMeat = blockEntity.meat;
        blockEntity.prevPlant = blockEntity.plant;
        blockEntity.meat = Math.max(blockEntity.meat, 0);
        blockEntity.plant = Math.max(blockEntity.plant, 0);
        boolean dirty = false;
        ItemStack itemStack = blockEntity.getItem(0);
        if (!itemStack.isEmpty()) {
            if (blockEntity.canPlaceItem(0, itemStack) && blockEntity.ticksExisted % 5 == 0 && blockEntity.meat < 10000) {
                int foodPoints = FoodMappings.getFoodAmount(itemStack.getItem(), Diet.CARNIVORE_EGG);
                if (foodPoints == 0) {
                    foodPoints = FoodMappings.getFoodAmount(itemStack.getItem(), Diet.PISCIVORE);
                }
                if (foodPoints > 0) {
                    dirty = true;
                    blockEntity.meat += foodPoints;
                    itemStack.shrink(1);
                }
            }
        }
        itemStack = blockEntity.getItem(1);
        if (!itemStack.isEmpty()) {
            if (blockEntity.canPlaceItem(1, itemStack) && blockEntity.ticksExisted % 5 == 0 && blockEntity.plant < 10000) {
                int foodPoints = FoodMappings.getFoodAmount(itemStack.getItem(), Diet.HERBIVORE);
                if (foodPoints > 0) {
                    dirty = true;
                    blockEntity.plant += foodPoints;
                    itemStack.shrink(1);
                }
            }
        }
        if (blockEntity.prevMeat != blockEntity.meat || blockEntity.prevPlant != blockEntity.plant) {
            dirty = true;
            state = state.setValue(FeederBlock.HERB, blockEntity.plant > 0).setValue(FeederBlock.CARN, blockEntity.meat > 0);
            level.setBlock(pos, state, 3);
        }
        if (dirty) {
            setChanged(level, pos, state);
        }
    }

    @Override
    public void load(CompoundTag tag) {
        super.load(tag);
        this.items = NonNullList.withSize(this.getContainerSize(), ItemStack.EMPTY);
        ContainerHelper.loadAllItems(tag, this.items);
        this.meat = tag.getShort("Meat");
        this.plant = tag.getShort("Plant");
    }

    @Override
    protected void saveAdditional(CompoundTag tag) {
        super.saveAdditional(tag);
        tag.putShort("Meat", (short) this.meat);
        tag.putShort("Plant", (short) this.plant);
        ContainerHelper.saveAllItems(tag, this.items);
    }

    @Override
    protected @NotNull Component getDefaultName() {
        return new TranslatableComponent("container.fossil.feeder");
    }

    @Override
    protected @NotNull AbstractContainerMenu createMenu(int containerId, Inventory inventory) {
        return new FeederMenu(containerId, inventory, this, dataAccess);
    }

    @Override
    public int getContainerSize() {
        return items.size();
    }

    @Override
    public boolean isEmpty() {
        for (ItemStack itemStack : items) {
            if (itemStack.isEmpty()) continue;
            return false;
        }
        return true;
    }

    public boolean isEmpty(Diet diet) {
        if (diet == Diet.CARNIVORE || diet == Diet.CARNIVORE_EGG || diet == Diet.PISCI_CARNIVORE || diet == Diet.PISCIVORE || diet == Diet.INSECTIVORE) {
            return meat == 0;
        }
        if (diet == Diet.HERBIVORE) {
            return plant == 0;
        }
        return diet == Diet.OMNIVORE && meat == 0 && plant == 0;
    }

    public void feedDinosaur(Prehistoric mob) {
        if (level != null) {
            int feedAmount = 0;
            if (!isEmpty(mob.type().diet)) {
                if (mob.type().diet == Diet.CARNIVORE || mob.type().diet == Diet.CARNIVORE_EGG || mob.type().diet == Diet.PISCI_CARNIVORE || mob.type().diet == Diet.PISCIVORE || mob.type().diet == Diet.INSECTIVORE) {
                    meat--;
                    level.broadcastEntityEvent(mob, (byte) 47);
                    feedAmount++;
                }
                if (mob.type().diet == Diet.HERBIVORE) {
                    plant--;
                    level.broadcastEntityEvent(mob, (byte) 45);
                    feedAmount++;
                }
                if (mob.type().diet == Diet.OMNIVORE) {
                    if (meat == 0 && plant != 0) {
                        plant--;
                        feedAmount++;
                    } else if (meat != 0 && plant == 0) {
                        meat--;
                        feedAmount++;
                    } else if (meat != 0) {
                        meat--;
                        feedAmount++;
                    }
                }
            }
            if (feedAmount > 0) {
                level.getBlockState(getBlockPos()).setValue(FeederBlock.HERB, plant > 0).setValue(FeederBlock.CARN, meat > 0);
                level.setBlockAndUpdate(getBlockPos(), getBlockState());
                setChanged(level, getBlockPos(), getBlockState());
                mob.setHunger(mob.getHunger() + feedAmount);
            }
        }
    }

    @Override
    public @NotNull ItemStack getItem(int slot) {
        return items.get(slot);
    }

    @Override
    public @NotNull ItemStack removeItem(int slot, int amount) {
        return ContainerHelper.removeItem(items, slot, amount);
    }

    @Override
    public @NotNull ItemStack removeItemNoUpdate(int slot) {
        return ContainerHelper.takeItem(items, slot);
    }

    @Override
    public void setItem(int slot, ItemStack stack) {
        items.set(slot, stack);
        if (stack.getCount() > getMaxStackSize()) {
            stack.setCount(getMaxStackSize());
        }
    }

    @Override
    public boolean stillValid(Player player) {
        return level.getBlockEntity(worldPosition) == this && player.distanceToSqr((double) worldPosition.getX() + 0.5,
                (double) worldPosition.getY() + 0.5, (double) worldPosition.getZ() + 0.5) <= 64.0;
    }

    @Override
    public void clearContent() {
        items.clear();
    }

    @Override
    public int @NotNull [] getSlotsForFace(Direction side) {
        return side != Direction.DOWN ? SLOTS_TOP : new int[]{};
    }

    @Override
    public boolean canPlaceItemThroughFace(int index, ItemStack itemStack, @Nullable Direction direction) {
        return canPlaceItem(index, itemStack);
    }

    @Override
    public boolean canTakeItemThroughFace(int index, ItemStack stack, Direction direction) {
        return direction != Direction.DOWN;
    }
}
