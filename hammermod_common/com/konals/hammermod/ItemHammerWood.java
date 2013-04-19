package com.konals.hammermod;

import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.EnumToolMaterial;

public class ItemHammerWood extends ItemHammer {
    
    public ItemHammerWood(int i, EnumToolMaterial enumToolMaterial) {
        
        super(i, enumToolMaterial);
        this.maxStackSize = 1;
        this.setMaxDamage(60);
        this.setUnlocalizedName("Wooden Hammer");
        this.setCreativeTab(CreativeTabs.tabTools);
    }
    
    public void updateIcons(IconRegister iconRegister) {
        
        iconIndex = iconRegister.registerIcon("hammermod:hammerwood");
    }
}