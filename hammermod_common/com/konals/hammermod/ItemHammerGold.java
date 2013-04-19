package com.konals.hammermod;

import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.EnumToolMaterial;

public class ItemHammerGold extends ItemHammer {
    
    public ItemHammerGold(int i, EnumToolMaterial enumToolMaterial) {
        
        super(i, enumToolMaterial);
        this.maxStackSize = 1;
        this.setMaxDamage(33);
        this.setUnlocalizedName("Gold Hammer");
        this.setCreativeTab(CreativeTabs.tabTools);
    }
    
    public void updateIcons(IconRegister iconRegister) {
        
        iconIndex = iconRegister.registerIcon("hammermod:hammergold");
    }
}