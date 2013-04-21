package com.konals.hammermod.block;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

import com.konals.hammermod.HammerMod;
import com.konals.hammermod.tileentity.TileEntityBloomeryCore;
import com.konals.hammermod.tileentity.TileEntityBloomeryDummy;

public class BlockBloomeryDummy extends BlockContainer {

    public BlockBloomeryDummy(int blockId) {

        super(blockId, Material.rock);

        setUnlocalizedName("blockBloomeryDummy");
        setStepSound(Block.soundStoneFootstep);
        setHardness(3.5f);
        setCreativeTab(CreativeTabs.tabDecorations);
    }

    @Override
    public int idDropped(int par1, Random par2Random, int par3) {

        return HammerMod.bloomeryBrick.blockID;
    }

    @Override
    public TileEntity createNewTileEntity(World world) {

        return new TileEntityBloomeryDummy();
    }

    @Override
    public void registerIcons(IconRegister iconRegister) {

        blockIcon = iconRegister.registerIcon("hammermod:bloombrick");
    }

    @Override
    public void breakBlock(World world, int x, int y, int z, int par5, int par6) {

        TileEntityBloomeryDummy dummy = (TileEntityBloomeryDummy) world.getBlockTileEntity(x, y, z);

        if (dummy != null && dummy.getCore() != null)
            dummy.getCore().invalidateMultiblock();

        super.breakBlock(world, x, y, z, par5, par6);
    }

    @Override
    public boolean onBlockActivated(World world, int x, int y, int z, EntityPlayer player, int par6, float par7, float par8, float par9) {

        if (player.isSneaking())
            return false;

        TileEntityBloomeryDummy dummy = (TileEntityBloomeryDummy) world.getBlockTileEntity(x, y, z);

        if (dummy != null && dummy.getCore() != null) {
            TileEntityBloomeryCore core = dummy.getCore();
            return core.getBlockType().onBlockActivated(world, core.xCoord, core.yCoord, core.zCoord, player, par6, par7, par8, par9);
        }

        return true;
    }
}
