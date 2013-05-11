package konals.mods.hammermod.item;

import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.EnumToolMaterial;

public class ItemHammerDiamond extends ItemHammer {

    public ItemHammerDiamond(int i, EnumToolMaterial enumToolMaterial) {

        super(i, enumToolMaterial);
        this.maxStackSize = 1;
        this.setMaxDamage(1562);
        this.setUnlocalizedName("Diamond Hammer");
        this.setCreativeTab(CreativeTabs.tabTools);
    }

    public void updateIcons(IconRegister iconRegister) {

        iconIndex = iconRegister.registerIcon("hammermod:hammerdiamond");
    }
}