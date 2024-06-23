package com.invadermonky.kickall;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.event.FMLServerStartingEvent;

@Mod(
        modid = KickAll.MOD_ID,
        name = KickAll.MOD_NAME,
        version = KickAll.MOD_VERSION,
        acceptedMinecraftVersions = KickAll.MC_VERSIONS
)
public class KickAll {
    public static final String MOD_ID = "kickall";
    public static final String MOD_NAME = "KickAll";
    public static final String MOD_VERSION = "1.12.2-1.0.1";
    public static final String MC_VERSIONS = "[1.12.2]";

    @Mod.Instance
    public static KickAll INSTANCE;

    @Mod.EventHandler
    public void serverStarting(FMLServerStartingEvent event) {
        event.registerServerCommand(new KickAllCommand());
    }
}
