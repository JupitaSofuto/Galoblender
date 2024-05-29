package com.jupitersoft.genesis.galoblender;

import com.jupitersoft.genesis.galoblender.common.GaloblenderRegion;
import com.jupitersoft.genesis.galoblender.common.GaloblenderConfig;
import net.minecraftforge.fml.ModLoadingContext;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.config.ModConfig;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.Marker;
import org.apache.logging.log4j.MarkerManager;
import terrablender.api.Regions;

@Mod("galoblender")
public class Galoblender {
    public static final Marker INIT_MARKER = MarkerManager.getMarker("INIT");
    public static final Logger LOGGER = LogManager.getLogger("Galoblender");

    public Galoblender() {
        // register configs
        LOGGER.debug(INIT_MARKER, "Registering configs");
        ModLoadingContext.get().registerConfig(ModConfig.Type.COMMON, GaloblenderConfig.COMMON_SPEC);

        var modBus = FMLJavaModLoadingContext.get().getModEventBus();
        modBus.addListener(this::commonSetup);
    }

    private void commonSetup(final FMLCommonSetupEvent event) {
        event.enqueueWork(() -> Regions.register(new GaloblenderRegion()));
    }
}
