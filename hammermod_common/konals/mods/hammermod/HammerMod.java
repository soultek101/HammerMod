package konals.mods.hammermod;

import konals.mods.hammermod.item.ModItems;
import konals.mods.hammermod.lib.Reference;
import konals.mods.hammermod.proxy.CommonProxy;
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
