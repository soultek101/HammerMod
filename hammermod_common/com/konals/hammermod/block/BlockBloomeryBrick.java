package com.konals.hammermod.block;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.creativetab.CreativeTabs;


public class BlockBloomeryBrick extends Block {

    public BlockBloomeryBrick(int blockId) {
        
        super(blockId, Material.rock);
        
        setUnlocalizedName("Bloomery Brick");
        setStepSound(Block.soundStoneFootstep);
        setHardness(3.5f);
        setCreativeTab(CreativeTabs.tabDecorations);
    }
    
    public void registerIcons(IconRegister iconRegister) {

        blockIcon = iconRegister.registerIcon("hammermod:bloombrick");
    }
}
