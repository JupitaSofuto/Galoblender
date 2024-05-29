package com.jupitersoft.genesis.common;

import com.jupitersoft.genesis.common.config.GenesisConfig;
import com.mojang.datafixers.util.Pair;
import net.minecraft.core.Registry;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.biome.Climate;
import net.orcinus.galosphere.compat.integration.terrablender.GalosphereRegion;

import java.util.function.Consumer;

public class GnGalosphereRegion extends GalosphereRegion {
    public GnGalosphereRegion() {
        super(GenesisConfig.COMMON.galosphereCavesWeight.get());
    }

    @Override
    public void addBiomes(Registry<Biome> registry, Consumer<Pair<Climate.ParameterPoint, ResourceKey<Biome>>> mapper) {
        super.addBiomes(registry, mapper);
        this.addModifiedVanillaOverworldBiomes(mapper, b -> { });
    }
}
