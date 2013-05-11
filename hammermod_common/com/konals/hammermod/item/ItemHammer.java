package com.konals.hammermod.item;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.EnumToolMaterial;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemTool;
import net.minecraft.world.World;

import com.konals.hammermod.HammerMod;

public class ItemHammer extends ItemTool {

    public static final Block[] blocksEffectiveAgainst = new Block[] { Block.cobblestone, Block.stoneDoubleSlab, Block.stoneSingleSlab,
            Block.stone, Block.sandStone, Block.cobblestoneMossy, Block.oreIron, Block.blockSteel, Block.oreCoal, Block.blockGold,
            Block.oreGold, Block.oreDiamond, Block.blockDiamond, Block.ice, Block.netherrack, Block.oreLapis, Block.blockLapis,
            Block.oreRedstone, Block.oreRedstoneGlowing, Block.rail, Block.railDetector, Block.railPowered, Block.railActivator };

    protected ItemHammer(int par1, EnumToolMaterial material) {

        super(par1, 2, material, blocksEffectiveAgainst);
        setContainerItem(this);
    }

    public boolean onBlockStartBreak(ItemStack itemstack, int x, int y, int z, EntityPlayer entityplayer) {

        World world = entityplayer.worldObj;
        if (world.isRemote) {
            return false;
        }

        itemstack.damageItem(1, entityplayer);
        if (world.getBlockId(x, y, z) == Block.oreCoal.blockID) {

            ItemStack itemstack1 = new ItemStack(HammerMod.chunkCoal, 8);
            double xrand = (double) (world.rand.nextFloat() * 0.7F) + (double) (0.3F) * 0.5D;
            double yrand = (double) (world.rand.nextFloat() * 0.7F) + (double) (0.3F) * 0.5D;
            double zrand = (double) (world.rand.nextFloat() * 0.7F) + (double) (0.3F) * 0.5D;
            EntityItem itemDrop = new EntityItem(world, (double) x + xrand, (double) y + yrand, (double) z + zrand, itemstack1);
            itemDrop.delayBeforeCanPickup = 10;
            if (!entityplayer.capabilities.isCreativeMode) {

                world.spawnEntityInWorld(itemDrop);
            }
            world.setBlock(x, y, z, 0);
            return true;

        } else {

            return false;
        }
    }

    public boolean canHarvestBlock(Block par1Block) {

        return par1Block == Block.obsidian ? this.toolMaterial.getHarvestLevel() == 3 : (par1Block != Block.blockDiamond
                && par1Block != Block.oreDiamond ? (par1Block != Block.oreEmerald && par1Block != Block.blockEmerald
                ? (par1Block != Block.blockGold && par1Block != Block.oreGold ? (par1Block != Block.blockSteel
                && par1Block != Block.oreIron ? (par1Block != Block.blockLapis && par1Block != Block.oreLapis
                ? (par1Block != Block.oreRedstone && par1Block != Block.oreRedstoneGlowing
                ? (par1Block.blockMaterial == Material.rock ? true : (par1Block.blockMaterial == Material.iron ? true
                : par1Block.blockMaterial == Material.anvil)) : this.toolMaterial.getHarvestLevel() >= 2)
                : this.toolMaterial.getHarvestLevel() >= 1) : this.toolMaterial.getHarvestLevel() >= 1) : this.toolMaterial
                .getHarvestLevel() >= 2) : this.toolMaterial.getHarvestLevel() >= 2) : this.toolMaterial.getHarvestLevel() >= 2);
    }

    public float getStrVsBlock(ItemStack par1ItemStack, Block par2Block) {

        return par2Block != null
                && (par2Block.blockMaterial == Material.iron || par2Block.blockMaterial == Material.anvil || par2Block.blockMaterial == Material.rock)
                ? this.efficiencyOnProperMaterial : super.getStrVsBlock(par1ItemStack, par2Block);
    }

    @Override
    public ItemStack getContainerItemStack(ItemStack itemStack) {

        itemStack.setItemDamage(itemStack.getItemDamage() + 1);

        return itemStack;
    }

    @Override
    public boolean doesContainerItemLeaveCraftingGrid(ItemStack itemStack) {

        return false;
    }

}