package com.konals.hammermod;

import java.util.logging.Level;

import net.minecraft.block.Block;
import net.minecraft.item.EnumToolMaterial;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.oredict.OreDictionary;

import com.konals.hammermod.block.BlockBloomeryBrick;
import com.konals.hammermod.block.BlockBloomeryCore;
import com.konals.hammermod.block.BlockBloomeryDummy;
import com.konals.hammermod.handler.HammerModFuelHandler;
import com.konals.hammermod.helper.LogHelper;
import com.konals.hammermod.item.ChunkCharcoal;
import com.konals.hammermod.item.ChunkCoal;
import com.konals.hammermod.item.ChunkDiamond;
import com.konals.hammermod.item.ChunkGold;
import com.konals.hammermod.item.ChunkIron;
import com.konals.hammermod.item.ItemHammerDiamond;
import com.konals.hammermod.item.ItemHammerGold;
import com.konals.hammermod.item.ItemHammerIron;
import com.konals.hammermod.item.ItemHammerStone;
import com.konals.hammermod.item.ItemHammerWood;
import com.konals.hammermod.proxy.CommonProxy;

import cpw.mods.fml.common.Loader;
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
import cpw.mods.fml.common.network.NetworkRegistry;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.common.registry.LanguageRegistry;

@Mod(modid = "HammerMod", name = "HammerMod", version = "1.0")
@NetworkMod(clientSideRequired = true, serverSideRequired = false)
public class HammerMod {

    @Instance("HammerMod")
    public static HammerMod instance;

    @SidedProxy(clientSide = "com.konals.hammermod.proxy.ClientProxy", serverSide = "com.konals.hammermod.proxy.CommonProxy")
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

    public static Block bloomeryCore = null;
    public static Block bloomeryDummy = null;
    public static Block bloomeryBrick = null;

    @PreInit
    public void preInit(FMLPreInitializationEvent event) {

        /*Configuration configFile = new Configuration(event.getSuggestedConfigurationFile());
        configFile.load();

        if (configFile.hasChanged())
            configFile.save();*/
    }

    @Init
    public void load(FMLInitializationEvent event) {

        proxy.registerRenderers();
        proxy.registerTileEntities();

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

        bloomeryCore = new BlockBloomeryCore(2700);
        bloomeryDummy = new BlockBloomeryDummy(2701);
        bloomeryBrick = new BlockBloomeryBrick(2702);

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

        LanguageRegistry.addName(bloomeryCore, "Bloomery Core");
        LanguageRegistry.addName(bloomeryDummy, "Bloomery Dummy");
        LanguageRegistry.addName(bloomeryBrick, "Bloomery Brick");

        LanguageRegistry.instance().addStringLocalization("bloomery.container.bloomery", "Bloomery");

        GameRegistry.registerBlock(bloomeryCore, "blockBloomeryCore");
        GameRegistry.registerBlock(bloomeryDummy, "blockBloomeryDummy");
        GameRegistry.registerBlock(bloomeryBrick, "blockBloomeryBrick");

        //GameRegistry.addRecipe(new ItemStack(bloomeryCore, 1), "XXX", "X X", "XXX", 'X', HammerMod.bloomeryBrick);

        GameRegistry.addShapelessRecipe(new ItemStack(chunkCoal, 8), new Object[] {
                new ItemStack(HammerMod.hammerWood, 1, Short.MAX_VALUE), new ItemStack(Item.coal, 1) });

        GameRegistry.addShapelessRecipe(new ItemStack(chunkCoal, 8), new Object[] {
                new ItemStack(HammerMod.hammerStone, 1, Short.MAX_VALUE), new ItemStack(Item.coal, 1) });
        GameRegistry.addShapelessRecipe(new ItemStack(chunkCoal, 8), new Object[] {
                new ItemStack(HammerMod.hammerIron, 1, Short.MAX_VALUE), new ItemStack(Item.coal, 1) });
        GameRegistry.addShapelessRecipe(new ItemStack(chunkCoal, 8), new Object[] {
                new ItemStack(HammerMod.hammerGold, 1, Short.MAX_VALUE), new ItemStack(Item.coal, 1) });
        GameRegistry.addShapelessRecipe(new ItemStack(chunkCoal, 8), new Object[] {
                new ItemStack(HammerMod.hammerDiamond, 1, Short.MAX_VALUE), new ItemStack(Item.coal, 1) });

        GameRegistry.addShapelessRecipe(new ItemStack(chunkCharcoal, 8), new Object[] {
                new ItemStack(HammerMod.hammerWood, 1, Short.MAX_VALUE), new ItemStack(Item.coal, 1, 1) });
        GameRegistry.addShapelessRecipe(new ItemStack(chunkCharcoal, 8), new Object[] {
                new ItemStack(HammerMod.hammerStone, 1, Short.MAX_VALUE), new ItemStack(Item.coal, 1, 1) });
        GameRegistry.addShapelessRecipe(new ItemStack(chunkCharcoal, 8), new Object[] {
                new ItemStack(HammerMod.hammerIron, 1, Short.MAX_VALUE), new ItemStack(Item.coal, 1, 1) });
        GameRegistry.addShapelessRecipe(new ItemStack(chunkCharcoal, 8), new Object[] {
                new ItemStack(HammerMod.hammerGold, 1, Short.MAX_VALUE), new ItemStack(Item.coal, 1, 1) });
        GameRegistry.addShapelessRecipe(new ItemStack(chunkCharcoal, 8), new Object[] {
                new ItemStack(HammerMod.hammerDiamond, 1, Short.MAX_VALUE), new ItemStack(Item.coal, 1, 1) });

        GameRegistry.addShapelessRecipe(new ItemStack(chunkIron, 8), new Object[] {
                new ItemStack(HammerMod.hammerStone, 1, Short.MAX_VALUE), new ItemStack(Block.oreIron, 1) });
        GameRegistry.addShapelessRecipe(new ItemStack(chunkIron, 8), new Object[] {
                new ItemStack(HammerMod.hammerIron, 1, Short.MAX_VALUE), new ItemStack(Block.oreIron, 1) });
        GameRegistry.addShapelessRecipe(new ItemStack(chunkIron, 8), new Object[] {
                new ItemStack(HammerMod.hammerDiamond, 1, Short.MAX_VALUE), new ItemStack(Block.oreIron, 1) });

        GameRegistry.addShapelessRecipe(new ItemStack(chunkGold, 8), new Object[] {
                new ItemStack(HammerMod.hammerIron, 1, Short.MAX_VALUE), new ItemStack(Block.oreGold, 1) });
        GameRegistry.addShapelessRecipe(new ItemStack(chunkGold, 8), new Object[] {
                new ItemStack(HammerMod.hammerDiamond, 1, Short.MAX_VALUE), new ItemStack(Block.oreGold, 1) });

        GameRegistry.addShapelessRecipe(new ItemStack(chunkDiamond, 8), new Object[] {
                new ItemStack(HammerMod.hammerIron, 1, Short.MAX_VALUE), new ItemStack(Block.oreDiamond, 1) });
        GameRegistry.addShapelessRecipe(new ItemStack(chunkDiamond, 8), new Object[] {
                new ItemStack(HammerMod.hammerDiamond, 1, Short.MAX_VALUE), new ItemStack(Block.oreDiamond, 1) });

        GameRegistry.addShapelessRecipe(new ItemStack(Item.coal, 1), new Object[] { new ItemStack(chunkCoal, 1),
                new ItemStack(chunkCoal, 1), new ItemStack(chunkCoal, 1), new ItemStack(chunkCoal, 1), new ItemStack(chunkCoal, 1),
                new ItemStack(chunkCoal, 1), new ItemStack(chunkCoal, 1), new ItemStack(chunkCoal, 1) });

        GameRegistry.addShapelessRecipe(new ItemStack(Item.coal, 1, 1), new Object[] { new ItemStack(chunkCharcoal, 1),
                new ItemStack(chunkCharcoal, 1), new ItemStack(chunkCharcoal, 1), new ItemStack(chunkCharcoal, 1),
                new ItemStack(chunkCharcoal, 1), new ItemStack(chunkCharcoal, 1), new ItemStack(chunkCharcoal, 1),
                new ItemStack(chunkCharcoal, 1) });

        GameRegistry.addShapelessRecipe(new ItemStack(Block.oreIron, 1), new Object[] { new ItemStack(chunkIron, 1),
                new ItemStack(chunkIron, 1), new ItemStack(chunkIron, 1), new ItemStack(chunkIron, 1), new ItemStack(chunkIron, 1),
                new ItemStack(chunkIron, 1), new ItemStack(chunkIron, 1), new ItemStack(chunkIron, 1) });

        GameRegistry.addShapelessRecipe(new ItemStack(Block.oreGold, 1), new Object[] { new ItemStack(chunkGold, 1),
                new ItemStack(chunkGold, 1), new ItemStack(chunkGold, 1), new ItemStack(chunkGold, 1), new ItemStack(chunkGold, 1),
                new ItemStack(chunkGold, 1), new ItemStack(chunkGold, 1), new ItemStack(chunkGold, 1) });

        GameRegistry.addShapelessRecipe(new ItemStack(Block.oreDiamond, 1), new Object[] { new ItemStack(chunkDiamond, 1),
                new ItemStack(chunkDiamond, 1), new ItemStack(chunkDiamond, 1), new ItemStack(chunkDiamond, 1),
                new ItemStack(chunkDiamond, 1), new ItemStack(chunkDiamond, 1), new ItemStack(chunkDiamond, 1),
                new ItemStack(chunkDiamond, 1) });
        
        GameRegistry.addSmelting(Block.brick.blockID, new ItemStack(HammerMod.bloomeryBrick, 1), 0.1F);

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
        NetworkRegistry.instance().registerGuiHandler(this, proxy);

    }

    @PostInit
    public void postInit(FMLPostInitializationEvent event) {

        if (Loader.isModLoaded("weaponmod")) {

            GameRegistry.addRecipe(new ItemStack(HammerMod.hammerWood, 1), new Object[] { " I ", "#I#", "#I#", Character.valueOf('#'),
                    Block.planks, Character.valueOf('I'), Item.stick });
            GameRegistry.addRecipe(new ItemStack(HammerMod.hammerStone, 1), new Object[] { " I ", "#I#", "#I#", Character.valueOf('#'),
                    Block.cobblestone, Character.valueOf('I'), Item.stick });
            GameRegistry.addRecipe(new ItemStack(HammerMod.hammerIron, 1), new Object[] { " I ", "#I#", "#I#", Character.valueOf('#'),
                    Item.ingotIron, Character.valueOf('I'), Item.stick });
            GameRegistry.addRecipe(new ItemStack(HammerMod.hammerGold, 1), new Object[] { " I ", "#I#", "#I#", Character.valueOf('#'),
                    Item.ingotGold, Character.valueOf('I'), Item.stick });
            GameRegistry.addRecipe(new ItemStack(HammerMod.hammerDiamond, 1), new Object[] { " I ", "#I#", "#I#", Character.valueOf('#'),
                    Item.diamond, Character.valueOf('I'), Item.stick });
            LogHelper.log(Level.INFO, "Balkon's Weapon Mod detected, flipping hammermod hammer recipe for compatibility!");
        } else {

            GameRegistry.addRecipe(new ItemStack(HammerMod.hammerWood, 1), new Object[] { "#I#", "#I#", " I ", Character.valueOf('#'),
                    Block.planks, Character.valueOf('I'), Item.stick });
            GameRegistry.addRecipe(new ItemStack(HammerMod.hammerStone, 1), new Object[] { "#I#", "#I#", " I ", Character.valueOf('#'),
                    Block.cobblestone, Character.valueOf('I'), Item.stick });
            GameRegistry.addRecipe(new ItemStack(HammerMod.hammerIron, 1), new Object[] { "#I#", "#I#", " I ", Character.valueOf('#'),
                    Item.ingotIron, Character.valueOf('I'), Item.stick });
            GameRegistry.addRecipe(new ItemStack(HammerMod.hammerGold, 1), new Object[] { "#I#", "#I#", " I ", Character.valueOf('#'),
                    Item.ingotGold, Character.valueOf('I'), Item.stick });
            GameRegistry.addRecipe(new ItemStack(HammerMod.hammerDiamond, 1), new Object[] { "#I#", "#I#", " I ", Character.valueOf('#'),
                    Item.diamond, Character.valueOf('I'), Item.stick });
        }
    }

}
