package com.konals.hammermod.proxy;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.world.World;

import com.konals.hammermod.gui.GuiBloomery;
import com.konals.hammermod.tileentity.TileEntityBloomeryCore;

public class ClientProxy extends CommonProxy {

    @Override
    public Object getClientGuiElement(int id, EntityPlayer player, World world, int x, int y, int z) {

        TileEntityBloomeryCore tileEntity = (TileEntityBloomeryCore) world.getBlockTileEntity(x, y, z);

        if (tileEntity != null)
            return new GuiBloomery(player.inventory, tileEntity);

        return null;
    }
}
