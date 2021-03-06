package com.buuz135.industrial.tile.agriculture;

import com.buuz135.industrial.IndustrialForegoing;
import com.buuz135.industrial.tile.CustomColoredItemHandler;
import com.buuz135.industrial.tile.WorkingAreaElectricMachine;
import com.buuz135.industrial.utils.ItemStackUtils;
import com.buuz135.industrial.utils.WorkUtils;
import net.minecraft.entity.passive.EntityAnimal;
import net.minecraft.entity.passive.EntitySquid;
import net.minecraft.init.Items;
import net.minecraft.item.EnumDyeColor;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumHand;
import net.minecraftforge.common.IShearable;
import net.minecraftforge.common.util.FakePlayer;
import net.minecraftforge.fluids.IFluidTank;
import net.minecraftforge.fluids.capability.CapabilityFluidHandler;
import net.minecraftforge.fluids.capability.IFluidHandlerItem;
import net.minecraftforge.items.ItemHandlerHelper;
import net.minecraftforge.items.ItemStackHandler;
import net.ndrei.teslacorelib.inventory.FluidTankType;

import java.util.List;

public class AnimalResourceHarvesterTile extends WorkingAreaElectricMachine {

    private ItemStackHandler outItems;
    private IFluidTank tank;

    public AnimalResourceHarvesterTile() {
        super(AnimalResourceHarvesterTile.class.getName().hashCode());
    }

    @Override
    protected void initializeInventories() {
        super.initializeInventories();
        tank = this.addSimpleFluidTank(8000, "tank", EnumDyeColor.WHITE, 50, 25, FluidTankType.OUTPUT, fluidStack -> false, fluidStack -> true);
        outItems = new ItemStackHandler(3 * 4) {
            @Override
            protected void onContentsChanged(int slot) {
                AnimalResourceHarvesterTile.this.markDirty();
            }
        };
        this.addInventory(new CustomColoredItemHandler(outItems, EnumDyeColor.ORANGE, "Output Items", 18 * 5 + 3, 25, 4, 3) {
            @Override
            public boolean canInsertItem(int slot, ItemStack stack) {
                return false;
            }

            @Override
            public boolean canExtractItem(int slot) {
                return true;
            }
        });
        this.addInventoryToStorage(outItems, "outItems");
    }

    @Override
    public float work() {
        if (WorkUtils.isDisabled(this.getBlockType())) return 0;
        List<EntityAnimal> animals = this.world.getEntitiesWithinAABB(EntityAnimal.class, getWorkingArea());
        boolean hasWorked = false;
        for (EntityAnimal living : animals) {
            if (!ItemStackUtils.isInventoryFull(outItems) && living instanceof IShearable && ((IShearable) living).isShearable(new ItemStack(Items.SHEARS), this.world, living.getPosition())) {
                List<ItemStack> stacks = ((IShearable) living).onSheared(new ItemStack(Items.SHEARS), this.world, null, 0);
                for (ItemStack stack : stacks) {
                    ItemHandlerHelper.insertItem(outItems, stack, false);
                }
                hasWorked = true;
            }
            if (tank.getFluidAmount() <= 7000) {
                FakePlayer player = IndustrialForegoing.getFakePlayer(this.world);
                player.setPosition(living.posX, living.posY, living.posZ);
                player.setHeldItem(EnumHand.MAIN_HAND, new ItemStack(Items.BUCKET));
                if (living.processInteract(player, EnumHand.MAIN_HAND)) {
                    ItemStack stack = player.getHeldItem(EnumHand.MAIN_HAND);
                    if (stack.hasCapability(CapabilityFluidHandler.FLUID_HANDLER_ITEM_CAPABILITY, null)) {
                        IFluidHandlerItem fluidHandlerItem = stack.getCapability(CapabilityFluidHandler.FLUID_HANDLER_ITEM_CAPABILITY, null);
                        tank.fill(fluidHandlerItem.drain(Integer.MAX_VALUE, true), true);
                        hasWorked = true;
                    }
                }
            }
        }
        for (EntitySquid animal : this.world.getEntitiesWithinAABB(EntitySquid.class, getWorkingArea())) {
            if (!ItemStackUtils.isInventoryFull(outItems) && world.rand.nextBoolean() && world.rand.nextBoolean() && world.rand.nextBoolean() && world.rand.nextBoolean()) {
                ItemHandlerHelper.insertItem(outItems, new ItemStack(Items.DYE), false);
                hasWorked = true;
            }
        }
        return hasWorked ? 1 : 0;
    }

    @Override
    protected boolean acceptsFluidItem(ItemStack stack) {
        return ItemStackUtils.acceptsFluidItem(stack);
    }

    @Override
    protected void processFluidItems(ItemStackHandler fluidItems) {
        ItemStackUtils.processFluidItems(fluidItems, tank);
    }
}
