package konals.mods.hammermod.item;

import java.util.logging.Level;

import konals.mods.hammermod.handler.HammerModFuelHandler;
import konals.mods.hammermod.helper.LogHelper;
import konals.mods.hammermod.lib.ItemIds;
import net.minecraft.block.Block;
import net.minecraft.item.EnumToolMaterial;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.oredict.OreDictionary;
import cpw.mods.fml.common.Loader;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.common.registry.LanguageRegistry;


public class ModItems {

    public static Item hammerWood;
    public static Item hammerStone;
    public static Item hammerIron;
    public static Item hammerGold;
    public static Item hammerDiamond;

    public static Item chunkCoal;
    public static Item chunkCharcoal;
    
    public static void init() {

        hammerWood = new ItemHammerWood(ItemIds.HAMMER_WOOD, EnumToolMaterial.WOOD);
        hammerStone = new ItemHammerStone(ItemIds.HAMMER_STONE, EnumToolMaterial.STONE);
        hammerIron = new ItemHammerIron(ItemIds.HAMMER_IRON, EnumToolMaterial.IRON);
        hammerGold = new ItemHammerGold(ItemIds.HAMMER_GOLD, EnumToolMaterial.GOLD);
        hammerDiamond = new ItemHammerDiamond(ItemIds.HAMMER_DIAMOND, EnumToolMaterial.EMERALD);
        
        chunkCoal = new ChunkCoal(ItemIds.CHUNK_COAL);
        chunkCharcoal = new ChunkCharcoal(ItemIds.CHUNK_CHARCOAL);
        
        LanguageRegistry.addName(hammerWood, "Wooden Hammer");
        LanguageRegistry.addName(hammerStone, "Stone Hammer");
        LanguageRegistry.addName(hammerIron, "Iron Hammer");
        LanguageRegistry.addName(hammerGold, "Gold Hammer");
        LanguageRegistry.addName(hammerDiamond, "Diamond Hammer");

        LanguageRegistry.addName(chunkCoal, "Coal Chunk");
        LanguageRegistry.addName(chunkCharcoal, "Charcoal Chunk");

        GameRegistry.addShapelessRecipe(new ItemStack(chunkCoal, 8), new Object[] {
                new ItemStack(hammerWood, 1, Short.MAX_VALUE), new ItemStack(Item.coal, 1) });

        GameRegistry.addShapelessRecipe(new ItemStack(chunkCoal, 8), new Object[] {
                new ItemStack(hammerStone, 1, Short.MAX_VALUE), new ItemStack(Item.coal, 1) });
        GameRegistry.addShapelessRecipe(new ItemStack(chunkCoal, 8), new Object[] {
                new ItemStack(hammerIron, 1, Short.MAX_VALUE), new ItemStack(Item.coal, 1) });
        GameRegistry.addShapelessRecipe(new ItemStack(chunkCoal, 8), new Object[] {
                new ItemStack(hammerGold, 1, Short.MAX_VALUE), new ItemStack(Item.coal, 1) });
        GameRegistry.addShapelessRecipe(new ItemStack(chunkCoal, 8), new Object[] {
                new ItemStack(hammerDiamond, 1, Short.MAX_VALUE), new ItemStack(Item.coal, 1) });

        GameRegistry.addShapelessRecipe(new ItemStack(chunkCharcoal, 8), new Object[] {
                new ItemStack(hammerWood, 1, Short.MAX_VALUE), new ItemStack(Item.coal, 1, 1) });
        GameRegistry.addShapelessRecipe(new ItemStack(chunkCharcoal, 8), new Object[] {
                new ItemStack(hammerStone, 1, Short.MAX_VALUE), new ItemStack(Item.coal, 1, 1) });
        GameRegistry.addShapelessRecipe(new ItemStack(chunkCharcoal, 8), new Object[] {
                new ItemStack(hammerIron, 1, Short.MAX_VALUE), new ItemStack(Item.coal, 1, 1) });
        GameRegistry.addShapelessRecipe(new ItemStack(chunkCharcoal, 8), new Object[] {
                new ItemStack(hammerGold, 1, Short.MAX_VALUE), new ItemStack(Item.coal, 1, 1) });
        GameRegistry.addShapelessRecipe(new ItemStack(chunkCharcoal, 8), new Object[] {
                new ItemStack(hammerDiamond, 1, Short.MAX_VALUE), new ItemStack(Item.coal, 1, 1) });

        GameRegistry.addShapelessRecipe(new ItemStack(Item.coal, 1), new Object[] { new ItemStack(chunkCoal, 1),
                new ItemStack(chunkCoal, 1), new ItemStack(chunkCoal, 1), new ItemStack(chunkCoal, 1), new ItemStack(chunkCoal, 1),
                new ItemStack(chunkCoal, 1), new ItemStack(chunkCoal, 1), new ItemStack(chunkCoal, 1) });

        GameRegistry.addShapelessRecipe(new ItemStack(Item.coal, 1, 1), new Object[] { new ItemStack(chunkCharcoal, 1),
                new ItemStack(chunkCharcoal, 1), new ItemStack(chunkCharcoal, 1), new ItemStack(chunkCharcoal, 1),
                new ItemStack(chunkCharcoal, 1), new ItemStack(chunkCharcoal, 1), new ItemStack(chunkCharcoal, 1),
                new ItemStack(chunkCharcoal, 1) });
        
        GameRegistry.addRecipe(new ItemStack(Block.torchWood, 4), new Object[] { "ccc", "csc", "ccc", Character.valueOf('c'),
            ModItems.chunkCoal, Character.valueOf('s'), Item.stick });
        GameRegistry.addRecipe(new ItemStack(Block.torchWood, 4), new Object[] { "ccc", "csc", "ccc", Character.valueOf('c'),
            ModItems.chunkCharcoal, Character.valueOf('s'), Item.stick });

        OreDictionary.registerOre("chunkCoal", new ItemStack(chunkCoal));
        OreDictionary.registerOre("chunkCharcoal", new ItemStack(chunkCharcoal));

        MinecraftForge.setToolClass(hammerWood, "pickaxe", 0);
        MinecraftForge.setToolClass(hammerStone, "pickaxe", 1);
        MinecraftForge.setToolClass(hammerIron, "pickaxe", 2);
        MinecraftForge.setToolClass(hammerGold, "pickaxe", 0);
        MinecraftForge.setToolClass(hammerDiamond, "pickaxe", 3);

        GameRegistry.registerFuelHandler(new HammerModFuelHandler());
    }
    
    public static void postInit() {
        
        if (Loader.isModLoaded("weaponmod")) {

            GameRegistry.addRecipe(new ItemStack(hammerWood, 1), new Object[] { " I ", "#I#", "#I#", Character.valueOf('#'),
                    Block.planks, Character.valueOf('I'), Item.stick });
            GameRegistry.addRecipe(new ItemStack(hammerStone, 1), new Object[] { " I ", "#I#", "#I#", Character.valueOf('#'),
                    Block.cobblestone, Character.valueOf('I'), Item.stick });
            GameRegistry.addRecipe(new ItemStack(hammerIron, 1), new Object[] { " I ", "#I#", "#I#", Character.valueOf('#'),
                    Item.ingotIron, Character.valueOf('I'), Item.stick });
            GameRegistry.addRecipe(new ItemStack(hammerGold, 1), new Object[] { " I ", "#I#", "#I#", Character.valueOf('#'),
                    Item.ingotGold, Character.valueOf('I'), Item.stick });
            GameRegistry.addRecipe(new ItemStack(hammerDiamond, 1), new Object[] { " I ", "#I#", "#I#", Character.valueOf('#'),
                    Item.diamond, Character.valueOf('I'), Item.stick });
            LogHelper.log(Level.INFO, "Balkon's Weapon Mod detected, flipping hammermod hammer recipe for compatibility!");
        } else {

            GameRegistry.addRecipe(new ItemStack(hammerWood, 1), new Object[] { "#I#", "#I#", " I ", Character.valueOf('#'),
                    Block.planks, Character.valueOf('I'), Item.stick });
            GameRegistry.addRecipe(new ItemStack(hammerStone, 1), new Object[] { "#I#", "#I#", " I ", Character.valueOf('#'),
                    Block.cobblestone, Character.valueOf('I'), Item.stick });
            GameRegistry.addRecipe(new ItemStack(hammerIron, 1), new Object[] { "#I#", "#I#", " I ", Character.valueOf('#'),
                    Item.ingotIron, Character.valueOf('I'), Item.stick });
            GameRegistry.addRecipe(new ItemStack(hammerGold, 1), new Object[] { "#I#", "#I#", " I ", Character.valueOf('#'),
                    Item.ingotGold, Character.valueOf('I'), Item.stick });
            GameRegistry.addRecipe(new ItemStack(hammerDiamond, 1), new Object[] { "#I#", "#I#", " I ", Character.valueOf('#'),
                    Item.diamond, Character.valueOf('I'), Item.stick });
        }
    }
}