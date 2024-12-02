package com.jupitersoft.genesis.galoblender;

import net.minecraftforge.common.ForgeConfigSpec;
import net.minecraftforge.fml.ModLoadingContext;
import net.minecraftforge.fml.config.ModConfig;

public final class GaloblenderConfig {
    static void register(ModLoadingContext context) {
        context.registerConfig(ModConfig.Type.COMMON, Common.SPEC.build());
    }

    public static final class Common {
        private static final ForgeConfigSpec.Builder SPEC = new ForgeConfigSpec.Builder();

        public static final ForgeConfigSpec.IntValue REGION_WEIGHT;

        static {
            REGION_WEIGHT = SPEC
                .translation("galoblender.config.common.galosphereCavesWeight")
                .comment("The weighting of Galosphere biome region in the overworld (for reference, the overworld biomes' default is 10).")
                .worldRestart()
                .defineInRange("galosphereCavesWeight", 1, 0, Integer.MAX_VALUE);
        }
    }
}
