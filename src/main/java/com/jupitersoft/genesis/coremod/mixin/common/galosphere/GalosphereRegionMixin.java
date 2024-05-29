package com.jupitersoft.genesis.coremod.mixin.common.galosphere;

import com.jupitersoft.genesis.common.config.GenesisConfig;
import com.jupitersoft.genesis.coremod.mixin.common.terrablender.RegionMixin;
import com.llamalad7.mixinextras.injector.ModifyExpressionValue;
import com.mojang.datafixers.util.Pair;
import net.minecraft.core.Registry;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.biome.Climate;
import net.orcinus.galosphere.compat.integration.terrablender.GalosphereRegion;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Constant;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.ModifyConstant;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import java.util.function.Consumer;

import static com.jupitersoft.genesis.coremod.GenesisCoreMod.LOGGER;
import static com.jupitersoft.genesis.coremod.GenesisCoreMod.MARKER;

@Mixin(value = GalosphereRegion.class, remap = false)
public abstract class GalosphereRegionMixin extends RegionMixin {
    @ModifyExpressionValue(
        method = "<init>()V",
        at = @At(
            value = "CONSTANT",
            args = "intValue=1"
        )
    )
    private static int modifyRegionWeight(int constant) {
        int weight = GenesisConfig.COMMON.galosphereCavesWeight.get();
        LOGGER.warn(MARKER, "Modifying galosphere region weight to {} from {}", weight, constant);
        return GenesisConfig.COMMON.galosphereCavesWeight.get();
    }

    @Inject(
        method = "addBiomes(Lnet/minecraft/core/Registry;Ljava/util/function/Consumer;)V",
        at = @At("TAIL")
    )
    private void finalizeBiomes(Registry<Biome> registry, Consumer<Pair<Climate.ParameterPoint, ResourceKey<Biome>>> mapper, CallbackInfo callback) {
        LOGGER.debug("Adding vanilla overworld biomes to galosphere region");
        this.addModifiedVanillaOverworldBiomes(mapper, b -> { });
    }
}
