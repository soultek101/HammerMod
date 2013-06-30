package konals.mods.hammermod;

import konals.mods.hammermod.item.ModItems;
import konals.mods.hammermod.lib.ItemIds;
import konals.mods.hammermod.lib.Reference;
import konals.mods.hammermod.lib.Strings;
import konals.mods.hammermod.proxy.CommonProxy;
import net.minecraftforge.common.Configuration;
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

@Mod(modid = Reference.MOD_ID, name = Reference.MOD_NAME, version = Reference.VERSION_NUMBER)
@NetworkMod(clientSideRequired = true, serverSideRequired = false)
public class HammerMod {
    
    @Instance(Reference.MOD_ID)
    public static HammerMod instance;

    @SidedProxy(clientSide = Reference.CLIENT_PROXY_CLASS, serverSide = Reference.SERVER_PROXY_CLASS )
    public static CommonProxy proxy;

    @PreInit
    public void preInit(FMLPreInitializationEvent event) {
        
        ModItems.init();
        Configuration config = new Configuration(event.getSuggestedConfigurationFile());
        
        config.load();
        
        ItemIds.HAMMER_WOOD = config.getItem(Strings.HAMMER_WOOD_NAME, ItemIds.HAMMER_WOOD_DEFAULT).getInt(ItemIds.HAMMER_WOOD_DEFAULT);
        ItemIds.HAMMER_STONE = config.getItem(Strings.HAMMER_STONE_NAME, ItemIds.HAMMER_STONE_DEFAULT).getInt(ItemIds.HAMMER_STONE_DEFAULT);
        ItemIds.HAMMER_IRON = config.getItem(Strings.HAMMER_IRON_NAME, ItemIds.HAMMER_IRON_DEFAULT).getInt(ItemIds.HAMMER_IRON_DEFAULT);
        ItemIds.HAMMER_GOLD = config.getItem(Strings.HAMMER_GOLD_NAME, ItemIds.HAMMER_GOLD_DEFAULT).getInt(ItemIds.HAMMER_GOLD_DEFAULT);
        ItemIds.HAMMER_DIAMOND = config.getItem(Strings.HAMMER_DIAMOND_NAME, ItemIds.HAMMER_DIAMOND_DEFAULT).getInt(ItemIds.HAMMER_DIAMOND_DEFAULT);
        ItemIds.CHUNK_COAL = config.getItem(Strings.CHUNK_COAL_NAME, ItemIds.CHUNK_COAL_DEFAULT).getInt(ItemIds.CHUNK_COAL_DEFAULT);
        ItemIds.CHUNK_CHARCOAL = config.getItem(Strings.CHUNK_CHARCOAL_NAME, ItemIds.CHUNK_CHARCOAL_DEFAULT).getInt(ItemIds.CHUNK_CHARCOAL_DEFAULT);
        
        config.save();
    }

    @Init
    public void load(FMLInitializationEvent event) {

        proxy.registerRenderers();

    }

    @PostInit
    public void postInit(FMLPostInitializationEvent event) {

        ModItems.postInit();
    }

}
