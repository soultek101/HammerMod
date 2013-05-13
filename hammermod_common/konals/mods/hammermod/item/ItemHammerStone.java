package konals.mods.hammermod.item;

import konals.mods.hammermod.lib.Strings;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.EnumToolMaterial;

public class ItemHammerStone extends ItemHammer {

    public ItemHammerStone(int i, EnumToolMaterial enumToolMaterial) {

        super(i, enumToolMaterial);
        this.maxStackSize = 1;
        this.setMaxDamage(132);
        this.setUnlocalizedName(Strings.HAMMER_STONE_NAME);
        this.setCreativeTab(CreativeTabs.tabTools);
    }

    public void updateIcons(IconRegister iconRegister) {

        itemIcon = iconRegister.registerIcon("hammermod:hammerstone");
    }
}