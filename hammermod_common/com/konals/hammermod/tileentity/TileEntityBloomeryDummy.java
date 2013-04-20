package com.konals.hammermod.tileentity;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.ISidedInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;

public class TileEntityBloomeryDummy extends TileEntity implements ISidedInventory {

    TileEntityBloomeryCore tileEntityCore;

    int coreX;

    int coreY;

    int coreZ;

    public TileEntityBloomeryDummy() {

    }

    public void setCore(TileEntityBloomeryCore core) {

        coreX = core.xCoord;
        coreY = core.yCoord;
        coreZ = core.zCoord;
        tileEntityCore = core;
    }

    public TileEntityBloomeryCore getCore() {

        if (tileEntityCore == null)
            tileEntityCore = (TileEntityBloomeryCore) worldObj.getBlockTileEntity(coreX, coreY, coreZ);

        return tileEntityCore;
    }

    @Override
    public void readFromNBT(NBTTagCompound tagCompound) {

        super.readFromNBT(tagCompound);

        coreX = tagCompound.getInteger("CoreX");
        coreY = tagCompound.getInteger("CoreY");
        coreZ = tagCompound.getInteger("CoreZ");
    }

    @Override
    public void writeToNBT(NBTTagCompound tagCompound) {

        super.writeToNBT(tagCompound);

        tagCompound.setInteger("CoreX", coreX);
        tagCompound.setInteger("CoreY", coreY);
        tagCompound.setInteger("CoreZ", coreZ);
    }

    @Override
    public int getSizeInventory() {

        return tileEntityCore.getSizeInventory();
    }

    @Override
    public ItemStack getStackInSlot(int i) {

        return tileEntityCore.getStackInSlot(i);
    }

    @Override
    public ItemStack decrStackSize(int i, int j) {

        return tileEntityCore.decrStackSize(i, j);
    }

    @Override
    public ItemStack getStackInSlotOnClosing(int i) {

        return tileEntityCore.getStackInSlotOnClosing(i);
    }

    @Override
    public void setInventorySlotContents(int i, ItemStack itemstack) {

        tileEntityCore.setInventorySlotContents(i, itemstack);
    }

    @Override
    public String getInvName() {

        return tileEntityCore.getInvName();
    }

    @Override
    public boolean isInvNameLocalized() {

        return tileEntityCore.isInvNameLocalized();
    }

    @Override
    public int getInventoryStackLimit() {

        return tileEntityCore.getInventoryStackLimit();
    }

    @Override
    public boolean isUseableByPlayer(EntityPlayer entityplayer) {

        return worldObj.getBlockTileEntity(xCoord, yCoord, zCoord) != this ? false : entityplayer.getDistanceSq((double) xCoord + 0.5,
                (double) yCoord + 0.5, (double) zCoord + 0.5) <= 64.0;
    }

    @Override
    public void openChest() {

    }

    @Override
    public void closeChest() {

    }

    @Override
    public boolean isStackValidForSlot(int i, ItemStack itemstack) {

        return tileEntityCore.isStackValidForSlot(i, itemstack);
    }

    @Override
    public int[] getSizeInventorySide(int var1) {

        return tileEntityCore.getSizeInventorySide(var1);
    }

    @Override
    public boolean func_102007_a(int i, ItemStack itemstack, int j) {

        return tileEntityCore.func_102007_a(i, itemstack, j);
    }

    @Override
    public boolean func_102008_b(int i, ItemStack itemstack, int j) {

        return tileEntityCore.func_102008_b(i, itemstack, j);
    }
}
