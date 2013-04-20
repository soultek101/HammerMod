package com.konals.hammermod.handler;

import net.minecraft.item.ItemStack;

import com.konals.hammermod.HammerMod;

import cpw.mods.fml.common.IFuelHandler;

public class HammerModFuelHandler implements IFuelHandler {

    @Override
    public int getBurnTime(ItemStack fuel) {

        int var1 = fuel.itemID;

        if (var1 == HammerMod.chunkCoal.itemID) {

            return 200;
        }

        if (var1 == HammerMod.chunkCharcoal.itemID) {

            return 200;
        }
        return 0;
    }

}