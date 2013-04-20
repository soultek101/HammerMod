package com.konals.hammermod.block;

import net.minecraft.block.Block;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

public class BlockBloomeryCore extends BlockContainer {

    public BlockBloomeryCore(int blockId)
    {
        super(blockId, Material.rock);
        
        setUnlocalizedName("Bloomery Core");
        setStepSound(Block.soundStoneFootstep);
        setHardness(3.5f);
        setCreativeTab(CreativeTabs.tabDecorations);
    }
    
    @Override
    public TileEntity createNewTileEntity(World world) {
        
        return null; //return new TileEntityBloomeryCore();
    }
}
