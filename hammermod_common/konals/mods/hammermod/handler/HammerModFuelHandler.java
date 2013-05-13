package konals.mods.hammermod.handler;

import konals.mods.hammermod.item.ModItems;
import net.minecraft.item.ItemStack;
import cpw.mods.fml.common.IFuelHandler;

public class HammerModFuelHandler implements IFuelHandler {

    @Override
    public int getBurnTime(ItemStack fuel) {

        int var1 = fuel.itemID;

        if (var1 == ModItems.chunkCoal.itemID) {

            return 200;
        }

        if (var1 == ModItems.chunkCharcoal.itemID) {

            return 200;
        }
        return 0;
    }

}