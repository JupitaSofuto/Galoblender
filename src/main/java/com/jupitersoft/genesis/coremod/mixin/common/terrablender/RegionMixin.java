package com.jupitersoft.genesis.coremod.mixin.common.terrablender;

import com.mojang.datafixers.util.Pair;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.biome.Climate;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import terrablender.api.ModifiedVanillaOverworldBuilder;
import terrablender.api.Region;

import java.util.function.Consumer;

@Mixin(value = Region.class, remap = false)
public abstract class RegionMixin {
    @Shadow
    protected abstract void addModifiedVanillaOverworldBiomes(Consumer<Pair<Climate.ParameterPoint, ResourceKey<Biome>>> mapper, Consumer<ModifiedVanillaOverworldBuilder> onModify);
}
