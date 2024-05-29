package com.jupitersoft.genesis;

import com.jupitersoft.genesis.common.config.GenesisConfig;
import net.minecraftforge.fml.ModLoadingContext;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.config.ModConfig;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.orcinus.galosphere.compat.integration.terrablender.GalosphereRegion;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.Marker;
import org.apache.logging.log4j.MarkerManager;
import terrablender.api.Regions;

@Mod(GCMGalosphereInfo.MOD_ID)
public class GCMGalosphereMod {
    public static final Marker INIT_MARKER = MarkerManager.getMarker("INIT");
    public static final Logger LOGGER = LogManager.getLogger("Genesis");

    public GCMGalosphereMod() {
        // register configs
        LOGGER.debug(INIT_MARKER, "Registering configs");
        ModLoadingContext.get().registerConfig(ModConfig.Type.CLIENT, GenesisConfig.CLIENT_SPEC);
        ModLoadingContext.get().registerConfig(ModConfig.Type.COMMON, GenesisConfig.COMMON_SPEC);
        ModLoadingContext.get().registerConfig(ModConfig.Type.SERVER, GenesisConfig.SERVER_SPEC);

        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::commonSetup);
    }

    private void commonSetup(final FMLCommonSetupEvent event) {
        event.enqueueWork(() -> Regions.register(new GalosphereRegion()));
    }
}
