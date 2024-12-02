package com.jupitersoft.genesis.galoblender;

import net.minecraftforge.fml.ModLoadingContext;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import terrablender.api.Regions;

@Mod("galoblender")
public class Galoblender {
    public Galoblender() {
        // register configs
        GaloblenderConfig.register(ModLoadingContext.get());

        // event listeners
        final var modBus = FMLJavaModLoadingContext.get().getModEventBus();
        modBus.addListener(this::commonSetup);
    }

    private void commonSetup(final FMLCommonSetupEvent event) {
        event.enqueueWork(GaloblenderRegion::register);
    }
}
