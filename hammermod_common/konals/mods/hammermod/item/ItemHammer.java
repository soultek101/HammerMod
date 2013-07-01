package konals.mods.hammermod.item;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.EnumToolMaterial;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemTool;
import net.minecraft.world.World;


public class ItemHammer extends ItemTool {

    public int weaponDamage;
    Random randomGen = new Random();
    public static final Block[] blocksEffectiveAgainst = new Block[] {};

    public ItemHammer(int par1, EnumToolMaterial material) {

        super(par1, 2, material, blocksEffectiveAgainst);
        setContainerItem(this);
        this.weaponDamage = 1 + material.getDamageVsEntity();
    }
    
    public int getDamageVsEntity(Entity entity)
    {
        return this.weaponDamage;
    }
    
    public boolean hitEntity(ItemStack itemStack, EntityLiving par2EntityLiving, EntityLiving par3EntityLiving)
    {
        itemStack.damageItem(1, par3EntityLiving);
        return true;
    }
    
    public boolean onBlockDestroyed(ItemStack itemStack, World world, int i, int x, int y, int z, EntityLiving entityLiving)
    {
        if ((double)Block.blocksList[i].getBlockHardness(world, x, y, z) != 0.0D)
        {
            itemStack.damageItem(1, entityLiving);
        }

        return true;
    }
    
    public boolean onBlockStartBreak(ItemStack itemstack, int x, int y, int z, EntityPlayer entityplayer) {

        World world = entityplayer.worldObj;
        if (world.isRemote) {
            return false;
        }

        itemstack.damageItem(1, entityplayer);
        if (world.getBlockId(x, y, z) == Block.oreCoal.blockID) {

            ItemStack itemstack1 = new ItemStack(ModItems.chunkCoal, 8);
            ItemStack itemstack2 = new ItemStack(ModItems.chunkCoal, 16);
            ItemStack itemstack3 = new ItemStack(ModItems.chunkCoal, 24);
            ItemStack itemstack4 = new ItemStack(ModItems.chunkCoal, 32);
            int rand1;
            double xrand = (double) (world.rand.nextFloat() * 0.7F) + (double) (0.3F) * 0.5D;
            double yrand = (double) (world.rand.nextFloat() * 0.7F) + (double) (0.3F) * 0.5D;
            double zrand = (double) (world.rand.nextFloat() * 0.7F) + (double) (0.3F) * 0.5D;
            EntityItem itemDrop1 = new EntityItem(world, (double) x + xrand, (double) y + yrand, (double) z + zrand, itemstack1);
            EntityItem itemDrop2 = new EntityItem(world, (double) x + xrand, (double) y + yrand, (double) z + zrand, itemstack2);
            EntityItem itemDrop3 = new EntityItem(world, (double) x + xrand, (double) y + yrand, (double) z + zrand, itemstack3);
            EntityItem itemDrop4 = new EntityItem(world, (double) x + xrand, (double) y + yrand, (double) z + zrand, itemstack4);
            itemDrop1.delayBeforeCanPickup = 10;
            itemDrop2.delayBeforeCanPickup = 10;
            itemDrop3.delayBeforeCanPickup = 10;
            itemDrop4.delayBeforeCanPickup = 10;
            if (!entityplayer.capabilities.isCreativeMode) {

                if (EnchantmentHelper.getEnchantmentLevel(Enchantment.fortune.effectId, itemstack) == 1) {
                    
                    rand1 = randomGen.nextInt(100);
                    if (rand1 < 33) {
                        
                        world.spawnEntityInWorld(itemDrop2);
                    } else {
                        
                        world.spawnEntityInWorld(itemDrop1);
                    }
                    
                } else if (EnchantmentHelper.getEnchantmentLevel(Enchantment.fortune.effectId, itemstack) == 2) {
                
                    rand1 = randomGen.nextInt(4);
                    if (rand1 < 50 && rand1 > 24) {
                        
                        world.spawnEntityInWorld(itemDrop2);
                        
                    } else if (rand1 <= 24) {
                        
                        world.spawnEntityInWorld(itemDrop3);
                        
                    } else {
                        
                        world.spawnEntityInWorld(itemDrop1);
                    }
                
                } else if (EnchantmentHelper.getEnchantmentLevel(Enchantment.fortune.effectId, itemstack) == 3) {
                    
                    rand1 = randomGen.nextInt(100);
                    if (rand1 < 60 && rand1 > 39) {
                        
                        world.spawnEntityInWorld(itemDrop2);
                        
                    } else if (rand1 <= 39 && rand1 > 19) {
                        
                        world.spawnEntityInWorld(itemDrop3);
                        
                    } else if (rand1 <= 19) {
                        
                        world.spawnEntityInWorld(itemDrop4);
                        
                    } else {
                        
                        world.spawnEntityInWorld(itemDrop1);
                    }
                    
                } else {
                    
                    world.spawnEntityInWorld(itemDrop1);
                }
            }
            world.setBlock(x, y, z, 0);
            return true;

        } else {

            return false;
        }
    }

    public boolean canHarvestBlock(Block block)
    {
        if (block.blockMaterial.isToolNotRequired()) {
            
            return true;
        }
        for (Material m : getEffectiveMaterials()) {
            
            if (m == block.blockMaterial) {
                
                return true;
            }
        }
        return false;
    }
    
    protected Material[] getEffectiveMaterials() {
        
        return new Material[] { Material.rock, Material.iron, Material.ice, Material.glass, Material.piston, Material.anvil, Material.circuits };
    }

    public float getStrVsBlock(ItemStack itemStack, Block block, int meta) {
        
        Material[] materials = getEffectiveMaterials();
        for (int i = 0; i < materials.length; i++) {
            
            if (materials[i] == block.blockMaterial) {
                
                return this.efficiencyOnProperMaterial;
            }
        }
        return 1.0f;
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