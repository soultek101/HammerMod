package konals.mods.hammermod.item;

import konals.mods.hammermod.lib.Strings;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

public class ChunkCoal extends Item {

    public ChunkCoal(int i) {

        super(i);
        maxStackSize = 64;
        setUnlocalizedName(Strings.COAL_CHUNK_NAME);
        this.setCreativeTab(CreativeTabs.tabMaterials);

    }

    public void updateIcons(IconRegister iconRegister) {

        itemIcon = iconRegister.registerIcon("hammermod:chunkcoal");
    }
}