package com.konals.hammermod.proxy;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.world.World;

import com.konals.hammermod.tileentity.ContainerBloomery;
import com.konals.hammermod.tileentity.TileEntityBloomeryCore;
import com.konals.hammermod.tileentity.TileEntityBloomeryDummy;

import cpw.mods.fml.common.network.IGuiHandler;
import cpw.mods.fml.common.registry.GameRegistry;

public class CommonProxy implements IGuiHandler {

    public void registerTileEntities() {

        GameRegistry.registerTileEntity(TileEntityBloomeryCore.class, "tileEntityBloomeryCore");
        GameRegistry.registerTileEntity(TileEntityBloomeryDummy.class, "tileEntityBloomeryDummy");
    }

    @Override
    public Object getServerGuiElement(int guiID, EntityPlayer player, World world, int x, int y, int z) {

        TileEntityBloomeryCore tileEntity = (TileEntityBloomeryCore) world.getBlockTileEntity(x, y, z);

        if (tileEntity != null)
            return new ContainerBloomery(player.inventory, tileEntity);

        return null;
    }

    @Override
    public Object getClientGuiElement(int guiID, EntityPlayer player, World world, int x, int y, int z) {

        return null;
    }

    public void registerRenderers() {

    }
}
