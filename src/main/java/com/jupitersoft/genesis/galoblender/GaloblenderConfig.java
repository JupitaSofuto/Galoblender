package com.jupitersoft.genesis.galoblender;

import net.minecraftforge.common.ForgeConfigSpec;
import net.minecraftforge.fml.ModLoadingContext;
import net.minecraftforge.fml.config.ModConfig;

public class GaloblenderConfig {
    // CONFIGS
    public static final Common COMMON;

    // CONFIG SPECS
    private static final ForgeConfigSpec COMMON_SPEC;

    static {
        var commonSpecBuilder = new ForgeConfigSpec.Builder();
        COMMON = new Common(commonSpecBuilder);
        COMMON_SPEC = commonSpecBuilder.build();
    }

    static void register(ModLoadingContext context) {
        context.registerConfig(ModConfig.Type.COMMON, COMMON_SPEC);
    }

    public static class Common {
        public final ForgeConfigSpec.IntValue galosphereCavesWeight;

        private Common(ForgeConfigSpec.Builder builder) {
            this.galosphereCavesWeight =
                builder.translation("galoblender.config.common.galosphereCavesWeight")
                    .comment("The weighting of Galosphere biome region in the overworld (for reference, the overworld biomes' default is 10).")
                    .worldRestart()
                    .defineInRange("galosphereCavesWeight", 1, 0, Integer.MAX_VALUE);
        }
    }
}
