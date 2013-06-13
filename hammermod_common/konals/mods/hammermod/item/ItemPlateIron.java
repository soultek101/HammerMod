package konals.mods.hammermod.item;

import konals.mods.hammermod.lib.Strings;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

public class ItemPlateIron extends Item {

    public ItemPlateIron(int i) {
        
        super(i);
        this.maxStackSize = 64;
        this.setUnlocalizedName(Strings.PLATE_IRON_NAME);
        this.setCreativeTab(CreativeTabs.tabMaterials);
    }
    
    public void updateIcons(IconRegister iconRegister) {
        
        itemIcon = iconRegister.registerIcon("hammermod:plateIron");
    }
}
