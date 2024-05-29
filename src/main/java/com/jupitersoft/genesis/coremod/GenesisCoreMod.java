package com.jupitersoft.genesis.coremod;

import com.jupitersoft.genesis.GCMGalosphereInfo;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.Marker;
import org.apache.logging.log4j.MarkerManager;
import org.jetbrains.annotations.Nullable;
import org.objectweb.asm.tree.ClassNode;
import org.spongepowered.asm.mixin.Mixins;
import org.spongepowered.asm.mixin.connect.IMixinConnector;
import org.spongepowered.asm.mixin.extensibility.IMixinConfigPlugin;
import org.spongepowered.asm.mixin.extensibility.IMixinInfo;

import java.util.List;
import java.util.Set;

public final class GenesisCoreMod implements IMixinConnector, IMixinConfigPlugin {
    public static final Logger LOGGER = LogManager.getLogger("Genesis");
    public static final Marker MARKER = MarkerManager.getMarker("CoreMod/");

    @Override
    public void connect() {
        Mixins.addConfiguration("META-INF/mixin/" + GCMGalosphereInfo.MOD_ID + ".mixins.json");
    }

    @Override
    public @Nullable List<String> getMixins() {
        return null;
    }

    @Override
    public void onLoad(String mixinPackage) { }

    @Override
    public String getRefMapperConfig() {
        return "META-INF/mixin/" + GCMGalosphereInfo.MOD_ID + ".refmap.json";
    }

    @Override
    public boolean shouldApplyMixin(String targetClassName, String mixinClassName) {
        return true;
    }

    @Override
    public void acceptTargets(Set<String> myTargets, Set<String> otherTargets) { }

    @Override
    public void preApply(String targetClassName, ClassNode targetClass, String mixinClassName, IMixinInfo mixinInfo) { }

    @Override
    public void postApply(String targetClassName, ClassNode targetClass, String mixinClassName, IMixinInfo mixinInfo) { }
}
