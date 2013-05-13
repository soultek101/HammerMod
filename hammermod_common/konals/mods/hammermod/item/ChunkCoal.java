package konals.mods.hammermod.item;

import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

public class ChunkCoal extends Item {

    public ChunkCoal(int i) {

        super(i);
        maxStackSize = 64;
        setUnlocalizedName("Coal Chunk");
        this.setCreativeTab(CreativeTabs.tabMaterials);

    }

    public void updateIcons(IconRegister iconRegister) {

        itemIcon = iconRegister.registerIcon("hammermod:chunkcoal");
    }
}