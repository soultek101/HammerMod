package konals.mods.hammermod.item;

import konals.mods.hammermod.lib.Strings;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.EnumToolMaterial;

public class ItemHammerIron extends ItemHammer {

    public ItemHammerIron(int i, EnumToolMaterial enumToolMaterial) {

        super(i, enumToolMaterial);
        this.maxStackSize = 1;
        this.setMaxDamage(334);
        this.setUnlocalizedName(Strings.HAMMER_IRON_NAME);
        this.setCreativeTab(CreativeTabs.tabTools);
    }

    public void updateIcons(IconRegister iconRegister) {

        itemIcon = iconRegister.registerIcon("hammermod:hammerIron");
    }
}