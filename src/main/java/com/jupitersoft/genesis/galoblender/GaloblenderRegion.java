package com.jupitersoft.genesis.galoblender;

import com.mojang.datafixers.util.Pair;
import net.minecraft.core.Registry;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.biome.Climate;
import net.orcinus.galosphere.compat.integration.terrablender.GalosphereRegion;

import java.util.function.Consumer;

public class GaloblenderRegion extends GalosphereRegion {
    public GaloblenderRegion() {
        super(GaloblenderConfig.COMMON.galosphereCavesWeight.get());
    }

    @Override
    public void addBiomes(Registry<Biome> registry, Consumer<Pair<Climate.ParameterPoint, ResourceKey<Biome>>> mapper) {
        super.addBiomes(registry, mapper);
        this.addModifiedVanillaOverworldBiomes(mapper, b -> { });
    }
}
