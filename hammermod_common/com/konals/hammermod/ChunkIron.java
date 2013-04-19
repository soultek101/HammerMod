package com.konals.hammermod;

import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

public class ChunkIron extends Item {
    
    public ChunkIron(int i) {
        
        super(i);
        maxStackSize = 64;
        setUnlocalizedName("Iron Chunk");
        this.setCreativeTab (CreativeTabs.tabMaterials);

    }
    
    public void updateIcons(IconRegister iconRegister) {
        
        iconIndex = iconRegister.registerIcon("hammermod:chunkiron");
    }
}