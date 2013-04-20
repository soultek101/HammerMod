package com.konals.hammermod.item;

import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

public class ChunkGold extends Item {
    
    public ChunkGold(int i) {
        
        super(i);
        maxStackSize = 64;
        setUnlocalizedName("Gold Chunk");
        this.setCreativeTab (CreativeTabs.tabMaterials);

    }
    
    public void updateIcons(IconRegister iconRegister) {
        
        iconIndex = iconRegister.registerIcon("hammermod:chunkgold");
    }
}