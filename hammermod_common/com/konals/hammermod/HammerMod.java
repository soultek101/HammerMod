package com.konals.hammermod;

import net.minecraft.block.Block;
import net.minecraft.item.EnumToolMaterial;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.oredict.OreDictionary;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.Init;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.Mod.PostInit;
import cpw.mods.fml.common.Mod.PreInit;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.network.NetworkMod;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.common.registry.LanguageRegistry;

@Mod(modid = "HammerMod", name = "HammerMod", version = "1.0")
@NetworkMod(clientSideRequired = true, serverSideRequired = false)

public class HammerMod {
    
    @Instance("HammerMod")
    public static HammerMod instance;
    
    @SidedProxy(clientSide="com.konals.hammermod.ClientProxy", serverSide="com.konals.hammermod.CommonProxy")
    public static CommonProxy proxy;
    
    public static Item hammerWood;
    public static Item hammerStone;
    public static Item hammerIron;
    public static Item hammerGold;
    public static Item hammerDiamond;
    
    public static Item chunkCoal;
    public static Item chunkCharcoal;
    public static Item chunkIron;
    public static Item chunkGold;
    public static Item chunkDiamond;
 
    @PreInit
    public void preInit(FMLPreInitializationEvent event) {
        // Stub Method
    }
    
    @Init
    public void load(FMLInitializationEvent event) {
        
        proxy.registerRenderers();
        
        hammerWood = new ItemHammerWood(8301, EnumToolMaterial.WOOD);
        hammerStone = new ItemHammerStone(8302, EnumToolMaterial.STONE);
        hammerIron = new ItemHammerIron(8303, EnumToolMaterial.IRON);
        hammerGold = new ItemHammerGold(8304, EnumToolMaterial.GOLD);
        hammerDiamond = new ItemHammerDiamond(8305, EnumToolMaterial.EMERALD);
        
        chunkCoal = new ChunkCoal(8306);
        chunkCharcoal = new ChunkCharcoal(8307);
        chunkIron = new ChunkIron(8308);
        chunkGold = new ChunkGold(8309);
        chunkDiamond = new ChunkDiamond(8310);
        
        LanguageRegistry.addName(hammerWood, "Wooden Hammer");
        LanguageRegistry.addName(hammerStone, "Stone Hammer");
        LanguageRegistry.addName(hammerIron, "Iron Hammer");
        LanguageRegistry.addName(hammerGold, "Gold Hammer");
        LanguageRegistry.addName(hammerDiamond, "Diamond Hammer");
        
        LanguageRegistry.addName(chunkCoal, "Coal Chunk");
        LanguageRegistry.addName(chunkCharcoal, "Charcoal Chunk");
        LanguageRegistry.addName(chunkIron, "Iron Chunk");
        LanguageRegistry.addName(chunkGold, "Gold Chunk");
        LanguageRegistry.addName(chunkDiamond, "Diamond Chunk");
        
        GameRegistry.addRecipe(new ItemStack(HammerMod.hammerWood, 1), new Object[] {"#I#", "#I#", " I ", Character.valueOf('#'), Block.planks, Character.valueOf('I'), Item.stick});
        GameRegistry.addRecipe(new ItemStack(HammerMod.hammerStone, 1), new Object[] {"#I#", "#I#", " I ", Character.valueOf('#'), Block.cobblestone, Character.valueOf('I'), Item.stick});
        GameRegistry.addRecipe(new ItemStack(HammerMod.hammerIron, 1), new Object[] {"#I#", "#I#", " I ", Character.valueOf('#'), Item.ingotIron, Character.valueOf('I'), Item.stick});
        GameRegistry.addRecipe(new ItemStack(HammerMod.hammerGold, 1), new Object[] {"#I#", "#I#", " I ", Character.valueOf('#'), Item.ingotGold, Character.valueOf('I'), Item.stick});
        GameRegistry.addRecipe(new ItemStack(HammerMod.hammerDiamond, 1), new Object[] {"#I#", "#I#", " I ", Character.valueOf('#'), Item.diamond, Character.valueOf('I'), Item.stick});
        
        GameRegistry.addShapelessRecipe(new ItemStack(chunkCoal, 8), new Object[] {new ItemStack(HammerMod.hammerWood, 1, Short.MAX_VALUE), new ItemStack(Item.coal, 1)});
        GameRegistry.addShapelessRecipe(new ItemStack(chunkCoal, 8), new Object[] {new ItemStack(HammerMod.hammerStone, 1, Short.MAX_VALUE), new ItemStack(Item.coal, 1)});
        GameRegistry.addShapelessRecipe(new ItemStack(chunkCoal, 8), new Object[] {new ItemStack(HammerMod.hammerIron, 1, Short.MAX_VALUE), new ItemStack(Item.coal, 1)});
        GameRegistry.addShapelessRecipe(new ItemStack(chunkCoal, 8), new Object[] {new ItemStack(HammerMod.hammerGold, 1, Short.MAX_VALUE), new ItemStack(Item.coal, 1)});
        GameRegistry.addShapelessRecipe(new ItemStack(chunkCoal, 8), new Object[] {new ItemStack(HammerMod.hammerDiamond, 1, Short.MAX_VALUE), new ItemStack(Item.coal, 1)});
        
        GameRegistry.addShapelessRecipe(new ItemStack(chunkCharcoal, 8), new Object[] {new ItemStack(HammerMod.hammerWood, 1, Short.MAX_VALUE), new ItemStack(Item.coal, 1, 1)});
        GameRegistry.addShapelessRecipe(new ItemStack(chunkCharcoal, 8), new Object[] {new ItemStack(HammerMod.hammerStone, 1, Short.MAX_VALUE), new ItemStack(Item.coal, 1, 1)});
        GameRegistry.addShapelessRecipe(new ItemStack(chunkCharcoal, 8), new Object[] {new ItemStack(HammerMod.hammerIron, 1, Short.MAX_VALUE), new ItemStack(Item.coal, 1, 1)});
        GameRegistry.addShapelessRecipe(new ItemStack(chunkCharcoal, 8), new Object[] {new ItemStack(HammerMod.hammerGold, 1, Short.MAX_VALUE), new ItemStack(Item.coal, 1, 1)});
        GameRegistry.addShapelessRecipe(new ItemStack(chunkCharcoal, 8), new Object[] {new ItemStack(HammerMod.hammerDiamond, 1, Short.MAX_VALUE), new ItemStack(Item.coal, 1, 1)});
        
        GameRegistry.addShapelessRecipe(new ItemStack(Item.coal, 1), new Object[] {new ItemStack(chunkCoal, 1), new ItemStack(chunkCoal, 1), new ItemStack(chunkCoal, 1),
            new ItemStack(chunkCoal, 1), new ItemStack(chunkCoal, 1), new ItemStack(chunkCoal, 1), new ItemStack(chunkCoal, 1), new ItemStack(chunkCoal, 1)});
        
        GameRegistry.addShapelessRecipe(new ItemStack(Item.coal, 1, 1), new Object[] {new ItemStack(chunkCharcoal, 1), new ItemStack(chunkCharcoal, 1), new ItemStack(chunkCharcoal, 1),
            new ItemStack(chunkCharcoal, 1), new ItemStack(chunkCharcoal, 1), new ItemStack(chunkCharcoal, 1), new ItemStack(chunkCharcoal, 1), new ItemStack(chunkCharcoal, 1)});
        
        OreDictionary.registerOre("chunkCoal", new ItemStack(chunkCoal));
        OreDictionary.registerOre("chunkCharcoal", new ItemStack(chunkCharcoal));
        OreDictionary.registerOre("chunkIron", new ItemStack(chunkIron));
        OreDictionary.registerOre("chunkGold", new ItemStack(chunkGold));
        OreDictionary.registerOre("chunkDiamond", new ItemStack(chunkDiamond));
        
        MinecraftForge.setToolClass(hammerWood, "pickaxe", 0);
        MinecraftForge.setToolClass(hammerStone, "pickaxe", 1);
        MinecraftForge.setToolClass(hammerIron, "pickaxe", 2);
        MinecraftForge.setToolClass(hammerGold, "pickaxe", 0);
        MinecraftForge.setToolClass(hammerDiamond, "pickaxe", 3);
        
        GameRegistry.registerFuelHandler(new HammerModFuelHandler());
        
    }
    
    @PostInit
    public void postInit(FMLPostInitializationEvent event) {
        
    }
    
}
